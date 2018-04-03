package core;

import core.interfaces.CommandExecutor;
import core.interfaces.Database;
import factories.interfaces.AttackFactory;
import factories.interfaces.BehaviorFactory;
import factories.interfaces.BlobFactory;
import io.interfaces.Writer;
import models.interfaces.Attack;
import models.interfaces.Behavior;
import models.interfaces.Blob;

public class CommandExecutorImpl implements CommandExecutor{

    private BehaviorFactory behaviorFactory;
    private AttackFactory attackFactory;
    private BlobFactory blobFactory;
    private Database database;
    private Writer writer;
    private boolean isReporting;

    public CommandExecutorImpl(BehaviorFactory behaviorFactory,
                               AttackFactory attackFactory,
                               BlobFactory blobFactory,
                               Database database,
                               Writer writer) {
        this.behaviorFactory = behaviorFactory;
        this.attackFactory = attackFactory;
        this.blobFactory = blobFactory;
        this.database = database;
        this.writer = writer;
        this.isReporting = false;
    }

    @Override
    public void executeCommand(String[] inputArgs) throws ReflectiveOperationException {
        String commandName = inputArgs[0];

        switch (commandName.toLowerCase()){
            case "report-events":
                this.isReporting = true;
                break;
            case "create":
                String name = inputArgs[1];
                int health = Integer.parseInt(inputArgs[2]);
                int damage = Integer.parseInt(inputArgs[3]);
                Behavior behavior = this.behaviorFactory.createBehavior(inputArgs[4]);
                Attack attack = this.attackFactory.createAttack(inputArgs[5]);
                Blob blob = this.blobFactory.createBlob(name, health, damage, behavior, attack);
                this.database.addBlob(blob);
                this.passTurn();
                break;
            case "attack":
                Blob attacker = this.database.getBlobByName(inputArgs[1]);
                Blob target = this.database.getBlobByName(inputArgs[2]);
                if (this.isReporting){
                    this.writer.write(attacker.attack(target));
                } else {
                    attacker.attack(target);
                }
                this.passTurn();
                break;
            case "pass":
                this.passTurn();
                break;
            case "status":
                StringBuilder output = new StringBuilder();

                for (Blob eachBlob : this.database.getBlobs()) {
                    output.append(eachBlob.toString());
                    output.append(System.lineSeparator());
                }

                this.writer.write(output.toString());
                this.passTurn();
                break;
        }
    }

    private void passTurn(){
        for (Blob blob : this.database.getBlobs()) {
            blob.update();
        }
    }
}
