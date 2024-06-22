package game.positions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.actors.HostileCreature;


import java.util.ArrayList;
import java.util.List;

/**
 * SpawnEnemyGround class which is an abstract class which represents a ground type which can spawn creatures.
 *
 * @author Dean Mascitti
 */
public abstract class SpawnEnemyGround extends Ground implements Spawnable {
    private HostileCreature creature;
    private int spawnRate;

    /**
     * Constructor.
     *
     * @param displayChar display character.
     * @param creature creature to be spawned
     * @param spawnRate rate of spawn
     */
    public SpawnEnemyGround(char displayChar, HostileCreature creature, int spawnRate) {
        super(displayChar);
        this.creature = creature;
        this.spawnRate = spawnRate;
    }

    /**
     * Sets actor to be spawned.
     *
     * @param creature creature to be spawned
     */
    public void setActor(HostileCreature creature) {
        this.creature = creature;
    }

    /**
     * Gets current creature being spawned.
     *
     * @return current creature being spawned.
     */
    public Actor getActor() {
        return this.creature;
    }

    /**
     * Setter for spawn rate.
     *
     * @param spawnRate the new spawn rate
     */
    public void setSpawnRate(int spawnRate) {
        this.spawnRate = spawnRate;
    }

    /**
     * Tick function attempts to spawn each tick.
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        int randomNumber = Utility.generateRandom(1, 100);

        if(randomNumber <= this.spawnRate)
            spawn(location);
    }

    /**
     * Executes the spawn.
     *
     * @param location current space of spawn class.
     */
    @Override
    public void spawn(Location location) {
        List<Location> locations = new ArrayList<>();
        for (Exit exit : location.getExits()) {
            Location destination = exit.getDestination();
            if (!destination.containsAnActor()) {
                locations.add(destination);
            }
        }

        int randomLocation = Utility.generateRandom(0, locations.size() - 1);
        locations.get(randomLocation).addActor(this.creature.copy());
    }
}