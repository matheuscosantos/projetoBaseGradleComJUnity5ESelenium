import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteAreaDeTreinamento {

    private static WebDriver driver;

    @BeforeAll
    public static void abreNavegador() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void fechaNavegador() {
        driver.close();
    }

    @Test
    public void teste00AbreAreaDeTreinamento(){
        driver.get("file:///" + System.getProperty("user.dir") + "\\src\\test\\resources\\campo-treinamento\\componentes.html");
    }

    @Test
    public void teste01TextFieldNome(){
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste do nome");
        String valorAtual = driver.findElement(By.id("elementosForm:nome")).getAttribute("value");
        assertEquals("Teste do nome",valorAtual);
    }

    @Test
    public void teste02TextFieldSobrenome(){
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Teste do sobrenome");
        String valorAtual = driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value");
        assertEquals("Teste do sobrenome",valorAtual);
    }

    @Test
    public void teste03TextAreaSugestoes(){
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste das sugest\u00f5es\nSugest\u00e3o 01\nSugest\u00e3o 02");
        String valorAtual = driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value");
        assertEquals("Teste das sugest\u00f5es\nSugest\u00e3o 01\nSugest\u00e3o 02",valorAtual);
    }

    @Test
    public void teste04RadioButtonMasculino(){
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        assertEquals(driver.findElement(By.id("elementosForm:sexo:0")).isSelected(),true);
    }

    @Test
    public void teste05RadioButtonFeminino(){
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        assertEquals(driver.findElement(By.id("elementosForm:sexo:1")).isSelected(),true);
    }

    @Test
    public void teste06CheckBoxComidaFavoritaTodos(){
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();

        assertEquals(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected(),true);
        assertEquals(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected(),true);
        assertEquals(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected(),true);
        assertEquals(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected(),true);
    }

    @Test
    public void teste07ComboBoxEscolaridade(){
        WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(elemento);
        //combo.selectByIndex(2);
        //combo.selectByValue("2graucomp");
        combo.selectByVisibleText("Especializacao");
        assertEquals("Especializacao",combo.getFirstSelectedOption().getText());
    }

    @Test
    public void teste08ComboBoxEscolaridadeValores(){
        WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(elemento);
        List<WebElement> opcoes = combo.getOptions();
        //assertEquals(8,opcoes.size());

        boolean encontrou = false;
        for(WebElement opcao : opcoes){
            if(opcao.getText().equals("Mestrado")){
                encontrou = true;
            }
        }
        assertEquals(true,encontrou);
    }

    @Test
    public void teste09ComboBoxEsportesMultiplasSelecoes(){
        WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(elemento);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");
        List<WebElement> todosElementosSelecionados = combo.getAllSelectedOptions();
        assertEquals(3,todosElementosSelecionados.size());
    }
}