package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.attributes.Ability;
import game.attributes.Status;
import game.displays.FancyMessage;

/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.CAN_ENTER_SPACESHIP);
    }

    /**
     * This method executes the players turn, giving the player the option of choosing its action.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return The action chosen by the player.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // return/print the console menu
        Menu menu = new Menu(actions);
        System.out.println(name);
        System.out.println("HP: " + this.getAttribute(BaseActorAttributes.HEALTH) + "/" + this.getAttributeMaximum(BaseActorAttributes.HEALTH));
        return menu.showMenu(this, display);
    }

    /**
     * Method returning actions the player can recieve.
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return the list of actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Result of when the player is dead.
     * @param actor the perpetrator
     * @param map where the actor fell unconscious
     * @return a string giving the death message.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        map.removeActor(this);
        return this + " met their demise at the hand of " + actor + "\n" + FancyMessage.YOU_ARE_FIRED;
    }

    /**
     * Result of when the player is dead.
     * @param map where the actor fell unconscious
     * @return
     */
    @Override
    public String unconscious(GameMap map) {
        map.removeActor(this);
        return this + " ceased to exist." + "\n" + FancyMessage.YOU_ARE_FIRED;
    }

    /**
     * Returns the players intrinsic weapon.
     * @return the players intrinsic weapon.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "punches with bare hands", 5);
    }

}
