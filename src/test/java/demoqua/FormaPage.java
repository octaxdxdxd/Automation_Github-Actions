package demoqua;

import org.example.TestNg.Basic;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class FormaPage {
    public static WebDriver driver;
    JavascriptExecutor js;

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

    public FormaPage(WebDriver driver) {
        FormaPage.driver = driver;
        PageFactory.initElements(FormaPage.driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    public String setFirstNameElement(String firstNamePar) {
        firstNameElement.sendKeys(firstNamePar);
        return firstNamePar;
    }

    public String setLastNameElement(String lastNamePar) {
        lastNameElement.sendKeys(lastNamePar);
        return lastNamePar;
    }

    public String setEmailElement(String emailPar) {
        userEmailElement.sendKeys(emailPar);
        return emailPar;
    }

    public void setGenderElement() {
        userGenderElement.click();
    }

    public String setMobileElement(String mobilePar) {
        userMobileElement.sendKeys(mobilePar);
        return mobilePar;
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

    public void setHobbyElement() {
        userHobbiesElement.click();
    }

    public String setTextAreaElement(String textAreaPar) {
        userTextAreaElement.sendKeys(textAreaPar);
        return textAreaPar;
    }

    public void setSubjects(String subject) {
        subjectsInputElement.sendKeys(subject);
        subjectsInputElement.sendKeys(Keys.ENTER);
    }

    public void setState(String state) {
        stateDropdown.click();
        WebElement stateOption = driver.findElement(By.xpath("//div[text()='" + state + "']"));
        stateOption.click();
    }

    public void setCity(String city) {
        cityDropdown.click();
        WebElement cityOption = driver.findElement(By.xpath("//div[text()='" + city + "']"));
        cityOption.click();
    }
}
