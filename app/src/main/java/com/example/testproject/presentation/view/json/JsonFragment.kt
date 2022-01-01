package com.example.testproject.presentation.view.json

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.testproject.MyApp
import com.example.testproject.data.network.json.ApiFactory
import com.example.testproject.databinding.FragmentJsonBinding
import com.example.testproject.data.network.json.model.GameInfoDto
import com.example.testproject.databinding.ItemGameInfoBinding
import com.example.testproject.domain.repository.json.pojo.GameInfo
import com.example.testproject.presentation.adapter.json.GameInfoAdapter
import com.example.testproject.presentation.viewModel.json.JsonViewModel
import com.example.testproject.presentation.viewModel.json.JsonViewModel.Companion.PAGE
import com.example.testproject.presentation.viewModel.json.JsonViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import kotlin.concurrent.thread

class JsonFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: JsonViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[JsonViewModel::class.java]
    }

    private val component by lazy {
        (requireContext().applicationContext as MyApp).component
    }

    private var _binding: FragmentJsonBinding? = null
    private val binding: FragmentJsonBinding
        get() = _binding ?: throw RuntimeException("FragmentJsonBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJsonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GameInfoAdapter(requireContext())
        adapter.onGameClickListener = object : GameInfoAdapter.OnGameClickListener {
            override fun onGameClick(gameInfo: GameInfo) {
                Toast.makeText(context, gameInfo.name, Toast.LENGTH_SHORT).show()
                hideKeyboard(requireActivity())
            }
        }
        adapter.onNameLongClickListener = object : GameInfoAdapter.OnNameLongClickListener {
            override fun onNameLongClick() {
                Toast.makeText(context, "Copy text to clipboard using popup", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.rvGameInfoList.adapter = adapter
        binding.buttonNext.setOnClickListener {
            if (PAGE >= PAGE_N) {
                viewModel.deleteData()
                viewModel.loadData(++PAGE)
                binding.pageNumber.text = PAGE.toString().toEditable()
            }
        }
        binding.buttonPrev.setOnClickListener {
            if (PAGE >= PAGE_P) {
                viewModel.deleteData()
                viewModel.loadData(--PAGE)
                binding.pageNumber.text = PAGE.toString().toEditable()
            }
        }
        binding.pageNumber.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                val key = p0

                if (key != null && key.toString() != EMPTY_STRING) {
                    binding.pageNumber.setOnKeyListener { view, i, keyEvent ->
                        if (i == KeyEvent.KEYCODE_ENTER && keyEvent.action == KeyEvent.ACTION_UP
                            && key.toString() != EMPTY_STRING
                            && key.toString().toInt() >= MIN_PAGE
                        ) {
                            PAGE = key.toString().toInt()
                            viewModel.deleteData()
                            viewModel.loadData(PAGE)
                            binding.pageNumber.clearFocus()
                            hideKeyboard(requireActivity())
                            return@setOnKeyListener true
                        } else {
                            false
                        }
                    }
                } else if (key == null
                    || key.toString() == EMPTY_STRING
                ) {
                    Toast.makeText(context, "Enter page", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.getGameInfoList().observe(viewLifecycleOwner,
            {
                adapter.submitList(it)
            })
    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun hideKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            activity.currentFocus?.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private val EMPTY_STRING = ""
        private val MIN_PAGE = 1
        private val PAGE_N = 0
        private val PAGE_P = 2

        fun newInstance() = JsonFragment()
    }
}