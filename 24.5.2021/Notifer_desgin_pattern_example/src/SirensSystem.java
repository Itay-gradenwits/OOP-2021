import java.util.ArrayList;
import java.util.List;

public class SirensSystem implements RocketListener{

    private List<SirenUnit> sirenUnits;

    public SirensSystem() {
        sirenUnits = new ArrayList<>();
        sirenUnits.add(new SirenUnit("Ashkelon"));
        sirenUnits.add(new SirenUnit("Tel-Aviv"));
        sirenUnits.add(new SirenUnit("Ashdod"));
    }

    @Override
    public void HandleRocketAttack(RocketAttack ra) {
        for(SirenUnit s : sirenUnits) {
            s.makeNoise(ra);
        }
    }
}
