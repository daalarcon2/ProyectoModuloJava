package dataProvider;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.productosData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class productosDataProvider {

    @DataProvider(name="getProductosDataFromJson")

    public Object[] getProductosDataFromJson() throws FileNotFoundException {

        JsonElement jsonData = new JsonParser().parse(new FileReader("C:\\Users\\danalarc2\\IdeaProjects\\Proyecto_Final_5\\src\\test\\java\\ProductosData\\productosData.json"));
        JsonElement productosDataSet=jsonData.getAsJsonObject().get("dataSetPriceMacBook");

        List<productosData> products =new Gson().fromJson(productosDataSet, new TypeToken<List<productosData>>(){}.getType());

        Object[][] returnValue = new Object[products.size()][1];

        int index=0;

        for( Object[] each:returnValue){
            each[0]=products.get(index);

            System.out.println(products.get(index).getPoundsPrice());
            System.out.println(products.get(index).getDollarPrice());
            System.out.println(products.get(index).getEuroPrice());

        }

        return returnValue;


    }


}
