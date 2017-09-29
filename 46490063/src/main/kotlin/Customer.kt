import com.google.gson.annotations.SerializedName

data class Customer(val password1: String,
                val password2: String,
                @SerializedName("last_name") val lastName: String,
                @SerializedName("first_name") val firstName: String,
                val email: String)
