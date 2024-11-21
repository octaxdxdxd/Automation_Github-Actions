package demoqua;

import org.example.TestNg.Basic;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class FormaPage {

    private WebDriver driver;
    private JavascriptExecutor js;

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "userEmail")
    private WebElement userEmailElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement userGenderElement;

    @FindBy(id = "userNumber")
    private WebElement userMobileElement;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;

    @FindBy(css = ".react-datepicker__month-select")
    private WebElement monthDropdown;

    @FindBy(css = ".react-datepicker__year-select")
    private WebElement yearDropdown;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement userHobbiesElement;

    @FindBy(id = "currentAddress")
    private WebElement userTextAreaElement;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInputElement;

    @FindBy(id = "state")
    private WebElement stateDropdown;

    @FindBy(id = "city")
    private WebElement cityDropdown;

    @FindBy(xpath = "//div[contains(@class,'menu')]//div[text()='NCR']")
    private WebElement stateOption;

    @FindBy(xpath = "//div[contains(@class,'menu')]//div[text()='Delhi']")
    private WebElement cityOption;

    public FormaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    // Fill First Name
    public String setFirstNameElement(String firstName) {
        firstNameElement.sendKeys(firstName);
        return firstName;
    }

    // Fill Last Name
    public String setLastNameElement(String lastName) {
        lastNameElement.sendKeys(lastName);
        return lastName;
    }

    // Fill Email
    public String setEmailElement(String email) {
        userEmailElement.sendKeys(email);
        return email;
    }

    // Select Gender
    public void setGenderElement() {
        userGenderElement.click();
    }

    // Fill Mobile Number
    public String setMobileElement(String mobile) {
        userMobileElement.sendKeys(mobile);
        return mobile;
    }

    // Set Date of Birth
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

    // Fill Subjects
    public void setSubjects(String subject) {
        subjectsInputElement.sendKeys(subject);
        subjectsInputElement.sendKeys(Keys.ENTER);
    }

    // Select Hobbies
    public void setHobbyElement() {
        userHobbiesElement.click();
    }

    // Fill Address Text Area
    public String setTextAreaElement(String address) {
        userTextAreaElement.sendKeys(address);
        return address;
    }

    // Select State
    public void setState(String state) {
        js.executeScript("arguments[0].scrollIntoView(true);", stateDropdown);
        stateDropdown.click();
        stateOption.click();
    }

    // Select City
    public void setCity(String city) {
        js.executeScript("arguments[0].scrollIntoView(true);", cityDropdown);
        cityDropdown.click();
        cityOption.click();
    }
}