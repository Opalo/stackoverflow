import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TryTestNG
{
    @BeforeClass
    public void setup()
    {
        System.out.println("I am in Setup");
    }

    @Test
    public void test()
    {
        System.out.println("I am in Test");
    }

    @AfterClass
    public void tearDown()
    {
        System.out.println("I am in tearDown");
    }
}
