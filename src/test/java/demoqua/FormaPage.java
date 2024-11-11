package demoqua;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormaPage {
    public static WebDriver driver;
    JavascriptExecutor js;

    @FindBy(id="firstName")
    private WebElement firstNameElement;
    @FindBy(id="lastName")
    private WebElement lastNameElement;
    @FindBy(id="userEmail")
    private WebElement userEmailElement;
    @FindBy(xpath="//label[@for='gender-radio-1']")
    private WebElement userGenderElement;
    @FindBy(id="userNumber")
    private WebElement userMobileElement;
    @FindBy(id="dateOfBirthInput")
    private WebElement dateOfBirthElement;

    @FindBy(css=".react-datepicker__month-select")
    private WebElement monthDropdown;

    @FindBy(css=".react-datepicker__year-select")
    private WebElement yearDropdown;

    @FindBy(id="subjectsInput")
    private WebElement userSubjectsElement;
    @FindBy(id="currentAddress")
    private WebElement userTextAreaElement;

    public FormaPage(WebDriver driver) {
        FormaPage.driver = driver;
        PageFactory.initElements(FormaPage.driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    public String setFirstNameElement(String FirstNamePar) {
        firstNameElement.sendKeys(FirstNamePar);
        return FirstNamePar;
    }

    public String setLastNameElement(String LastNamePar) {
        lastNameElement.sendKeys(LastNamePar);
        return LastNamePar;
    }

    public String setEmailElement(String EmailPar) {
        userEmailElement.sendKeys(EmailPar);
        return EmailPar;
    }

    public void setGenderElement() {
        userGenderElement.click();
    }

    public String setMobileElement(String MobilePar) {
        userMobileElement.sendKeys(MobilePar);
        return MobilePar;
    }

    public void setDateCalendarElement(String dateOfBirth) {
        js.executeScript("arguments[0].scrollIntoView(true);", dateOfBirthElement);

        String[] dateParts = dateOfBirth.split("-");
        String year = dateParts[0];
        String month = dateParts[1];
        String day = dateParts[2];

        String monthName = convertMonthNumberToName(month);
        dateOfBirthElement.click();

        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText(year);

        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText(monthName);

        WebElement dayElement = driver.findElement(By.xpath("//div[text()='" + Integer.parseInt(day) + "']"));
        dayElement.click();
    }

    private String convertMonthNumberToName(String month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int monthIndex = Integer.parseInt(month) - 1;
        return monthNames[monthIndex];
    }

    public String setSubjectElement(String SubjectPar) {
        userSubjectsElement.sendKeys(SubjectPar);
        userTextAreaElement.sendKeys(Keys.ENTER);
        return SubjectPar;
    }
    public String setTextAreaElement(String TextAreaPar) {
        userTextAreaElement.sendKeys(TextAreaPar);
        return TextAreaPar;
    }
}
