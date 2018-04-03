package factories;

import factories.interfaces.BlobFactory;
import models.blobs.BlobImpl;
import models.interfaces.Attack;
import models.interfaces.Behavior;
import models.interfaces.Blob;

public class BlobFactoryImpl implements BlobFactory{

    @Override
    public Blob createBlob(String name, int health, int damage, Behavior behavior, Attack attack) {
        return new BlobImpl(name, health, damage, behavior, attack);
    }
}
