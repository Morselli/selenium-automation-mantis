package com.viniciusmorselli.mantis.tests;

import com.viniciusmorselli.mantis.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@DisplayName("Testes automatizados - Mantis - Tarefas")
public class TasksTests {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        String userName = "Vinicius_Morselli";
        String userPassword = "Teste@2024";

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LoginPage loginPage = new LoginPage(driver);

        loginPage.getLoginPage();
        loginPage.enterUserName(userName);
        loginPage.clickEnterButton();
        loginPage.enterPassword(userPassword);
        loginPage.clickEnterButton();
    }

    @Test
    @DisplayName("Criar tarefa a partir do botão na barra de navegação com sucesso")
    public void testCreateTaskFromNavBar() {
        String summary = "TAREFA-001 - Teste Automatizado";
        String description = "Descrição da tarefa do teste automatizado";

        MyViewPage myViewPage = new MyViewPage(driver);

        myViewPage.clickOnCreateTaskNavbarButton();

        CreateTaskPage createTaskPage = new CreateTaskPage(driver);

        createTaskPage.selectCategoryOption();
        createTaskPage.fillSummaryInput(summary);
        createTaskPage.fillDescriptionTextArea(description);
        createTaskPage.clickCreateNewTaskButton();

        TaskDetailsPage taskDetailsPage = new TaskDetailsPage(driver);

        taskDetailsPage.verifyBugSummary(summary);
        taskDetailsPage.verifyBugDescription(description);

        driver.quit();
    }

    @Test
    @DisplayName("Criar tarefa a partir do botão na barra lateral com sucesso")
    public void testCreateTaskFromSideBar() {
        String summary = "TAREFA-002 - Teste Automatizado";
        String description = "Descrição da tarefa do teste automatizado";

        MyViewPage myViewPage = new MyViewPage(driver);

        myViewPage.clickOnCreateTaskSidebarButton();

        CreateTaskPage createTaskPage = new CreateTaskPage(driver);

        createTaskPage.selectCategoryOption();
        createTaskPage.fillSummaryInput(summary);
        createTaskPage.fillDescriptionTextArea(description);
        createTaskPage.clickCreateNewTaskButton();

        TaskDetailsPage taskDetailsPage = new TaskDetailsPage(driver);

        taskDetailsPage.verifyBugSummary(summary);
        taskDetailsPage.verifyBugDescription(description);

        driver.quit();
    }

    @Test
    @DisplayName("Visualizar listagem de todas as tarefas com sucesso")
    public void testViewAllTasksList() {
        MyViewPage myViewPage = new MyViewPage(driver);

        myViewPage.clickOnViewTasksButton();

        TasksListPage tasksListPage = new TasksListPage(driver);

        tasksListPage.verifyTasksListUrl();
        tasksListPage.verifyViewingTasksH4();

        driver.quit();
    }

    @Test
    @DisplayName("Visulizar listagem de tarefas com filtro de 'Não Atribuído' com sucesso")
    public void testViewTasksListWithUnassignedFilter() {
        MyViewPage myViewPage = new MyViewPage(driver);

        myViewPage.clickOnViewUnassignedTasksAnchor();

        TasksListPage tasksListPage = new TasksListPage(driver);

        tasksListPage.verifyTasksListUrl();
        tasksListPage.verifyViewingTasksH4();

        driver.quit();
    }

    @Test
    @DisplayName("Visulizar listagem de tarefas com filtro de 'Relatados por Mim' com sucesso")
    public void testViewTasksListWithRelatedByMeFilter() {
        MyViewPage myViewPage = new MyViewPage(driver);

        myViewPage.clickOnViewReportedByMeTasksAnchor();

        TasksListPage tasksListPage = new TasksListPage(driver);

        tasksListPage.verifyTasksListUrl();
        tasksListPage.verifyViewingTasksH4();

        driver.quit();
    }

    @Test
    @DisplayName("Visulizar listagem de tarefas com filtro de 'Resolvidos' com sucesso")
    public void testViewTasksListWithResolvedFilter() {
        MyViewPage myViewPage = new MyViewPage(driver);

        myViewPage.clickOnViewResolvedTasksAnchor();

        TasksListPage tasksListPage = new TasksListPage(driver);

        tasksListPage.verifyTasksListUrl();
        tasksListPage.verifyViewingTasksH4();

        driver.quit();
    }

    @Test
    @DisplayName("Visulizar listagem de tarefas com filtro de 'Modificados Recentemente (30 Dias)' com sucesso")
    public void testViewTasksListWithRecentlyModifiedFilter() {
        MyViewPage myViewPage = new MyViewPage(driver);

        myViewPage.clickOnViewRecentlyModifiedTasksAnchor();

        TasksListPage tasksListPage = new TasksListPage(driver);

        tasksListPage.verifyTasksListUrl();
        tasksListPage.verifyViewingTasksH4();

        driver.quit();
    }

    @Test
    @DisplayName("Visulizar listagem de tarefas com filtro de 'Monitorados por Mim' com sucesso")
    public void testViewTasksListWithMonitoredByMeFilter() {
        MyViewPage myViewPage = new MyViewPage(driver);

        myViewPage.clickOnViewMonitoredByMeTasksAnchor();

        TasksListPage tasksListPage = new TasksListPage(driver);

        tasksListPage.verifyTasksListUrl();
        tasksListPage.verifyViewingTasksH4();

        driver.quit();
    }
}
