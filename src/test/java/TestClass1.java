import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestClass1 {

    /*
        @BeforeClass
        ++Variables que podemos reultizar



     */
    //Variables que podemos reutilizar
    //El webDriver
    //El input de la busqueda
    //El wait
    //el resultado - La list

    @Test
    public void searchGoogle() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //seteo el webdriver e indico en donde esta
        WebDriver chrome = new ChromeDriver(); //instancio un nuevo webdriver
        chrome.get("https://www.google.com.uy/"); //le indico hacia donde ir
        WebElement inputBusqueda = chrome.findElement(By.name("q")); //especifico el campo de busqueda y que lo encuentre por su nombre
        inputBusqueda.sendKeys("selenium"); //ingreso que es lo que voy a buscar
        inputBusqueda.submit(); //envia el formulario, literalmente despues de escribir lo que voy a buscar hago el enter para que lo busque
        //WebElement btnBuscar = chrome.findElement(By.name(("btnk"))); //le instancio que boton es el de buscar
        //btnBuscar.click();  //le indico que haga click en buscar
        //chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //establezco el timeout
        WebDriverWait wait = new WebDriverWait(chrome, 5); //establezco el tiempo de espera
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));//le idico que espere a que tal elemento aparezca
        Assert.assertEquals(chrome.getTitle(), "selenium - Buscar con Google"); //le pido que compare si es que el titulo de la pagina es el correcto
        List<WebElement> resultados = chrome.findElements(By.className("rc"));//el primer resultado esta contendido dentro de una class rc, que contiene una class r y dentro contiene una class h3
        Assert.assertTrue(resultados.size() > 0, "no hay resultados de la busqueda");
        chrome.quit(); //aca cierro el navegador y elimino el cache

    }

    @Test
    public void searchGoogleFirefox() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe"); //seteo el webdriver e indico en donde esta
        WebDriver firefox = new FirefoxDriver(); //instancio un nuevo webdriver
        firefox.get("https://www.google.com.uy/"); //le indico hacia donde ir
        WebElement inputBusqueda = firefox.findElement(By.name("q")); //especifico el campo de busqueda y que lo encuentre por su nombre
        inputBusqueda.sendKeys("selenium"); //ingreso que es lo que voy a buscar
        inputBusqueda.submit(); //envia el formulario, literalmente despues de escribir lo que voy a buscar hago el enter para que lo busque
        //WebElement btnBuscar = chrome.findElement(By.name(("btnk"))); //le instancio que boton es el de buscar
        //btnBuscar.click();  //le indico que haga click en buscar
        WebDriverWait wait = new WebDriverWait(firefox, 5); //establezco el tiempo de espera
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));//le idico que espere a que tal elemento aparezca
        //firefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //establezco el timeout
        Assert.assertEquals(firefox.getTitle(), "selenium - Buscar con Google"); //le pido que compare si es que el titulo de la pagina es el correcto
        List<WebElement> resultados = firefox.findElements(By.className("rc"));//el primer resultado esta contendido dentro de una class rc, que contiene una class r y dentro contiene una class h3
        Assert.assertTrue(resultados.size() > 0, "no hay resultados de la busqueda");
        firefox.quit(); //aca cierro el navegador y elimino el cache

    }


    /*
    @AfterClass
    +Le indicamos que cierre el navegador
     */
}
