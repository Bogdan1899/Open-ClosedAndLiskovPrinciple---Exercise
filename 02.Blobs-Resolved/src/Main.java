import core.CommandExecutorImpl;
import core.DatabaseImpl;
import core.EngineImpl;
import core.interfaces.CommandExecutor;
import core.interfaces.Database;
import core.interfaces.Engine;
import factories.AttackFactoryImpl;
import factories.BehaviorFactoryImpl;
import factories.BlobFactoryImpl;
import factories.interfaces.AttackFactory;
import factories.interfaces.BehaviorFactory;
import factories.interfaces.BlobFactory;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.interfaces.Reader;
import io.interfaces.Writer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ReflectiveOperationException {
        BehaviorFactory behaviorFactory = new BehaviorFactoryImpl();
        AttackFactory attackFactory = new AttackFactoryImpl();
        BlobFactory blobFactory = new BlobFactoryImpl();
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Database database = new DatabaseImpl();
        CommandExecutor commandExecutor = new CommandExecutorImpl(behaviorFactory, attackFactory, blobFactory, database, writer);
        Engine engine = new EngineImpl(reader, commandExecutor);
        engine.run();
    }
}
