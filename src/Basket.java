import java.util.*;

public class Basket {
    private final String name;
    private  Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int reserve(StockItem item, int qunatity){
        if((item != null) ){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + qunatity);
            return inBasket;
        }
        return 0;
    }


    public void checkOut(){
        for(Map.Entry<StockItem, Integer> item : list.entrySet()){
            item.getKey().adjustStock(-item.getValue());
        }
        this.list = new TreeMap<>();
    }

    public Map<StockItem, Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contians " + list.size() +((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem, Integer> item : list.entrySet()){
            s = s + item.getKey() + ". " + item.getValue() + " reserved\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost: " + totalCost + "$";
    }
}
