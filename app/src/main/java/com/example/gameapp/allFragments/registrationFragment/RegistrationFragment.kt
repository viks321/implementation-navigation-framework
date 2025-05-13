package com.example.gameapp.allFragments.registrationFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.gameapp.R
import com.example.gameapp.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    lateinit var binding : FragmentRegistrationBinding
    val registrationViewmodel by viewModels<RegistrationViewmodel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegistrationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginText.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
        observerData()
    }

    fun observerData(){

        registrationViewmodel.liveDataBinking.observe(viewLifecycleOwner, Observer {
            if(it){
                binding.loginText.visibility = if (binding.loginText.visibility == View.VISIBLE) {
                    View.INVISIBLE
                } else {
                    View.VISIBLE
                }
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        registrationViewmodel.isBlinking=false
        registrationViewmodel.handler.removeCallbacksAndMessages(null)
    }

}