


// Source File Name:   FireBallToBricks.java

package Collusion;

import Animations.Explosion;
import Objects.FireBall;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import java.awt.Point;

public class FireBallToBricks extends BasicCollisionGroup
{

    public FireBallToBricks(Mario g)
    {
        game = g;
    }

    
    public void collided(Sprite FireBall, Sprite Bricks)
    {
        FireBall F = (FireBall)FireBall;
        Point FireBall_Center = new Point((int)FireBall.getX() + FireBall.getWidth(), (int)FireBall.getY() + FireBall.getHeight());
        Point Bricks_Center = new Point((int)Bricks.getX() + Bricks.getWidth(), (int)Bricks.getY() + Bricks.getHeight());
        int angle = (int)Math.toDegrees(Math.atan2(FireBall_Center.getY() - Bricks_Center.getY(), FireBall_Center.getX() - Bricks_Center.getX()));
        String side;
        if(angle > 50 && angle < 130)
            side = "down";
        else
        if(angle <= -30 && angle >= -150)
        {
            side = "up";
            F.bounce();
        } else
        if(angle > 150 || angle < -150)
        {
            side = "left";
            FireBall.setActive(false);
            game.playSound("music/smb_bump.mp3");
            game.AnimationGroup.add(new Explosion(FireBall.getX(), FireBall.getY(), game.bsLoader.getStoredImages("Explosion")));
        } else
        if(angle < 30 && angle > -30)
        {
            side = "right";
            FireBall.setActive(false);
            game.playSound("music/smb_bump.mp3");
            game.AnimationGroup.add(new Explosion(FireBall.getX(), FireBall.getY(), game.bsLoader.getStoredImages("Explosion")));
        }
    }

    Mario game;
}
