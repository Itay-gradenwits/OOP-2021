public class StrongPersonDecorator extends AbstractPersonDecorator{
    StrongPersonDecorator(Person person) {
        super(person);
    }
    @Override
    public String describeMe() {
        return super.describeMe() + " and I am Strong";
    }
}
