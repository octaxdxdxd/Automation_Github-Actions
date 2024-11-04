package demoqua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormaPage {
    public static WebDriver driver;

    @FindBy(id="firstName")
    private WebElement firstNameElement;
    @FindBy(id="lastName")
    private WebElement lastNameElement;
    @FindBy(id="userEmail")
    private WebElement userEmailElement;

    public FormaPage(WebDriver driver) {
        FormaPage.driver = driver;
        PageFactory.initElements(FormaPage.driver, this);
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
    public String setGenderElement(String GenderPar) {
        firstNameElement.sendKeys(GenderPar);
        return GenderPar;
    }
}
