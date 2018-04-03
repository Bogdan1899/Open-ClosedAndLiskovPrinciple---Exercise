package models.blobs;

import models.interfaces.Attack;
import models.interfaces.Behavior;
import models.interfaces.Blob;

public class BlobImpl implements Blob {

    private String name;
    private int health;
    private int damage;
    private int initialHealth;
    private Behavior behavior;
    private Attack attack;

    public BlobImpl(String name, int health, int damage, Behavior behavior, Attack attack) {
        this.setName(name);
        this.setHealth(health);
        this.setDamage(damage);
        this.setInitialHealth(health);
        this.setBehavior(behavior);
        this.setAttack(attack);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;

        if (this.health < 0) {
            this.health = 0;
        }
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    private void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }

    @Override
    public Attack getAttack() {
        return this.attack;
    }

    private void setAttack(Attack attack) {
        this.attack = attack;
    }

    @Override
    public Behavior getBehavior() {
        return this.behavior;
    }

    private void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public String attack(Blob target) {
        return this.getAttack().produceAttack(this, target);
    }

    @Override
    public boolean isDead() {
        return this.getHealth() < 1;
    }

    @Override
    public String checkTheBehavior(){
        if (this.health <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
            this.behavior.trigger(this);
            return String.format("Blob %s toggled %sBehavior\n", this.getName(), this.getBehavior().getClass().getSimpleName());
        }

        if (this.isDead()){
            return String.format("Blob %s was killed\n", this.getName());
        }

        return "";
    }

    @Override
    public void update() {
        this.behavior.applyRecurrentEffect(this);
    }

    @Override
    public String toString() {
        if (this.isDead()) {
            return String.format("Blob %s KILLED", this.getName());
        }

        return String.format("Blob %s: %s HP, %s Damage", this.getName(), this.getHealth(), this.getDamage());
    }
}
