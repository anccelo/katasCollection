import java.beans.PropertyChangeSupport;

public class Cake {

    private CakeState cakeState;
    private final int cakeId;


    public Cake(final int cakeId) {
        this.cakeId = cakeId;
    }

    public int getCakeId() {
        return cakeId;
    }

    public void hasBeenPrepared() {
        this.cakeState = CakeState.PREPARED;
    }

    public void hasBeenCooked() {
        this.cakeState = CakeState.COOKED;
    }

    public void hasBeenPackaged() {
        this.cakeState = CakeState.PACKAGED;
    }
}
