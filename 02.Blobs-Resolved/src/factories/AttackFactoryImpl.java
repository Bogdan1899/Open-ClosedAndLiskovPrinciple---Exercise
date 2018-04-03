package factories;

import factories.interfaces.AttackFactory;
import models.attacks.BlobPlode;
import models.attacks.PutridFart;
import models.interfaces.Attack;

public class AttackFactoryImpl implements AttackFactory{

    @Override
    public Attack createAttack(String attackName) {

        switch (attackName.toLowerCase()){
            case "putridfart":
                return new PutridFart();
            case "blobplode":
                return new BlobPlode();
                default:
                    throw new IllegalArgumentException("No such Attack!");
        }
    }
}
