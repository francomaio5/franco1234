import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass2 {

    @Test
    public void TestClass1LogInCorrecto () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://verstandqa.com/login-employee-v2/");
        WebElement inputUsuario = chrome.findElement(By.id("user"));
        inputUsuario.sendKeys("admin");
        WebElement inputPassword = chrome.findElement(By.id("pass"));
        inputPassword.sendKeys("admin123");
        WebElement logInBtn = chrome.findElement((By.id("loginButton")));
        logInBtn.click();
        Assert.assertEquals(chrome.getTitle(), "Add Employee v2 – Verstand QA");
        WebElement addButton = chrome.findElement(By.id("addButton"));
        Assert.assertTrue(addButton.isDisplayed());
    }

    @Test
    public void TestClassLogInMal () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://verstandqa.com/login-employee-v2/");
        WebElement inputUsuario = chrome.findElement(By.id("user"));
        inputUsuario.sendKeys("admin");
        WebElement inputPassword = chrome.findElement(By.id("pass"));
        inputPassword.sendKeys("");
        WebElement logInBtn = chrome.findElement((By.id("loginButton")));
        logInBtn.click();
        WebElement failMessage = chrome.findElement(By.name("errorMessage"));
        Assert.assertTrue(failMessage.isDisplayed());
        Assert.assertEquals(failMessage.getText(), "Bad credentials Please try again..");
    }

    @Test

    public void TestCrearEmpleado () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://verstandqa.com/login-employee-v2/");
        WebElement inputUsuario = chrome.findElement(By.id("user"));
        inputUsuario.sendKeys("admin");
        WebElement inputPassword = chrome.findElement(By.id("pass"));
        inputPassword.sendKeys("admin123");
        WebElement logInBtn = chrome.findElement((By.id("loginButton")));
        logInBtn.click();
        Assert.assertEquals(chrome.getTitle(), "Add Employee v2 – Verstand QA");
        WebElement addButton = chrome.findElement(By.id("addButton"));
        Assert.assertTrue(addButton.isDisplayed());
            WebElement nameField = chrome.findElement(By.name("name"));
            WebElement addressField = chrome.findElement(By.name("address"));
            WebElement cityField = chrome.findElement(By.name("city"));
            WebElement stateField = chrome.findElement(By.name("state"));
            WebElement postCodeField = chrome.findElement(By.name("postcode"));
            WebElement emailField = chrome.findElement(By.name("email"));
            WebElement phoneNumberField = chrome.findElement(By.name("phoneNumber"));
                nameField.sendKeys("Ramón");
                addressField.sendKeys("Ramón");
                cityField.sendKeys("Ramón");
                stateField.sendKeys("Ramón");
                postCodeField.sendKeys("Ramón");
                emailField.sendKeys("Ramón");
                phoneNumberField.sendKeys("Ramón");
                    WebElement addBttn = chrome.findElement(By.name("addButton"));
                    addBttn.click();
                    WebElement successAlert = chrome.findElement(By.name("success-alert"));
                    Assert.assertTrue(successAlert.isDisplayed());

    }


    }
