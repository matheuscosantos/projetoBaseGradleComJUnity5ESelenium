import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TesteWebDriver {

    @Test
    public void testaNavegador() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://www.google.com.br");
        TimeUnit.SECONDS.sleep(5);
        driver.get("https://github.com/matheuscosantos");
        TimeUnit.SECONDS.sleep(5);
        driver.close();
    }
}
