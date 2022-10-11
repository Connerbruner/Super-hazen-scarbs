


// Source File Name:   EnemyTurtlePatrol.java

package Objects;

import Animations.*;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;

// Referenced classes of package Objects:
//            TurtelShell, BasicEnemy, Player

public class EnemyTurtlePatrol extends AnimatedSprite
    implements BasicEnemy
{

    public EnemyTurtlePatrol(int x, int y, Mario g, int Length)
    {
        PositiveX = true;
        Gravity = 6;
        Standing = true;
        Left = 0;
        right = 0;
        Green = false;
        game = g;
        setImages(game.bsLoader.getStoredImages("EnemyTurtlePatrol"));
        setLocation(x, y);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(0, 1);
        Left = x;
        right = x + 32 * Length;
        setID(102);
    }

    
    public void update(long l)
    {
        if(getX() < (double)Left)
            CollidedWithBrick_GoToRight();
        if(getX() > (double)right)
            CollidedWithBrick_GoToLeft();
        moveY(Gravity);
        if(PositiveX)
            moveX(-2D);
        else
            moveX(2D);
        super.update(l);
    }

    
    public void CollidedWithBrick_GoToLeft()
    {
        PositiveX = true;
        setAnimationFrame(0, 1);
    }

    
    public void CollidedWithBrick_GoToRight()
    {
        PositiveX = false;
        setAnimationFrame(2, 3);
    }

    
    public void MarioJumpedOnEnemy()
    {
        game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));
        game.player.Jump(-8);
        game.player.Jump(-8);
        game.EnemyGroup.add(new TurtelShell(getX(), getY() + 16D, game, MariotoRight(), Standing, Green));
        if(game.player.HasStar())
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void KilledByFireBall()
    {
        if(Green)
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
        else
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
        setActive(false);
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
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        if(Green)
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
        else
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
        setActive(false);
    }

    
    public void OtherEnemyTouchedFromRight()
    {
        PositiveX = true;
        setAnimationFrame(0, 1);
    }

    
    public void OtherEnemyTouchedFromLeft()
    {
        PositiveX = false;
        setAnimationFrame(2, 3);
    }

    
    public void CollidedWithMarioFromTOLeft()
    {
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            if(Green)
                game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
            else
                game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
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
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            if(Green)
                game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
            else
                game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
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
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            if(Green)
                game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
            else
                game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
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
        game.EnemyGroup.add(new TurtelShell(getX(), getY() + 16D, game, MariotoRight(), false, "Jump", Green));
        Standing = false;
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

    boolean PositiveX;
    Mario game;
    public int Gravity;
    boolean Standing;
    int Left;
    int right;
    public boolean Green;
}
