package Tests;

import PageObjects.precioProductoPage;
import org.testng.annotations.Test;
import dataProvider.productosDataProvider;
import pojo.productosData;

public class precioProductoTest extends baseTest{


    @Test(groups={"caso3"}, dataProvider = "getProductosDataFromJson", dataProviderClass = productosDataProvider.class)

    public void doPrice (productosData _productosData) throws InterruptedException {

        precioProductoPage precio =new precioProductoPage (driver,getBaseURL());

        precio.goToPage();
        precio.doPrice(_productosData.getDollarPrice(),_productosData.getPoundsPrice(),_productosData.getEuroPrice());

    }
}
