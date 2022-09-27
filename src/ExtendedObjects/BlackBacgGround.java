


// Source File Name:   BlackBacgGround.java

package ExtendedObjects;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class BlackBacgGround extends Sprite
{

    public BlackBacgGround(BufferedImage image, int x, int y, Mario g)
    {
        delay = 0;
        CurrentFrame = 0;
        game = g;
        setImage(image);
        setLocation(x, y);
        OriginalX = x;
        lampimage = game.bsLoader.getStoredImages("Lamp");
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
        g.drawImage(lampimage[anim[CurrentFrame]], null, (int)getScreenX() + 190, 155);
        g.drawImage(lampimage[anim[CurrentFrame]], null, (int)getScreenX() + 699, 155);
    }

    private void UpdateLampimage()
    {
        CurrentFrame++;
        if(CurrentFrame >= anim.length)
            CurrentFrame = 0;
    }

    Mario game;
    int OriginalX;
    BufferedImage lampimage[];
    int delay;
    int anim[] = {
        0, 1, 0, 1, 2, 3, 3, 3, 2, 1
    };
    int CurrentFrame;
}
