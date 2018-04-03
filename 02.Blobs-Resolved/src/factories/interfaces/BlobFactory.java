package factories.interfaces;

import models.interfaces.Attack;
import models.interfaces.Behavior;
import models.interfaces.Blob;

public interface BlobFactory {

    Blob createBlob(String name, int health, int damage, Behavior behavior, Attack attack);
}
