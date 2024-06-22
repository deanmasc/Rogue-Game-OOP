package game.attributes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;

/**
 * AttackBehaviour class prompts to attack when it's near a threat.
 *
 * @author Dean mascitti
 */
public class AttackBehaviour implements Behaviour {


    /**
     * Checks when the actor has the right to attack, returns null otherwise.
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return AttackAction or null if no action is required.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {
            if (exit.getDestination().containsAnActor()) {
                Actor actor2 = exit.getDestination().getActor();
                if (!actor2.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                    return new AttackAction(actor2, exit.getName());
                }
            }
        }
        return null;
    }
}
