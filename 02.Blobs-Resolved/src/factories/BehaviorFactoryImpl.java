package factories;

import factories.interfaces.BehaviorFactory;
import models.interfaces.Behavior;

public class BehaviorFactoryImpl implements BehaviorFactory{

    private static final String PREFIX = "models.behaviors.";

    @Override
    public Behavior createBehavior(String behaviorName) throws ReflectiveOperationException {

        return (Behavior) Class.forName(PREFIX + behaviorName).newInstance();
    }
}
