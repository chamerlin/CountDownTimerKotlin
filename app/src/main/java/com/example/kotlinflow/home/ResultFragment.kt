package com.example.kotlinflow.home

import android.icu.number.IntegerWidth
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.kotlinflow.databinding.FragmentResultBinding
import kotlinx.coroutines.launch

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val viewModel: HomeViewModel by viewModels()
    val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_result, container, false)
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startTimer()
    }

    private fun startTimer(){
        try {
            lifecycleScope.launchWhenResumed {
                viewModel.getCountDownTimer(args.minutes , args.seconds)
                    .collect{
                        binding.tvFlow.text = it
                    }
            }
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "invalid input", Toast.LENGTH_SHORT).show()
        }

    }
}