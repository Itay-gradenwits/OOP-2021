public class HandsomePersonDecorator extends AbstractPersonDecorator{
    HandsomePersonDecorator(Person person) {
        super(person);
    }
    @Override
    public String describeMe() {
        return super.describeMe() + " and I am Handsome";
    }
}
