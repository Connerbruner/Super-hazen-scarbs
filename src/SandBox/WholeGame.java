// Source File Name:   WholeGame.java
package SandBox;

import CheckPoint.CheckPoints;
import com.golden.gamedev.*;
import com.golden.gamedev.funbox.GameSettings;
import java.awt.Dimension;
import java.awt.Point;
import java.io.*;

// Referenced classes of package SandBox:
//            Mario
public class WholeGame extends GameEngine {

    public WholeGame() {
    }

    
    public void initResources() {
        LoadImages();
        nextGameID = new CheckPoints(3, 5, 10 , new Point(3, 13));
        currentGameID = new CheckPoints(0.0D, 0.0D, 0, new Point(0, 0));
    }

    
    public GameObject getGame(int GameID) {
        return new Mario(dimension, this, nextGameID);

    }

    public static void main(String args[])
            throws FileNotFoundException, IOException {
        File SETTINGS = new File("Setting.txt");
        if (SETTINGS.exists()) {
            FileInputStream fin = new FileInputStream(SETTINGS);
            DataInputStream in = new DataInputStream(fin);

            try {
                fullscreen = in.readBoolean();
                bufferStrategy = in.readBoolean();
                sound = in.readBoolean();
                Skip = in.readBoolean();
                game_width = in.readInt();
                game_height = in.readInt();
                in.close();
//            SETTINGS.delete();

            } catch (java.io.EOFException e) {
                fullscreen = false;
                bufferStrategy = false;
                sound = false;
                Skip = false;
                game_width = 640;
                game_height = 480;

            }

            dimension = new Dimension(game_width, game_height);

        } else {
            dimension = new Dimension(640, 480);
        }

        if (Skip && SETTINGS.exists()) {

            GameSettings settings = new GameSettings(fullscreen, bufferStrategy, sound) {

                
                public void start() {

                    dimension = new Dimension(Integer.parseInt(Game_Width.getText()), Integer.parseInt(Game_Height.getText()));

                    // here goes the usual game initialization
                    GameLoader game = new GameLoader();
                    game.setup(new WholeGame() {

                        
                        protected void initEngine() {
                            super.initEngine();
                            // set active sound base on user setting
                            bsSound.setActive(sound.isSelected());
                            bsMusic.setActive(sound.isSelected());
                        }
                    }, dimension, fullscreen.isSelected(), bufferstrategy.isSelected());
                    game.start();
                }
            };
        } else {

            GameSettings settings = new GameSettings() {

                
                public void start() {

                    dimension = new Dimension(Integer.parseInt(Game_Width.getText()), Integer.parseInt(Game_Height.getText()));

                    // here goes the usual game initialization
                    GameLoader game = new GameLoader();
                    game.setup(new WholeGame() {

                        
                        protected void initEngine() {
                            super.initEngine();
                            // set active sound base on user setting
                            bsSound.setActive(sound.isSelected());
                            bsMusic.setActive(sound.isSelected());
                        }
                    }, dimension, fullscreen.isSelected(), bufferstrategy.isSelected());
                    game.start();
                }
            };
        }

    }

