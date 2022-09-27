// Source File Name:   Enemy_Brick.java
package Collusion;

import Bricks.BasicBrick;
import Objects.BasicEnemy;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import java.awt.Point;

public class Enemy_Brick extends BasicCollisionGroup {

    public Enemy_Brick(Mario aThis) {
        M = aThis;
    }

    
    public void collided(Sprite enemy, Sprite brick) {
        BasicEnemy e = (BasicEnemy) enemy;
        BasicBrick bri = (BasicBrick) brick;
        boolean NoCollusion = true;
        switch (e.getType()) {
            case 104://MovingTurtelShell = 104 
                if (enemy.getDistance(brick) < 16) {
                    e.CollidedWithMovingShell();
                }
                break;
            case 107://MovingHelmetShell = 107; 
                if (enemy.getDistance(brick) < 16) {
                    e.CollidedWithMovingShell();
                }
                break;
            case 109: // 'm'
                NoCollusion = false;
                break;

            case 110: // 'n'
                NoCollusion = false;
                break;

            case 111: // 'o'
                NoCollusion = false;
                break;

            case 112: // 'p'
                NoCollusion = false;
                break;

            case 113: // 'q'
                NoCollusion = false;
                break;

            case 114: // 'r'
                NoCollusion = false;
                break;

            case 115: // 's'
                NoCollusion = false;
                break;

            case 116: // 't'
                NoCollusion = false;
                break;
        }
        if (NoCollusion) {
            Point enemy_Center = new Point((int) enemy.getX() + enemy.getWidth(), (int) enemy.getY() + enemy.getHeight());
            Point brick_Center = new Point((int) brick.getX() + brick.getWidth(), (int) brick.getY() + brick.getHeight());
            int angle = (int) Math.toDegrees(Math.atan2(enemy_Center.getY() - brick_Center.getY(), enemy_Center.getX() - brick_Center.getX()));
            M.setDegree(angle);
            String side;
            if (angle > 30 && angle < 150) {
                side = "down";
            } else if (angle < -30 && angle > -150) {
                side = "up";
                if (bri.isJump()) {
                    switch (e.getType()) {
                        case 100: // 'd'
                            e.CollidedWithJumping_Brick();
                            break;

                        case 101: // 'e'
                            e.CollidedWithJumping_Brick();
                            break;

                        case 102: // 'f'
                            e.CollidedWithJumping_Brick();
                            break;

                        case 103: // 'g'
                            e.CollidedWithJumping_Brick();
                            break;

                        case 105: // 'i'
                            e.CollidedWithJumping_Brick();
                            break;

                        case 106: // 'j'
                            e.CollidedWithJumping_Brick();
                            break;

                        case 107: // 'k'
                            e.CollidedWithJumping_Brick();
                            break;

                        case 108: // 'l'
                            e.CollidedWithJumping_Brick();
                            break;

                        case 117: // 'u'
                            e.CollidedWithJumping_Brick();
                            break;

                        case 3: // '\003'
                            e.CollidedWithJumping_Brick();
                            break;

                        case 21: // '\025'
                            e.CollidedWithJumping_Brick();
                            break;
                    }
                }
                e.setYloc(brick.getY() - (double) enemy.getHeight());
            } else if (angle > 150 || angle < -150) {
                side = "left";
                e.CollidedWithBrick_GoToLeft();
//                switch (e.getType()) {
//                    case 104: // 'h'
//                    case 107: // 'k'
////                        M.playSound("music/smb_bump.mp3");
//                        break;
//                }
            } else if (angle < 30 && angle > -30) {
                side = "right";
                e.CollidedWithBrick_GoToRight();
//                switch (e.getType()) {
//                    case 104: // 'h'
//                    case 107: // 'k'
////                        M.playSound("music/smb_bump.mp3");
//                        break;
//                }
            } else {
                side = "null";
            }
            M.setDegree(side);
        }
    }

    Mario M;
}
