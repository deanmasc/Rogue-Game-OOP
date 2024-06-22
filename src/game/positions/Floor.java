package game.positions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.attributes.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Dean Mascitti
 *
 */
public class Floor extends Ground {
    /**
     * Constructor.
     */
    public Floor() {
        super('_');
    }

    /**
     * Returns if an actor can enter Floor.
     *
     * @param actor the Actor to check
     * @return boolean true if can, false if not
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Ability.CAN_ENTER_SPACESHIP);
    }
}
