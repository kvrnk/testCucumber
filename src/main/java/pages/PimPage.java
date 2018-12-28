package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PimPage {
    private WebDriver driver;
    private String firstName = "Robert";
    private String middleName = "";
    private String lastName = "Craig";
    private String employeeId = "0006";
    private String otherId = "";
    private String driversNumber = "";
    private String date = "yyyy-mm-dd";
    private String maritalStatus = "Married";
    private String nationality = "American";
    private String birthDate = "1982-10-08";

    public PimPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement pimTab;

    @FindBy(css = "[id='empsearch_sub_unit'] > :nth-child(2)")
    private WebElement chooseSubUnit;

    @FindBy(id = "searchBtn")
    private WebElement buttonSearch;

    @FindBy(css = "tr.odd td a")
    private List<WebElement> peoplesId;

    @FindBy(css = "ol li input")
    private List<WebElement> inputFields;

    @FindBy(css = "ol li select")
    private List<WebElement> selectFields;

    public void toFormPIM() {
        pimTab.click();
    }

    public void chooseUnit() {
        chooseSubUnit.click();
        buttonSearch.click();
        if (peoplesId.size() > 0) {
            peoplesId.get(0).click();
        } else {
            System.out.println("No users with SALES attribute");
        }
    }

    public void checkForm() {
        checkFullName();
        checkProfessionalInfo();
        checkPersonalInfo();

        System.out.println("PIM page verified successfully!");
    }

    private void checkFullName() {
        Assert.assertTrue(inputFields.get(0).isDisplayed());
        Assert.assertEquals(firstName, inputFields.get(0).getAttribute("value"));

        Assert.assertTrue(inputFields.get(1).isDisplayed());
        Assert.assertEquals(middleName, inputFields.get(1).getAttribute("value"));

        Assert.assertTrue(inputFields.get(2).isDisplayed());
        Assert.assertEquals(lastName, inputFields.get(2).getAttribute("value"));
    }

    private void checkProfessionalInfo() {
        Assert.assertTrue(inputFields.get(3).isDisplayed());
        Assert.assertEquals(employeeId, inputFields.get(3).getAttribute("value"));

        Assert.assertTrue(inputFields.get(4).isDisplayed());
        Assert.assertEquals(otherId, inputFields.get(4).getAttribute("value"));

        Assert.assertTrue(inputFields.get(5).isDisplayed());
        Assert.assertEquals(driversNumber, inputFields.get(5).getAttribute("value"));

        Assert.assertTrue(inputFields.get(6).isDisplayed());
        Assert.assertEquals(date, inputFields.get(6).getAttribute("value"));
    }

    private void checkPersonalInfo() {
        Assert.assertTrue(inputFields.get(7).isDisplayed());
        Assert.assertTrue(inputFields.get(7).isSelected());

        Assert.assertTrue(inputFields.get(8).isDisplayed());
        Assert.assertFalse(inputFields.get(8).isSelected());

        Assert.assertTrue(selectFields.get(0).isDisplayed());
        Assert.assertEquals(maritalStatus, driver.findElements(By.cssSelector("ol li select > :nth-child(3)")).get(0).getText());

        Assert.assertTrue(selectFields.get(1).isDisplayed());
        Assert.assertEquals(nationality, driver.findElement(By.cssSelector("ol li select > :nth-child(5)")).getText());

        Assert.assertTrue(inputFields.get(9).isDisplayed());
        Assert.assertEquals(birthDate, inputFields.get(9).getAttribute("value"));
    }

}
