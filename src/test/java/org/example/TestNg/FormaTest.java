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
        Thread.sleep(1000);
        form.setFirstNameElement(Basic.FIRST_NAME);

        logger.info("Set User: Last Name - " + Basic.LAST_NAME);
        Thread.sleep(1000);
        form.setLastNameElement(Basic.LAST_NAME);

        logger.info("Set User: Email - " + Basic.EMAIL);
        Thread.sleep(1000);
        form.setEmailElement(Basic.EMAIL);

        logger.info("Set User: Gender");
        Thread.sleep(1000);
        form.setGenderElement();

        logger.info("Set User: Mobile - " + Basic.Mobile);
        Thread.sleep(1000);
        form.setMobileElement(Basic.Mobile);

        logger.info("Set User: Date of Birth - " + Basic.DATE_OF_BIRTH);
        Thread.sleep(1000);
        form.setDateCalendarElement(Basic.DATE_OF_BIRTH);

        logger.info("Set User: Hobbies - " + Basic.HOBBY);
        Thread.sleep(1000);
        form.setHobbyElement();

        logger.info("Set User: Address - " + Basic.TEXTAREA);
        Thread.sleep(1000);
        form.setTextAreaElement(Basic.TEXTAREA);

        Thread.sleep(10000);

    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
