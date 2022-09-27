


// Source File Name:   Monkey.java

package Objects;

import Animations.DirectFalling;
import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.Utility;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            Hammer, BasicEnemy, Player

public class Monkey extends AnimatedSprite
    implements BasicEnemy
{

    public Monkey(BufferedImage storedImages[], int x, int y, Mario g)
    {
        left = 64;
        right = 64;
        PositiveX = true;
        JumpTime = 20;
        ComeDownTime = 40;
        ComeDown = false;
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        setID(108);
        game = g;
        left = x - 32;
        right = x + 32;
        JumpTime = Utility.getRandom(3, 6) * 20;
        ComeDownTime = Utility.getRandom(3, 6) * 40;
        HammerThrowTime = Utility.getRandom(1, 10) * 10;
    }

    
    public void update(long l)
    {
        HammerThrow();
        ComeDown();
        JumpTime--;
        if(JumpTime < 0)
            Jump();
        if(Gravity < 8)
            Gravity = Gravity + 1;
        moveY(Gravity);
        if(getX() < (double)left)
            PositiveX = false;
        if(getX() > (double)right)
            PositiveX = true;
        if(PositiveX)
            moveX(-1D);
        else
            moveX(1.0D);
        LookAtMario();
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
        game.player.Jump(-8);
        game.AnimationGroup.add(new DirectFalling(getImage(), getX(), getY(), MariotoRight()));
        setActive(false);
        if(game.player.HasStar())
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
    }

    
    public void KilledByFireBall()
    {
        game.AnimationGroup.add(new DirectFalling(getImage(), getX(), getY(), MariotoRight()));
        setActive(false);
    }

    
    public void bounce()
    {
    }

    
    public void setYloc(double d)
    {
        if(!ComeDown || getY() >= 320D)
            setY(d);
    }

    private void LookAtMario()
    {
        if(game.player.getX() < getX())
            setAnimationFrame(0, 1);
        else
            setAnimationFrame(4, 5);
    }

    private void Jump()
    {
        Gravity = -16;
        JumpTime = Utility.getRandom(3, 6) * 20;
    }

    private void ComeDown()
    {
        ComeDownTime--;
        if(ComeDownTime < 0)
        {
            ComeDown = true;
            ComeDownFor = 10;
            ComeDownTime = Utility.getRandom(3, 6) * 20;
        }
        if(ComeDown)
            ComeDownFor--;
        if(ComeDownFor < 0)
            ComeDown = false;
    }

    private void HammerThrow()
    {
        HammerThrowTime--;
        if(HammerThrowTime < 0)
        {
            HammerThrowTime = Utility.getRandom(1, 10) * 10;
            if(game.player.getX() < getX())
                game.HammerGroup.add(new Hammer(getX(), getY(), true, game.bsLoader.getStoredImages("Hammer")));
            else
                game.HammerGroup.add(new Hammer(getX(), getY(), false, game.bsLoader.getStoredImages("Hammer")));
        }
    }

    
    public void CollidedWithShell()
    {
    }

    
    public void CollidedWithMovingShell()
    {
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
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
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
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
    int left;
    int right;
    boolean PositiveX;
    int JumpTime;
    int ComeDownTime;
    private int Gravity;
    boolean ComeDown;
    private int ComeDownFor;
    int HammerThrowTime;
}
