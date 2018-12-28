package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Steps {

    public WebDriver driver;
    public LoginPage loginPage;
    public LogoutPage logoutPage;
    public UserManagementPage userManagementPage;
    public JobTitlesPage jobTitlesPage;
    public CandidatesPage candidatesPage;
    public DashboardPage dashboardPage;
    public PimPage pimPage;
    public String baseUrl;

    @Given("^Login page under administrator rights$")
    public void login_page_under_administrator_rights() {
        System.getProperty("java.classpath");
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
        driver.get(baseUrl);

        loginPage = new LoginPage(driver);
        loginPage.inputLogin("admin");
        loginPage.inputPassword("admin123");
        loginPage.clickLogin();
    }

    @When("^We check the form and add the user$")
    public void we_check_the_form_and_add_the_user() {
        userManagementPage = new UserManagementPage(driver);
        userManagementPage.toFormAddUser();
        userManagementPage.checkForm();
        userManagementPage.addUser();
    }

    @When("^Delete (\\d+) Job Titles$")
    public void delete_Job_Titles(int count) {
        jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.toFormJobTitles();
        jobTitlesPage.deleteJobTitles(count);
    }

    @When("^Add candidate$")
    public void add_candidate() {
        candidatesPage = new CandidatesPage(driver);
        candidatesPage.toFormCandidates();
        candidatesPage.addCandidate();
    }

    @When("^Check Dashboard$")
    public void check_Dashboard() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.toFormDashboard();
        dashboardPage.checkForm();
    }

    @Then("^Check personal details of any sales$")
    public void check_personal_details_of_any_sales() {
        pimPage = new PimPage(driver);
        pimPage.toFormPIM();
        pimPage.chooseUnit();
        pimPage.checkForm();
    }

    @Then("^Logged off from the page$")
    public void logged_off_from_the_page() {
        logoutPage = new LogoutPage(driver);
        logoutPage.toLogout();
        logoutPage.clickLogout();
        driver.quit();
    }
}
