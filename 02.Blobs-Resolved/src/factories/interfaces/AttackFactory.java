package factories.interfaces;

import models.interfaces.Attack;

public interface AttackFactory {

    Attack createAttack(String attackName);
}
