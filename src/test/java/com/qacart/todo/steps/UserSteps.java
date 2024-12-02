package com.qacart.todo.steps;

import com.qacart.todo.Page.LoginPage;
import com.qacart.todo.Page.TodoPage;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.EnvUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class UserSteps {
    WebDriver driver;
    @Given("User is at the login page")
    public void userIsAtTheLoginPage() throws IOException {
        driver = DriverFactory.getDriver();
        new LoginPage(driver).load(EnvUtils.getInstance().getURL());
    }
    @When("User fill the email and password and login")
    public void userFillTheEmailAndPassword() throws IOException {
        new LoginPage(driver).login(EnvUtils.getInstance().getEmail(),EnvUtils.getInstance().getPassword());
    }
    @Then("Welcome message should be displayed")
    public void welcomeMessageShouldBeDisplayed(){
        boolean isWelcomeDisplayed = new TodoPage(driver).isWelcomeDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
    }
}
