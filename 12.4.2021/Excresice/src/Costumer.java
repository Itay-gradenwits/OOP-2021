public class Costumer {
    private String id;
    private Integer price;

    public Costumer(String id, Integer price) throws Exception {
        if (price < 0) {
            throw new Exception("price cannot be negative");
        }
        this.id = id;
        this.price = price;
    }

   int getPrice() {
        return this.price;
   }
   String getID() {
        return this.id;
   }

}
