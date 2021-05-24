public class IronDomeUnit {
    private String location;

    public IronDomeUnit(String location) {
        this.location = location;
    }

    public RocketAttack destroyRockets(RocketAttack originalAttack) {
        RocketAttack copyAttack = new RocketAttack();
        for(Rocket rocket : originalAttack.getRockets()) {
            copyAttack.addRocket(rocket);
        }
        for (Rocket cRocket : copyAttack.getRockets()) {
            if(cRocket.getLocation().equals(this.location)) {
                System.out.println("BOOM!!! Just destroy a rocket at: " + this.location);
                originalAttack.removeRocket(cRocket);
            }
        }
        return originalAttack;
    }
}
