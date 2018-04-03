package models.behaviors;

import models.interfaces.Behavior;
import models.interfaces.Blob;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;
    private boolean toDelayRecurrentEffect;

    protected AbstractBehavior() {
        this.setIsTriggered(false);
        this.setToDelayRecurrentEffect(true);
    }

    protected boolean getToDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    protected void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }

    @Override
    public abstract void trigger(Blob blob);

    @Override
    public abstract void applyRecurrentEffect(Blob blob);

    protected void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    protected abstract void applyTriggerEffect(Blob blob);
}
