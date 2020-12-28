package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrdenComprasPage extends BasePage {

    private By searchBox =By.xpath("//*[@id=\"search\"]/input");
    private By searchButton =By.xpath("/html/body/header/div/div/div[2]/div/span/button");
    private By addButton =By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");
    private By successMsg =By.cssSelector("div#product-search.container div.alert.alert-success.alert-dismissible");
    private By carBtn= By.cssSelector("#cart > button");
    private By viewCheckOutBtn= By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong");
    private By alertNoProduct= By.cssSelector("#checkout-cart > div.alert.alert-danger.alert-dismissible");

    public OrdenComprasPage(WebDriver driver){

        super(driver);
    }

    public OrdenComprasPage(WebDriver driver, String url){
        super(driver, url);

    }

    public WebElement setSearchBox() {

        return driver.findElement(this.searchBox);
    }

    public WebElement setSearchButton() {

        return driver.findElement(this.searchButton);
    }

    public WebElement setAddButton() {

        return driver.findElement(this.addButton);
    }

    public WebElement setSuccessMsg() {

        return driver.findElement(this.successMsg);
    }

    public WebElement setCarBtn() {

        return driver.findElement(this.carBtn);
    }

   public WebElement setViewCartBtn() {

        return driver.findElement(this.viewCheckOutBtn);
    }

    public WebElement setAlertNoProduct() {

        return driver.findElement(this.alertNoProduct);
    }

    public void goCheckOut(){

        this.setViewCartBtn().click();
        this.setAlertNoProduct();

    }

    public void doOrden (String search) throws InterruptedException {

        this.setSearchBox().sendKeys(search);
        this.setSearchButton().click();
        this.setAddButton().click();
        Thread.sleep(5000);
        this.setSuccessMsg();
        this.setCarBtn().click();
        Thread.sleep(3000);

    }
}
