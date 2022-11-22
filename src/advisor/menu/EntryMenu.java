package advisor.menu;

import advisor.Utils;
import advisor.command.*;

import java.util.Arrays;
import java.util.List;

import static advisor.Utils.scannedWords;

public class EntryMenu implements CommandsMenu {
    private static class CommandThatNeedsAccess implements Command {
        private final Command command;

        public CommandThatNeedsAccess(Command command) {
            this.command = command;
        }

        @Override
        public String name() {
            return command.name();
        }

        @Override
        public void execute(String args) {
            System.out.println("Please, provide access for application.");
        }
    }

    final List<Command> availableCommands = List.of(
            new ExitCm(),
            new EntersMenuAfterExecution(new CommandThatNeedsAccess(new NewCm()), this),
            new EntersMenuAfterExecution(new CommandThatNeedsAccess(new CategoriesCm()), this),
            new EntersMenuAfterExecution(new CommandThatNeedsAccess(new FeaturedCm()), this),
            new EntersMenuAfterExecution(new CommandThatNeedsAccess(new PlaylistsCm()), this),
            new EntersMenuAfterExecution(new AuthCm(), new AfterAuthMenu()),
            new EntersMenuAfterExecution(new UnknownCm(), this));

    public void enter() {
//        System.out.print("> "); Can't pass a test with this
        final String inputCommand = scannedWords();
        Command command = Utils.enteredCommand(inputCommand, availableCommands);
        command.execute(inputCommand);
    }

}