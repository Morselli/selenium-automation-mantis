package com.viniciusmorselli.mantis.pages;

import com.viniciusmorselli.mantis.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskDetailsPage extends BasePage {

    By bugSummaryTd = By.xpath("//td[@class='bug-summary']");
    By bugDescriptionTd = By.xpath("//td[@class='bug-description']");

    public TaskDetailsPage(WebDriver driver) {
        super(driver);
    }

    public TaskDetailsPage verifyBugSummary(String summary) {
        String bugSummary = driver.findElement(bugSummaryTd).getText();
        Assertions.assertTrue(bugSummary.contains(summary));
        return this;
    }

    public TaskDetailsPage verifyBugDescription(String description) {
        String bugDescription = driver.findElement(bugDescriptionTd).getText();
        Assertions.assertEquals(bugDescription, description);
        return this;
    }
}
