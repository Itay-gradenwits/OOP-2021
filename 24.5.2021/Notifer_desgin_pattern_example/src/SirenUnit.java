public class SirenUnit {
    private String location;

    public SirenUnit(String location) {
        this.location = location;
    }

    public void makeNoise(RocketAttack rocketAttack) {
        for(Rocket rocket : rocketAttack.getRockets()) {
            if(rocket.getLocation().equals(this.location)) {
                System.out.println("WIOOOWIOOOOWIOOOOOWIOOOOWIOOOOWIOOOWIOOOWIOOO (at:) " + rocket.getLocation());
            }
        }
    }
}
