// Source File Name:   Bank.java
package Bricks;

import Animations.CoinAnim;
import SandBox.Mario;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            Brick, Iron, BasicBrick
public class Bank extends Brick
        implements BasicBrick {

    public Bank(int x, int y, BufferedImage storedImage, Mario g) {
        super(x, y, storedImage, g);
        ActiveCoins = 100;
        active = false;
        setID(10);
        game = g;
    }

    
    public void update(long l) {
        if (active) {
            ActiveCoins--;
        }
        super.update(l);
    }

    
    public void HitFromDown() {
        if (ActiveCoins < 0) {
            game.BrickGroup.add(new Iron((int) getX(), (int) getY(), game.bsLoader.getStoredImages("Iron"), game));
            setActive(false);
        } else {
            active = true;
            game.AnimationGroup.add(new CoinAnim((int) getX(), (int) getY(), game.bsLoader.getStoredImages("CoinAnim"), game));
            Bounce();
        }
    }

    
    public String getInsideItem() {
        return "empty";
    }

    
    public boolean isJump() {
        return Jump;
    }

    int ActiveCoins;
    boolean active;
}
