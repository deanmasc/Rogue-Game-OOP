package game.positions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.actors.HostileCreature;
import game.actors.HuntsmanSpider;

import java.util.List;

/**
 * Crater class in which extends its parent SpawnEnemyGround.
 */
public class Crater extends SpawnEnemyGround{

    /**
     * Constructor.
     *
     * @param creature Creature to be spawned
     * @param spawnRate the rate of spawning
     */
    public Crater(HostileCreature creature, int spawnRate) {
        super('u', creature, spawnRate);
    }

}
