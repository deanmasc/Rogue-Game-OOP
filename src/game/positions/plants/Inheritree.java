package game.positions.plants;

import edu.monash.fit2099.engine.positions.Location;
import game.items.LargeFruit;
import game.items.SmallFruit;

import java.util.List;

/**
 * Inheritree class, which extends its parent DroppablePlant.
 *
 * @author Dean Mascitti
 */
public class Inheritree extends DroppablePlant{


    /**
     * Constructor.
     */
    public Inheritree() {
        super('t', new SmallFruit(), 30);

    }

    /**
     * Tick method which updates and checks for maturity every tick.
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        addTickCount(1);

        if (getTickCount() == 5) {
            setDisplayChar('T');
            setDropRate(20);
            setDroppable(new LargeFruit());
        }

        spawn(location);
    }

}
