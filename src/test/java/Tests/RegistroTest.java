package Tests;

import PageObjects.RegistroPage;
import org.junit.Assert;
import org.testng.annotations.Test;
import utilities.waits;

public class RegistroTest extends baseTest{

    @Test(groups={"caso1"})
    public void doRegistro() {

        RegistroPage registro =new RegistroPage (driver, getBaseURL());
        registro.goToPage();
        waits wait=new waits(driver);
        wait.waitUntilElementExists(registro.setAcountCreatedtext());
        registro.doRegistro("daniel","alarcon", "danalarc","danalarc");
        Assert.assertEquals(registro.setAcountCreatedtext().isDisplayed(), true);
    }
}
