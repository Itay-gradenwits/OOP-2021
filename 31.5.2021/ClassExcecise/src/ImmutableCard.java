public final class ImmutableCard {
    private final char number;
    private final String color;

    public ImmutableCard(char number, String color) {
        this.number = number;
        this.color = color;
    }

    String getColor() {
        return this.color;
    }
    char getNumber() {
        return this.number;
    }
}

