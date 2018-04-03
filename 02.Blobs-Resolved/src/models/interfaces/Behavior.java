package models.interfaces;

public interface Behavior {

    boolean isTriggered();

    void trigger(Blob blob);

    void applyRecurrentEffect(Blob blob);
}
