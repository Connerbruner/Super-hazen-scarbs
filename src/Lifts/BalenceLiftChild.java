// Source File Name:   BalenceLiftChild.java
package Lifts;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

// Referenced classes of package Lifts:
//            BasicLift, BalenceLiftParent
class BalenceLiftChild extends Sprite
        implements BasicLift {

    public BalenceLiftChild(int x, int y, Mario g, BalenceLiftParent parent) {
        MarioOnLift = false;
        MaxY = 96;
        MinY = 352;
        SpeedY = 0;
        game = g;
        setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), 6));
        setLocation(x, y + 64);
        Parent = parent;
        AddBlackBoxes();
        chain = ImageUtil.resize(game.bsLoader.getStoredImages("Chain")[0], 32, 32);
    }

    
    public void update(long elapsedTime) {
        if (getY() < (double) MaxY) {
            Break();
            Parent.Break();
        }
        if (getY() > (double) MinY) {
            Break();
            Parent.Break();
        }
        if (MarioOnLift) {
            SpeedY++;
            if (SpeedY > 60) {
                SpeedY = 60;
            }
            game.player.moveY(SpeedY / 12);
            moveY(SpeedY / 12);
            Parent.moveY(-SpeedY / 12);
            MarioOnLift = false;
        } else if (!MarioOnLift) {
            if (SpeedY > 0) {
                SpeedY--;
            }
            Parent.moveY(-SpeedY / 12);
            moveY(SpeedY / 12);
        }
        SpriteBlackBoxes.setY(getY());
        super.update(elapsedTime);
    }

    
    public void render(Graphics2D g) {
        g.drawImage(chain, (int) getScreenX() + 32, 96, 32, (int) SpriteBlackBoxes.getScreenY() - 96, null);
        super.render(g);
    }

    
    public boolean OnLift() {
        return MarioOnLift;
    }

    
    public void MarioIsOnLift() {
        MarioOnLift = true;
    }

    void Break() {
        Break = true;
        if ((int) SpriteBlackBoxes.getScreenY() - 96 > 32) {
            game.BackGroundSpriteGroup.add(new Sprite(ImageUtil.resize(game.bsLoader.getStoredImages("Chain")[0], 32, (int) SpriteBlackBoxes.getScreenY() - 96), getX() + 32D, 96D));
        }
    }

    private void AddChain() {
        BufferedImage Chain = ImageUtil.resize(game.bsLoader.getStoredImages("Chain")[0], 32, 480);
        game.BackGroundSpriteGroup.add(new Sprite(Chain, getX() + 32D, 96D));
    }

    private void AddBlackBoxes() {
        BufferedImage BlackBoxes = ImageUtil.createImage(32, 480, 3);
        SpriteBlackBoxes = new Sprite(BlackBoxes, getX() + 32D, getY());
        game.BackGroundSpriteGroup.add(SpriteBlackBoxes);
    }

    boolean MarioOnLift;
    Mario game;
    BalenceLiftParent Parent;
    int MaxY;
    int MinY;
    private int SpeedY;
    private boolean Break;
    Sprite SpriteBlackBoxes;
    BufferedImage chain;
}
