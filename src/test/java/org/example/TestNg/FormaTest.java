package org.example.TestNg;

import demoqua.FormaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;


public class FormaTest {
    public static WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void FormaTest(){
        driver.get("https://demoqa.com/automation-practice-form");
        FormaPage form = new FormaPage(driver);
        form.setFirstNameElement(Basic.FIRST_NAME);
        form.setLastNameElement(Basic.LAST_NAME);
        form.setEmailElement(Basic.EMAIL);
//
//        WebElement userEmail = driver.findElement(By.xpath("//*[@id='userEmail']"));
//        userEmail.sendKeys("maxdolghieru@gmial.com");
//
//        WebElement genderMaleLabel = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
//        genderMaleLabel.click();
//
//        WebElement userNumber = driver.findElement(By.xpath("//*[@id='userNumber']"));
//        userNumber.sendKeys("0687900636");
//
//        WebElement dateOfBirth = driver.findElement(By.xpath("//*[@id='dateOfBirth']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("value='10/25/2023';", dateOfBirth);

//        WebElement subjectsInput = driver.findElement(By.xpath("//*[@id='subjectsInput']"));
//        subjectsInput.sendKeys("Maths");
//        subjectsInput.sendKeys(Keys.ENTER);
//        subjectsInput.sendKeys("Chemistry");
//        subjectsInput.sendKeys(Keys.ENTER);
//
//        WebElement hobbiesCheckbox3 = driver.findElement(By.xpath("//label[@id='hobbies-checkbox-3']"));
//        hobbiesCheckbox3.click();



    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
