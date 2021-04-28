public class Zara extends AbstractStore {

    public Zara(int startCash) {
        super(startCash);
    }

    @Override
    public void sellMerch(String productName) {
        for(Product p : products) {
            if(p.getName().equals(productName)){
                System.out.println("in Zara, you just bought: " + productName);
                this.cash += p.getValue() + 70;
            }
        }
        System.out.println("thank you for shopping in zara.");
    }
}
