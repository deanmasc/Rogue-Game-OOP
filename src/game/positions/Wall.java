package game.positions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Represents a Wall.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Dean Mascitti
 *
 */
public class Wall extends Ground {

    /**
     * Constructor.
     */
    public Wall() {
        super('#');
    }

    /**
     * Returns false for actors ability to enter.
     * @param actor the Actor to check
     * @return false
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
