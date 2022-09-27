package Utility;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import java.awt.*;

// Referenced classes of package Utility:
//            SoundPlayer

public class MarioRun extends Game
{

    public MarioRun()
    {
        Frame = 1;
        something = 1;
    }

    
    public void initResources()
    {
        setFPS(30);
        sp = new SoundPlayer();
    }

    
    public void update(long elapsedTime)
    {
        if(bsInput.isKeyDown(39))
        {
            something++;
            sp.play("music/smb_kick.mp3");
        }
        if(!bsInput.isKeyDown(76));
        if(bsInput.isKeyDown(37))
        {
            sp.play("music/smb_coin.mp3");
            something--;
        }
        if(something > 10)
        {
            something = 1;
            AdvanceFrame();
        }
        if(something < -10)
        {
            something = -1;
            DeAdvanceFrame();
        }
    }

    
    public void render(Graphics2D g)
    {
        g.setColor(Color.blue);
        g.fillRect(0, 0, 640, 480);
        g.setColor(Color.white);
        g.drawString(" > " + Frame + " < ", 100, 100);
    }

    public static void main(String args[])
    {
        GameLoader GL = new GameLoader();
        GL.setup(new MarioRun(), new Dimension(640, 480), false);
        GL.start();
    }

    private void AdvanceFrame()
    {
        if(Frame == 1)
            Frame = 2;
        else
        if(Frame == 2)
            Frame = 3;
        else
        if(Frame == 3)
            Frame = 1;
    }

    private void DeAdvanceFrame()
    {
        if(Frame == 1)
            Frame = 2;
        else
        if(Frame == 2)
            Frame = 3;
        else
        if(Frame == 3)
            Frame = 1;
    }

    int Frame;
    int something;
    SoundPlayer sp;
}
