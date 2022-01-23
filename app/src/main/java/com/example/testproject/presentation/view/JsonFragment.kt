package com.example.testproject.presentation.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.MyApp
import com.example.testproject.databinding.FragmentJsonBinding
import com.example.testproject.domain.repository.pojo.GameInfo
import com.example.testproject.presentation.adapter.GameInfoAdapter
import com.example.testproject.presentation.viewModel.JsonViewModel
import com.example.testproject.presentation.viewModel.JsonViewModel.Companion.PAGE
import com.example.testproject.presentation.viewModel.JsonViewModelFactory
import java.lang.RuntimeException
import javax.inject.Inject

class JsonFragment : Fragment() {

    private lateinit var viewModel: JsonViewModel

    @Inject
    lateinit var viewModelFactory: JsonViewModelFactory

    private val component by lazy {
        (requireActivity().application as MyApp).component
    }

    override fun onAttach(context: Context) {
        component.injectJsonFragment(this)
        super.onAttach(context)
    }

    private var _binding: FragmentJsonBinding? = null
    private val binding: FragmentJsonBinding
        get() = _binding ?: throw RuntimeException("FragmentJsonBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJsonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[JsonViewModel::class.java]
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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

    companion object {

        private val EMPTY_STRING = ""
        private val MIN_PAGE = 1
        private val PAGE_N = 0
        private val PAGE_P = 2

        fun newInstance() = JsonFragment()
    }
}