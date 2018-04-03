package core.interfaces;

public interface CommandExecutor {

    void executeCommand(String[] inputArgs) throws ReflectiveOperationException;
}
