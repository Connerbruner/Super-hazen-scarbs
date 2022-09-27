


// Source File Name:   FireWorks.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.util.ImageUtil;
import com.golden.gamedev.util.Utility;

public class FireWorks extends AnimatedSprite
{

    public FireWorks(int x, int y, Mario g)
    {
        game = g;
        setImages(ImageUtil.splitImages(game.bsLoader.getStoredImages("fireworks")[Utility.getRandom(0, 2)], 4, 1));
        AnimationTimes = Utility.getRandom(4, 7);
        game.DelayToNextCheckPoint = game.DelayToNextCheckPoint + AnimationTimes * 10;
        basex = x;
        setAnimationTimer(new Timer(200));
        setAnimate(true);
        UdpatePos();
    }

    
    public void update(long elapsedTime)
    {
        if(getFrame() == getFinishAnimationFrame())
            UdpatePos();
        super.update(elapsedTime);
    }

    public void UdpatePos()
    {
        int newX = Utility.getRandom(basex - 128, basex + 128);
        int newY = Utility.getRandom(3, 7) * 32;
        setLocation(newX, newY);
        setImages(ImageUtil.splitImages(game.bsLoader.getStoredImages("fireworks")[Utility.getRandom(0, 2)], 4, 1));
        setAnimate(true);
        AnimationTimes--;
        if(AnimationTimes < 0)
            setActive(false);
        else
            game.playSound("music/smb_fireworks.mp3");
    }

    Mario game;
    int basex;
    int AnimationTimes;
}
