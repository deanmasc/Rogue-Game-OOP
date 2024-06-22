package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import game.attributes.Ability;

/**
 * Scrap class is an abstract class that represents scraps in the game which do not have special ability.
 *
 * @author Dean Mascitti
 */
public abstract class Scrap extends Item {

    /**
     * Constructor.
     * @param name scraps name.
     * @param displayChar scraps display character.
     */
    public Scrap(String name, char displayChar) {
        super(name, displayChar, true);
    }

}
