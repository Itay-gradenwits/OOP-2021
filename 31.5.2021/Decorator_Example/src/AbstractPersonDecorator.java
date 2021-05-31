public abstract class AbstractPersonDecorator implements Person{
    private Person person;

    AbstractPersonDecorator(Person person) {
        this.person = person;
    }
    @Override
    public String describeMe() {
        return person.describeMe();
    }
}
