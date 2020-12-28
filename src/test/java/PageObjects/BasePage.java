package PageObjects;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public static WebDriver driver;
    public String url;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public BasePage(WebDriver driver, String url){
        this.driver=driver;
        this.url=url;
    }

    public void goToPage(){
        this.driver.get(this.url);

    }
}
