package com.viniciusmorselli.mantis.pages;

import com.viniciusmorselli.mantis.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTaskPage extends BasePage {

    By categorySelect = By.id("category_id");
    By categoryOptionValueTwo = By.xpath("//option[@value=2]");
    By summaryInput = By.id("summary");
    By descriptionTextArea = By.id("description");
    By createNewTaskButton = By.xpath("//input[@value='Criar Nova Tarefa']");

    public CreateTaskPage(WebDriver driver) {
        super(driver);
    }

    public CreateTaskPage selectCategoryOption() {
        driver.findElement(categorySelect).click();
        driver.findElement(categoryOptionValueTwo).click();
        return this;
    }

    public CreateTaskPage fillSummaryInput(String text) {
        driver.findElement(summaryInput).sendKeys(text);
        return this;
    }

    public CreateTaskPage fillDescriptionTextArea(String text) {
        driver.findElement(descriptionTextArea).sendKeys(text);
        return this;
    }

    public CreateTaskPage clickCreateNewTaskButton() {
        driver.findElement(createNewTaskButton).click();
        return this;
    }
}
