


// Source File Name:   Hammer_Player.java

package Collusion;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import com.golden.gamedev.object.sprite.VolatileSprite;

public class Hammer_Player extends BasicCollisionGroup
{

    public Hammer_Player(Mario aThis)
    {
        game = aThis;
    }

    
    public void collided(Sprite hammer, Sprite player)
    {
        Player p = (Player)player;
        boolean collide = true;
        if(p.KeyPressedDown & (player.getID() != 1) && hammer.getY() + (double)hammer.getHeight() < p.getY() + 48D)
            collide = false;
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), hammer.getX(), hammer.getY()));
            hammer.setActive(false);
        } else
        if(collide)
            game.player.Decerease();
    }

    Mario game;
}
