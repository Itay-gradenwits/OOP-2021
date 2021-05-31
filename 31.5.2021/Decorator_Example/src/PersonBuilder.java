public class PersonBuilder {

    public Person buildAmazingAndNicePerson() {
        return new AmazingPersonDecorator(new NicePersonDecorator(new BasicPerson()));
    }

    public Person buildHandsomeAndStrongPerson() {
        return new HandsomePersonDecorator(new StrongPersonDecorator(new BasicPerson()));
    }

}





