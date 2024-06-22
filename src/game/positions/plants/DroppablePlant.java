package game.positions.plants;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.items.Consumable;
import game.positions.Spawnable;


import java.util.List;

/**
 * DroppablePlant class which represents a ground type in which can drop consumables.
 *
 * @author Dean Mascitti.
 */
public abstract class DroppablePlant extends Ground implements Spawnable {
    private int tickCount = 0;
    private Consumable consumable;
    private int dropRate;

    /**
     * Constructor.
     *
     * @param displayChar display character
     * @param consumable Consumable being dropped
     * @param dropRate The rate at which it is dropped
     */
    public DroppablePlant(char displayChar, Consumable consumable, int dropRate) {
        super(displayChar);
        this.consumable = consumable;
        this.dropRate = dropRate;
    }

    /**
     * Gets tick count.
     *
     * @return tick count
     */
    public int getTickCount() {
        return tickCount;
    }

    /**
     * Adds to the tick count.
     *
     * @param increment how much its being added by.
     */
    public void addTickCount(int increment) {
        tickCount += increment;
    }


    /**
     * Updates what consumable is being dropped.
     * @param consumable new consumable.
     */
    public void setDroppable(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     * Updates the drop rate of consumable.
     *
     * @param dropRate new drop rate
     */
    public void setDropRate(int dropRate) {
        this.dropRate = dropRate;
    }

    /**
     * Spawn functionality for the droppable plant.
     *
     * @param location location of the plant.
     */
    @Override
    public void spawn(Location location) {
        int randomNumber = Utility.generateRandom(1, 100);

        if (randomNumber <= this.dropRate) {
            List<Exit> exits = location.getExits();
            int randomExit = Utility.generateRandom(0, exits.size() - 1);
            System.out.println("yes");
            exits.get(randomExit).getDestination().addItem(this.consumable);
        }
    }
}
