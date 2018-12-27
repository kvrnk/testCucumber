package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class UserManagementPage {
    private WebDriver driver;
    private String helpText1 = "Very Weak";
    private String helpText2 = "For a strong password, please use a hard to guess combination of text with upper and lower case characters, symbols and numbers";
    private String validationError1 = "Invalid";
    private String validationError2 = "Should have at least 5 characters";
    private String validationError3 = "Should have at least 8 characters";
    private String validationError4 = "Please enter at least 8 characters.";
    private String employeeName = "Fiona Grace";
    private String userName = "Fiona.grace1111";
    private String password = "123456789";

    public UserManagementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminTab;

    @FindBy(css = "a[id^='menu_admin_U']")
    private WebElement userManagementTab;

    @FindBy(id = "menu_admin_viewSystemUsers")
    private WebElement usersTab;

    @FindBy(id = "btnAdd")
    private WebElement buttonAdd;

    @FindBy(css = "ol > li")
    private List<WebElement> forms;

    @FindBy(css = "ol > li label")
    private List<WebElement> nameForms;

    @FindBy(css = ".helpText span")
    private List<WebElement> helpText;

    @FindBy(css = "li > span.validation-error")
    private List<WebElement> validationError;

    @FindBy(css = "ol li input")
    private List<WebElement> inputFields;

    @FindBy(id = "btnSave")
    private WebElement buttonSave;

    private void toAdmin() {
        adminTab.click();
    }

    private void toUserManagement() {
        userManagementTab.click();
    }

    private void toUsersTab() {
        usersTab.click();
    }

    private void clickButtonAdd() {
        buttonAdd.click();
    }

    public void toFormAddUser() {
        toAdmin();
        toUserManagement();
        toUsersTab();
        clickButtonAdd();
    }

    public void checkForm() {
        checkWithEmptyField();
        checkWithFullFields();

        System.out.println("User Management page verified successfully!");
    }

    public void addUser() {
        inputFields.get(0).sendKeys(Keys.BACK_SPACE);
        inputFields.get(0).sendKeys(employeeName);
        inputFields.get(2).sendKeys(userName);
        inputFields.get(4).sendKeys(password);
        inputFields.get(5).sendKeys(password);

       // (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(buttonSave));
      //  waitForClickable(buttonSave);
        buttonSave.click();

       // (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(buttonAdd));
    }

    private void checkWithEmptyField() {
        Assert.assertTrue(forms.get(0).isDisplayed());
        Assert.assertEquals("User Role *", nameForms.get(0).getText());

        Assert.assertTrue(forms.get(1).isDisplayed());
        Assert.assertEquals("Employee Name *", nameForms.get(1).getText());

        Assert.assertTrue(forms.get(2).isDisplayed());
        Assert.assertEquals("Username *", nameForms.get(2).getText());

        Assert.assertTrue(forms.get(3).isDisplayed());
        Assert.assertEquals("Status *", nameForms.get(3).getText());

        Assert.assertTrue(forms.get(5).isDisplayed());
        Assert.assertEquals("Password", nameForms.get(5).getText());
        Assert.assertEquals(helpText2, helpText.get(1).getText());

        Assert.assertTrue(forms.get(6).isDisplayed());
        Assert.assertEquals("Confirm Password", nameForms.get(6).getText());

        Assert.assertTrue(forms.get(7).isDisplayed());
        Assert.assertEquals("* Required field", forms.get(7).getText());
    }

    private void checkWithFullFields() {
        inputFields.get(0).sendKeys("d");
        inputFields.get(2).sendKeys("d");
        inputFields.get(4).sendKeys("1");
        inputFields.get(5).sendKeys("1");

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(helpText.get(0)));

        Assert.assertEquals(helpText1, helpText.get(0).getText());
        Assert.assertEquals(validationError1, validationError.get(0).getText());
        Assert.assertEquals(validationError2, validationError.get(1).getText());
        Assert.assertEquals(validationError3, validationError.get(2).getText());
        Assert.assertEquals(validationError4, validationError.get(3).getText());
    }

    private WebElement waitForClickable(WebElement element){
        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    private Wait<WebDriver> getWebDriverWait() {
        return (Wait<WebDriver>) new FluentWait<>(driver)
                .withTimeout(15, SECONDS)
                .pollingEvery(250, MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }
}
