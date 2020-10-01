import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class CakeFactory {

    private static final int MAX_NUMBER_CAKES_SUPPORTED_BY_THE_MIXER = 3;
    private static final int MAX_NUMBER_CAKES_SUPPORTED_BY_THE_OVEN = 5;
    private static final int MAX_NUMBER_CAKES_SUPPORTED_BY_THE_PACKAGING_MACHINE = 2;
    private static final int COMMANDED_CAKES = 5;

    public static void main(String[] args) throws InterruptedException {

        final List<CakePreparation> cakePreparations = new ArrayList<>();
        final ExecutorService oven = newFixedThreadPool(MAX_NUMBER_CAKES_SUPPORTED_BY_THE_OVEN);
        final ExecutorService packagingMachine = newFixedThreadPool(MAX_NUMBER_CAKES_SUPPORTED_BY_THE_PACKAGING_MACHINE);

        final Scheduler scheduler = new Scheduler(oven, packagingMachine);

        for (int i = 0; i < COMMANDED_CAKES; i++) {
            final CakePreparation cakePreparation = new CakePreparation(scheduler);
            cakePreparations.add(cakePreparation);
        }
        ExecutorService mixer = newFixedThreadPool(MAX_NUMBER_CAKES_SUPPORTED_BY_THE_MIXER);
        try {
            mixer.invokeAll(cakePreparations);
        } catch (InterruptedException interruptedException) {
            System.out.println("there is a problem with mixer");
        } finally {
            System.out.println("END preparations");
            mixer.shutdown();
            while (Scheduler.getReadyCakes().size() != COMMANDED_CAKES) {
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("END COOKING");
            oven.shutdown();
            System.out.println("END PACKAGING");
            System.out.println("The " + COMMANDED_CAKES + " CAKE are READY!!!!Enjoy your meal");
            packagingMachine.shutdown();
        }

    }

}







