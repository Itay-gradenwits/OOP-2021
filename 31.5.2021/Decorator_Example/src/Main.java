public class Main {
    public static void main(String[] args) {
//        Person person1 = new AmazingPersonDecorator(new NicePersonDecorator(new BasicPerson()));
//        Person person2 = new HandsomePersonDecorator(new NicePersonDecorator(new StrongPersonDecorator(new BasicPerson())));
//        System.out.println(person1.describeMe());
//        System.out.println(person2.describeMe());

        PersonBuilder builder = new PersonBuilder();
        Person person3 = builder.buildAmazingAndNicePerson();
        Person person4 = builder.buildHandsomeAndStrongPerson();
        System.out.println(person3.describeMe());
        System.out.println(person4.describeMe());

    }
}


