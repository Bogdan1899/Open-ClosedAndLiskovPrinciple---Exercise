package core;

import core.interfaces.CommandExecutor;
import core.interfaces.Engine;
import io.interfaces.Reader;

import java.io.IOException;

public class EngineImpl implements Engine{

    private Reader reader;
    private CommandExecutor commandExecutor;

    public EngineImpl(Reader reader, CommandExecutor commandExecutor) {
        this.reader = reader;
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void run() throws IOException, ReflectiveOperationException {
        String input = this.reader.read();

        while (!input.equalsIgnoreCase("drop")){
            String[] inputArgs = input.split(" ");
            this.commandExecutor.executeCommand(inputArgs);

            input = this.reader.read();
        }
    }
}
