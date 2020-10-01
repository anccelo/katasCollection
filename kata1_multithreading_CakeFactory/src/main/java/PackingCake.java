import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class PackingCake implements Callable<Cake> {

    private static final int PACKING_TIME = 2;
    private final Cake cake;
    private final Scheduler scheduler;

    public PackingCake(Cake cake, Scheduler scheduler) {
        this.cake = cake;
        this.scheduler = scheduler;
    }

    @Override
    public Cake call() throws Exception {
        System.out.println("packing cake number " + cake.getCakeId() + " ");
        TimeUnit.SECONDS.sleep(PACKING_TIME);
        System.out.println("cake number " + cake.getCakeId() + " DONE!");
        cake.hasBeenPackaged();
        scheduler.getReadyCakes().add(cake);
        return null;
    }
}
