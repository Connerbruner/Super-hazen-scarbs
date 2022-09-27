


// Source File Name:   BackTest.java

package Utility;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.ImageBackground;
import com.golden.gamedev.object.background.ParallaxBackground;
import com.golden.gamedev.util.ImageUtil;
import java.awt.*;

public class BackTest extends Game
{

    public BackTest()
    {
        Distance = 400;
        font = new Font("Tahoma", 1, 14);
    }

    
    public void initResources()
    {
        bg1 = new ImageBackground(getImage("BlueBackGround.png"));
        bg2 = new ImageBackground(getImage("clouds.png"));
        bg3 = new ImageBackground(getImage("mountains.png"));
        bg4 = new ImageBackground(ImageUtil.createImage(20000, 1, 3));
        background = new ParallaxBackground(new Background[] {
            bg1, bg2, bg3, bg4
        });
        Black = new Sprite(getImage("Mashroom.png"), 200D, 200D);
        BricksSpriteGroup = new SpriteGroup("Bricks");
        for(int i = 0; i < 5; i++)
            BricksSpriteGroup.add(new Sprite(getImage("Fence2.png"), 1536 * i, 32D));

        for(int i = 0; i < 500; i++)
            BricksSpriteGroup.add(new Sprite(getImage("mud.png"), 32 * i, 416D));

        playfield = new PlayField(background);
        playfield.add(Black);
        playfield.getBackground().getX();
        playfield.addGroup(BricksSpriteGroup);
    }

    
    public void update(long elapsedTime)
    {
        Distance = Distance + 1;
        Black.setX(Distance);
        background.setToCenter(Black);
        playfield.update(elapsedTime);
    }

    
    public void render(Graphics2D g)
    {
        g.setColor(Color.blue);
        g.fillRect(0, 0, 640, 480);
        playfield.render(g);
        g.drawString("Distance " + Distance, 50, 50);
    }

    public static void main(String args[])
    {
        GameLoader GL = new GameLoader();
        GL.setup(new BackTest(), new Dimension(640, 480), false);
        GL.start();
    }

    ParallaxBackground background;
    ImageBackground bg1;
    ImageBackground bg2;
    ImageBackground bg3;
    ImageBackground bg4;
    PlayField playfield;
    Sprite Black;
    int Distance;
    Font font;
    SpriteGroup BricksSpriteGroup;
}
