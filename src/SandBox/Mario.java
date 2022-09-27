// Source File Name:   Mario.java
package SandBox;

import Animations.*;
import Bricks.*;
import CheckPoint.CheckPoints;
import Collusion.*;
import ExtendedObjects.*;
import Gears.Codes;
import Gears.Construct;
import Levels.BasicLevel;
import Levels.Eight.BonusArea.BonusArea81B;
import Levels.Eight.BonusArea.BonusArea82E;
import Levels.Eight.*;
import Levels.Extra.Clowd_level_for_2_1;
import Levels.Extra.Clowd_level_for_3_1;
import Levels.Extra.Clowd_level_for_4_2;
import Levels.Extra.Clowd_level_for_5_2;
import Levels.Extra.Clowd_level_for_6_2;
import Levels.Extra.Level_Start;
import Levels.Extra.TestArea;
import Levels.Five.BonusArea.BonusArea51E;
import Levels.Five.BonusArea.BonusArea52F;
import Levels.Five.*;
import Levels.Four.BonusArea.BonusArea41D;
import Levels.Four.BonusArea.BonusArea42E;
import Levels.Four.*;
import Levels.One.BonusArea.BonusArea11A;
import Levels.One.BonusArea.BonusArea12B;
import Levels.One.*;
import Levels.Seven.BonusArea.BonusArea71A;
import Levels.Seven.*;
import Levels.Six.BonusArea.*;
import Levels.Six.*;
import Levels.Three.BonusArea.BonusArea31C;
import Levels.Three.*;
import Levels.Two.BonusArea.BonusArea21A;
import Levels.Two.*;
import Lifts.*;
import Objects.*;
import Teleport.SpriteTeleport;
import com.golden.gamedev.GameObject;
import com.golden.gamedev.object.*;
import com.golden.gamedev.util.ImageUtil;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// Referenced classes of package SandBox:
//            WholeGame
public class Mario extends GameObject {

    boolean Background;
    public PlayField playfield;
    Background background;
    CollisionManager Player_FlyingFishesCollisionManager;
    CollisionManager Player_InvisibleObjects_CollisionManager;
    CollisionManager Player_Teleport_CollisionManager;
    CollisionManager Player_Lift_CollisionManager;
    CollisionManager Player_CheckPointCollisionManager;
    CollisionManager Player_Flag_CollisionManager;
    CollisionManager Enemy_Brick_CollisionManager;
    CollisionManager Player_Brick_CollisionManager;
    CollisionManager Hammer_Player_CollisionManager;
    CollisionManager Player_Plant_CollisionManager;
    CollisionManager Player_Enemy_CollisionManager;
    CollisionManager Enemy_Enemy_CollisionManager;
    CollisionManager FireBall_PlantCollisionManager;
    CollisionManager FireBall_BricksCollisionManager;
    CollisionManager FireBall_Enemys_CollisionManager;
    public SpriteGroup FlyingFishesGroup;
    public SpriteGroup KageGroup;
    public SpriteGroup TilesGroup;
    public SpriteGroup InvisibleObjects;
    public SpriteGroup PlantGroup;
    public SpriteGroup TeleportGroup;
    public SpriteGroup LiftGroup;
    public SpriteGroup UnderGroup;
    public SpriteGroup FlagGroup;
    public SpriteGroup HammerGroup;
    public SpriteGroup FireBall;
    public SpriteGroup AnimationGroup;
    public SpriteGroup EnemyGroup;
    public SpriteGroup BrickGroup;
    public SpriteGroup PlayerGroup;
    public SpriteGroup VolitileGroup;
    public SpriteGroup BackGroundSpriteGroup;
    public Player player;
    private int degree;
    private String Side;
    int LevelNumber;
    int PlayetX;
    int PlayerY;
    private boolean PlayLivingThings;
    private boolean FindDublicatesON;
    public double Distance;
    public double InvertDistance;
    public Boss boss;
    public Sprite DemoMario;
    private String GameAttribute;
    CheckPoints CurrentCheckpoint;
    private boolean LevelComplete;
    private CheckPoints cp;
    public int DelayToNextCheckPoint;
    private FlagTop flagtop;
    boolean Bombs;
    private int BombsDelay;
    public int BombsTurnOff;
    boolean FlyingFishes;
    private int FlyingFishesLength;
    public BasicLevel CurrentLevel;
    boolean PlayGame;
    GameFont font;
    private String WORLD;
    boolean StopScroll;
    public boolean SmoothScroll;
    public Color BackGroundColor;
    int StartWorld;
    int StartLevel;
    Sprite NAME;
    int Screenshot;
    Timer AutoSave;
    BufferedImage BackGroundColorImage;
    boolean ShowShinyFrame;
    private BufferedImage ShinyFrame;
    double ShinyFrameYpos;
    private boolean ShinyFrameUP;
    PrincessAnim princessAnim;
    private int FlyingFishesdelay;
    private boolean ShowInfo;
    private BufferedImage Info;
    private Dimension dimension;
//    double scale = 1;
    private double scale_width;
    private double scale_height;
    private boolean scaleOn;

