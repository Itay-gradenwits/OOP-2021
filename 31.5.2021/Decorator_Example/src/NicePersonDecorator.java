public class NicePersonDecorator extends AbstractPersonDecorator{
    NicePersonDecorator(Person person) {
        super(person);
    }
    @Override
    public String describeMe() {
        return super.describeMe() + " and I am Nice";
    }
}
