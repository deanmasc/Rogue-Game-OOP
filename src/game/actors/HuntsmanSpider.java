package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.attributes.Status;
import game.attributes.WanderBehaviour;
import game.actions.AttackAction;
import game.positions.Spawnable;


import java.util.HashMap;
import java.util.Map;

/**
 * HuntsmanSpider class, which holds all attributes and functionality of a huntsman spider.
 *
 * @author Dean mascitti
 */
public class HuntsmanSpider extends HostileCreature {

    /**
     * Constructor.
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
    }

    /**
     * Returns the intrnsic weapon of the huntsman spider.
     *
     * @return intrinsic weapon instance.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "hits with long legs", 25);
    }

    /**
     * Returns a copy of a huntsman spider instance.
     *
     * @return a copy of a huntsman spider instance.
     */
    @Override
    public HostileCreature copy() {
        return new HuntsmanSpider();
    }




}
