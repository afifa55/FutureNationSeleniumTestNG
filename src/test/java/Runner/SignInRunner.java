package Runner;

import Base.SetUp;
import Page.SignInPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utills.Utils;

import java.io.IOException;
import java.time.Duration;

public class SignInRunner extends SetUp {
    SignInPage signIn;

    ExtentTest test;







    @Test(priority = 3,description = "Login With Valid Email And Pass")
    public void signInTest() throws InterruptedException, IOException, ParseException {
        test = extentReports.createTest("Login With Valid Email And Pass");
        test.log(Status.INFO, "Test started");

        signIn= new SignInPage(driver);
        driver.get("https://platform.futurenation.gov.bd/");
        JSONObject userObject= Utils.loadJsonFile("./src/test/resources/user.json");
        String email= (String) userObject.get("email");
        String password= (String) userObject.get("password");
        signIn.homeSignIn();
        Thread.sleep(3000);
        signIn.doLoginValidCreds(email,password);

        //Assertion
        WebElement txtMyprofile = driver.findElement(By.xpath("(//a[contains(text(),'My Profile')])[1]"));
        String myprofile_acTualText = txtMyprofile.getText();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(txtMyprofile));
        String myProfile_expectedText = "My Profile";

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(myprofile_acTualText,myProfile_expectedText);

        // Log test status
        test.log(Status.PASS, "Test Passed");

        softAssert.assertAll();


    }
    @Test(priority= 1, description = "Login With Invalid Email")
    public void signInInvalidEmail() throws InterruptedException {
        test = extentReports.createTest("Login With Invalid Email");
        test.log(Status.INFO, "Test started");
        signIn= new SignInPage(driver);
        driver.get("https://platform.futurenation.gov.bd/");
        Thread.sleep(3000);
        signIn.homeSignIn();
        signIn.doLoginInValidCreds1();

        //assertion

        WebElement txtError = driver.findElement(By.id("input-error"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(txtError));
        String error_message= txtError.getText();
        String error_message_expected="Invalid username or password.";
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(error_message,error_message_expected);

        // Log test status
        test.log(Status.PASS, "Test Passed");

        softAssert.assertAll();

    }
    @Test(priority= 2, description = "Login With Invalid Pass")
    public void signInInvalidPass() throws InterruptedException {
        test = extentReports.createTest("Login With Invalid Pass");
        test.log(Status.INFO, "Test started");
        signIn= new SignInPage(driver);
        driver.get("https://platform.futurenation.gov.bd/");
        Thread.sleep(3000);
        signIn.homeSignIn();
        signIn.doLoginInValidCreds2();

        //assertion

        WebElement txtError = driver.findElement(By.id("input-error"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(txtError));
        String error_message= txtError.getText();
        String error_message_expected="Invalid username or password.";
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(error_message,error_message_expected);

        // Log test status
        test.log(Status.PASS, "Test Passed");

        softAssert.assertAll();

    }
}
