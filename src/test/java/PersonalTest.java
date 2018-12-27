import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PersonalTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public LogoutPage logoutPage;
    public UserManagementPage userManagementPage;
    public JobTitlesPage jobTitlesPage;
    public CandidatesPage candidatesPage;
    public DashboardPage dashboardPage;
    public PimPage pimPage;
    public String baseUrl;

    @Before
    public void setup() {
        System.getProperty("java.classpath");
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        jobTitlesPage = new JobTitlesPage(driver);
        userManagementPage = new UserManagementPage(driver);
        candidatesPage = new CandidatesPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PimPage(driver);
        baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void tests() {
        //1
        loginPage.inputLogin("admin");
        loginPage.inputPassword("admin123");
        loginPage.clickLogin();

        //2
        userManagementPage.toFormAddUser();
        userManagementPage.checkForm();
        userManagementPage.addUser();

        //3
        jobTitlesPage.toFormJobTitles();
        jobTitlesPage.deleteJobTitles();

        //4
        candidatesPage.toFormCandidates();
        candidatesPage.addCandidate();

        //5
        dashboardPage.toFormDashboard();
        dashboardPage.checkForm();

        //6
        pimPage.toFormPIM();
        pimPage.chooseUnit();
        pimPage.checkForm();

        //7
        logoutPage.toLogout();
        logoutPage.clickLogout();
    }

    @After
    public void shutDown() {
        driver.quit();
    }
}
