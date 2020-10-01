import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CookCake implements Callable<Cake> {

    private static final int CAKE_COOKING_TIME = 5;
    private final Cake cake;

    private final Scheduler scheduler;

    public CookCake(final Cake cake, final Scheduler scheduler) {
        this.cake = cake;
        this.scheduler = scheduler;
    }

    @Override
    public Cake call() throws Exception {
        System.out.println("cooking cake number " + cake.getCakeId() + " ");
        TimeUnit.SECONDS.sleep(CAKE_COOKING_TIME);
        System.out.println("cake number " + cake.getCakeId() + " ready to packaging.");
        cake.hasBeenCooked();
        scheduler.addCakeToThePackMachineQueue(cake);
        return null;
    }
}
