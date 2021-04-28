public class CastroEilat extends Castro {

    public CastroEilat(int cash) {
        super(cash);
    }

    @Override
    public void sellMerch(String productName) {
        for(Product p : products) {
            if(p.getName().equals(productName)){
                System.out.println("in castro Eilat, you just bought: " + productName);
                this.cash += p.getValue() + 41;
            }
        }
        System.out.println("thank you for shopping in castro - Eilat.");
    }
}
