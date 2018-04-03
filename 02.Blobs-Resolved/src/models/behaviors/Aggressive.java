package models.behaviors;

import models.interfaces.Blob;

public class Aggressive extends AbstractBehavior {

    private static final int AGGRESSIVE_DAMAGE_MULTIPLY = 2;
    private static final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

    private int sourceInitialDamage;

    public Aggressive() {
        super();
    }

    @Override
    public void trigger(Blob blob) {
        this.sourceInitialDamage = blob.getDamage();
        super.setIsTriggered(true);
        this.applyTriggerEffect(blob);
    }

    @Override
    public void applyRecurrentEffect(Blob blob) {
        if (super.isTriggered()){
            if (super.getToDelayRecurrentEffect()){
                super.setToDelayRecurrentEffect(false);
            } else {
                blob.setDamage(blob.getDamage() - AGGRESSIVE_DAMAGE_DECREMENT);

                if (blob.getDamage() <= this.sourceInitialDamage) {
                    blob.setDamage(this.sourceInitialDamage);
                }
            }
        }
    }

    protected void applyTriggerEffect(Blob blob) {
        blob.setDamage(blob.getDamage() * AGGRESSIVE_DAMAGE_MULTIPLY);
    }
}
