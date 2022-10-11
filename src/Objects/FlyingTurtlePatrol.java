


// Source File Name:   FlyingTurtlePatrol.java

package Objects;

import Animations.*;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.ImageUtil;

// Referenced classes of package Objects:
//            EnemyTurtle, BasicEnemy, Player

public class FlyingTurtlePatrol extends AnimatedSprite
    implements BasicEnemy
{

    public FlyingTurtlePatrol(int x, int y, Mario g, int Length)
    {
        PositiveX = true;
        Up = 0;
        Down = 0;
        FiyUp = false;
        DistanceFromCenter = 128;
        Green = false;
        game = g;
        setImages(game.bsLoader.getStoredImages("FlyingTurtlePatrol"));
        setLocation(x, y);
        Up = y;
        Down = y + 32 * Length;
        setID(101);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(0, 1);
        CenterY = y + 32 * Length;
    }

    
    public void update(long l)
    {
        setY(Math.cos(game.Distance) * (double)DistanceFromCenter + (double)CenterY);
        moveY(game.Distance);
        super.update(l);
    }

    
    public void bounce()
    {
    }

    
    public void MarioJumpedOnEnemy()
    {
        game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));        game.player.Jump(-8);
        game.EnemyGroup.add(new EnemyTurtle((int)getX(), (int)getY(), game, Green));
        if(game.player.HasStar())
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void CollidedWithMovingShell()
    {
        java.awt.image.BufferedImage HorizontalFilpShell = game.bsLoader.getStoredImage("TurtelShellRed");
        HorizontalFilpShell = ImageUtil.flipHorizontal(HorizontalFilpShell);
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), HorizontalFilpShell, MariotoRight()));
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
        setAnimationFrame(2, 3);
    }

    
    public int getType()
    {
        return getID();
    }

    
    public void KilledByFireBall()
    {
        java.awt.image.BufferedImage HorizontalFilpShell = game.bsLoader.getStoredImage("TurtelShellRed");
        HorizontalFilpShell = ImageUtil.flipHorizontal(HorizontalFilpShell);
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), HorizontalFilpShell, MariotoRight()));
        setActive(false);
    }

    
    public void setYloc(double d)
    {
        setY(d);
        bounce();
    }

    
    public void CollidedWithShell()
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
        if(game.player.HasStar())
            CollidedWithMovingShell();
        else
            game.player.Decerease();
    }

    
    public void CollidedWithMarioTORight()
    {
        if(game.player.HasStar())
            CollidedWithMovingShell();
        else
            game.player.Decerease();
    }

    public void Kill()
    {
    }

    
    public void EnemyJumperOnMario()
    {
        if(game.player.HasStar())
            CollidedWithMovingShell();
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

    private void GoDown()
    {
        FiyUp = false;
    }

    private void GoUp()
    {
        FiyUp = true;
    }

    boolean PositiveX;
    Mario game;
    int Up;
    int Down;
    private boolean FiyUp;
    int DistanceFromCenter;
    int CenterX;
    int CenterY;
    public boolean Green;
}
