package models.attacks;

import models.interfaces.Blob;

public class PutridFart extends AbstractAttack {

    @Override
    public String produceAttack(Blob attacker, Blob target) {
        StringBuilder result = new StringBuilder();
        int currentHealth = target.getHealth();
        currentHealth -= attacker.getDamage();
        target.setHealth(currentHealth);
        result.append(target.checkTheBehavior());

        return result.toString();
    }
}
