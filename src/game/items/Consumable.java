package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.HealAction;

/**
 * Consumable class represents the template of an item in which can be consumed.
 *
 * @author Dean mascitti
 */
public abstract class Consumable extends Item implements SpecialScrap{

    private int healPoints;

    /**
     * Contructor.
     *
     * @param consumableName name of consumable
     * @param displayChar display character of class
     * @param healPoints how many points it can heal
     */
    public Consumable(String consumableName, char displayChar, int healPoints) {
        super(consumableName, displayChar, true);
        this.healPoints = healPoints;
    }

    /**
     * Gathers all actions the item can do to an actor.
     *
     * @param actor the actor that owns the item.
     * @return List of actions item can do to actor.
     */
    @Override
    public ActionList allowableActions(Actor actor) {

        return this.getSpecialAbilities(actor);
    }

    /**
     * Gathers all actions the item can do to an actor.
     *
     * @param actor actor actions are being done to.
     * @return List of actions item can do to actor.
     */
    @Override
    public ActionList getSpecialAbilities(Actor actor) {
        ActionList actions = new ActionList();
        actions.add(new HealAction(this, actor));

        return actions;
    }

    public int getHealPoints() {
        return healPoints;
    }
}
