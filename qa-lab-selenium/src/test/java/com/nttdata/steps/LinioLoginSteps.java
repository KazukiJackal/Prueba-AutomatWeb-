package com.nttdata.steps;

import com.nttdata.page.LinioLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinioLoginSteps {

    private WebDriver driver;

    //constructor
    public LinioLoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LinioLoginPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LinioLoginPage.loginButton));

    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LinioLoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(LinioLoginPage.loginButton).click();
    }

    public void seleccionMejoresCalificados(){
        this.driver.findElement(LinioLoginPage.selectionMjcal).click();
    }

    public void seleccionoUnProductoAleatorio(){
        this.driver.findElement(LinioLoginPage.selectionProdAleat).click();
    }
    public void carrito(){
        this.driver.findElement(LinioLoginPage.selectionCarritodeCompras).click();
    }
}
