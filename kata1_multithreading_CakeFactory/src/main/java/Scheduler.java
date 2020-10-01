import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;


public class Scheduler {

    private final ExecutorService oven;
    private final ExecutorService packMachine;

    private static final List<Cake> readyCakes = new ArrayList<>();

    public Scheduler(final ExecutorService oven, final ExecutorService packagingMachine) {
        this.oven = oven;
        this.packMachine = packagingMachine;
    }

    public void addCakeToTheOvenQueue(final Cake preparedCake) {
        CookCake cookCake = new CookCake(preparedCake, this);
        oven.submit(cookCake);
    }

    public void addCakeToThePackMachineQueue(final Cake cookedCake) {
        PackingCake packingCake = new PackingCake(cookedCake, this);
        packMachine.submit(packingCake);
    }

    public static List<Cake> getReadyCakes() {
        return readyCakes;
    }


}
