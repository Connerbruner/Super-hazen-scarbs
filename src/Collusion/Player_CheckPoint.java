


// Source File Name:   Player_CheckPoint.java

package Collusion;

import Animations.*;
import Objects.Boss;
import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseAudio;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import java.awt.Point;
import java.util.Random;

public class Player_CheckPoint extends BasicCollisionGroup
{

    public Player_CheckPoint(Mario f)
    {
        game = f;
    }

    
    public void collided(Sprite player, Sprite checkpoint)
    {
        Player p = (Player)player;
        String side = "?";
        Point player_Center = new Point((int)player.getX() + player.getWidth(), (int)player.getY() + player.getHeight());
        Point checkpoint_Center = new Point((int)checkpoint.getX() + checkpoint.getWidth(), (int)checkpoint.getY() + checkpoint.getHeight());
        int angle = (int)Math.toDegrees(Math.atan2(player_Center.getY() - checkpoint_Center.getY(), player_Center.getX() - checkpoint_Center.getX()));
        game.setDegree(angle);
        switch(checkpoint.getID())
        {
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
        case 22: // '\026'
        default:
            break;

        case 23: // '\027'
            FlagUp flagUp = new FlagUp(game.bsLoader.getStoredImages("FlagUp"), (int)checkpoint.getX() - 32, 288);
            game.BackGroundSpriteGroup.add(flagUp);
            Random r = new Random();
            if(r.nextBoolean())
                game.AnimationGroup.add(new FireWorks((int)checkpoint.getX(), (int)checkpoint.getY(), game));
            game.LevelComplete(checkpoint);
            game.AnimationGroup.add(new Victory(game, (int)checkpoint.getX(), (int)checkpoint.getY()));
            p.setActive(false);
            break;

        case 16: // '\020'
            game.boss.BadGameGlitch();
            game.VolitileGroup.add(new AnotherCastleMessage(game.bsLoader.getStoredImages("AnotherCastleMessage"), checkpoint.getX() - 224D, checkpoint.getY() - 192D, game));
            p.setX(checkpoint.getX() - (double)p.getWidth());
            p.StopSpeed();
            p.NoControlling();
            p.ShowThumbs();
            p.StopMoveForward();
            game.AnimationGroup.add(new JumpingGuy((int)checkpoint.getX(), (int)checkpoint.getY(), game));
            game.LevelComplete(checkpoint, 200);
            checkpoint.setActive(false);
            game.playMusic("");
            break;

        case 24: // '\030'
            if(p.speed > 2)
            {
                game.MarioGoingInsidePumpToRight();
                game.LevelComplete(checkpoint);
                game.player.setActive(false);
                game.bsMusic.stopAll();
                game.playSound("music/smb_pipe.mp3");
                p.setActive(false);
            }
            break;

        case 25: // '\031'
            if(p.getX() < checkpoint.getX() + 10D && p.getX() > checkpoint.getX() - 10D && p.KeyPressedDown())
            {
                game.MarioGoingDownAnimation();
                game.LevelComplete(checkpoint);
                game.bsMusic.stopAll();
                game.playSound("music/smb_pipe.mp3");
                p.setActive(false);
            }
            break;

        case 26: // '\032'
            game.boss.BadGameGlitch();
            game.VolitileGroup.add(new Sprite(game.bsLoader.getStoredImage("QuestComplete"), checkpoint.getX() - 224D, checkpoint.getY() - 192D));
            p.setX(checkpoint.getX() - (double)p.getWidth());
            p.StopSpeed();
            p.NoControlling();
            p.StopMoveForward();
            break;
            
            case 27:

                game.LevelComplete(checkpoint);
                p.setActive(false);

                game.DelayToNextCheckPoint = 200;
                game.bsMusic.stopAll();
//                game.playSound("music/smb_stage_clear.wav");
                break;

            case 28:

                if (p.KeyPressedUP) {
                    game.LevelComplete(checkpoint);
                    p.setActive(false);
                    game.DelayToNextCheckPoint = 200;
                    game.bsMusic.stopAll();
                }
//                game.playSound("music/smb_stage_clear.wav");
                break;
        }
        game.setDegree(side);
    }

    Mario game;
}
