package com.example.gameapp.allFragments.loginFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.gameapp.R
import com.example.gameapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    val loginViewmodel by viewModels<LoginViewmodel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.createAccountTxt.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
        observerData()
    }

    fun observerData(){

        loginViewmodel.liveDataBinking.observe(viewLifecycleOwner, Observer {
            if(it){
                binding.createAccountTxt.visibility = if (binding.createAccountTxt.visibility == View.VISIBLE) {
                    View.INVISIBLE
                } else {
                    View.VISIBLE
                }
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        loginViewmodel.isBlinking=false
        loginViewmodel.handler.removeCallbacksAndMessages(null)
    }

}