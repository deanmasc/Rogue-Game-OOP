package game.positions.plants;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Plant class for non droppable plants.
 *
 * @author Dean Mascitti.
 */
public abstract class Plant extends Ground{
    private int tickCount = 0;
    private boolean mature = false;

    /**
     * Constructor.
     * @param displayChar
     */
    public Plant(char displayChar) {
        super(displayChar);
    }

    /**
     * Gets tick count.
     *
     * @return gets tick count
     */
    public int getTickCount() {
        return tickCount;
    }

    /**
     * Increments tick count.
     *
     * @param increment tick count being added by.
     */
    public void addTickCount(int increment) {
        tickCount += increment;
    }

    /**
     * Returns maturity status.
     *
     * @return maturity status
     */
    public boolean isMature() {
        return mature;
    }

    /**
     * Sets maturity.
     *
     * @param maturity new maturity.
     */
    public void setMature(boolean maturity) {
        mature = maturity;
    }
}
