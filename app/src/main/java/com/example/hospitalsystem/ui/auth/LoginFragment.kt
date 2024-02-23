package com.example.hospitalsystem.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.hospitalsystem.R
import com.example.hospitalsystem.databinding.FragmentLoginBinding
import com.example.hospitalsystem.utils.HR
import com.example.hospitalsystem.utils.MySharedPreferences
import com.example.hospitalsystem.utils.RECEPTIONIST
import com.example.hospitalsystem.utils.Resource
import com.example.hospitalsystem.utils.showToast
import com.example.hospitalsystem.utils.visibilityGone
import com.example.hospitalsystem.utils.visibilityVisible
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {

    val loginViewModel by viewModels<LoginViewModel>()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.toString().trim()

            if (validateLogin(email, password)) {
                loginViewModel.login(email, password, "sss")
            }
        }

        observe()

    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginViewModel.loginSF.collectLatest {response ->
                    when (response) {
                        is Resource.Loading -> {
                            showLoading()
                        }

                        is Resource.Success -> {
                            hideLoading()
                            showToast("Welcome back")
                            response.data?.let {userData ->
                                MySharedPreferences.setUserTOKEN(userData.access_token)
                                MySharedPreferences.setUserType(userData.type)
                                MySharedPreferences.setUserName(userData.first_name+" "+userData.last_name)
                                MySharedPreferences.setUserId(userData.id)
                                navigate(userData.type)
                            }

                        }

                        is Resource.Error -> {
                            hideLoading()
                            response.message?.let {message->
                                showToast(message)
                            }
                        }

                        else -> {}
                    }
                }
            }
        }

    }

    private fun navigate(type: String) {
        when(type){
            HR -> findNavController().navigate(R.id.action_loginFragment_to_hrFragment)
            RECEPTIONIST-> findNavController().navigate(R.id.action_loginFragment_to_specialistFragment)
        }
    }

    private fun showLoading() {
        binding.progressLogin.visibilityGone()
    }

    private fun hideLoading() {
        binding.progressLogin.visibilityVisible()
    }

    private fun validateLogin(email: String, password: String): Boolean {
        val emailRegex = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+$")
        if (email.isEmpty()) {
            binding.etEmail.error = getString(R.string.required)
            binding.etEmail.requestFocus()
            return false
        } else if (password.isEmpty()) {
            binding.etPassword.error = getString(R.string.required)
            binding.etPassword.requestFocus()
            return false
        } else if (!emailRegex.matches(email)) {
            binding.etEmail.error = "Wrong email"
            binding.etEmail.requestFocus()
            return false
        } else {
            return false
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}