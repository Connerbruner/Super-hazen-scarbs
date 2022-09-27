


// Source File Name:   Player_Teleport.java

package Collusion;

import Objects.Player;
import SandBox.Mario;
import Teleport.SpriteTeleport;
import Teleport.Teleport;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

public class Player_Teleport extends BasicCollisionGroup
{

    public Player_Teleport(Mario aThis)
    {
        M = aThis;
    }

    
    public void collided(Sprite player, Sprite Teleport)
    {
        Player p = (Player)player;
        SpriteTeleport t = (SpriteTeleport)Teleport;
        p.setX(t.teleport.getOUTx());
    }

    Mario M;
}
