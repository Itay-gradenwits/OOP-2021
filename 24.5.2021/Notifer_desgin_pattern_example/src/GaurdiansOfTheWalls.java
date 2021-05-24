import java.util.concurrent.TimeUnit;

public class GaurdiansOfTheWalls {
    private Hamas hamas;
    private AttackIdentifer attackIdentifer;

    public GaurdiansOfTheWalls() {
        this.hamas = new Hamas();
        this.attackIdentifer = new AttackIdentifer();
        attackIdentifer.addListener(new SirensSystem());
        attackIdentifer.addListener(new TV_Reporter());
        attackIdentifer.addListener(new IronDomeSystem());
    }

    public void begin() throws InterruptedException {
        for(int i = 0; i<10; i ++) {
            RocketAttack r = hamas.attackIsrael();
            attackIdentifer.identity(r);
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
