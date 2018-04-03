package models.behaviors;

import models.interfaces.Blob;

public class Inflated extends AbstractBehavior {

    private static final int HEALTH_TO_GET = 50;
    private static final int HEALTH_TO_LOSE_EACH_TURN = 10;

    public Inflated() {
        super();
    }

    @Override
    public void trigger(Blob blob) {
        super.setIsTriggered(true);
        this.applyTriggerEffect(blob);
    }

    @Override
    public void applyRecurrentEffect(Blob blob) {
        if (super.isTriggered()){
            if (super.getToDelayRecurrentEffect()){
                super.setToDelayRecurrentEffect(false);
            } else {
                blob.setHealth(blob.getHealth() - HEALTH_TO_LOSE_EACH_TURN);
            }
        }
    }

    protected void applyTriggerEffect(Blob blob) {
        blob.setHealth(blob.getHealth() + HEALTH_TO_GET);
    }
}
