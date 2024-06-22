package game.weapons;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.items.SpecialScrap;

/**
 * MetalPipe class, which represents a weapon that can hit other actors.
 *
 * @author Dean Mascitti
 */
public class MetalPipe extends WeaponItem implements SpecialScrap {

    /**
     * Constructor.
     */
    public MetalPipe() {
        super("Metal Pipe", '!', 1, "hits", 20);
    }

    /**
     * Returns all actions which the weapon can do to another actor.
     *
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return Returns all actions which the weapon can do to another actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){

        return this.getSpecialAbilities(otherActor);
    }

    /**
     * Returns all special actions which the weapon can do to another actor.
     *
     * @param otherActor the actor in correlation.
     * @return Returns all actions which the weapon can do to another actor.
     */
    @Override
    public ActionList getSpecialAbilities(Actor otherActor) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, this));
        return actions;
    }


}
