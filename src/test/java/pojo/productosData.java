package pojo;

public class productosData {

    private String dollarPrice;
    private String euroPrice;
    private String poundsPrice;

    public productosData (String dollar, String euro, String pounds){
        this.dollarPrice=dollar;
        this.euroPrice=euro;
        this.poundsPrice=pounds;

    }

    public String getDollarPrice(){

        return this.dollarPrice;
    }

    public String getEuroPrice (){

        return this.euroPrice;
    }

    public String getPoundsPrice(){

        return this.poundsPrice;
    }

}
