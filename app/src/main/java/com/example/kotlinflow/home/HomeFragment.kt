package com.example.kotlinflow.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinflow.R
import com.example.kotlinflow.databinding.FragmentHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.numberSeq2.forEach {
//            Log.d("hello", "Sequence $it")
//        }
//        lifecycleScope.launchWhenResumed {
//            viewModel.firstFlow.collect {
//                delay(1000)
//                Log.d("hello", "hello first flow $it")
//            }
//        }

//        lifecycleScope.launchWhenResumed {
//            viewModel.firstFlow.buffer().collect {
//                delay(1000)
//                Log.d("hello", "hello from collection:  $it")
//            }
//        }
//        lifecycleScope.launchWhenResumed {
//            viewModel.firstFlow
//                .filter { it and 1 == 1 }
////                .map { it*2 }
//                .collect {
//                    delay(3000)
//                    Log.d("hello", "hello from collection first:  $it")
//                }
//        }

//        lifecycleScope.launchWhenResumed {
//            viewModel.createCountDownTimer(10)
//                .catch {
//                    Log.d("hello", "Exception")
//                }
//                .collect {
//                    binding.tvFlow.text= it.toString()
//                }
//        }
//
//        lifecycleScope.launchWhenResumed {
//            viewModel.getCountDownTimer(10)
//                .catch {
//                    Log.d("hello", "Exception")
//                }
//                .collect {
//                    binding.tvFlow.text= it.toString()
//                }
//        }
//
//        lifecycleScope.launchWhenResumed {
//            viewModel.getCountDownTimer(10).asLiveData().observe(viewLifecycleOwner){
//                Log.d("hello", "hello  frim live data $it")
//            }
//        }

        binding.btnStart.setOnClickListener {
            val minute = Integer.parseInt(binding.etMinute.text.toString())
            val second = Integer.parseInt(binding.etSecond.text.toString())

            val action = HomeFragmentDirections.actionHomeFragmentToResultFragment(minute, second)
            NavHostFragment.findNavController(this).navigate(action)

//            startTimer()
        }
    }

//    private fun startTimer(){
//        try {
//            val minute = Integer.parseInt(binding.etMinute.text.toString())
//            val second = Integer.parseInt(binding.etSecond.text.toString())
//            lifecycleScope.launchWhenResumed {
////                viewModel.getCountDownTimer(minute , second)
////                    .collect{
////                        viewModel.minutes = minute
////                        viewModel.seconds = second
//////                        binding.tvFlow.text = it
////                    }
//            }
//        } catch (e: Exception) {
//            Toast.makeText(requireContext(), "invalid input", Toast.LENGTH_SHORT).show()
//        }
//
//    }

}