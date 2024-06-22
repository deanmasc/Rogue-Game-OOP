package game.positions;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Spawnable interface represents all classes that can spawn something and gives them the function for this ability.
 *
 * @author Dean Mascitti.
 */
public interface Spawnable {

        /**
         * Spawns the object.
         *
         * @param location current space of spawn class.
         */
        void spawn(Location location);
}
