import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CakePreparation implements Callable<Cake> {

    private static final AtomicInteger CAKE_ID_GENERATOR = new AtomicInteger(0);

    private final Scheduler scheduler;

    public CakePreparation(final Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public Cake call() {
        Cake cake = new Cake(CAKE_ID_GENERATOR.addAndGet(1));
        long randomPreparationTime = (long) (Math.random() * ((8 - 5) + 1)) + 5;// [5,6,7,8]
        System.out.println("cake number " + cake.getCakeId() + " is prepared in " + randomPreparationTime + "  seconds");
        try {
            TimeUnit.SECONDS.sleep(randomPreparationTime);
        } catch (InterruptedException e) {
            System.out.println("Preparation wrong");
        }
        System.out.println("finished preparing, ready to cooking number " + cake.getCakeId());
        cake.hasBeenPrepared();
        scheduler.addCakeToTheOvenQueue(cake);
        return cake;
    }


}
