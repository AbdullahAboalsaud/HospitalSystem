package com.example.hospitalsystem.ui.auth


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitalsystem.data.ModelLogin
import com.example.hospitalsystem.data.UserData
import com.example.hospitalsystem.repository.Repo
import com.example.hospitalsystem.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel : ViewModel() {

    private val repo = Repo()

    private val _loginSF = MutableStateFlow<Resource<UserData>>(Resource.Unspecified())
    val loginSF = _loginSF.asStateFlow()


    fun login(email: String, password: String, deviceToken: String) {
        viewModelScope.launch {

            _loginSF.emit(Resource.Loading())
            try {
                val response = repo.login(email, password, deviceToken)
                if (response.status==1) {
                    _loginSF.emit(Resource.Success(response.data))
                }else{
                    _loginSF.emit(Resource.Error(response.message))
                }
            } catch (e: Exception) {
                _loginSF.emit(Resource.Error("Error: ${e.message}"))
            }

        }
    }


}