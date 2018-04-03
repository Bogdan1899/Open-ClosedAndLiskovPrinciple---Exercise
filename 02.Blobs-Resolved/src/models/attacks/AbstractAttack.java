package models.attacks;

import models.interfaces.Attack;
import models.interfaces.Blob;

public abstract class AbstractAttack implements Attack {
    public abstract String produceAttack(Blob attacker, Blob target);
}
