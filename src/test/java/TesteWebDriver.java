import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteWebDriver {

    private WebDriver driver;

    @BeforeEach
    public void abreNavegador(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void fechaNavegador(){
        driver.close();
    }

    @Test
    public void verificaTitulo() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://www.google.com.br");
        TimeUnit.SECONDS.sleep(3);
        driver.get("https://github.com/matheuscosantos");
        TimeUnit.SECONDS.sleep(3);
        assertEquals(driver.getTitle(), "matheuscosantos (matheuscosantos) \u00b7 GitHub");
    }
}

