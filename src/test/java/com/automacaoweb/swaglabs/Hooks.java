package com.automacaoweb.swaglabs;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;

    @Before
    public void iniciar() {
        Driver wdriver = new Driver();
        driver = wdriver.webDriver();
    }

    @After
    public void finalizar() {
         driver.quit();
    }

    
}
