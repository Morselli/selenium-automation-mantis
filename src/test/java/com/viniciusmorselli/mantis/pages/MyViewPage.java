package com.viniciusmorselli.mantis.pages;

import com.viniciusmorselli.mantis.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyViewPage extends BasePage {

    By userInfoSpan = By.className("user-info");
    By createTaskNavbarButton = By.xpath("//a[@href='bug_report_page.php']");
    By createTaskSidebarButton = By.xpath("//a[@href='/bug_report_page.php']");
    By viewTasksButton = By.xpath("//a[@href='/view_all_bug_page.php']");
    By viewUnassignedTasksAnchor = By.xpath("//a[@href='view_all_set.php?type=1&temporary=y&handler_id=[none]&hide_status=90']");
    By viewReportedByMeTasksAnchor = By.xpath("//a[@href='view_all_set.php?type=1&temporary=y&reporter_id=280&hide_status=90']");
    By viewResolvedTasksAnchor = By.xpath("//a[@href='view_all_set.php?type=1&temporary=y&status=80&hide_status=90']");
    By viewRecentlyModifiedTasksAnchor = By.xpath("//a[@href='view_all_set.php?type=1&temporary=y&hide_status=none&filter_by_last_updated_date=1&last_updated_end_day=1&last_updated_end_month=9&last_updated_end_year=2024&last_updated_start_day=2&last_updated_start_month=8&last_updated_start_year=2024']");
    By viewMonitoredByMeTasksAnchor = By.xpath("//a[@href='view_all_set.php?type=1&temporary=y&monitor_user_id=280&hide_status=90']");

    public MyViewPage(WebDriver driver) {
        super(driver);
    }

    public MyViewPage verifyLoggedUser(String userName) {
        String spanName = driver.findElement(userInfoSpan).getText();
        Assertions.assertEquals(userName, spanName);
        return this;
    }

    public MyViewPage clickOnCreateTaskNavbarButton() {
        driver.findElement(createTaskNavbarButton).click();
        return this;
    }

    public MyViewPage clickOnCreateTaskSidebarButton() {
        driver.findElement(createTaskSidebarButton).click();
        return this;
    }

    public MyViewPage clickOnViewTasksButton() {
        driver.findElement(viewTasksButton).click();
        return this;
    }

    public MyViewPage clickOnViewUnassignedTasksAnchor() {
        driver.findElement(viewUnassignedTasksAnchor).click();
        return this;
    }

    public MyViewPage clickOnViewReportedByMeTasksAnchor() {
        driver.findElement(viewReportedByMeTasksAnchor).click();
        return this;
    }

    public MyViewPage clickOnViewResolvedTasksAnchor() {
        driver.findElement(viewResolvedTasksAnchor).click();
        return this;
    }

    public MyViewPage clickOnViewRecentlyModifiedTasksAnchor() {
        driver.findElement(viewRecentlyModifiedTasksAnchor).click();
        return this;
    }

    public MyViewPage clickOnViewMonitoredByMeTasksAnchor() {
        driver.findElement(viewMonitoredByMeTasksAnchor).click();
        return this;
    }
}