    private void LoadImages() {
        System.out.print("loading images");
        bsLoader.storeImages("Iron", getImages("Iron.png", 4, 1));
        bsLoader.storeImages("QuestionMark", getImages("QuestionMark.png", 3, 1));
        bsLoader.storeImages("QuestionMarkGrey", getImages("QuestionMarkGrey.png", 3, 1));
        bsLoader.storeImage("Mashroom", getImage("Mashroom.png"));
        bsLoader.storeImages("Mashrooms", getImages("Mashrooms.png", 2, 1));
        bsLoader.storeImage("chocolate_Sea", getImage("chocolate_Sea.png"));
        bsLoader.storeImage("chocolate", getImage("chocolate.png"));
        bsLoader.storeImage("chocolate_UnderGround", getImage("chocolate_UnderGround.png"));
        bsLoader.storeImage("chocolate_Castle", getImage("chocolate_Castle.png"));
        bsLoader.storeImages("CoinAnim", getImages("CoinAnim.png", 9, 1));
        bsLoader.storeImages("BrickPeaces", getImages("BrickPeaces.png", 2, 4));
        bsLoader.storeImages("Flower", getImages("Flower.png", 4, 1));
        bsLoader.storeImages("SmallToBigMarioAnim", getImages("SmallToBigMarioAnim.png", 6, 1));
        bsLoader.storeImages("BigBlackMario", getImages("BigBlackMario.png", 4, 7));
        bsLoader.storeImages("BigPlayer", getImages("BigPlayer.png", 4, 7));
        bsLoader.storeImages("BigGreenMario", getImages("BigGreenMario.png", 4, 7));
        bsLoader.storeImages("BigRedMario", getImages("BigRedMario.png", 4, 7));
        bsLoader.storeImages("SmallBlackMario", getImages("SmallBlackMario.png", 4, 7));
        bsLoader.storeImages("player", getImages("player.png", 4, 7));
        bsLoader.storeImages("SmallGreenMario", getImages("SmallGreenMario.png", 4, 7));
        bsLoader.storeImages("SmallRedMario", getImages("SmallRedMario.png", 4, 7));
        bsLoader.storeImages("FirePlayer", getImages("FirePlayer.png", 4, 7));
        bsLoader.storeImages("enemy", getImages("enemy.png", 2, 4));
        bsLoader.storeImages("turtle", getImages("turtle.png", 4, 1));
        bsLoader.storeImage("brick_Sea", getImage("brick_Sea.png"));
        bsLoader.storeImage("brick", getImage("brick.png"));
        bsLoader.storeImage("brick_UnderGround", getImage("brick_UnderGround.png"));
        bsLoader.storeImage("brick_Castle", getImage("brick_Castle.png"));
        bsLoader.storeImages("stone_Sea", getImages("stone_Sea.png", 4, 2));
        bsLoader.storeImages("stone", getImages("stone.png", 4, 2));
        bsLoader.storeImages("stone_fencewhite", getImages("stone_fencewhite.png", 4, 2));
        bsLoader.storeImages("stone_UnderGround", getImages("stone_UnderGround.png", 4, 2));
        bsLoader.storeImages("stone_Castle", getImages("stone_Castle.png", 4, 2));
        bsLoader.storeImage("pump top", getImage("pump top.png"));
        bsLoader.storeImage("pump Castle", getImage("pump Castle.png"));
        bsLoader.storeImage("pump Sea", getImage("pump Sea.png"));
        bsLoader.storeImage("pump", getImage("pump.png"));
        bsLoader.storeImage("pump top Castle", getImage("pump top Castle.png"));
        bsLoader.storeImage("pump top Sea", getImage("pump top Sea.png"));
        bsLoader.storeImage("TurtelShell", getImage("TurtelShell.png"));
        bsLoader.storeImage("TurtelShellRed", getImage("TurtelShellRed.png"));
        bsLoader.storeImages("BigToSmallMarioAnim", getImages("BigToSmallMarioAnim.png", 5, 1));
        bsLoader.storeImages("FireToSmallMarioAnim", getImages("FireToSmallMarioAnim.png", 5, 1));
        bsLoader.storeImage("SmallDeadMario", getImage("SmallDeadMario.png"));
        bsLoader.storeImages("FireBall", getImages("FireBall.png", 4, 1));
        bsLoader.storeImages("Explosion", getImages("Explosion.png", 3, 1));
        bsLoader.storeImage("SmallCastle", getImage("SmallCastle.png"));
        bsLoader.storeImage("BigCastle", getImage("BigCastle.png"));
        bsLoader.storeImages("tree", getImages("tree.png", 5, 3));
        bsLoader.storeImages("Wall", getImages("Wall.png", 2, 1));
        bsLoader.storeImages("RocketLauncher", getImages("RocketLauncher.png", 1, 4));
        bsLoader.storeImages("FlyingTurtle", getImages("FlyingTurtle.png", 4, 1));
        bsLoader.storeImages("plant", getImages("plant.png", 2, 1));
        bsLoader.storeImages("Monkey", getImages("Monkey.png", 3, 2));
        bsLoader.storeImages("Hammer", getImages("Hammer.png", 4, 1));
        bsLoader.storeImages("1UP", getImages("1UP.png", 2, 1));
        bsLoader.storeImages("Helmet", getImages("Helmet.png", 4, 1));
        bsLoader.storeImage("HelmetShell", getImage("HelmetShell.png"));
        bsLoader.storeImages("SonOfABuitch", getImages("SonOfABuitch.png", 2, 1));
        bsLoader.storeImages("SpikeyEgg", getImages("SpikeyEgg.png", 2, 1));
        bsLoader.storeImages("Spikey", getImages("Spikey.png", 4, 1));
        bsLoader.storeImage("Bouncer", getImage("Bouncer.png"));
        bsLoader.storeImages("Spring", getImages("Spring.png", 3, 1));
        bsLoader.storeImage("Flag", getImage("Flag.png"));
        bsLoader.storeImage("FlagFence", getImage("FlagFence.png"));
        bsLoader.storeImage("SlidingFlagDownAnim", getImage("SlidingFlagDownAnim.png"));
        bsLoader.storeImages("Axe", getImages("Axe.png", 4, 1));
        bsLoader.storeImages("WhyYouDOThis", getImages("WhyYouDOThis.png", 2, 1));
        bsLoader.storeImages("AnotherCastleMessage", getImages("AnotherCastleMessage.png", 2, 1));
        bsLoader.storeImages("Boss", getImages("Extended/Boss.png", 8, 4));
        bsLoader.storeImages("Fire", getImages("Fire.png", 3, 1));
        bsLoader.storeImage("BridgeBloks", getImage("BridgeBloks.png"));
        bsLoader.storeImages("Star", getImages("Star.png", 4, 1));
        bsLoader.storeImages("Coin", getImages("Coin.png", 3, 1));
        bsLoader.storeImage("Lava", getImage("Lava.png"));
        bsLoader.storeImage("TurtelShellFilp", getImage("TurtelShellFilp.png"));
        bsLoader.storeImage("TurtelShellFilpRed", getImage("TurtelShellFilpRed.png"));
        bsLoader.storeImages("HoriImage", getImages("HoriImage.png", 2, 1));
        bsLoader.storeImage("Lift", getImage("Lift.png"));
        bsLoader.storeImages("EnemyTurtlePatrol", getImages("EnemyTurtlePatrol.png", 4, 1));
        bsLoader.storeImages("FlyingTurtlePatrol", getImages("FlyingTurtlePatrol.png", 4, 1));
        bsLoader.storeImages("FlagTop", getImages("FlagTop.png", 3, 1));
        bsLoader.storeImage("FlagSphere", getImage("FlagSphere.png"));
        bsLoader.storeImage("FlagSphereFence", getImage("FlagSphereFence.png"));
        bsLoader.storeImages("FishGrey", getImages("FishGrey.png", 2, 1));
        bsLoader.storeImages("FishRed", getImages("FishRed.png", 2, 1));
        bsLoader.storeImages("OctoPussy", getImages("OctoPussy.png", 2, 1));
        bsLoader.storeImages("Bubble", getImages("Bubble.png", 4, 1));
        bsLoader.storeImage("WoodenBridge", getImage("WoodenBridge.png"));
        bsLoader.storeImage("Rope", getImage("Rope.png"));
        bsLoader.storeImage("RopeFence", getImage("RopeFence.png"));
        bsLoader.storeImages("LavaBall", getImages("LavaBall.png", 3, 2));
        bsLoader.storeImage("WhiteLine", getImage("WhiteLine.png"));
        bsLoader.storeImages("Water", getImages("Water.png", 8, 1));
        bsLoader.storeImages("Chain", getImages("Chain.png", 4, 1));
        bsLoader.storeImages("stone_Castle_Sea", getImages("stone_Castle_Sea.png", 4, 2));
        bsLoader.storeImage("Start", getImage("Start.png"));
        bsLoader.storeImage("bend", getImage("bend.png"));
        bsLoader.storeImage("Princess", getImage("Princess.png"));
        bsLoader.storeImage("QuestComplete", getImage("QuestComplete.png"));
        bsLoader.storeImages("BWHammer", getImages("BWHammer.png", 4, 1));
        bsLoader.storeImages("Font", getImages("Font.png", 16, 3));
        bsLoader.storeImages("Rocket", getImages("Extended/Rocket.png", 3, 2));
        bsLoader.storeImages("TurtelShellGreenMoving", getImages("Extended/TurtelShellGreenMoving.png", 4, 1));
        bsLoader.storeImages("TurtelShellRedMoving", getImages("Extended/TurtelShellRedMoving.png", 4, 1));
        bsLoader.storeImages("TurtelShellGreenMovingFlip", getImages("Extended/TurtelShellGreenMovingFlip.png", 4, 1));
        bsLoader.storeImages("TurtelShellRedMovingFlip", getImages("Extended/TurtelShellRedMovingFlip.png", 4, 1));
        bsLoader.storeImages("Lamp", getImages("Background/Lamp.png", 4, 1));
        bsLoader.storeImages("AnimatedGrass", getImages("Background/AnimatedGrass.png", 4, 1));
        bsLoader.storeImages("WaterFall", getImages("Background/WaterFall.png", 4, 1));
        bsLoader.storeImages("Daze", getImages("Extended/Daze.png", 1, 15));
        bsLoader.storeImages("LavaAnim", getImages("Extended/LavaAnim.png", 7, 1));
        bsLoader.storeImages("Rope3Frames", getImages("Extended/Rope3Frames.png", 3, 1));
        bsLoader.storeImages("Tile", getImages("Tile.png", 16, 2));
        bsLoader.storeImages("TilesTransparent", getImages("TilesTransparent.png", 16, 2));
        bsLoader.storeImages("BridgeBloksFalling", getImages("Extended/BridgeBloksFalling.png", 15, 1));
        bsLoader.storeImage("stone_Green_Sea", getImage("stone_Green_Sea.png"));
        bsLoader.storeImages("FlagUp", getImages("Extended/FlagUp.png", 4, 1));
        bsLoader.storeImages("YellowFalg", getImages("Extended/YellowFalg.png", 4, 1));
        bsLoader.storeImages("Kiss", getImages("Extended/Kiss.png", 7, 3));
        bsLoader.storeImage("QuestCompleteText", getImage("Extended/QuestCompleteText.png"));
        bsLoader.storeImages("Twink", getImages("Extended/Twink.png", 6, 1));
        bsLoader.storeImages("fireworks", getImages("Extended/fireworks.png", 1, 3));
        bsLoader.storeImages("Victory", getImages("Extended/Victory.png", 11, 3));
        bsLoader.storeImages("LavaSpots", getImages("Extended/LavaSpots.png", 3, 1));
        bsLoader.storeImages("Smoke", getImages("Extended/Smoke.png", 3, 1));
        bsLoader.storeImages("Dust", getImages("Extended/Dust.png", 3, 1));
        bsLoader.storeImages("LiftClowd", getImages("LiftClowd.png", 1, 4));

        this.bsLoader.storeImage("Info", this.getImage("Info.png"));
        this.bsLoader.storeImage("Clowd", this.getImage("Clowd.png"));
        this.bsLoader.storeImage("stone_Clowd", this.getImage("stone_Clowd.png"));
        
        this.bsLoader.storeImage("numbers432", this.getImage("numbers432.png"));
        this.bsLoader.storeImage("numbers876", this.getImage("numbers876.png"));

    }
    private static boolean fullscreen;
    private static boolean bufferStrategy;
    private static boolean sound;
    private static boolean Skip;
//    private static int resolution = 0; // 640 x 480
    private static Dimension dimension;
    private static int game_width;
    private static int game_height;
//    MusicPlayer musicPlayer;
}
