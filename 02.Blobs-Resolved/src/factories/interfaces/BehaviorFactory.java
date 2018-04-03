package factories.interfaces;

import models.interfaces.Behavior;

public interface BehaviorFactory {

    Behavior createBehavior(String behaviorName) throws ClassNotFoundException, ReflectiveOperationException;
}
