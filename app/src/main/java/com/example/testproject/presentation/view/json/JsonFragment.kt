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
            .jsonFragmentComponentFactory()
            .create()
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
        binding.rvMovies.adapter = adapter
        viewModel.gameInfoLDList.observe(viewLifecycleOwner
        ) {
            adapter.submitList(it)
            println("DONE $it")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = JsonFragment()
    }
}