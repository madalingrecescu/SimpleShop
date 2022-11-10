import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("biscuits", 0.4,212);
        stockList.addStock(temp);

        temp = new StockItem("bread", 1.2,50);
        stockList.addStock(temp);

        temp = new StockItem("butter", 3,60);
        stockList.addStock(temp);

        temp = new StockItem("cake", 5.5,10);
        stockList.addStock(temp);

        temp = new StockItem("cheese", 3.2,35);
        stockList.addStock(temp);

        temp = new StockItem("juice", 1.8,150);
        stockList.addStock(temp);
        temp = new StockItem("juice",1.9,80);
        stockList.addStock(temp);

        temp = new StockItem("milk", 2.2,83);
        stockList.addStock(temp);

        temp = new StockItem("water", 1,8);
        stockList.addStock(temp);
        System.out.println(stockList);

        Basket madalinsBasket = new Basket("Madalin");

        rezerveItem(madalinsBasket,"water",5);
        System.out.println(madalinsBasket);
        rezerveItem(madalinsBasket,"water",1);
        System.out.println(madalinsBasket);
        System.out.println("===========================");
        rezerveItem(madalinsBasket,"water",3);
        System.out.println(madalinsBasket);

        rezerveItem(madalinsBasket,"meat",3);


        rezerveItem(madalinsBasket,"milk",2);
        System.out.println("===========================");
        rezerveItem(madalinsBasket,"juice",55);
        System.out.println(madalinsBasket);
        rezerveItem(madalinsBasket,"juice",-52);
        System.out.println(madalinsBasket);
        rezerveItem(madalinsBasket,"juice",-52);
        System.out.println("===========================");
        rezerveItem(madalinsBasket,"cake",2);
        rezerveItem(madalinsBasket,"milk",2);
        System.out.println(madalinsBasket);
        System.out.println(stockList);

        madalinsBasket.checkOut();
        System.out.println(stockList);
        System.out.println(madalinsBasket);

    }

    public static int rezerveItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We do not have " + item + " in stock.");
            return 0;
        }

        if(stockList.reserveStock(item,quantity) != 0){
            basket.reserve(stockItem,quantity);
            return quantity;
        }

        return 0;
    }
}