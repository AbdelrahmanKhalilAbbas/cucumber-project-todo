package com.qacart.todo.steps;

import com.qacart.todo.Page.LoginPage;
import com.qacart.todo.Page.NewTodoPage;
import com.qacart.todo.Page.TodoPage;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.EnvUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TodoSteps {
    WebDriver driver;
    @Given("User is at the todo page")
    public void UserIsAtTheTodoPage() throws IOException {
        driver = DriverFactory.getDriver();
        new LoginPage(driver).load(EnvUtils.getInstance().getURL());
        new LoginPage(driver).login(EnvUtils.getInstance().getEmail(),EnvUtils.getInstance().getPassword());
    }
    @When("User add a new todo")
    public void UserAddANewTodo(){
        new TodoPage(driver).plusButtonClick();
        new NewTodoPage(driver).addTodo("Learn Cucumber");
    }
    @Then("Todo should be added correctly")
    public void TodoShouldBeAddedCorrectly(){
        String text = new TodoPage(driver).getLastTodoText();
        Assert.assertEquals(text,"Learn Cucumber");
    }
}
