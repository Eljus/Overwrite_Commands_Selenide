import com.codeborne.selenide.Configuration;
import com.configurations.SetUp;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Demo_Test_To_Apply_Commands {

    @BeforeTest
    public void configure(){
        new SetUp().browserConfigurations();
    }

    @BeforeMethod
    public void configuration(){
        open("/");
    }

    @Test
    public void testNewClick(){
        $(By.name("q")).setValue("Selenide testing");
    }
}
