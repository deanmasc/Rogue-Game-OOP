package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface which gives scraps the ability to return their special actions.
 *
 * @author Dean Mascitti.
 */
public interface SpecialScrap {
    /**
     * Returns a list of the scraps special abilities.
     * @param actor the actor in correlation.
     * @return a list of the scraps special abilities.
     */
    ActionList getSpecialAbilities(Actor actor);

}
