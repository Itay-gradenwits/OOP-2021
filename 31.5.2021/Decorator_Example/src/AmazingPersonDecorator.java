public class AmazingPersonDecorator extends AbstractPersonDecorator{
    AmazingPersonDecorator(Person person) {
        super(person);
    }
    @Override
    public String describeMe() {
        return super.describeMe() + " and I am Amazing";
    }
}
