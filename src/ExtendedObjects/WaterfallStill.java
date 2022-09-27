


// Source File Name:   WaterfallStill.java

package ExtendedObjects;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class WaterfallStill extends Sprite
{

    public WaterfallStill(BufferedImage image, int x, int y, Mario g)
    {
        delay = 0;
        CurrentFrame = 0;
        game = g;
        setImage(image);
        setLocation(x, 344D);
        OriginalX = x;
        WaterFall = game.bsLoader.getStoredImages("WaterFall");
    }

    
    public void update(long elapsedTime)
    {
        double divided = game.playfield.getBackground().getX() / 1.8D;
        setX(divided + (double)OriginalX);
        super.update(elapsedTime);
        delay--;
        if(delay < 0)
        {
            delay = 2;
            UpdateLampimage();
        }
    }

    
    public void render(Graphics2D g)
    {
        super.render(g);
        for(int i = 0; i < 4; i++)
            g.drawImage(WaterFall[anim[CurrentFrame]], null, (int)getScreenX() + 128 + i * 32, 352);

        g.drawImage(WaterFall[anim[CurrentFrame]], null, (int)getScreenX() + 449, 352);
        for(int i = 0; i < 3; i++)
            g.drawImage(WaterFall[anim[CurrentFrame]], null, (int)getScreenX() + 640 + i * 32, 352);

        g.drawImage(WaterFall[anim[CurrentFrame]], null, (int)getScreenX() + 1088, 352);
        for(int i = 0; i < 2; i++)
            g.drawImage(WaterFall[anim[CurrentFrame]], null, (int)getScreenX() + 1217 + i * 32, 352);

        for(int i = 0; i < 4; i++)
            g.drawImage(WaterFall[anim[CurrentFrame]], null, (int)getScreenX() + 1664 + i * 32, 352);

        for(int i = 0; i < 2; i++)
            g.drawImage(WaterFall[anim[CurrentFrame]], null, (int)getScreenX() + 2112 + i * 32, 352);

        for(int i = 0; i < 2; i++)
            g.drawImage(WaterFall[anim[CurrentFrame]], null, (int)getScreenX() + 2240 + i * 32, 352);

        for(int i = 0; i < 9; i++)
            g.drawImage(WaterFall[anim[CurrentFrame]], null, (int)getScreenX() + 2497 + i * 32, 352);

    }

    private void UpdateLampimage()
    {
        CurrentFrame++;
        if(CurrentFrame >= anim.length)
            CurrentFrame = 0;
    }

    Mario game;
    int OriginalX;
    BufferedImage WaterFall[];
    int delay;
    int anim[] = {
        0, 1, 2, 3
    };
    int CurrentFrame;
}
