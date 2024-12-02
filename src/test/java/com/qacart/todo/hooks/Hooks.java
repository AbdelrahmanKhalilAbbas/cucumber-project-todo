package com.qacart.todo.hooks;

import com.qacart.todo.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    WebDriver driver;
    @Before
    public void setup(){
        driver = DriverFactory.initDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
