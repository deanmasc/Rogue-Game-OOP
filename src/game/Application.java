package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.HuntsmanSpider;
import game.actors.Player;
import game.displays.FancyMessage;
import game.items.LargeBolt;
import game.items.SmallFruit;
import game.weapons.MetalPipe;
import game.items.MetalSheet;
import game.positions.*;
import game.positions.plants.Inheritree;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Dean Mascitti
 *
 */
public class Application {

    /**
     * Main function in which runs the entire application of the game.
     *
     * @param args
     */
    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(
                new Dirt(), new Wall(), new Floor(), new Puddle(), new Inheritree());

        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        "..............................",
                        ".............#####............",
                        ".............#___#...........~",
                        ".............#___#..........~~",
                        "......t......##_##.........~~~",
                        ".................~~........~~~",
                        "................~~~~.......~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.........~",
                        ".....~~~...~~~~~~~~~..........",
                        ".....~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        Item metalSheet = new MetalSheet();
        Item largeBolt = new LargeBolt();
        Item metalPipe = new MetalPipe();

        Crater crater = new Crater(new HuntsmanSpider(), 5);

        gameMap.at(10, 4).setGround(crater);
        gameMap.at(12, 6).addItem(metalSheet);
        gameMap.at(11, 6).addItem(largeBolt);
        gameMap.at(10, 6).addItem(metalPipe);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }


        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));

        world.run();
    }
}
