package org.example.TestNg;

import demoqua.FormaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utils.SeleniumDriver;


public class FormaTest extends Basic {
    public static WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
       
        driver= SeleniumDriver.getRemoteDriver();
    }

    @Test
    public void FormaTest() throws InterruptedException {

        logger.info("Start test");

        driver.get("https://demoqa.com/automation-practice-form");
        FormaPage form = new FormaPage(driver);

        logger.info("Set User: Name - " + Basic.FIRST_NAME);
        form.setFirstNameElement(Basic.FIRST_NAME);

        logger.info("Set User: Last Name - " + Basic.LAST_NAME);
        form.setLastNameElement(Basic.LAST_NAME);

        logger.info("Set User: Email - " + Basic.EMAIL);
        form.setEmailElement(Basic.EMAIL);

        logger.info("Set User: Gender");
        form.setGenderElement();

        logger.info("Set User: Mobile - " + Basic.MOBILE);
        form.setMobileElement(Basic.MOBILE);

        logger.info("Set User: Date of Birth - " + Basic.DATE_OF_BIRTH);
        form.setDateCalendarElement(Basic.DATE_OF_BIRTH);

        logger.info("Set User: Subject - " + Basic.SUBJECT);
        form.setSubjects(Basic.SUBJECT);

        logger.info("Set User: Hobbies - " + Basic.HOBBY);
        form.setHobbyElement();

        logger.info("Set User: Address - " + Basic.TEXTAREA);
        form.setTextAreaElement(Basic.TEXTAREA);

        logger.info("Set User: State - " + Basic.STATE);
        form.setState(Basic.STATE);

        logger.info("Set User: City - " + Basic.CITY);
        form.setCity(Basic.CITY);

        Thread.sleep(1000); // For demo purposes


}

    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
