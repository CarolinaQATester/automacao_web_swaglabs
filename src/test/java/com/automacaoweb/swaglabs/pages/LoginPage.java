package com.automacaoweb.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    //Login
    @FindBy(how = How.XPATH, using = "//input[@type='text'][@id='user-name']")
    private WebElement inputLogin;
    @FindBy(how = How.XPATH, using = "//input[@type='password'][@id='password']")
    private WebElement inputPassword;
    @FindBy(how = How.XPATH, using = "//input[@type='submit'][@id='login-button']")
    private WebElement btnLogin;

   
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void preencherUser(String user){
        inputLogin.sendKeys(user);
    }
    public void preenhcerPassword(String pass){
        inputPassword.sendKeys(pass);
    }
    public void clicarLogin(){
        btnLogin.click();
    }

}
