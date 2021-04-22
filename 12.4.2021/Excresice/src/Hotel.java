import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Costumer> costumers;

    public Hotel() {
        costumers = new ArrayList<>();
    }

    public void addCostumer(Costumer costumer) throws Exception{
        for(Costumer x: costumers) {
            if(x.getID().equals(costumer.getID())) {
                throw new Exception("there is already a guy with this id");
            }
        }
        costumers.add(costumer);
    }

    public List<Costumer> getCostumers() {
        return this.costumers;
    }

    public int getProfit() {
        int profit = 0;
        for(Costumer x: this.costumers) {
            profit += x.getPrice();
        }
        return profit;
    }

    public static Hotel fromMainArguments(String[] args) throws Exception {
        Hotel hotel = new Hotel();
        for (int i = 0; i < args.length; i+=2) {
            hotel.addCostumer(new Costumer(args[i],Integer.parseInt(args[i+1])));
        }
        return hotel;
    }
}
