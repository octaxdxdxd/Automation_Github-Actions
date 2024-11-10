package demoqua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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
        this.js = (JavascriptExecutor) driver;  // Initialize JavascriptExecutor after driver is set
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
        // Scroll to the calendar element
        js.executeScript("arguments[0].scrollIntoView(true);", dateOfBirthElement);

        // Assume dateOfBirth is in the format "YYYY-MM-DD"
        String[] dateParts = dateOfBirth.split("-");  // Split the date string into parts
        String year = dateParts[0];   // Extract year
        String month = dateParts[1];  // Extract month as a two-digit string
        String day = dateParts[2];    // Extract day as a two-digit string

        // Convert the month to the correct format if needed (e.g., from "10" to "October")
        String monthName = convertMonthNumberToName(month);

        // Open the calendar picker
        dateOfBirthElement.click();

        // Select year
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText(year);

        // Select month
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText(monthName);

        // Select day
        WebElement dayElement = driver.findElement(By.xpath("//div[text()='" + Integer.parseInt(day) + "']"));
        dayElement.click();
    }

    private String convertMonthNumberToName(String month) {
        // Convert month number (e.g., "01", "02", ...) to month name (e.g., "January", "February", ...)
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int monthIndex = Integer.parseInt(month) - 1;  // Convert "01" to 0, "02" to 1, etc.
        return monthNames[monthIndex];
    }

    public String setSubjectElement(String SubjectPar) {
        userSubjectsElement.sendKeys(SubjectPar);
        return SubjectPar;
    }
    public String setTextAreaElement(String TextAreaPar) {
        userTextAreaElement.sendKeys(TextAreaPar);
        return TextAreaPar;
    }
}
