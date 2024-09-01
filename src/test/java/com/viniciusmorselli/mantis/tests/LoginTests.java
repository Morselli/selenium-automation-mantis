package com.viniciusmorselli.mantis.tests;

import com.viniciusmorselli.mantis.pages.LoginPage;
import com.viniciusmorselli.mantis.pages.MyViewPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@DisplayName("Testes automatizados - Mantis - Login")
public class LoginTests {
	WebDriver driver;

	@BeforeEach
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	@DisplayName("Realizar login com sucesso")
	public void testLoginSuccessfully() {
		String userName = "Vinicius_Morselli";
		String userPassword = "Teste@2024";

		LoginPage loginPage = new LoginPage(driver);

		loginPage.getLoginPage();
		loginPage.enterUserName(userName);
		loginPage.clickEnterButton();
		loginPage.enterPassword(userPassword);
		loginPage.clickEnterButton();

		MyViewPage myViewPage = new MyViewPage(driver);

		myViewPage.verifyLoggedUser(userName);

		driver.quit();
	}

	@Test
	@DisplayName("Tentar realizar login sem sucesso")
	public void testUnsuccessfulLogin() {
		String userName = "Teste_Testando";
		String userPassword = "12345";

		LoginPage loginPage = new LoginPage(driver);

		loginPage.getLoginPage();
		loginPage.enterUserName(userName);
		loginPage.clickEnterButton();
		loginPage.enterPassword(userPassword);
		loginPage.clickEnterButton();

		loginPage.verifyUnsuccessfulLoginMessage();

		driver.quit();
	}
}
