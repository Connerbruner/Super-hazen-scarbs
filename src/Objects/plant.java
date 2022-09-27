


// Source File Name:   plant.java

package Objects;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class plant extends AnimatedSprite
    implements BasicEnemy
{

    public plant(BufferedImage storedImage[], int x, int y, Mario g)
    {
        Upheight = 48;
        DownHeight = 48;
        MoveUp = true;
        MarioIsNear = false;
        CanStopMovingUp = false;
        setLocation(x, y);
        setID(110);
        game = g;
        setImages(storedImage);
        Upheight = y - 96;
        DownHeight = y;
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
    }

    
    public void update(long l)
    {
        if(getY() < (double)Upheight)
            MoveUp = false;
        if(getY() > (double)DownHeight)
            MoveUp = true;
        if(MoveUp)
        {
            if((game.player.getX() > getX() - 100D) & (game.player.getX() < getX() + 100D))
                MarioIsNear = true;
            else
                MarioIsNear = false;
            if(getY() > (double)(DownHeight - 32))
                CanStopMovingUp = true;
            else
                CanStopMovingUp = false;
            if(!MarioIsNear || !CanStopMovingUp)
                moveY(-1D);
        } else
        {
            moveY(1.0D);
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

    
    public void setActive(boolean b)
    {
        super.setActive(false);
    }

    
    public void MarioJumpedOnEnemy()
    {
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            super.setActive(false);
        } else
        if(game.player.getY() + (double)game.player.getHeight() > getY() + 16D)
            game.player.Decerease();
    }

    
    public void KilledByFireBall()
    {
        super.setActive(false);
    }

    
    public void bounce()
    {
    }

    
    public void setYloc(double d1)
    {
    }

    
    public void CollidedWithShell()
    {
        setActive(false);
    }

    
    public void CollidedWithMovingShell()
    {
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void OtherEnemyTouchedFromRight()
    {
    }

    
    public void OtherEnemyTouchedFromLeft()
    {
    }

    
    public void CollidedWithMarioFromTOLeft()
    {
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            setActive(false);
        } else
        if(game.player.getY() + (double)game.player.getHeight() > getY() + 16D)
            game.player.Decerease();
    }

    
    public void CollidedWithMarioTORight()
    {
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            setActive(false);
        } else
        if(game.player.getY() + (double)game.player.getHeight() > getY() + 16D)
            game.player.Decerease();
    }

    
    public void EnemyJumperOnMario()
    {
        if(game.player.HasStar())
            setActive(false);
        else
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
    int Upheight;
    int DownHeight;
    boolean MoveUp;
    boolean MarioIsNear;
    boolean CanStopMovingUp;
}