    Mario(Dimension dimension, WholeGame aThis, CheckPoints CP) {

        super(aThis);

        Background = true;
        degree = 0;
        Side = "up";
        LevelNumber = 14;
        PlayetX = 3;
        PlayerY = 6;
        PlayLivingThings = true;
        FindDublicatesON = false;
        Distance = 3.1415926535897931D;
        InvertDistance = 0.0D;
        LevelComplete = false;
        DelayToNextCheckPoint = 160;
        Bombs = false;
        BombsDelay = 50;
        BombsTurnOff = -1;
        FlyingFishes = false;
        FlyingFishesLength = 50;
        PlayGame = true;
        StopScroll = true;
        SmoothScroll = false;
        BackGroundColor = new Color(92, 148, 252);
        StartWorld = 1;
        StartLevel = 1;
        Screenshot = 1;
        ShowShinyFrame = false;
        ShinyFrameYpos = 0.0D;
        FlyingFishesdelay = 0;
        CurrentCheckpoint = CP;
        LevelNumber = CurrentCheckpoint.GetNextLevel();
        PlayetX = CurrentCheckpoint.NextLocation.x * 32;
        PlayerY = CurrentCheckpoint.NextLocation.y * 32;

        this.dimension = dimension;

        double width = dimension.width;
        double hegith = dimension.height;

        scale_width = width / 640;
        scale_height = hegith / 480;

        scaleOn = true;
        if (scale_width == 1 & scale_height == 1) {
            scaleOn = false;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void initResources() {
        AutoSave = new Timer(500);
        java.net.URL url = null;
        try {
            setFPS(30);
            EnemyGroup = new SpriteGroup("EnemyGroup");
            BrickGroup = new SpriteGroup("BrickGroup");
            HammerGroup = new SpriteGroup("HammerGroup ");
            FlagGroup = new SpriteGroup("FlagGroup");
            AnimationGroup = new SpriteGroup("AnimationGroup");
            UnderGroup = new SpriteGroup("UnderGroup");
            LiftGroup = new SpriteGroup("LiftGroup");
            TeleportGroup = new SpriteGroup("TeleportGroup");
            PlantGroup = new SpriteGroup("PlantGroup");
            InvisibleObjects = new SpriteGroup("InvisibleObjects");
            BackGroundSpriteGroup = new SpriteGroup("BackGroundSpriteGroup");
            TilesGroup = new SpriteGroup("TilesGroup");
            KageGroup = new SpriteGroup("KageGroup");
            FlyingFishesGroup = new SpriteGroup("FlyingFishesGroup");
            CurrentLevel = SelectLevel(LevelNumber);
            GameAttribute = CurrentLevel.attribute;
            if ("Blue".equals(CurrentLevel.BackGroundColor)) {
                BackGroundColorImage = getImage("Background/BackGroundColor/Blue.png");
            } else if ("black".equals(CurrentLevel.BackGroundColor)) {
                BackGroundColorImage = getImage("Background/BackGroundColor/black.png");
            } else if ("BlueFant".equals(CurrentLevel.BackGroundColor)) {
                BackGroundColorImage = getImage("Background/BackGroundColor/BlueFant.png");
            } else if ("BarkBlue".equals(CurrentLevel.BackGroundColor)) {
                BackGroundColorImage = getImage("Background/BackGroundColor/BarkBlue.png");
                ShowShinyFrame = true;
                ShinyFrame = ImageUtil.getImage(getClass().getResource("Background/BackGroundColor/shinyFrame.png"), 3);
            } else {
                BackGroundColorImage = getImage("Background/BackGroundColor/Blue.png");
            }
            if (Background) {
                if ("sky".equals(CurrentLevel.BackGroundMiddleImage1)) {
                    for (int i = 0; i < 2; i++) {
                        CloudsScrolling CloudsBGround = new CloudsScrolling(getImage("Background/CloudsScrolling.png"), 6142 * i, 0, this);
                        BackGroundSpriteGroup.add(CloudsBGround);
                    }

                } else if (!"stars[A]".equals(CurrentLevel.BackGroundMiddleImage1) && "Thunder".equals(CurrentLevel.BackGroundMiddleImage1)) {
                    Thunder thunder = new Thunder(0, 0, getImages("Background/Thunder.png", 7, 1), this);
                    BackGroundSpriteGroup.add(thunder);
                }
                if ("mountain".equals(CurrentLevel.BackGroundMiddleImage2)) {
                    for (int i = 0; i < 3; i++) {
                        MountainsScrolling MountainsBGround = new MountainsScrolling(getImage("Background/MountainsScrolling.png"), 3772 * i, 0, this);
                        BackGroundSpriteGroup.add(MountainsBGround);
                    }

                } else if (!"mountain &trees".equals(CurrentLevel.BackGroundMiddleImage2)) {
                    if ("river[A]".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        for (int i = 0; i < 3; i++) {
                            WaterfallStill WaterfallStillBGround = new WaterfallStill(getImage("Background/WaterfallStill.png"), 2900 * i, 0, this);
                            BackGroundSpriteGroup.add(WaterfallStillBGround);
                        }

                    } else if ("Pillars".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        for (int i = 0; i < 2; i++) {
                            MountainsScrolling MountainsBGround = new MountainsScrolling(getImage("Background/Pillars.png"), 4062 * i, 0, this);
                            BackGroundSpriteGroup.add(MountainsBGround);
                        }

                    } else if ("RedTrees".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        for (int i = 0; i < 3; i++) {
                            MountainsScrolling MountainsBGround = new MountainsScrolling(getImage("Background/RedTrees.png"), 2706 * i, 180, this);
                            BackGroundSpriteGroup.add(MountainsBGround);
                        }

                    } else if ("purplestones".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        for (int i = 0; i < 20; i++) {
                            MountainsScrolling MountainsBGround = new MountainsScrolling(getImage("Background/purplestones.png"), 512 * i, 0, this);
                            BackGroundSpriteGroup.add(MountainsBGround);
                        }

                    } else if ("castle-img".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        int Tiles[] = {
                            0, 0, 1, 2, 2, 3, 3, 3, 3, 3,
                            3, 3, 3, 3, 3
                        };
                        for (int i = 0; i < Tiles.length; i++) {
                            MountainsScrolling MountainsBGround = new MountainsScrolling(getImages("Background/CastleBackGround.png", 4, 1)[Tiles[i]], 512 * i, 0, this);
                            BackGroundSpriteGroup.add(MountainsBGround);
                        }

                    } else if ("castle-img2".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        int Tiles[] = {
                            0, 0, 1, 2, 2, 3, 3, 3, 3, 3,
                            3, 3, 3, 3, 3
                        };
                        for (int i = 0; i < Tiles.length; i++) {
                            MountainsScrolling MountainsBGround = new MountainsScrolling(getImages("Background/castle-img2.png", 4, 1)[Tiles[i]], 512 * i, 0, this);
                            BackGroundSpriteGroup.add(MountainsBGround);
                        }

                    } else if ("cave-img".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        for (int i = 0; i < 20; i++) {
                            BlackBacgGround BGround = new BlackBacgGround(getImage("Background/BlackBacgGround.png"), 1024 * i, 0, this);
                            BackGroundSpriteGroup.add(BGround);
                        }

                    } else if ("lolypopGreen".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        for (int i = 0; i < 3; i++) {
                            MountainsScrolling MountainsBGround = new MountainsScrolling(getImage("Background/lolypopGreen.png"), 3568 * i, 0, this);
                            BackGroundSpriteGroup.add(MountainsBGround);
                        }

                    } else if ("lolypopWhite".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        for (int i = 0; i < 3; i++) {
                            MountainsScrolling MountainsBGround = new MountainsScrolling(getImage("Background/lolypopWhite.png"), 3044 * i, 0, this);
                            BackGroundSpriteGroup.add(MountainsBGround);
                        }

                    } else if ("lolypopRed".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        for (int i = 0; i < 3; i++) {
                            MountainsScrolling MountainsBGround = new MountainsScrolling(getImage("Background/lolypopRed.png"), 3226 * i, 0, this);
                            BackGroundSpriteGroup.add(MountainsBGround);
                        }

                    } else if ("AnimatedSea".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        int start[] = new int[70];
                        int movement = 0;
                        boolean positve = true;
                        for (int i = 0; i < 70; i++) {
                            if (movement < -35) {
                                positve = true;
                            }
                            if (movement > 35) {
                                positve = false;
                            }
                            if (positve) {
                                movement += 5;
                            } else {
                                movement -= 5;
                            }
                            start[i] = movement;
                        }

                        for (int i = 0; i < 3; i++) {
                            for (int row = 0; row < 62; row++) {
                                AnimatedSea Animatedsea = new AnimatedSea(ImageUtil.splitImages(getImage("Background/AnimatedSea.png"), 1, 62)[row], 2298 * i, 170 + row * 5, this, start[row]);
                                BackGroundSpriteGroup.add(Animatedsea);
                            }

                        }

                    } else if ("house".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        int start[] = new int[70];
                        int movement = 0;
                        boolean positve = true;
                        for (int i = 0; i < 70; i++) {
                            if (movement < -35) {
                                positve = true;
                            }
                            if (movement > 35) {
                                positve = false;
                            }
                            if (positve) {
                                movement += 5;
                            } else {
                                movement -= 5;
                            }
                            start[i] = movement;
                        }

                        for (int i = 0; i < 2; i++) {
                            for (int row = 0; row < 32; row++) {
                                AnimatedSea Animatedsea = new AnimatedSea(ImageUtil.splitImages(getImage("Background/house.png"), 1, 32)[row], 1138 * i, 288 + row * 4, this, start[row]);
                                BackGroundSpriteGroup.add(Animatedsea);
                            }

                        }

                    } else if ("Wall".equals(CurrentLevel.BackGroundMiddleImage2)) {
                        for (int i = 0; i < 3; i++) {
                            MountainsScrolling MountainsBGround = new MountainsScrolling(getImage("Background/Wall.png"), 3934 * i, 96, this);
                            BackGroundSpriteGroup.add(MountainsBGround);
                        }

                    }
                }
                if ("fencegreen".equals(CurrentLevel.BackGroundImage)) {
                    for (int i = 0; i < 10; i++) {
                        BackGroundSpriteGroup.add(new Sprite(getImage("Fence2.png"), 1536 * i, 32D));
                    }

                } else if ("grass[A]".equals(CurrentLevel.BackGroundImage)) {
                    for (int i = 0; i < 3; i++) {
                        BackGroundSpriteGroup.add(new AnimatedGrass(bsLoader.getStoredImages("AnimatedGrass"), i * 1536 + 352, 384));
                        BackGroundSpriteGroup.add(new AnimatedGrass(bsLoader.getStoredImages("AnimatedGrass"), i * 1536 + 384, 384));
                        BackGroundSpriteGroup.add(new AnimatedGrass(bsLoader.getStoredImages("AnimatedGrass"), i * 1536 + 416, 384));
                        BackGroundSpriteGroup.add(new AnimatedGrass(bsLoader.getStoredImages("AnimatedGrass"), i * 1536 + 736, 384));
                        BackGroundSpriteGroup.add(new AnimatedGrass(bsLoader.getStoredImages("AnimatedGrass"), i * 1536 + 1312, 384));
                        BackGroundSpriteGroup.add(new AnimatedGrass(bsLoader.getStoredImages("AnimatedGrass"), i * 1536 + 1344, 384));
                    }

                } else if ("fencewhite".equals(CurrentLevel.BackGroundImage)) {
                    for (int i = 0; i < 10; i++) {
                        BackGroundSpriteGroup.add(new Sprite(getImage("Fence.png"), 1536 * i, 32D));
                    }

                }
                if ("Sea".equals(CurrentLevel.attribute)) {
                    for (int i = 0; i < CurrentLevel.LevelLength / 32; i++) {
                        AnimatedSprite Sea = new AnimatedSprite(getImages("Sea.png", 8, 1));
                        Sea.setAnimationTimer(new Timer(100));
                        Sea.setAnimate(true);
                        Sea.setLoopAnim(true);
                        Sea.setLocation(32 * i, 0.0D);
                        BackGroundSpriteGroup.add(Sea);
                    }

                }
            }
            LoadLevel(CurrentLevel);
            LoadCheckPoints(CurrentLevel);
            LoadTeleport(CurrentLevel);
            LoadInvisibleObjects();
            Bombs = CurrentLevel.Bombs;
            BombsTurnOff = CurrentLevel.BombsTurnOff;
            FlyingFishes = CurrentLevel.FlyingFishes;
            FlyingFishesLength = CurrentLevel.FlyingFishesLength;
            if ("Blue".equals(CurrentLevel.BackGroundColor)) {
                background = new Background(CurrentLevel.LevelLength, 480);
            } else if ("Black".equals(CurrentLevel.BackGroundColor)) {
                background = new Background(CurrentLevel.LevelLength, 480);
            } else if ("DarkBlue".equals(CurrentLevel.BackGroundColor)) {
                background = new Background(CurrentLevel.LevelLength, 480);
            } else {
                background = new Background(CurrentLevel.LevelLength, 480);
            }
            background.setClip(0, 0, 640, 480);
            Enemy_Brick_CollisionManager = new Enemy_Brick(this);
            Enemy_Brick_CollisionManager.setCollisionGroup(EnemyGroup, BrickGroup);
            player = new Player(PlayetX, PlayerY, bsLoader.getStoredImages("player"), this);
            PlayerGroup = new SpriteGroup("PlayerGroup");
            PlayerGroup.add(player);
            Player_Brick_CollisionManager = new Player_Brick(this);
            Player_Brick_CollisionManager.setCollisionGroup(PlayerGroup, BrickGroup);
            Player_Enemy_CollisionManager = new Player_EnemyGroup(this);
            Player_Enemy_CollisionManager.setCollisionGroup(PlayerGroup, EnemyGroup);
            Player_Plant_CollisionManager = new Player_EnemyGroup(this);
            Player_Plant_CollisionManager.setCollisionGroup(PlayerGroup, PlantGroup);
            Player_InvisibleObjects_CollisionManager = new Player_InvisibleObjects(this);
            Player_InvisibleObjects_CollisionManager.setCollisionGroup(PlayerGroup, InvisibleObjects);
            Player_FlyingFishesCollisionManager = new Player_EnemyGroup(this);
            Player_FlyingFishesCollisionManager.setCollisionGroup(PlayerGroup, FlyingFishesGroup);
            Player_Lift_CollisionManager = new Player_Lift(this);
            Player_Lift_CollisionManager.setCollisionGroup(PlayerGroup, LiftGroup);
            Player_Teleport_CollisionManager = new Player_Teleport(this);
            Player_Teleport_CollisionManager.setCollisionGroup(PlayerGroup, TeleportGroup);
            VolitileGroup = new SpriteGroup("VolitileGroup");
            playfield = new PlayField(background);
            playfield.addGroup(InvisibleObjects);
            playfield.addGroup(BackGroundSpriteGroup);
            playfield.addGroup(UnderGroup);
            playfield.addGroup(PlayerGroup);
            playfield.addGroup(VolitileGroup);
            playfield.addGroup(PlantGroup);
            playfield.addGroup(BrickGroup);
            playfield.addGroup(EnemyGroup);
            playfield.addGroup(FlyingFishesGroup);
            playfield.addGroup(LiftGroup);
            playfield.addGroup(HammerGroup);
            playfield.addGroup(FlagGroup);
            playfield.addGroup(TeleportGroup);
            playfield.addGroup(TilesGroup);
            playfield.addGroup(KageGroup);
            FireBall = new SpriteGroup("FireBall");
            playfield.addGroup(FireBall);
            playfield.addGroup(AnimationGroup);
            Enemy_Enemy_CollisionManager = new EnemyToEnemy(this);
            Enemy_Enemy_CollisionManager.setCollisionGroup(EnemyGroup, EnemyGroup);
            FireBall_BricksCollisionManager = new FireBallToBricks(this);
            FireBall_BricksCollisionManager.setCollisionGroup(FireBall, BrickGroup);
            FireBall_Enemys_CollisionManager = new FireBallToEnemys(this);
            FireBall_Enemys_CollisionManager.setCollisionGroup(FireBall, EnemyGroup);
            FireBall_PlantCollisionManager = new FireBallToEnemys(this);
            FireBall_PlantCollisionManager.setCollisionGroup(FireBall, PlantGroup);
            Hammer_Player_CollisionManager = new Hammer_Player(this);
            Hammer_Player_CollisionManager.setCollisionGroup(HammerGroup, PlayerGroup);

            Player_Flag_CollisionManager = new Player_Flag(this);
            Player_Flag_CollisionManager.setCollisionGroup(FlagGroup, PlayerGroup);

            Player_CheckPointCollisionManager = new Player_CheckPoint(this);
            Player_CheckPointCollisionManager.setCollisionGroup(PlayerGroup, FlagGroup);
            FindDublicates(CurrentLevel);
            if ("Sea".equals(CurrentLevel.attribute)) {
                player.Water = true;
            }
            String stringfont = "_0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ @#*-x^!&=$";
            font = fontManager.getFont(bsLoader.getStoredImages("Font"), stringfont);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        if (this.LevelNumber == 10) { // start screen
            player.NoControlling();
            NAME = new Sprite(this.bsLoader.getStoredImage("Start"), 144, 64);

        } else {
            PlayGameMusic();
        }

        PlayetX = (int) player.getX();
        PlayerY = (int) player.getY();
    }

    public void update(long l) {
        if (AutoSave.action(l)) {
            if (player.OnGround & (!player.OnLift)) {
                Sprite pos = new Sprite();
                pos.setLocation(PlayetX, PlayerY);
                if (player.getDistance(pos) > 1000) {
                    PlayetX = (int) player.getX();
                    PlayerY = (int) player.getY();

                }
            }
            player.OnLift = false;
        }
        if (LevelNumber == 10) {
            if (bsInput.isKeyPressed(90)) {
                IncreaseWorld();
            }
            if (bsInput.isKeyPressed(88)) {
                IncreaseLevel();
            }
            if (bsInput.isKeyPressed(10)) {
                CheckPoints oneone = new CheckPoints(4D, 6D, StartWorld * 10 + StartLevel, new Point(4, 6));
                cp = oneone;
                parent.nextGameID = cp;
                finish();
            }
        }

        if (bsInput.isKeyPressed(10)) {
            if (PlayGame) {
                PlayGame = false;
            } else {
                PlayGame = true;
            }
            playSound("music/smb_pause.mp3");
        }
        if (PlayGame) {
            if (Bombs && player.getX() / 32D < (double) BombsTurnOff) {
                BombsDelay--;
                if (BombsDelay < 0) {
                    Random r = new Random();
                    BombsDelay = (r.nextInt(5) + 1) * 50;
                    EnemyGroup.add(new Rocket((player.getX() - player.getScreenX()) + 680D, (r.nextInt(10) + 1) * 32, "gotoleft", bsLoader.getStoredImages("Rocket"), this));
                }
            }
            if (FlyingFishes & (player.getX() < (double) FlyingFishesLength) & (player.getX() > 640D) && FlyingFishesGroup.getSize() < 10) {
                if (FlyingFishesdelay < 0) {
                    FlyingFishesGroup.add(new FishyGround(this));
                    FlyingFishesdelay = 50;
                }
                if (FlyingFishesdelay > -10) {
                    FlyingFishesdelay--;
                }
            }
            if (LevelComplete) {
                DelayToNextCheckPoint--;
            }
            if (DelayToNextCheckPoint < 0) {
                LoadNextCheckPoint();
            }
            if (player.getY() > 500D) {
                Restart();
            }
            if (bsInput.isKeyDown(39)) {
                player.GoToRight();
            }
            if (bsInput.isKeyDown(37)) {
                player.GoToLeft();
            }
            if (bsInput.isKeyDown(40)) {
                player.Down();
            } else {
                player.KeyPressedDown = false;
            }
            if (this.bsInput.isKeyDown(KeyEvent.VK_UP)) {
                player.Up();
            } else {
                player.KeyPressedUP = false;
            }
            if (bsInput.isKeyPressed(90)) {
                player.Fire();
            }
            if (bsInput.isKeyDown(90)) {
                player.Speed(true);
            } else {
                player.Speed(false);
            }
            if (bsInput.isKeyDown(88) && !player.Water) {
                player.Jump();
            }
            if (bsInput.isKeyPressed(88) && player.Water) {
                player.Jump();
            }
            if (StopScroll) {
                background.setToCenter(player);

            }

            if (player.getScreenX() < 0.0D) {
                player.moveX(8D);
                player.StopSpeed();
            }
            if (player.getScreenX() > 608D) {
                player.moveX(-8D);
                player.StopSpeed();
            }

            if (SmoothScroll && player.getScreenX() > 320D) {
                background.move(5D, 0.0D);
            }
            if (PlayLivingThings) {
                playfield.update(l);
                Enemy_Brick_CollisionManager.checkCollision();
                Player_Brick_CollisionManager.checkCollision();
                Player_Plant_CollisionManager.checkCollision();
                Player_Enemy_CollisionManager.checkCollision();
                Player_FlyingFishesCollisionManager.checkCollision();
                Enemy_Enemy_CollisionManager.checkCollision();
                FireBall_BricksCollisionManager.checkCollision();
                FireBall_Enemys_CollisionManager.checkCollision();
                FireBall_PlantCollisionManager.checkCollision();
                Hammer_Player_CollisionManager.checkCollision();
                Player_Flag_CollisionManager.checkCollision();
                Player_CheckPointCollisionManager.checkCollision();
                Player_Lift_CollisionManager.checkCollision();
                Player_Teleport_CollisionManager.checkCollision();
                Player_InvisibleObjects_CollisionManager.checkCollision();
                Distance = Distance + 0.02D;
                InvertDistance = InvertDistance - 0.02D;
                if (Distance >= 6.2831853071795862D) {
                    Distance = 0.0D;
                }
            } else {
                AnimationGroup.update(l);
            }
            if (bsInput.isKeyPressed(27)) {
                finish();
            }
            if (bsInput.isKeyPressed(66)) {
                player.STAR();
            }
            if (bsInput.isKeyPressed(84)) {
                File F;
                for (F = new File(Screenshot + ".png"); F.exists(); F = new File(Screenshot + ".png")) {
                    Screenshot++;
                }

                takeScreenShot(F);
            }
            RemoveOutOfScreenFireBalls();
        }
    }

    public void render(Graphics2D g) {
        if (PlayGame) {

            if (scaleOn) {
                g.scale(scale_width, scale_height);// 1024 x 768
            }

            g.drawImage(BackGroundColorImage, null, 0, 0);
            if (PlayLivingThings) {
                playfield.render(g);
            } else {
                playfield.getBackground().render(g);
                for (int i = 0; i < playfield.getGroups().length; i++) {
                    if (playfield.getGroups()[i] != PlayerGroup) {
                        playfield.getGroups()[i].render(g);
                    }
                }

            }
            if (LevelNumber == 10) {
                NAME.render(g);
            }
            DrawShinyFrame(g);
            DrawScore(g);
        }
    }

    public void setDegree(int angle) {
        degree = angle;
    }

    public void setDegree(String side) {
        Side = side;
    }

    public void addSomeBrickFragmends(double x, double y) {
        BrickPeaces UpLeft = null;
        BrickPeaces UpRight = null;
        BrickPeaces DownLeft = null;
        BrickPeaces DownRight = null;
        BufferedImage brik[] = new BufferedImage[2];
        if ("Sea".equals(GetAttribute())) {
            brik[0] = bsLoader.getStoredImages("BrickPeaces")[2];
            brik[1] = bsLoader.getStoredImages("BrickPeaces")[3];
        } else if ("Ground".equals(GetAttribute())) {
            brik[0] = bsLoader.getStoredImages("BrickPeaces")[2];
            brik[1] = bsLoader.getStoredImages("BrickPeaces")[3];
        } else if ("UnderGround".equals(GetAttribute())) {
            brik[0] = bsLoader.getStoredImages("BrickPeaces")[4];
            brik[1] = bsLoader.getStoredImages("BrickPeaces")[5];
        } else if ("Castle".equals(GetAttribute())) {
            brik[0] = bsLoader.getStoredImages("BrickPeaces")[6];
            brik[1] = bsLoader.getStoredImages("BrickPeaces")[7];
        }
        UpLeft = new BrickPeaces(x, y, -4, -16, brik);
        UpRight = new BrickPeaces(x, y, 4, -16, brik);
        DownLeft = new BrickPeaces(x, y, -3, -12, brik);
        DownRight = new BrickPeaces(x, y, 3, -12, brik);
        AnimationGroup.add(UpLeft);
        AnimationGroup.add(UpRight);
        AnimationGroup.add(DownLeft);
        AnimationGroup.add(DownRight);
        playSound("music/smb_breakblock.mp3");
    }

    public void pauseEnemys() {
        PlayLivingThings = false;
    }

    public void PlayEnemys() {
        PlayLivingThings = true;
    }

    private void LoadLevel(BasicLevel CurrentLevel) {
        label0:
        for (int i = 0; i < CurrentLevel.Get_Items_Amount(); i++) {
            if (CurrentLevel.get_Item_Number(i) == null) {
                continue;
            }
            Construct constr = CurrentLevel.get_Item_Number(i);
            int x = 0;
            do {
                if (x >= constr.Length_X) {
                    continue label0;
                }
                for (int y = 0; y < constr.Length_Y; y++) {
                    label1:
                    switch (Codes.GetCode(constr.getItem_Type())) {
                        case -1:
                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                        case 8: // '\b'
                        case 9: // '\t'
                        case 10: // '\n'
                        case 11: // '\013'
                        case 18: // '\022'
                        case 25: // '\031'
                        case 34: // '"'
                        case 43: // '+'
                        case 46: // '.'
                        default:
                            break;

                        case 3: // '\003'
                        {
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Brick(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Sea"), this));
                                break;
                            }
                            if ("Ground".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Brick(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick"), this));
                                break;
                            }
                            if ("UnderGround".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Brick(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_UnderGround"), this));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Brick(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Castle"), this));
                            }
                            break;
                        }

                        case 4: // '\004'
                        {
                            BrickGroup.add(new QuestionMark(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            break;
                        }

                        case 5: // '\005'
                        {
                            BrickGroup.add(new QuestionMark(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("QuestionMark"), "Mashroom", this));
                            break;
                        }

                        case 6: // '\006'
                        {
                            int CurrentTile = 0;
                            if (y == 0) {
                                if (x == 0) {
                                    CurrentTile = 0;
                                } else if (x == constr.getLength_X() - 1) {
                                    CurrentTile = 2;
                                } else {
                                    CurrentTile = 1;
                                }
                            } else if (x == 0) {
                                CurrentTile = 4;
                            } else if (x == constr.getLength_X() - 1) {
                                CurrentTile = 6;
                            } else {
                                CurrentTile = 5;
                            }
                            if (constr.getLength_X() == 1) {
                                if (y == 0) {
                                    CurrentTile = 3;
                                } else {
                                    CurrentTile = 7;
                                }
                            }
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                if (constr.getY() < 13) {
                                    BrickGroup.add(new Stone(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("stone_Green_Sea.png")));
                                } else {
                                    BrickGroup.add(new Stone(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("stone_Sea")[CurrentTile]));
                                }
                                break;
                            }
                            if ("Ground".equals(CurrentLevel.attribute)) {
                                if ("fencewhite".equals(this.CurrentLevel.BackGroundImage)) {
                                    BrickGroup.add(new Stone(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("stone_fencewhite")[CurrentTile]));
                                } else {
                                    BrickGroup.add(new Stone(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("stone")[CurrentTile]));
                                }
                                break;
                            }
                            if ("UnderGround".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Stone(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("stone_UnderGround")[CurrentTile]));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Stone(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("stone_Castle")[CurrentTile]));
                            } else if ("Clowd".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Stone((constr.getX() * 32) + (x * 32), (constr.getY() * 32) + (y * 32), this.bsLoader.getStoredImage("stone_Clowd")));
                            }
                            break;
                        }

                        case 7: // '\007'
                        {
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new chocolate(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("chocolate_Sea")));
                                break;
                            }
                            if ("Ground".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new chocolate(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("chocolate")));
                                break;
                            }
                            if ("UnderGround".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new chocolate(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("chocolate_UnderGround")));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new chocolate(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("chocolate_Castle")));
                            }
                            break;
                        }

