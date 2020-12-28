package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class waits {

    public WebDriver driver;

    public waits (WebDriver driver){
        this.driver=driver;

    }

    @Test
    public void waitUntilElementExists(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
