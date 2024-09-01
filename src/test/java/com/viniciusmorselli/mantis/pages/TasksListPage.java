package com.viniciusmorselli.mantis.pages;

import com.viniciusmorselli.mantis.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TasksListPage extends BasePage {

    By viewingTasksH4 = By.xpath("//h4[contains(., 'Visualizando Tarefas ')]");

    public TasksListPage(WebDriver driver) {
        super(driver);
    }

    public TasksListPage verifyViewingTasksH4() {
        WebElement h4 = driver.findElement(viewingTasksH4);
        Assertions.assertNotNull(h4);
        return this;
    }

    public TasksListPage verifyTasksListUrl() {
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.contains("view_all_bug_page.php"));
        return this;
    }
}
