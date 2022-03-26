package com.example.testproject.presentation.view.json

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.MyApp
import com.example.testproject.databinding.FragmentJsonBinding
import com.example.testproject.presentation.adapter.json.MoviesAdapter
import com.example.testproject.presentation.viewModel.json.JsonViewModel
import com.example.testproject.presentation.viewModel.json.JsonViewModelFactory
import java.lang.RuntimeException
import javax.inject.Inject

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
        val adapter = MoviesAdapter()

        viewModel.moviesLit.observe(viewLifecycleOwner
        ) {
            adapter.submitList(it)
        }

        binding.rvMovies.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = JsonFragment()
    }
}