                        case 12: // '\f'
                        {
                            if (y == 0) {
                                PlantGroup.add(new plant(bsLoader.getStoredImages("plant.png"), constr.getX() * 32 + x * 32 + 16, constr.getY() * 32 + y * 32 + 48, this));
                                if ("Sea".equals(CurrentLevel.attribute)) {
                                    BrickGroup.add(new pump(bsLoader.getStoredImage("pump top Sea.png"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                                    break;
                                }
                                if ("Castle".equals(CurrentLevel.attribute) || "fencewhite".equals(CurrentLevel.BackGroundImage)) {
                                    BrickGroup.add(new pump(bsLoader.getStoredImage("pump top Castle"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                                } else {
                                    BrickGroup.add(new pump(bsLoader.getStoredImage("pump top.png"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                                }
                                break;
                            }
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new pump(bsLoader.getStoredImage("pump Sea.png"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute) || "fencewhite".equals(CurrentLevel.BackGroundImage)) {
                                BrickGroup.add(new pump(bsLoader.getStoredImage("pump Castle"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            } else {
                                BrickGroup.add(new pump(bsLoader.getStoredImage("pump.png"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            }
                            break;
                        }

                        case 13: // '\r'
                        {
                            BufferedImage temp[] = new BufferedImage[2];
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                temp[0] = bsLoader.getStoredImages("enemy")[0];
                                temp[1] = bsLoader.getStoredImages("enemy")[1];
                                EnemyGroup.add(new EnemyMashroom(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, temp, this));
                                break;
                            }
                            if ("Ground".equals(CurrentLevel.attribute)) {
                                temp[0] = bsLoader.getStoredImages("enemy")[2];
                                temp[1] = bsLoader.getStoredImages("enemy")[3];
                                EnemyGroup.add(new EnemyMashroom(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, temp, this));
                                break;
                            }
                            if ("UnderGround".equals(CurrentLevel.attribute)) {
                                temp[0] = bsLoader.getStoredImages("enemy")[4];
                                temp[1] = bsLoader.getStoredImages("enemy")[5];
                                EnemyGroup.add(new EnemyMashroom(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, temp, this));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute)) {
                                temp[0] = bsLoader.getStoredImages("enemy")[6];
                                temp[1] = bsLoader.getStoredImages("enemy")[7];
                                EnemyGroup.add(new EnemyMashroom(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, temp, this));
                            }
                            break;
                        }

                        case 14: // '\016'
                        {
                            EnemyGroup.add(new EnemyTurtle(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, true));
                            break;
                        }

                        case 15: // '\017'
                        {
                            if ("fencewhite".equals(this.CurrentLevel.BackGroundImage)) {
                                UnderGroup.add(new Sprite(getImage("Extended/SmallCastleSnow.png"), constr.getX() * 32 - 16, constr.getY() * 32));
                            } else {
                                UnderGroup.add(new Sprite(bsLoader.getStoredImage("SmallCastle"), constr.getX() * 32 - 16, constr.getY() * 32));
                            }
                            break;
                        }

                        case 16: // '\020'
                        {
                            UnderGroup.add(new SimpleAnimatedSprite(bsLoader.getStoredImages("YellowFalg"), constr.getX() * 32, 192));
                            UnderGroup.add(new SimpleAnimatedSprite(bsLoader.getStoredImages("YellowFalg"), constr.getX() * 32 + 256 + 16, 192));
                            if ("fencewhite".equals(this.CurrentLevel.BackGroundImage)) {
                                UnderGroup.add(new Sprite(getImage("Extended/BigCastleSnow.png"), constr.getX() * 32 - 16, constr.getY() * 32));
                            } else {
                                UnderGroup.add(new Sprite(bsLoader.getStoredImage("BigCastle"), constr.getX() * 32 - 16, constr.getY() * 32));
                            }
                            break;
                        }

                        case 17: // '\021'
                        {
                            if ("GreenAndTrees".equals(CurrentLevel.type)) {
                                if (y == 0) {
                                    if (x == 0) {
                                        BrickGroup.add(new Tree(bsLoader.getStoredImages("tree")[0], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                                        break;
                                    }
                                    if (x == constr.getLength_X() - 1) {
                                        BrickGroup.add(new Tree(bsLoader.getStoredImages("tree")[2], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                                    } else {
                                        BrickGroup.add(new Tree(bsLoader.getStoredImages("tree")[1], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                                    }
                                    break;
                                }
                                if (constr.getLength_X() == 3) {
                                    if (x == 1) {
                                        BackGroundSpriteGroup.add(new Sprite(bsLoader.getStoredImages("tree")[10], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                                    }
                                    break;
                                }
                                if (x == 1) {
                                    BackGroundSpriteGroup.add(new Sprite(bsLoader.getStoredImages("tree")[11], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                                    break;
                                }
                                if (x == constr.getLength_X() - 2) {
                                    BackGroundSpriteGroup.add(new Sprite(bsLoader.getStoredImages("tree")[13], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                                    break;
                                }
                                if ((x > 1) & (x < constr.getLength_X() - 2)) {
                                    BackGroundSpriteGroup.add(new Sprite(bsLoader.getStoredImages("tree")[12], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                                }
                                break;
                            }
                            if (!"OrangeAndMushroom".equals(CurrentLevel.type)) {
                                break;
                            }
                            if (y == 0) {
                                if (x == 0) {
                                    BrickGroup.add(new Tree(bsLoader.getStoredImages("tree")[5], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                                    break;
                                }
                                if (x == constr.getLength_X() - 1) {
                                    BrickGroup.add(new Tree(bsLoader.getStoredImages("tree")[7], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                                } else {
                                    BrickGroup.add(new Tree(bsLoader.getStoredImages("tree")[6], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                                }
                                break;
                            }
                            int Middel = constr.getLength_X() / 2;
                            if (x != Middel) {
                                break;
                            }
                            if (y == 1) {
                                BackGroundSpriteGroup.add(new Sprite(bsLoader.getStoredImages("tree")[8], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                            } else {
                                BackGroundSpriteGroup.add(new Sprite(bsLoader.getStoredImages("tree")[9], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                            }
                            break;
                        }

                        case 19: // '\023'
                        {
                            if (y == 0) {
                                BrickGroup.add(new RocketLauncher(bsLoader.getStoredImages("RocketLauncher")[0], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                                break;
                            }
                            if (y == 1) {
                                BrickGroup.add(new RocketLauncherBody(bsLoader.getStoredImages("RocketLauncher")[1], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            } else {
                                BrickGroup.add(new RocketLauncherBody(bsLoader.getStoredImages("RocketLauncher")[2], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            }
                            break;
                        }

                        case 20: // '\024'
                        {
                            EnemyGroup.add(new FlyingTurtle(bsLoader.getStoredImages("FlyingTurtle"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            break;
                        }

                        case 21: // '\025'
                        {
                            EnemyGroup.add(new Monkey(bsLoader.getStoredImages("Monkey"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            break;
                        }

                        case 22: // '\026'
                        {
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Bank(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Sea"), this));
                                break;
                            }
                            if ("Ground".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Bank(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick"), this));
                                break;
                            }
                            if ("UnderGround".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Bank(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_UnderGround"), this));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new Bank(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Castle"), this));
                            }
                            break;
                        }

                        case 23: // '\027'
                        {
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Sea"), "Mashroom", this));
                                break;
                            }
                            if ("Ground".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick"), "Mashroom", this));
                                break;
                            }
                            if ("UnderGround".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_UnderGround"), "Mashroom", this));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Castle"), "Mashroom", this));
                            }
                            break;
                        }

                        case 24: // '\030'
                        {
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Sea"), "1UP", this));
                                break;
                            }
                            if ("Ground".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick"), "1UP", this));
                                break;
                            }
                            if ("UnderGround".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_UnderGround"), "1UP", this));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Castle"), "1UP", this));
                            }
                            break;
                        }

                        case 26: // '\032'
                        {
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Sea"), "CoinInside", this));
                                break;
                            }
                            if ("Ground".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick"), "CoinInside", this));
                                break;
                            }
                            if ("UnderGround".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_UnderGround"), "CoinInside", this));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BankWithItem(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Castle"), "CoinInside", this));
                            }
                            break;
                        }

                        case 27: // '\033'
                        {
                            EnemyGroup.add(new Helmet(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("Helmet"), this));
                            break;
                        }

                        case 28: // '\034'
                        {
                            int j = 0;
                            do {
                                if (j >= 6) {
                                    break label1;
                                }
                                if ("CW".equals(constr.ExtraInfo)) {
                                    EnemyGroup.add(new EnemyFireBall(constr.getX() * 32 + x * 32 + 8, constr.getY() * 32 + y * 32 + 8, j * 16, this, true));
                                } else {
                                    EnemyGroup.add(new EnemyFireBall(constr.getX() * 32 + x * 32 + 8, constr.getY() * 32 + y * 32 + 8, j * 16, this, false));
                                }
                                j++;
                            } while (true);
                        }

                        case 29: // '\035'
                        {
                            int j = 0;
                            do {
                                if (j >= 12) {
                                    break label1;
                                }
                                if ("CW".equals(constr.ExtraInfo)) {
                                    EnemyGroup.add(new EnemyFireBall(constr.getX() * 32 + x * 32 + 8, constr.getY() * 32 + y * 32 + 8, j * 16, this, true));
                                } else {
                                    EnemyGroup.add(new EnemyFireBall(constr.getX() * 32 + x * 32 + 8, constr.getY() * 32 + y * 32 + 8, j * 16, this, false));
                                }
                                j++;
                            } while (true);
                        }

                        case 30: // '\036'
                        {
                            EnemyGroup.add(new SonOfABuitch(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("SonOfABuitch"), this));
                            break;
                        }

                        case 31: // '\037'
                        {
                            BrickGroup.add(new Spring(constr.getX() * 32 + x * 32, (constr.getY() * 32 + y * 32) - 32, bsLoader.getStoredImages("Spring"), this));
                            BrickGroup.add(new Bouncer(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("Bouncer"), this));
                            break;
                        }

                        case 32: // ' '
                        {
                            if ("fencewhite".equals(CurrentLevel.BackGroundImage)) {
                                FlagGroup.add(new Flag(constr.getX() * 32 + x * 32 + 14, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("FlagFence"), this));
                                flagtop = new FlagTop(bsLoader.getStoredImages("FlagTop"), constr.getX() * 32 + x * 32 + 16, constr.getY() * 32 + y * 32, this);
                                AnimationGroup.add(flagtop);
                                AnimationGroup.add(new Sprite(bsLoader.getStoredImage("FlagSphereFence"), constr.getX() * 32 + x * 32, (constr.getY() * 32 + y * 32) - 32));
                            } else {
                                FlagGroup.add(new Flag(constr.getX() * 32 + x * 32 + 14, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("Flag"), this));
                                flagtop = new FlagTop(bsLoader.getStoredImages("FlagTop"), constr.getX() * 32 + x * 32 + 16, constr.getY() * 32 + y * 32, this);
                                AnimationGroup.add(flagtop);
                                AnimationGroup.add(new Sprite(bsLoader.getStoredImage("FlagSphere"), constr.getX() * 32 + x * 32, (constr.getY() * 32 + y * 32) - 32));
                            }
                            break;
                        }

                        case 33: // '!'
                        {
                            BrickGroup.add(new Axe(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("Axe"), this));
                            break;
                        }

                        case 35: // '#'
                        {
                            boss = new Boss(bsLoader.getStoredImages("Boss"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this);
                            EnemyGroup.add(boss);
                            break;
                        }

                        case 36: // '$'
                        {
                            BrickGroup.add(new BridgeBloks(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("BridgeBloks"), this));
                            break;
                        }

                        case 37: // '%'
                        {
                            BrickGroup.add(new InvisibleBrck(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, "1UP", this));
                            break;
                        }

                        case 38: // '&'
                        {
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BrickWithStar(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Sea"), this));
                                break;
                            }
                            if ("Ground".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BrickWithStar(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick"), this));
                                break;
                            }
                            if ("UnderGround".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BrickWithStar(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_UnderGround"), this));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new BrickWithStar(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImage("brick_Castle"), this));
                            }
                            break;
                        }

                        case -2: {
                            EnemyGroup.add(new Coin(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("Coin"), this));
                            break;
                        }

                        case 39: // '\''
                        {
                            BrickGroup.add(new Iron(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("Iron"), "red", "noBounce", this));
                            break;
                        }

                        case 40: // '('
                        {
                            BrickGroup.add(new InvisibleBrck(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, "Coin", this));
                            break;
                        }

                        case 41: // ')'
                        {
                            HammerGroup.add(new Fire(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, bsLoader.getStoredImages("Fire"), this));
                            break;
                        }

                        case 42: // '*'
                        {
                            KageGroup.add(new SimpleAnimatedSprite(bsLoader.getStoredImages("LavaAnim"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                            break;
                        }

                        case 44: // ','
                        {
                            BrickGroup.add(new pump(bsLoader.getStoredImages("HoriImage")[0], constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            BrickGroup.add(new pump(bsLoader.getStoredImages("HoriImage")[1], constr.getX() * 32 + x * 32 + 64, constr.getY() * 32 + y * 32, this));
                            break;
                        }

                        case 45: // '-'
                        {
                            BrickGroup.add(new pump(bsLoader.getStoredImage("pump"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            break;
                        }

                        case 47: // '/'
                        {
                            EnemyGroup.add(new EnemyTurtlePatrol(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, constr.PetrolLength));
                            break;
                        }

                        case 48: // '0'
                        {
                            EnemyGroup.add(new FlyingTurtlePatrol(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, constr.PetrolLength));
                            break;
                        }

                        case 49: // '1'
                        {
                            LiftGroup.add(new Lift_UpDown(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, constr.PetrolLength));
                            break;
                        }

                        case 50: // '2'
                        {
                            LiftGroup.add(new Lift_LeftRight(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, constr.PetrolLength));
                            break;
                        }

                        case 51: // '3'
                        {
                            LiftGroup.add(new Lift_LeftRightInvert(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, constr.PetrolLength));
                            break;
                        }

                        case 52: // '4'
                        {
                            LiftGroup.add(new LiftUP(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, constr.PetrolLength));
                            break;
                        }

                        case 53: // '5'
                        {
                            LiftGroup.add(new LiftDown(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, constr.PetrolLength));
                            break;
                        }

                        case 54: // '6'
                        {
                            EnemyGroup.add(new FishyWater(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, 1));
                            break;
                        }

                        case 55: // '7'
                        {
                            EnemyGroup.add(new FishyWater(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, 3));
                            break;
                        }

                        case 56: // '8'
                        {
                            EnemyGroup.add(new FishyWater(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, 2));
                            break;
                        }

                        case 57: // '9'
                        {
                            EnemyGroup.add(new FishyWater(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, 4));
                            break;
                        }

                        case 58: // ':'
                        {
                            EnemyGroup.add(new OctoPussy(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            break;
                        }

                        case 59: // ';'
                        {
                            if ("fencewhite".equals(CurrentLevel.BackGroundImage)) {
                                BackGroundSpriteGroup.add(new Sprite(bsLoader.getStoredImage("RopeFence"), constr.getX() * 32 + x * 32, (constr.getY() * 32 + y * 32) - 32));
                                BrickGroup.add(new WoodenBridge(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                                break;
                            }
                            if (x == 0) {
                                BackGroundSpriteGroup.add(new Sprite(bsLoader.getStoredImages("Rope3Frames")[0], constr.getX() * 32 + x * 32, (constr.getY() * 32 + y * 32) - 32));
                            } else if (x == constr.getLength_X() - 1) {
                                BackGroundSpriteGroup.add(new Sprite(bsLoader.getStoredImages("Rope3Frames")[2], constr.getX() * 32 + x * 32, (constr.getY() * 32 + y * 32) - 32));
                            } else {
                                BackGroundSpriteGroup.add(new Sprite(bsLoader.getStoredImages("Rope3Frames")[1], constr.getX() * 32 + x * 32, (constr.getY() * 32 + y * 32) - 32));
                            }
                            BrickGroup.add(new WoodenBridge(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            break;
                        }

                        case 60: // '<'
                        {
                            EnemyGroup.add(new LavaBall(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            break;
                        }

                        case 61: // '='
                        {
                            BackGroundSpriteGroup.add(new Sprite(ImageUtil.resize(bsLoader.getStoredImage("WhiteLine"), 32, 416), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                            break;
                        }

                        case 62: // '>'
                        {
                            BackGroundSpriteGroup.add(new SimpleAnimatedSprite(bsLoader.getStoredImages("Water"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32));
                            break;
                        }

                        case 63: // '?'
                        {
                            LiftGroup.add(new BalenceLiftParent(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, constr.getBridgeLength()));
                            break;
                        }

                        case 64: // '@'
                        {
                            LiftGroup.add(new LiftFall(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this, constr.PetrolLength));
                            break;
                        }

                        case 65: // 'A'
                        {
                            boss = new Boss(bsLoader.getStoredImages("Boss"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this);
                            boss.SetHammer(true);
                            EnemyGroup.add(boss);
                            break;
                        }

                        case 66: // 'B'
                        {
                            if (y == 0) {
                                if ("Sea".equals(CurrentLevel.attribute)) {
                                    BrickGroup.add(new pump(bsLoader.getStoredImage("pump top Sea.png"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                                    break;
                                }
                                if ("Castle".equals(CurrentLevel.attribute) || "fencewhite".equals(CurrentLevel.BackGroundImage)) {
                                    BrickGroup.add(new pump(bsLoader.getStoredImage("pump top Castle"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                                } else {
                                    BrickGroup.add(new pump(bsLoader.getStoredImage("pump top.png"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                                }
                                break;
                            }
                            if ("Sea".equals(CurrentLevel.attribute)) {
                                BrickGroup.add(new pump(bsLoader.getStoredImage("pump Sea.png"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                                break;
                            }
                            if ("Castle".equals(CurrentLevel.attribute) || "fencewhite".equals(CurrentLevel.BackGroundImage)) {
                                BrickGroup.add(new pump(bsLoader.getStoredImage("pump Castle"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            } else {
                                BrickGroup.add(new pump(bsLoader.getStoredImage("pump.png"), constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, this));
                            }
                            break;
                        }

                        case 67: // 'C'
                        {
                            BrickGroup.add(new Tile(constr.getX() * 32 + x * 32, constr.getY() * 32 + y * 32, constr.getFrame(), this));
                            break;
                        }

                        case 642: // LiftCar

                            this.LiftGroup.add(new LiftCar((constr.getX() * 32) + (x * 32), (constr.getY() * 32) + (y * 32), this, constr.PetrolLength));

                            break;
                    }
                }

                x++;
            } while (true);
        }

    }

    private void RemoveOutOfScreenFireBalls() {
        for (int i = 0; i < FireBall.getSize(); i++) {
            if ((FireBall.getSprites()[i].getScreenX() < -50D) | (FireBall.getSprites()[i].getScreenX() > 700D)) {
                FireBall.getSprites()[i].setActive(false);
            }
        }

    }

    private BasicLevel SelectLevel(int LevelNumber1) {
        BasicLevel newLevel = null;
        switch (LevelNumber1) {
            case 10: // '\n'
                newLevel = new Level_Start();
                WORLD = "1-1";
                break;

            case 11: // '\013'
                newLevel = new Level_11();
                WORLD = "1-1";
                break;

            case 12: // '\f'
                newLevel = new Level_12();
                WORLD = "1-2";
                break;

            case 13: // '\r'
                newLevel = new Level_13();
                WORLD = "1-3";
                break;

            case 14: // '\016'
                newLevel = new Level_14();
                WORLD = "1-4";
                break;

            case 21: // '\025'
                newLevel = new Level_21();
                WORLD = "2-1";
                break;

            case 22: // '\026'
                newLevel = new Level_22();
                WORLD = "2-2";
                break;

            case 23: // '\027'
                newLevel = new Level_23();
                WORLD = "2-3";
                break;

            case 24: // '\030'
                newLevel = new Level_24();
                WORLD = "2-4";
                break;

            case 31: // '\037'
                newLevel = new Level_31();
                WORLD = "3-1";
                break;

            case 32: // ' '
                newLevel = new Level_32();
                WORLD = "3-2";
                break;

            case 33: // '!'
                newLevel = new Level_33();
                WORLD = "3-3";
                break;

            case 34: // '"'
                newLevel = new Level_34();
                WORLD = "3-4";
                break;

            case 41: // ')'
                newLevel = new Level_41();
                WORLD = "4-1";
                break;

            case 42: // '*'
                newLevel = new Level_42();
                WORLD = "4-2";
                break;

            case 43: // '+'
                newLevel = new Level_43();
                WORLD = "4-3";
                break;

            case 44: // ','
                newLevel = new Level_44();
                WORLD = "4-4";
                break;

            case 51: // '3'
                newLevel = new Level_51();
                WORLD = "5-1";
                break;

            case 52: // '4'
                newLevel = new Level_52();
                WORLD = "5-2";
                break;

            case 53: // '5'
                newLevel = new Level_53();
                WORLD = "5-3";
                break;

            case 54: // '6'
                newLevel = new Level_54();
                WORLD = "5-4";
                break;

            case 61: // '='
                newLevel = new Level_61();
                WORLD = "6-1";
                break;

            case 62: // '>'
                newLevel = new Level_62();
                WORLD = "6-2";
                break;

            case 63: // '?'
                newLevel = new Level_63();
                WORLD = "6-3";
                break;

            case 64: // '@'
                newLevel = new Level_64();
                WORLD = "6-4";
                break;

            case 71: // 'G'
                newLevel = new Level_71();
                WORLD = "7-1";
                break;

            case 72: // 'H'
                newLevel = new Level_72();
                WORLD = "7-2";
                break;

            case 73: // 'I'
                newLevel = new Level_73();
                WORLD = "7-3";
                break;

            case 74: // 'J'
                newLevel = new Level_74();
                WORLD = "7-4";
                break;

            case 81: // 'Q'
                newLevel = new Level_81();
                WORLD = "8-1";
                break;

            case 82: // 'R'
                newLevel = new Level_82();
                WORLD = "8-2";
                break;

            case 83: // 'S'
                newLevel = new Level_83();
                WORLD = "8-3";
                break;

            case 84: // 'T'
            case 841:
                newLevel = new Level_841();
                WORLD = "8-4 1";
                break;

            case 842:
                newLevel = new Level_842();
                WORLD = "8-4 2";
                break;

            case 843:
                newLevel = new Level_843();
                WORLD = "8-4 3";
                break;

            case 844:
                newLevel = new Level_844();
                WORLD = "8-4 4";
                break;

            case 845:
                newLevel = new Level_845();
                WORLD = "8-4 5";
                break;

            case 92: // clowd level for 2- 1
                newLevel = new Clowd_level_for_2_1();
                WORLD = "C21";
                break;
            case 93: // clowd level for 2- 1
                newLevel = new Clowd_level_for_3_1();
                WORLD = "C31";
                break;
            case 94: // clowd level for 2- 1
                newLevel = new Clowd_level_for_4_2();
                WORLD = "C42";
                break;
            case 95: // clowd level for 2- 1
                newLevel = new Clowd_level_for_5_2();
                WORLD = "C52";
                break;
            case 96: // clowd level for 2- 1
                newLevel = new Clowd_level_for_6_2();
                WORLD = "C62";
                break;

            case 555:
                newLevel = new TestArea();
                WORLD = "555";
                break;

            case 97: // 'a'
                newLevel = new BonusArea11A();
                WORLD = "1-1";
                break;

            case 98: // 'b'
                newLevel = new BonusArea12B();
                WORLD = "1-2";
                break;

            case 99: // 'c'
                newLevel = new BonusArea21A();
                WORLD = "2-1";
                break;

            case 100: // 'd'
                newLevel = new BonusArea31C();
                WORLD = "3-1";
                break;

            case 101: // 'e'
                newLevel = new BonusArea41D();
                WORLD = "4-1";
                break;

            case 102: // 'f'
                newLevel = new BonusArea42E();
                WORLD = "4-2";
                break;

            case 103: // 'g'
                newLevel = new BonusArea51E();
                WORLD = "5-1";
                break;

            case 104: // 'h'
                newLevel = new BonusArea52F();
                WORLD = "5-2";
                break;

            case 105: // 'i'
                newLevel = new BonusArea62E();
                WORLD = "6-2";
                break;

            case 106: // 'j'
                newLevel = new BonusArea62G();
                WORLD = "6-2";
                break;

            case 107: // 'k'
                newLevel = new BonusArea62D();
                WORLD = "6-2";
                break;

            case 108: // 'l'
                newLevel = new BonusArea71A();
                WORLD = "7-1";
                break;

            case 109: // 'm'
                newLevel = new BonusArea81B();
                WORLD = "8-1";
                break;

            case 110: // 'n'
                newLevel = new BonusArea82E();
                WORLD = "8-2";
                break;
        }
        return newLevel;
    }

    private void FindDublicates(BasicLevel CurrentLevel)
            throws InterruptedException {
        if (FindDublicatesON) {
            for (int a = 0; a < playfield.getGroups().length; a++) {
                Thread.sleep(100L);
                for (int i = 0; i < playfield.getGroups()[a].getSprites().length; i++) {
                    Thread.sleep(10L);
                    if (playfield.getGroups()[a].getSprites()[i] == null);
                    for (int j = 0; j < playfield.getGroups()[a].getSprites().length; j++) {
                        if (playfield.getGroups()[a].getSprites()[j] != null && playfield.getGroups()[a].getSprites()[i] != null && j != i && playfield.getGroups()[a].getSprites()[i].getX() == playfield.getGroups()[a].getSprites()[j].getX() && playfield.getGroups()[a].getSprites()[i].getY() == playfield.getGroups()[a].getSprites()[j].getY()) {
                            System.out.println(playfield.getGroups()[a].getName() + ": " + playfield.getGroups()[a].getSprites()[i].getX() / 32D + "  " + playfield.getGroups()[a].getSprites()[i].getY() / 32D);
                        }
                    }

                }

            }

            for (int i = 0; i < CurrentLevel.Get_Items_Amount(); i++) {
                Thread.sleep(10L);
                if (CurrentLevel.get_Item_Number(i) == null);
                for (int j = 0; j < CurrentLevel.Get_Items_Amount(); j++) {
                    if (CurrentLevel.get_Item_Number(j) != null && CurrentLevel.get_Item_Number(i) != null && j != i && CurrentLevel.get_Item_Number(i).getX() == CurrentLevel.get_Item_Number(j).getX() && CurrentLevel.get_Item_Number(i).getY() == CurrentLevel.get_Item_Number(j).getY()) {
                        System.out.println("Duplicate " + CurrentLevel.get_Item_Number(i).getX() + "  " + CurrentLevel.get_Item_Number(i).getY());
                    }
                }

            }

        }
    }

    public void RemoveBridge(Sprite axe) {
        for (int i = 0; i < BrickGroup.getSize(); i++) {
            if (BrickGroup.getSprites()[i] != null && BrickGroup.getSprites()[i].getID() == 18) {
                BrickGroup.getSprites()[i].setActive(false);
            }
        }

        boss.setActive(false);
        DemoMario = new Sprite(player.getImage(), player.getX(), player.getY());
        AnimationGroup.add(DemoMario);
        int X = (int) (axe.getX() / 32D) - 13;
        for (int i = 0; i < 13; i++) {
            int delay = 26 - i * 2;
            AnimationGroup.add(new BridgeBloksFalling(bsLoader.getStoredImages("BridgeBloksFalling"), (i + X) * 32, 320, delay));
        }

        AnimationGroup.add(new BossFallingAnim(bsLoader.getStoredImages("Boss"), boss.getX(), boss.getY(), this));
    }

    public void removeDemoMario() {
        DemoMario.setActive(false);
    }

    public String GetAttribute() {
        return GameAttribute;
    }

    private void LoadCheckPoints(BasicLevel CurrentLevel) {
        for (int i = 0; i < 10; i++) {
            if (CurrentLevel.get_CheckPoints_Number(i) == null) {
                continue;
            }
            CheckPoints cp = CurrentLevel.get_CheckPoints_Number(i);
            if (cp.getID() == 16) {
                cp.setImage(bsLoader.getStoredImages("WhyYouDOThis")[0]);
            } else if (cp.getID() == 26) {
                cp.setImage(bsLoader.getStoredImage("Princess.png"));
            } else if (cp.getID() == 27) { // long clowd check point
//                    checkpoint.setImage(this.bsLoader.getStoredImage("clowd_checkpoint.png")); // made visible for testing purpuse
                cp.setImage(ImageUtil.createImage(640, 64, 3));
            } else if (cp.getID() == 28) { // long clowd check point
                cp.setImage(this.bsLoader.getStoredImage("Clowd.png"));
            } else {
                cp.setImage(ImageUtil.createImage(32, 32, 3));
            }
            FlagGroup.add(cp);
        }

    }

    private void LoadTeleport(BasicLevel CurrentLevel) {
        for (int i = 0; i < 20; i++) {
            if (CurrentLevel.get_Teleport_Number(i) != null) {
                Teleport.Teleport teleport = CurrentLevel.get_Teleport_Number(i);
                SpriteTeleport spriteteleport = new SpriteTeleport(teleport, this);
                TeleportGroup.add(spriteteleport);
            }
        }

    }

    public void LevelComplete(Sprite checkpoint) {
        LevelComplete = true;
        cp = (CheckPoints) checkpoint;
    }

    public void LoadNextCheckPoint() {
        parent.nextGameID = cp;
        finish();
    }

    public void MarioGoingDownAnimation() {
        MarioGoingDownAnimation ani = new MarioGoingDownAnimation();
        ani.setImage(player.getImage());
        ani.setLocation(player.getX(), player.getY());
        UnderGroup.add(ani);
    }

    public void MarioGoingInsidePumpToRight() {
        MarioGoingInPump ani = new MarioGoingInPump();
        ani.setImages(player.getImages());
        ani.setLocation(player.getX(), player.getY());
        ani.setAnimate(true);
        ani.setLoopAnim(true);
        ani.setAnimationFrame(4, 6);
        ani.setAnimationTimer(new Timer(200));
        UnderGroup.add(ani);
    }

    public void Restart() {
        PlayEnemys();
        player.setLocation(PlayetX, PlayerY);
        player.speed = 0;
        player.GoDown();
        PlayLivingThings = true;
        DelayToNextCheckPoint = 120;
        LevelComplete = false;
        player.ResetStatus();
        StopScroll = true;
        PlayGameMusic();
    }

    public void StartFlagScrollingDown() {
        flagtop.ScrollDown();
    }

    public void LevelComplete(Sprite checkpoint, int waitFor) {
        LevelComplete = true;
        cp = (CheckPoints) checkpoint;
        DelayToNextCheckPoint = waitFor;
    }

    public void PrintString(String s, int i, int j) {
    }

    private void DrawScore(Graphics2D g) {
        font.drawString(g, "WORLD", 368, 32);
        if (parent.getCoin() < 10) {
            font.drawString(g, "$x0" + parent.getCoin(), 256, 48);
        } else {
            font.drawString(g, "$x" + parent.getCoin(), 256, 48);
        }
        if (LevelNumber == 10) {
            font.drawString(g, "" + StartWorld + "-" + StartLevel, 384, 48);
            font.drawString(g, "PUSH BUTTON Z X", 220, 287);
            font.drawString(g, "TO SELECT A WORLD", 190, 320);
            font.drawString(g, "PRESS ENTER TO", 192, 352);
            font.drawString(g, "START GAME", 240, 384);
        } else {
            font.drawString(g, "" + WORLD, 384, 48);
        }
    }

    private void LoadInvisibleObjects() {
        switch (LevelNumber) {
            case 12: // '\f'
                Sprite noscroll = new Sprite(ImageUtil.createImage(3 * 32, 1 * 32));
                noscroll.setLocation(187 * 32, 3 * 32);
                noscroll.setDataID("StopScrollAndNumber");
                this.InvisibleObjects.add(noscroll);
                break;

            case 14: // '\016'
                Sprite noscroll2 = new Sprite(ImageUtil.createImage(32, 224));
                noscroll2.setLocation(4288D, 96D);
                noscroll2.setDataID("StopScroll");
                InvisibleObjects.add(noscroll2);
                Sprite scroll = new Sprite(ImageUtil.createImage(32, 96));
                scroll.setLocation(4576D, 192D);
                scroll.setDataID("scroll");
                InvisibleObjects.add(scroll);
                break;

            case 24: // '\030'
                Sprite noscroll3 = new Sprite(ImageUtil.createImage(32, 224));
                noscroll3.setLocation(4288D, 96D);
                noscroll3.setDataID("StopScroll");
                InvisibleObjects.add(noscroll3);
                Sprite scroll2 = new Sprite(ImageUtil.createImage(32, 96));
                scroll2.setLocation(4576D, 192D);
                scroll2.setDataID("scroll");
                InvisibleObjects.add(scroll2);
                break;

            case 34: // '"'
                Sprite noscroll4 = new Sprite(ImageUtil.createImage(32, 224));
                noscroll4.setLocation(4288D, 96D);
                noscroll4.setDataID("StopScroll");
                InvisibleObjects.add(noscroll4);
                Sprite scroll3 = new Sprite(ImageUtil.createImage(32, 96));
                scroll3.setLocation(4576D, 192D);
                scroll3.setDataID("scroll");
                InvisibleObjects.add(scroll3);
                break;

            case 44: // ','
                Sprite noscroll5 = new Sprite(ImageUtil.createImage(32, 224));
                noscroll5.setLocation(9312D, 96D);
                noscroll5.setDataID("StopScroll");
                InvisibleObjects.add(noscroll5);
                Sprite scroll4 = new Sprite(ImageUtil.createImage(32, 96));
                scroll4.setLocation(9600D, 192D);
                scroll4.setDataID("scroll");
                InvisibleObjects.add(scroll4);
                break;

            case 54: // '6'
                Sprite noscroll6 = new Sprite(ImageUtil.createImage(32, 224));
                noscroll6.setLocation(4288D, 96D);
                noscroll6.setDataID("StopScroll");
                InvisibleObjects.add(noscroll6);
                Sprite scroll5 = new Sprite(ImageUtil.createImage(32, 96));
                scroll5.setLocation(4576D, 192D);
                scroll5.setDataID("scroll");
                InvisibleObjects.add(scroll5);
                break;

            case 64: // '@'
                Sprite noscroll7 = new Sprite(ImageUtil.createImage(32, 224));
                noscroll7.setLocation(4288D, 96D);
                noscroll7.setDataID("StopScroll");
                InvisibleObjects.add(noscroll7);
                Sprite scroll7 = new Sprite(ImageUtil.createImage(32, 96));
                scroll7.setLocation(4576D, 192D);
                scroll7.setDataID("scroll");
                InvisibleObjects.add(scroll7);
                break;

            case 74: // 'J'
                Sprite noscroll8 = new Sprite(ImageUtil.createImage(32, 224));
                noscroll8.setLocation(10336D, 96D);
                noscroll8.setDataID("StopScroll");
                InvisibleObjects.add(noscroll8);
                Sprite scroll8 = new Sprite(ImageUtil.createImage(32, 96));
                scroll8.setLocation(10624D, 192D);
                scroll8.setDataID("scroll");
                InvisibleObjects.add(scroll8);
                break;

            case 845:
                Sprite noscroll9 = new Sprite(ImageUtil.createImage(32, 224));
                noscroll9.setLocation(1248D, 96D);
                noscroll9.setDataID("StopScroll");
                InvisibleObjects.add(noscroll9);
                Sprite scroll9 = new Sprite(ImageUtil.createImage(32, 96));
                scroll9.setLocation(1504D, 192D);
                scroll9.setDataID("scroll");
                InvisibleObjects.add(scroll9);
                Sprite jump = new Sprite(ImageUtil.createImage(64, 32));
                jump.setLocation(1728D, 384D);
                jump.setDataID("Jump");
                InvisibleObjects.add(jump);
                Sprite StopMario = new Sprite(ImageUtil.createImage(32, 32));
                StopMario.setLocation(1904D, 256D);
                StopMario.setDataID("StopMario");
                InvisibleObjects.add(StopMario);
                KageGroup.add(new Sprite(getImage("Extended/Kage.png"), 1792D, 96D));
                princessAnim = new PrincessAnim(1968, 224, getImages("Extended/Princess.png", 5, 1), this);
                AnimationGroup.add(princessAnim);
                break;

            case 94:
                Sprite noscroll10 = new Sprite(ImageUtil.createImage(3 * 32, 1 * 32, 3));
                noscroll10.setLocation(60 * 32, 5 * 32);
                noscroll10.setDataID("StopScrollAndNumber2");
                this.InvisibleObjects.add(noscroll10);
                break;
        }
    }

    public void Scroll(boolean command) {
        StopScroll = command;
    }

    public void SmoothScroll() {
        SmoothScroll = true;
        bsMusic.stopAll();
        playSound("music/smb_world_clear.mp3");
    }

    private void IncreaseWorld() {
        StartWorld++;
        if (StartWorld > 8) {
            StartWorld = 1;
        }
    }

    private void IncreaseLevel() {
        StartLevel++;
        if (StartLevel > 4) {
            StartLevel = 1;
        }
    }

    private void ShowInfo() {
        ShowInfo = true;
    }

    private void DrawShinyFrame(Graphics2D g) {
        if (ShowShinyFrame) {
            if (ShinyFrameYpos < 500D) {
                ShinyFrameUP = true;
                ShinyFrameYpos = 500D;
            }
            if (ShinyFrameYpos > 550D) {
                ShinyFrameUP = false;
                ShinyFrameYpos = 550D;
            }
            if (ShinyFrameUP) {
                ShinyFrameYpos = ShinyFrameYpos + 0.5D;
            } else {
                ShinyFrameYpos = ShinyFrameYpos - 0.5D;
            }
            g.drawImage(ShinyFrame, 0, 96, 640, (int) ShinyFrameYpos - 96, null);
        }
    }

    public void PrincessComeNearMario() {
        princessAnim.Play();
    }

    private void PlayGameMusic() {
        if (this.CurrentLevel.attribute.equals("Clowd")) {
            this.playMusic("music/Ground.mp3");
        } else {
            this.playMusic("music/" + this.CurrentLevel.attribute + ".mp3");

        }
    }

    // for level 12 and in 42 in cloud level 94( Clowd_level_for_4_2.java )  we need the plants inside the pump to remove from game when
    // mario is about to enter those pump , especially the plants
    public void KillAllEnemies() {

        for (int i = 0; i < PlantGroup.getSize(); i++) {

            // check if its not null
            if (PlantGroup.getSprites()[i] != null) {

                // check if its active
                if (PlantGroup.getSprites()[i].isActive()) {

                    // then deactivate it
                    PlantGroup.getSprites()[i].setActive(false);
                }
            }

        }

    }
}
