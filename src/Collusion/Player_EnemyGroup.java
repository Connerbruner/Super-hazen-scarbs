


// Source File Name:   Player_EnemyGroup.java

package Collusion;

import Objects.BasicEnemy;
import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.GameEngine;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import java.awt.Point;

public class Player_EnemyGroup extends BasicCollisionGroup
{

    public Player_EnemyGroup(Mario aThis)
    {
        M = aThis;
    }

    
    public void collided(Sprite player, Sprite enemy)
    {
        Player p = (Player)player;
        BasicEnemy e = (BasicEnemy)enemy;
        boolean collide = true;
        if(p.KeyPressedDown & (p.getID() != 1) && enemy.getY() + (double)enemy.getHeight() < p.getY() + 48D)
            collide = false;
        Point player_Center = new Point((int)player.getX() + player.getWidth(), (int)player.getY() + player.getHeight());
        Point enemy_Center = new Point((int)enemy.getX() + enemy.getWidth(), (int)enemy.getY() + enemy.getHeight());
        int angle = (int)Math.toDegrees(Math.atan2(player_Center.getY() - enemy_Center.getY(), player_Center.getX() - enemy_Center.getX()));
        M.setDegree(angle);
        if(e.getType() == 21)
        {
            e.setActive(false);
            M.parent.CoinInc();
            M.playSound("music/smb_coin.mp3");
        }
        if(e.getType() == 3 || e.getType() == 4)
        {
            e.setActive(false);
            p.Grow();
        } else
        {
            String side;
            if(angle > 30 && angle < 150)
            {
                side = "down";
                if(collide)
                    e.EnemyJumperOnMario();
            } else
            if(angle < -30 && angle > -150)
            {
                side = "up";
                e.MarioJumpedOnEnemy();
            } else
            if(angle > 150 || angle < -150)
            {
                side = "left";
                e.CollidedWithMarioFromTOLeft();
            } else
            if(angle < 30 && angle > -30)
            {
                side = "right";
                e.CollidedWithMarioTORight();
            } else
            {
                side = "null";
            }
            M.setDegree(side);
        }
    }

    Mario M;
}
