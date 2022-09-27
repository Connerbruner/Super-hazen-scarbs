// Source File Name:   MovingTurtelShell.java
package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;

// Referenced classes of package Objects:
//            TurtelShell, BasicEnemy, Player
public class MovingTurtelShell extends AnimatedSprite
        implements BasicEnemy {

    MovingTurtelShell(double x, double y, Mario g, boolean b, boolean legsDown,
            boolean isGreen) {
        super(x, y);
        PositiveX = true;
        Gravity = 6;
        Standing = true;
        Green = true;
        setID(104);
        Standing = legsDown;
        PositiveX = b;
        game = g;
        Green = isGreen;
        if (Standing) {
            if (Green) {
                setImages(game.bsLoader.getStoredImages("TurtelShellGreenMoving"));
            } else {
                setImages(game.bsLoader.getStoredImages("TurtelShellRedMoving"));
            }
        } else if (Green) {
            setImages(game.bsLoader.getStoredImages("TurtelShellGreenMovingFlip"));
        } else {
            setImages(game.bsLoader.getStoredImages("TurtelShellRedMovingFlip"));
        }
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(150));
    }

    
    public void update(long l) {
        moveY(Gravity);
        if (PositiveX) {
            moveX(-8D);
        } else {
            moveX(8D);
        }
        super.update(l);
    }

    
    public void CollidedWithBrick_GoToLeft() {
        PositiveX = true;
//        if (this.getScreenX() > -500 & this.getScreenX() < 1200) {

        if (isOnScreen()) {
            game.playSound("music/smb_bump.mp3");
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
//        }
        }
    }

    
    public void CollidedWithBrick_GoToRight() {
        PositiveX = false;
//        if (this.getScreenX() > -500 & this.getScreenX() < 1200) {
        if (isOnScreen()) {
            game.playSound("music/smb_bump.mp3");
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
//        }
        }
    }

    
    public int getType() {
        return getID();
    }

    
    public void MarioJumpedOnEnemy() {
        game.player.Jump(-8);
        if (Standing) {
            game.EnemyGroup.add(new TurtelShell(getX(), getY(), game, MariotoRight(), Standing, Green));
        } else {
            game.EnemyGroup.add(new TurtelShell(getX(), getY(), game, MariotoRight(), Standing, Green));
        }
        if (game.player.HasStar()) {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        }
        setActive(false);
    }

    
    public void KilledByFireBall() {
        if (Green) {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
        } else {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
        }
        setActive(false);
    }

    
    public void bounce() {
        Gravity = 6;
    }

    
    public void setYloc(double d) {
        setY(d);
    }

    
    public void CollidedWithShell() {
    }

    
    public void CollidedWithMovingShell() {
        if (Green) {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
        } else {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
        }
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void OtherEnemyTouchedFromRight() {
    }

    
    public void OtherEnemyTouchedFromLeft() {
    }

    
    public void CollidedWithMarioFromTOLeft() {
        if (game.player.HasStar()) {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            if (Green) {
                game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
            } else {
                game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
            }
            setActive(false);
        } else {
            game.player.Decerease();
        }
    }

    
    public void CollidedWithMarioTORight() {
        if (game.player.HasStar()) {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            if (Green) {
                game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
            } else {
                game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
            }
            setActive(false);
        } else {
            game.player.Decerease();
        }
    }

    
    public void EnemyJumperOnMario() {
        if (game.player.HasStar()) {
            KilledByFireBall();
        } else {
            game.player.Decerease();
        }
    }

    
    public int Life() {
        return 0;
    }

    
    public void CollidedWithJumping_Brick() {
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        if (PositiveX) {
            PositiveX = false;
        } else {
            PositiveX = true;
        }
        bounce();
    }

    
    public boolean MariotoRight() {
        boolean positive;
        if (game.player.getX() < getX()) {
            positive = false;
        } else {
            positive = true;
        }
        return positive;
    }

    boolean PositiveX;
    Mario game;
    public int Gravity;
    boolean Standing;
    public boolean Green;
}
