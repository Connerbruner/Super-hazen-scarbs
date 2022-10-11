


// Source File Name:   EnemyMashroom.java

package Objects;

import Animations.*;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSingleImage;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class EnemyMashroom extends AnimatedSprite
    implements BasicEnemy
{

    public EnemyMashroom(int x, int y, BufferedImage Enemy_Image[], Mario g)
    {
        PositiveX = true;
        Gravity = 10;
        setLocation(x, y);
        setImages(Enemy_Image);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(0, 1);
        game = g;
        setID(100);
    }

    
    public void update(long l)
    {
        moveY(Gravity);
        if(PositiveX)
            moveX(-2D);
        else
            moveX(2D);
        super.update(l);
    }

    
    public void MarioJumpedOnEnemy()
    {
        game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));
        game.player.Jump(-8);
        VolatileSingleImage DeadMushroom = new VolatileSingleImage(ImageUtil.resize(getImage(), 32, 16), getX(), getY() + 16D, 100);
        game.VolitileGroup.add(DeadMushroom);
        if(game.player.HasStar())
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void KilledByFireBall()
    {
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
        setActive(false);
        game.playSound("music/smb_kick.mp3");
    }

    
    public void bounce()
    {
    }

    
    public void setYloc(double d)
    {
        setY(d);
    }

    
    public void CollidedWithShell()
    {
    }

    
    public int getType()
    {
        return getID();
    }

    
    public void CollidedWithMovingShell()
    {
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void CollidedWithBrick_GoToLeft()
    {
        PositiveX = true;
        setAnimationFrame(0, 1);
    }

    
    public void CollidedWithBrick_GoToRight()
    {
        PositiveX = false;
        setAnimationFrame(0, 1);
    }

    
    public void OtherEnemyTouchedFromRight()
    {
        PositiveX = true;
        setAnimationFrame(0, 1);
    }

    
    public void OtherEnemyTouchedFromLeft()
    {
        PositiveX = false;
        setAnimationFrame(0, 1);
    }

    
    public void CollidedWithMarioFromTOLeft()
    {
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            setActive(false);
        } else
        {
            game.player.Decerease();
        }
    }

    
    public void CollidedWithMarioTORight()
    {
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            setActive(false);
        } else
        {
            game.player.Decerease();
        }
    }

    
    public void EnemyJumperOnMario()
    {
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            setActive(false);
        } else
        {
            game.player.Decerease();
        }
    }

    
    public int Life()
    {
        return 0;
    }

    
    public void CollidedWithJumping_Brick()
    {
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        KilledByFireBall();
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

    boolean PositiveX;
    Mario game;
    public int Gravity;
}
