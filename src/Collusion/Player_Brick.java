package Collusion;

import Bricks.BasicBrick;
import Bricks.Spring;
import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import java.awt.Point;

public class Player_Brick extends BasicCollisionGroup
{

    public Player_Brick(Mario aThis)
    {
        game = aThis;
    }

    
    public void collided(Sprite player, Sprite brick)
    {
        Player p = (Player)player;
        BasicBrick b = (BasicBrick)brick;
        boolean collide = true;
        if(p.KeyPressedDown & (p.getID() != 1) && brick.getY() + (double)brick.getHeight() < p.getY() + 32D)
            collide = false;
        String side = "?";
        Point player_Center = new Point((int)player.getX() + player.getWidth(), (int)player.getY() + player.getHeight());
        Point brick_Center = new Point((int)brick.getX() + brick.getWidth(), (int)brick.getY() + brick.getHeight());
        int angle = (int)Math.toDegrees(Math.atan2(player_Center.getY() - brick_Center.getY(), player_Center.getX() - brick_Center.getX()));
        game.setDegree(angle);
        if(p.getID() == 1)
        {
            if(angle > 60 && angle < 120)
            {
                side = "down";
                if(collide && !p.isFalling())
                {
                    b.HitFromDown();
                    p.GoDown();
                    switch(b.getID())
                    {
                    case 2: // '\002'
                        game.playSound("music/smb_bump.mp3");
                        break;
                    }
                }
            }
        } else
        if(angle > 70 && angle < 110)
        {
            side = "down";
            if(collide && !p.isFalling())
            {
                b.HitFromDown();
                p.GoDown();
                switch(b.getID())
                {
                case 2: // '\002'
                    game.playSound("music/smb_bump.mp3");
                    break;
                }
            }
        }
        if(angle <= -50 && angle >= -130)
        {
            side = "up";
            if(b.getID() == 15)
            {
                p.NoControlling();
                p.MoveForward();
                if(game.boss.isActive())
                {
                    game.pauseEnemys();
                    game.RemoveBridge(brick);
                }
                b.setActive(false);
                for(int i = 0; i < game.EnemyGroup.getSize(); i++)
                    if(game.EnemyGroup.getSprites()[i] != null)
                        game.EnemyGroup.getSprites()[i].setActive(false);

            }
            if(b.getID() != 17)
            {
                if(b.getID() == 13)
                    p.Jump(-22);
                if(b.getID() == 14)
                {
                    Spring S = (Spring)brick;
                    S.PlayAnimation();
                } else
                {
                    p.setY(brick.getY() - (double)p.getHeight());
                    if(p.ComingDown())
                        p.OnGround();
                }
            }
        }
        if((angle > 135 || angle < -135) && b.getID() != 17)
        {
            side = "left";
            if(p.speed >= 0)
            {
                p.setX(brick.getX() - (double)p.getWidth());
                p.StopSpeed();
            }
        }
        if(angle < 45 && angle > -45 && b.getID() != 17)
        {
            side = "right";
            if(p.speed <= 0)
            {
                p.setX(brick.getX() + (double)brick.getWidth());
                p.StopSpeed();
            }
        }
        game.setDegree(side);
    }

    Mario game;
}
