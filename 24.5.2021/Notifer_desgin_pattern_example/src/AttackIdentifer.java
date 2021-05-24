import java.util.ArrayList;
import java.util.List;

public class AttackIdentifer implements RocketNotifer{

    private List<RocketListener> listeners;

    public AttackIdentifer() {
        listeners = new ArrayList<>();
    }

    @Override
    public void addListener(RocketListener rl) {
        listeners.add(rl);
    }

    @Override
    public void notifyAll(RocketAttack r) {
        for(RocketListener listener : listeners) {
            listener.HandleRocketAttack(r);
        }
    }

    public void identity(RocketAttack ra) {
        System.out.println("a rocket attack just assured");
        notifyAll(ra);
    }
}
