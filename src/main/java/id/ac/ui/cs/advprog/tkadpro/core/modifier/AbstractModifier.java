package id.ac.ui.cs.advprog.tkadpro.core.modifier;

public abstract class AbstractModifier implements Modifier{
    protected final int decrementPoint;
    protected final int incrementPoint;
    protected final int decrementHP;

    public AbstractModifier(int decrementPoint, int incrementPoint, int decrementHP) {
        this.decrementPoint = decrementPoint;
        this.incrementPoint = incrementPoint;
        this.decrementHP = decrementHP;
    }

    @Override
    public int getDecrementPoint() {
        return decrementPoint;
    }

    @Override
    public int getIncrementPoint() {
        return incrementPoint;
    }

    @Override
    public int getDecrementHP() {
        return decrementHP;
    }

}
