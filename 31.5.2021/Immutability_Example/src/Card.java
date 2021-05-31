public final class Card {
    private final String color;
    private final String number;

    public Card(String color, String number) {
        this.color = color;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }
}
