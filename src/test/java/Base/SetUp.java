package Base;

import Page.SignInPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class SetUp {
    public WebDriver driver;
    public static ExtentReports extentReports = new ExtentReports();

    @BeforeTest
    public void basesetup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @BeforeTest
    public void extent_setUp() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("ExtentReport/Spark.html");
        extentReports.attachReporter(htmlReporter);
    }

    @AfterTest
    public void tearDown() {
        extentReports.flush();
    }

    @AfterTest
    public void closedriver(){
        driver.close();
    }


    
}
