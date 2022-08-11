package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LinioLoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LinioStepDef {

    private WebDriver driver;
    private Scenario scenario;
    private LinioLoginSteps loginSteps;


    @Before(order = 0)
    public void setUp() {
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Given("estoy en la pagina de login de linio")
    public void EstoyEnLaPaginaDeLogindeLinio() {
        driver.get("https://www.linio.com.pe/account/login");
        screenShot();
    }

    @When("digito mis datos de usuario {string} y clave {string}")
    public void digitomisdatosdeUsuarioYClave(String user, String password) {
        loginSteps = new LinioLoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        screenShot();
    }

    @And("hago clic en el botón login")
    public void hagoClicEnElBotónLogin() {
        loginSteps.login();
        screenShot();
    }

    @And("se muestra que inicié sesión correctamente")
    public void SeMuestraQueIniciéSesiónCorrectamente() {
        screenShot();//falta implementar
    }


    @And("hago clic en la opción Mejores Calificados")
    public void hagoClicEnLaOpciónMejoresCalificados() {
        loginSteps.seleccionMejoresCalificados();
        screenShot();
    }
    @And("selecciono un producto aleatorio")
    public void seleccionoUnProductoAleatorio() {
        loginSteps.seleccionoUnProductoAleatorio();
        screenShot();
    }
    @And("hago clic en el botón añadir al carrito")
    public void hagoClicEnElBotónAñadirAlCarrito() {
        loginSteps.carrito();
        screenShot();
    }


    public void screenShot() {
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
}
