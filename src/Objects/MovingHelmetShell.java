// Source File Name:   MovingHelmetShell.java
package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.sprite.VolatileSprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            HelmetShell, BasicEnemy, Player
public class MovingHelmetShell extends Sprite
        implements BasicEnemy {

    MovingHelmetShell(double x, double y, BufferedImage storedImage, Mario g, boolean b) {
        super(storedImage, x, y);
        PositiveX = true;
        Gravity = 6;
        setID(107);
        PositiveX = b;
        game = g;
    }

    
    public void update(long l) {
        moveY(Gravity);
        if (PositiveX) {
            moveX(-9D);
        } else {
            moveX(9D);
        }
        super.update(l);
    }

    
    public void CollidedWithBrick_GoToLeft() {

        PositiveX = true;
//        if (this.getScreenX() > -500 & this.getScreenX() < 1200) {
        if (isOnScreen()) {
            game.playSound("music/smb_bump.mp3");
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        }
    }

    
    public void CollidedWithBrick_GoToRight() {
        PositiveX = false;
//        if (this.getScreenX() > -500 & this.getScreenX() < 1200) {
        if (isOnScreen()) {

            game.playSound("music/smb_bump.mp3");
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        }
    }

    
    public int getType() {
        return getID();
    }

    
    public void MarioJumpedOnEnemy() {
        game.player.Jump(-8);
        game.EnemyGroup.add(new HelmetShell(getX(), getY(), game.bsLoader.getStoredImage("HelmetShell"), game, MariotoRight()));
        setActive(false);
        if (game.player.HasStar()) {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        }
    }

    
    public void KilledByFireBall() {
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
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void OtherEnemyTouchedFromRight() {
    }

    
    public void OtherEnemyTouchedFromLeft() {
    }

    
    public void CollidedWithMarioFromTOLeft() {
        if (game.player.HasStar()) {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            setActive(false);
        } else {
            game.player.Decerease();
        }
    }

    
    public void CollidedWithMarioTORight() {
        if (game.player.HasStar()) {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            setActive(false);
        } else {
            game.player.Decerease();
        }
    }

    
    public void EnemyJumperOnMario() {
        if (game.player.HasStar()) {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            setActive(false);
        } else {
            game.player.Decerease();
        }
    }

    
    public int Life() {
        return 0;
    }

    
    public void CollidedWithJumping_Brick() {
        if (PositiveX) {
            PositiveX = false;
        } else {
            PositiveX = true;
        }
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
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
}
