import java.util.ArrayList;
import java.util.List;

public class IronDomeSystem implements RocketListener{
    private List<IronDomeUnit> ironDomeUnits;

    public IronDomeSystem() {
        ironDomeUnits = new ArrayList<>();
        ironDomeUnits.add(new IronDomeUnit("Ashkelon"));
        ironDomeUnits.add(new IronDomeUnit("Tel-Aviv"));
        ironDomeUnits.add(new IronDomeUnit("Ashdod"));
    }

    @Override
    public void HandleRocketAttack(RocketAttack ra) {
        for(IronDomeUnit unit : ironDomeUnits) {
            ra = unit.destroyRockets(ra);
        }
    }
}
