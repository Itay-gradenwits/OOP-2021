public class Castro extends AbstractStore{

    public Castro(int cash) {
        super(cash);
    }

//    @Override
//    public void buyMerch(Product p ){
//
//    }

    @Override
    public void sellMerch(String productName) {
        for(Product p : products) {
            if(p.getName().equals(productName)){
                this.cash += p.getValue() + 50;
                System.out.println("in castro, you just bought: " + productName);
            }
        }
        System.out.println("thank you for shopping in castro.");
    }
}
