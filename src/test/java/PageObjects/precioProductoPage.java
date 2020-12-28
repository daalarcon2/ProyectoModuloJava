package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class precioProductoPage extends BasePage{

    private By productNameCta =By.cssSelector("#content > div.row > div:nth-child(1) > div > div.caption > h4 > a");
    private By dropDown = By.cssSelector("#form-currency > div > button");
    private By dropDownList = By.cssSelector(".btn-group.open ul.dropdown-menu > li");
    private By dollarPrice= By.xpath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[1]/h2");
    private By poundPrice= By.xpath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[1]/h2");
    private By euroPrice= By.xpath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[1]/h2");


    public precioProductoPage(WebDriver driver){

        super(driver);
    }

    public precioProductoPage(WebDriver driver, String url){

        super(driver, url);

    }

    public WebElement setProductNameCta() {

        return driver.findElement(this.productNameCta);
    }

    public List<WebElement> setDropDownList() {

        return driver.findElements(this.dropDownList);
    }

    public WebElement setDollarPrice() {

        return driver.findElement(this.dollarPrice);
    }

    public WebElement setPoundPrice() {

        return driver.findElement(this.poundPrice);
    }

    public WebElement setEuroPrice() {

        return driver.findElement(this.euroPrice);
    }

    public WebElement setDropDown() {

        return driver.findElement(this.dropDown);
    }


    public void doPrice(String precioDolar, String precioLibra, String precioEuro) throws InterruptedException {
        this.setProductNameCta().click();
        this.setDropDown();
        this.setDollarPrice();
        this.setDropDownList();


        String typePrice ="";
        for (int j=0; j < 3; j++){
            setDropDown().click();
            Thread.sleep(5000);
            typePrice = setDropDownList().get(j).getText();
            setDropDownList().get(j).click();
            Thread.sleep(5000);
            comparePriceType(typePrice, precioDolar, precioLibra, precioEuro);

        }
    }
     public void comparePriceType(String typePrice, String precioDolar, String precioLibra, String precioEuro){
       switch (typePrice){
            case "€ Euro":
                Assert.assertEquals((setEuroPrice().getText()), (precioEuro));
                System.out.println("Success! Json Euro "+ precioEuro +" Euro pagina "+ setEuroPrice().getText());
                break;
            case "£ Pound Sterling":
                Assert.assertEquals((setPoundPrice().getText()), (precioLibra));
                System.out.println("Success!  Json Libra "+ precioLibra +" Libra pagina "+ setPoundPrice().getText());
                break;
            case "$ US Dollar":
                Assert.assertEquals((setDollarPrice().getText()), (precioDolar));
                System.out.println("Success!  Json Dolar "+ precioDolar +" Libra pagina "+ setDollarPrice().getText());
                break;
            default:
                System.out.println("error, the price type does not match with options listed" );
                break;
        }

     }
}
