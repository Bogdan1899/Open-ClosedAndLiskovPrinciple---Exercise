package models.interfaces;

public interface Blob {

    String getName();

    int getHealth();

    void setHealth(int health);

    int getDamage();

    void setDamage(int damage);

    Attack getAttack();

    Behavior getBehavior();

    String attack(Blob target);

    boolean isDead();

    void update();

    String checkTheBehavior();
}