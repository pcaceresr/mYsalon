package services

import com.example.mysalon.models.LoginPayloadDTO
import com.example.mysalon.models.LoginResponseDTO
import com.example.mysalon.models.RegisterPayloadDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/api/auth/local")
    fun login(@Body payload: LoginPayloadDTO): Call<LoginResponseDTO>

    @POST("/api/auth/local/register")
    fun register(@Body payload: RegisterPayloadDTO): Call<Void>

}