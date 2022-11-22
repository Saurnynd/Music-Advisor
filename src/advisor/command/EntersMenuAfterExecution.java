package advisor.command;

import advisor.menu.CommandsMenu;

/**
 * Decorator
 */
public class EntersMenuAfterExecution implements Command {
    private final Command command;
    private final CommandsMenu menu;

    public EntersMenuAfterExecution(Command command, CommandsMenu menu) {
        this.command = command;
        this.menu = menu;
    }

    @Override
    public String name() {
        return command.name();
    }

    @Override
    public void execute(String str) {
        command.execute(str);
        menu.enter();
    }
}