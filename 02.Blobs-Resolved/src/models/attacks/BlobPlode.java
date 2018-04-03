package models.attacks;

import models.interfaces.Blob;

public class BlobPlode extends AbstractAttack{

    @Override
    public String produceAttack(Blob attacker, Blob target) {
        int halfBlood = attacker.getHealth() / 2;

        if (attacker.getHealth() % 2 != 0){
            halfBlood += 1;
        }

        StringBuilder result = new StringBuilder();
        attacker.setHealth(halfBlood);
        result.append(attacker.checkTheBehavior());
        int currentHealth = target.getHealth();
        currentHealth -= attacker.getDamage() * 2;
        target.setHealth(currentHealth);
        result.append(target.checkTheBehavior());

        return result.toString();
    }
}
