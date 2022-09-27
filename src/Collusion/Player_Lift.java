


// Source File Name:   Player_Lift.java

package Collusion;

import Lifts.BasicLift;
import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import java.awt.Point;

public class Player_Lift extends BasicCollisionGroup
{

    public Player_Lift(Mario aThis)
    {
        M = aThis;
    }

    
    public void collided(Sprite player, Sprite basiclift)
    {
        Player p = (Player)player;
        BasicLift b = (BasicLift)basiclift;
        String side = "?";
        Point player_Center = new Point((int)player.getX() + player.getWidth(), (int)player.getY() + player.getHeight());
        Point basiclift_Center = new Point((int)basiclift.getX() + basiclift.getWidth(), (int)basiclift.getY() + basiclift.getHeight());
        int angle = (int)Math.toDegrees(Math.atan2(player_Center.getY() - basiclift_Center.getY(), player_Center.getX() - basiclift_Center.getX()));
        M.setDegree(angle);
        if(p.isFalling())
        {
            p.setY(basiclift.getY() - (double)p.getHeight());
            b.MarioIsOnLift();
            p.OnGround();
            M.player.OnLift = true;
        }
        M.setDegree(side);
    }

    Mario M;
}
