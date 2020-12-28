package Tests;

import PageObjects.OrdenComprasPage;
import org.testng.annotations.Test;
import utilities.waits;
import org.junit.Assert;

public class OrdenComprasTest  extends baseTest{


    @Test(groups={"caso2"})

    public void doOrden () throws InterruptedException {

        OrdenComprasPage orden =new OrdenComprasPage (driver,getBaseURL());
        waits wait=new waits(driver);

        orden.goToPage();

        orden.doOrden("iphone");


        wait.waitUntilElementExists(orden.setSuccessMsg());
        System.out.println(orden.setSuccessMsg().getText());
        Assert.assertEquals(orden.setSuccessMsg().isDisplayed(), true);

        wait.waitUntilElementExists(orden.setViewCartBtn());
        orden.goCheckOut();

        System.out.println(orden.setAlertNoProduct().getText());
        Assert.assertEquals(orden.setAlertNoProduct().isDisplayed(), true);


    }
}
