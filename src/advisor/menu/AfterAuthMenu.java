package advisor.menu;

import advisor.Utils;
import advisor.command.*;

import java.util.Arrays;
import java.util.List;

import static advisor.Utils.scannedWords;

public class AfterAuthMenu implements CommandsMenu {
    private final Command newCommand = new NewCm();
    private final Command categoriesCommand = new CategoriesCm();
    private final Command featuredCommand = new FeaturedCm();
    private final Command playlistsCommand = new PlaylistsCm();

    final List<Command> availableCommands = List.of(
            new ExitCm(),
            new EntersMenuAfterExecution(newCommand, this),
            new EntersMenuAfterExecution(categoriesCommand, this),
            new EntersMenuAfterExecution(featuredCommand, this),
            new EntersMenuAfterExecution(playlistsCommand, this),
            new EntersMenuAfterExecution(new UnknownCm(), this));

    public void enter() {
        final String inputCommand = scannedWords();
        Command command = Utils.enteredCommand(inputCommand, availableCommands);
        command.execute(inputCommand);
    }
}