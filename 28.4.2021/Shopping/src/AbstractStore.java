import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected int cash ;
    protected List<Product> products;

    public AbstractStore(int startCash) {
        this.cash = startCash;
        products = new ArrayList<>();
    }


    @Override
    public void buyMerch(Product p) {
        products.add(p);
        cash-=p.getValue();
    }

    @Override
    public int getCash() {
        return cash;
    }

    public abstract void sellMerch(String productName);

}
