public class TV_Reporter implements RocketListener{


    public void report(RocketAttack rocketAttack) {
        for (Rocket r : rocketAttack.getRockets()) {
            System.out.println("a rocket is flying into " + r.getLocation() + "!!!");
        }
    }

    @Override
    public void HandleRocketAttack(RocketAttack ra) {
        report(ra);
    }
}
