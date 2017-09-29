import java.util.Random
import org.junit.Test;

class CreateUserKt {

    @Test
    fun createRandomUser() {
        val random = Random()
        val randomNumber = random.nextInt(10000000)
        val customer = Customer("password", "password", "lastName", "firstName", "ted$randomNumber@gmail.com")
    }
}
