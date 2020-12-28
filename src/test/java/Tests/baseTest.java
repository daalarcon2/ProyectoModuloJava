package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class baseTest {

    public WebDriver driver;
    public ChromeOptions options;


    public String getBaseURL() {
        return "https://demo.opencart.com/";
    }

    @BeforeClass(alwaysRun=true)

    public void setUpTest(){


        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        String driverPath = currentDirectory.concat("\\src\\test\\resources\\drivers\\chromedriver.exe");
        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);

        options=new ChromeOptions();
        options.addArguments("--kiosk");
        options.addArguments("--started");

        driver = new ChromeDriver(options);

    }

    @AfterClass(alwaysRun=true)
    public void tearDown(){

        driver.quit();
    }

}
