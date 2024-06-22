package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * HealAction class udndertakes the healing of an Actor.
 *
 * @author Dean Mascitti
 */
public class HealAction extends Action {

    private Consumable consumable;
    private Actor actor;

    /**
     * Class constructor initiating the heal actor and consumable.
     *
     * @param consumable what is being consumed for the healing
     * @param actor the actor being healed
     */
    public HealAction(Consumable consumable, Actor actor) {
        this.consumable = consumable;
        this.actor = actor;
    }

    /**
     * The execution of the healing.
     *
     * @param actor The actor being healed.
     * @param map The map the actor is on.
     * @return a string giving the details of the healing result
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.heal(consumable.getHealPoints());

        actor.removeItemFromInventory(consumable);

        return actor + " has been healed by " + consumable.getHealPoints() + " hit points by the " + consumable;
    }

    /**
     * Menu description giving the player the option to heal.
     *
     * @param actor The actor performing the healing.
     * @return a string outputting the option.
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Heal the " + actor + " by consuming the " + consumable + " in their inventory.";
    }
}
