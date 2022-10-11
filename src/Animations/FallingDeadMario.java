


// Source File Name:   FallingDeadMario.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;

public class FallingDeadMario extends Sprite
{

    public FallingDeadMario(double x, double y, Mario g)
    {
        game.Restart();
    }

    
    public void update(long l) {
        return;
    }

    int Gravity;
    int delay;
    Mario game;
}
