// Source File Name:   Brick.java
package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            TemporaryAndInvisibleBrick, BasicBrick
public class Brick extends Sprite
        implements BasicBrick {

    int Gravity;
    boolean Jump;
    Mario game;

    int DownGoBelowThisYAxis;

    public Brick(int x, int y, BufferedImage b, Mario g) {
        Gravity = 4;
        Jump = false;
        setLocation(x, y);
        setImage(b);
        setID(3);
        game = g;

        DownGoBelowThisYAxis = y;
    }

    
    public void update(long l) {
        if (Gravity >= 4) {
            Jump = false;
        } else {
            Gravity = Gravity + 1;
            moveY(Gravity);
        }

    }

    
    public void HitFromDown() {
        if (game.player.getID() == 2 || game.player.getID() == 3) {
            game.addSomeBrickFragmends(getX(), getY());
            game.BrickGroup.add(new TemporaryAndInvisibleBrick((int) getX(), (int) getY(), ImageUtil.createImage(32, 32, 3), game));
            RemoveIt();
        }

        if (Gravity <= 0 & Jump) {        // going up don nothing
        } else if (Gravity > 0 & Jump) {  // coming down = invert gravity
            Gravity = ~Gravity;
        } else {
            Gravity = -5;  // what if already jumping
            Jump = true;
            game.player.GoDown();
        }
    }

    
    public void RemoveIt() {
        setActive(false);
    }

    
    public String getInsideItem() {
        return "empty";
    }

    public void Bounce() {
        Gravity = -5;
        Jump = true;
    }

    
    public boolean isJump() {
        return Jump;
    }

}
