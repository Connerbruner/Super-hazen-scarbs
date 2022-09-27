


// Source File Name:   BasicEnemy.java

package Objects;


public interface BasicEnemy
{

    public abstract void update(long l);

    public abstract void CollidedWithBrick_GoToLeft();

    public abstract void CollidedWithBrick_GoToRight();

    public abstract int getType();

    public abstract void setActive(boolean flag);

    public abstract void MarioJumpedOnEnemy();

    public abstract void KilledByFireBall();

    public abstract void bounce();

    public abstract void setYloc(double d);

    public abstract void CollidedWithShell();

    public abstract void CollidedWithMovingShell();

    public abstract void OtherEnemyTouchedFromRight();

    public abstract void OtherEnemyTouchedFromLeft();

    public abstract void CollidedWithMarioFromTOLeft();

    public abstract void CollidedWithMarioTORight();

    public abstract void EnemyJumperOnMario();

    public abstract int Life();

    public abstract void CollidedWithJumping_Brick();

    public abstract boolean MariotoRight();
}
