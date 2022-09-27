


// Source File Name:   EnemyFireBall.java

package Objects;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class EnemyFireBall extends AnimatedSprite
    implements BasicEnemy
{

    public EnemyFireBall(int x, int y, BufferedImage Enemy_Image[], Mario g)
    {
        AntiClockWise = true;
        setLocation(x, y);
        CenterX = x;
        CenterY = y;
        setImages(Enemy_Image);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(0, 3);
        game = g;
        setID(114);
    }

    public EnemyFireBall(int CenterX, int CenterY, int dis, Mario game, boolean Anticlockwise)
    {
        this(CenterX, CenterY, game.bsLoader.getStoredImages("FireBall"), game);
        DistanceFromCenter = dis;
        AntiClockWise = Anticlockwise;
    }

    
    public void update(long l)
    {
        if(AntiClockWise)
        {
            setX(Math.sin(game.Distance) * (double)DistanceFromCenter + (double)CenterX);
            setY(Math.cos(game.Distance) * (double)DistanceFromCenter + (double)CenterY);
        } else
        {
            setX(Math.sin(game.InvertDistance) * (double)DistanceFromCenter + (double)CenterX);
            setY(Math.cos(game.InvertDistance) * (double)DistanceFromCenter + (double)CenterY);
        }
        super.update(l);
    }

    
    public void CollidedWithBrick_GoToLeft()
    {
    }

    
    public void CollidedWithBrick_GoToRight()
    {
    }

    
    public int getType()
    {
        return getID();
    }

    
    public void MarioJumpedOnEnemy()
    {
        if(!game.player.HasStar())
            game.player.Decerease();
    }

    
    public void KilledByFireBall()
    {
    }

    
    public void bounce()
    {
    }

    
    public void setYloc(double d1)
    {
    }

    
    public void CollidedWithShell()
    {
    }

    
    public void CollidedWithMovingShell()
    {
    }

    
    public void OtherEnemyTouchedFromRight()
    {
    }

    
    public void OtherEnemyTouchedFromLeft()
    {
    }

    
    public void CollidedWithMarioFromTOLeft()
    {
        if(!game.player.HasStar())
            game.player.Decerease();
    }

    
    public void CollidedWithMarioTORight()
    {
        if(!game.player.HasStar())
            game.player.Decerease();
    }

    
    public void EnemyJumperOnMario()
    {
        if(!game.player.HasStar())
            game.player.Decerease();
    }

    
    public int Life()
    {
        return 0;
    }

    
    public void CollidedWithJumping_Brick()
    {
    }

    
    public boolean MariotoRight()
    {
        boolean positive;
        if(game.player.getX() < getX())
            positive = false;
        else
            positive = true;
        return positive;
    }

    Mario game;
    int DistanceFromCenter;
    int CenterX;
    int CenterY;
    boolean AntiClockWise;
}
