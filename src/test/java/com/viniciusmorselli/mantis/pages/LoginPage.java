package com.viniciusmorselli.mantis.pages;

import com.viniciusmorselli.mantis.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.function.BooleanSupplier;

public class LoginPage extends BasePage {
	By usernameField = By.id("username");
	By passwordField = By.id("password");
	By enterButton = By.xpath("//input[@value='Entrar']");
	By loginErrorMessage = By.className("alert-danger");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void getLoginPage() {
		driver.get("https://mantis-prova.base2.com.br/login_page.php");
	}

	public LoginPage enterUserName(String userName) {
		driver.findElement(usernameField).sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
		return this;
	}
	
	public LoginPage clickEnterButton() {
		driver.findElement(enterButton).click();
		return this;
	}

	public LoginPage verifyUnsuccessfulLoginMessage() {
		try {
			WebElement messageDiv = driver.findElement(loginErrorMessage);
			Assertions.assertNotNull(messageDiv);
		} catch (NoSuchElementException e) {
			Assertions.fail("Element not found");
		}
		return this;
	}
}
