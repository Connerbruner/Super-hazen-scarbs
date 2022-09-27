


// Source File Name:   Player_Flag.java

package Collusion;

import Animations.MarioSlidingDown;
import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseAudio;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

public class Player_Flag extends BasicCollisionGroup
{

    public Player_Flag(Mario f)
    {
        FirstTime = true;
        game = f;
    }

    
    public void collided(Sprite Flag, Sprite player)
    {
        Player p = (Player)player;
        if(FirstTime & (Flag.getID() == -2))
        {
            for(int i = 0; i < game.EnemyGroup.getSize(); i++)
                if(game.EnemyGroup.getSprites()[i] != null)
                    game.EnemyGroup.getSprites()[i].setActive(false);

            game.pauseEnemys();
            game.AnimationGroup.add(new MarioSlidingDown(Flag.getX() - 24D, p.getY(), game));
            game.StartFlagScrollingDown();
            game.bsMusic.stopAll();
            game.playSound("music/smb_stage_clear.mp3");
            FirstTime = false;
        }
    }

    Mario game;
    boolean FirstTime;
}
