package com.example.testproject.presentation.view.json

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.data.network.json.ApiFactory
import com.example.testproject.databinding.FragmentJsonBinding
import com.example.testproject.data.network.json.model.GameInfoDto
import com.example.testproject.databinding.ItemGameInfoBinding
import com.example.testproject.domain.repository.json.pojo.GameInfo
import com.example.testproject.presentation.adapter.json.GameInfoAdapter
import com.example.testproject.presentation.viewModel.json.JsonViewModel
import com.example.testproject.presentation.viewModel.json.JsonViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import kotlin.concurrent.thread

class JsonFragment : Fragment() {

    private val viewModelFactory by lazy {
        JsonViewModelFactory(requireActivity().application)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[JsonViewModel::class.java]
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
        val adapter = GameInfoAdapter(requireContext())
        adapter.onGameClickListener = object : GameInfoAdapter.OnGameClickListener {
            override fun onGameClick(gameInfo: GameInfo) {
                Toast.makeText(context, gameInfo.name, Toast.LENGTH_SHORT).show()
            }
        }
        adapter.onNameLongClickListener = object : GameInfoAdapter.OnNameLongClickListener {
            override fun onNameLongClick() {
                Toast.makeText(context, "Copy text to clipboard using popup", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.rvGameInfoList.adapter = adapter
        viewModel.getGameInfoList().observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = JsonFragment()
    }
}