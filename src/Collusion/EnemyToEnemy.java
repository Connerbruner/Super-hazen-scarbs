


// Source File Name:   EnemyToEnemy.java

package Collusion;

import Objects.BasicEnemy;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import java.awt.Point;

public class EnemyToEnemy extends BasicCollisionGroup
{

    public EnemyToEnemy(Mario aThis)
    {
        game = aThis;
    }

    
    public void collided(Sprite Enemy1, Sprite Enemy2)
    {
        boolean NoCollusion = false;
        String side = "?";
        BasicEnemy e1 = (BasicEnemy)Enemy1;
        BasicEnemy e2 = (BasicEnemy)Enemy2;
        Point Enemy1_Center = new Point((int)Enemy1.getX() + Enemy1.getWidth(), (int)Enemy1.getY() + Enemy1.getHeight());
        Point Enemy2_Center = new Point((int)Enemy2.getX() + Enemy2.getWidth(), (int)Enemy2.getY() + Enemy2.getHeight());
        int angle = (int)Math.toDegrees(Math.atan2(Enemy1_Center.getY() - Enemy2_Center.getY(), Enemy1_Center.getX() - Enemy2_Center.getX()));
        game.setDegree(angle);
        switch(e1.getType())
        {
        case 3: // '\003'
        case 4: // '\004'
        case 12: // '\f'
        case 20: // '\024'
        case 21: // '\025'
            NoCollusion = true;
            break;
        }
        switch(e2.getType())
        {
        case 3: // '\003'
        case 4: // '\004'
        case 12: // '\f'
        case 20: // '\024'
        case 21: // '\025'
            NoCollusion = true;
            break;
        }
        if(!NoCollusion)
            if(angle > 50 && angle < 130)
                side = "down";
            else
            if(angle <= -30 && angle >= -150)
                side = "up";
            else
            if(angle > 150 || angle < -150)
            {
                side = "left";
                switch(e1.getType())
                {
                case 100: // 'd'
                    e1.OtherEnemyTouchedFromRight();
                    e2.OtherEnemyTouchedFromLeft();
                    break;

                case 101: // 'e'
                    e1.OtherEnemyTouchedFromRight();
                    e2.OtherEnemyTouchedFromLeft();
                    break;

                case 102: // 'f'
                    e1.OtherEnemyTouchedFromRight();
                    e2.OtherEnemyTouchedFromLeft();
                    break;

                case 103: // 'g'
                    e2.CollidedWithShell();
                    e1.CollidedWithShell();
                    break;

                case 104: // 'h'
                    e2.CollidedWithMovingShell();
                    game.playSound("music/smb_kick.mp3");
                    break;

                case 105: // 'i'
                    e1.OtherEnemyTouchedFromRight();
                    e2.OtherEnemyTouchedFromLeft();
                    break;

                case 106: // 'j'
                    e2.CollidedWithShell();
                    e1.CollidedWithShell();
                    break;

                case 107: // 'k'
                    e2.CollidedWithMovingShell();
                    game.playSound("music/smb_kick.mp3");
                    break;

                case 117: // 'u'
                    e1.OtherEnemyTouchedFromRight();
                    e2.OtherEnemyTouchedFromLeft();
                    break;
                }
            } else
            if(angle < 30 && angle > -30)
            {
                side = "right";
                switch(e1.getType())
                {
                case 100: // 'd'
                    e1.OtherEnemyTouchedFromLeft();
                    e2.OtherEnemyTouchedFromRight();
                    break;

                case 101: // 'e'
                    e1.OtherEnemyTouchedFromLeft();
                    e2.OtherEnemyTouchedFromRight();
                    break;

                case 102: // 'f'
                    e1.OtherEnemyTouchedFromLeft();
                    e2.OtherEnemyTouchedFromRight();
                    break;

                case 103: // 'g'
                    e2.CollidedWithShell();
                    e1.CollidedWithShell();
                    break;

                case 104: // 'h'
                    e2.CollidedWithMovingShell();
                    game.playSound("music/smb_kick.mp3");
                    break;

                case 105: // 'i'
                    e1.OtherEnemyTouchedFromLeft();
                    e2.OtherEnemyTouchedFromRight();
                    break;

                case 106: // 'j'
                    e2.CollidedWithShell();
                    e1.CollidedWithShell();
                    break;

                case 107: // 'k'
                    e2.CollidedWithMovingShell();
                    game.playSound("music/smb_kick.mp3");
                    break;

                case 117: // 'u'
                    e1.OtherEnemyTouchedFromLeft();
                    e2.OtherEnemyTouchedFromRight();
                    break;
                }
            } else
            {
                side = "null";
            }
        game.setDegree(side);
    }

    Mario game;
}
