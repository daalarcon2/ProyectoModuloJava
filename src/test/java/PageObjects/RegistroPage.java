package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class RegistroPage extends BasePage{

    private By firstNameTextBox =By.id("input-firstname");
    private By lastNameTextBox =By.id("input-lastname");
    private By emailTextBox =By.id("input-email");
    private By telephoneTextBox =By.id("input-telephone");
    private By passTextBox =By.id("input-password");
    private By confirmpsTextBox =By.id("input-confirm");
    private By listRadioBtn =By.cssSelector("label.radio-inline > input");
    private By checkBtn =By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
    private By continueBtn= By.cssSelector("input.btn.btn-primary");
    private By accountCreatedText= By.cssSelector("div#content.col-sm-9 > h1");


    public RegistroPage(WebDriver driver){

        super(driver);
    }

    public RegistroPage(WebDriver driver, String url){
        super(driver, url+"index.php?route=account/register");

    }

    public WebElement setFirstNameTextBox() {

        return driver.findElement(this.firstNameTextBox);
    }

    public WebElement setLastNameTextBox() {

        return driver.findElement(this.lastNameTextBox);
    }

    public WebElement setEmailTextBox() {

        return driver.findElement(this.emailTextBox);
    }

    public WebElement setTelephoneTextBox() {

        return driver.findElement(this.telephoneTextBox);
    }

    public WebElement setPasswordTextBox() {

        return driver.findElement(this.passTextBox);
    }

    public WebElement setConfirmpsTextBox() {

        return driver.findElement(this.confirmpsTextBox);
    }

    public List<WebElement> setListRadioBtn() {

        return driver.findElements(this.listRadioBtn);

    }

    public WebElement setCheck() {

        return driver.findElement(this.checkBtn);
    }

    public WebElement setcontinueBtn() {

        return driver.findElement(this.continueBtn);
    }

    public WebElement setAcountCreatedtext() {

        return driver.findElement(this.accountCreatedText);
    }

    public String converTel(){
        int randomA = (int) (Math.random()*(9999999 - 1)) +1;
        String j = Integer.toString(randomA);

        return j;

    }

    public String emailRandom(){

        int length =7;
        String estructuraEmail= "@gmail.com";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        builder.append(estructuraEmail);

        return builder.toString();

    }

    public int suscribe (){

        int randomC = (int) (Math.random()*(2-0)+0);
         return randomC;

    }

    public void doRegistro (String firstName, String lastName, String password, String confPass){

        this.setFirstNameTextBox().sendKeys(firstName);
        this.setLastNameTextBox().sendKeys(lastName);
        this.setEmailTextBox().sendKeys(emailRandom());
        this.setTelephoneTextBox().sendKeys(converTel());
        this.setPasswordTextBox().sendKeys(password);
        this.setConfirmpsTextBox().sendKeys(confPass);
        this.setListRadioBtn().get(suscribe()).click();
        this.setCheck().click();
        this.setcontinueBtn().click();
        this.setAcountCreatedtext();

    }
}

