import java.util.ArrayList;
import java.util.List;

public class RocketAttack {
    private List<Rocket> rockets;

    public RocketAttack() {
        rockets = new ArrayList<>();
    }

    public void addRocket(Rocket r) {
        this.rockets.add(r);
    }

    public void removeRocket(Rocket r) {
        this.rockets.remove(r);
    }

    public List<Rocket> getRockets() {
        return rockets;
    }
}
