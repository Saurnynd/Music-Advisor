package advisor;

import advisor.command.Command;
import advisor.command.UnknownCm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Utils {
    static Scanner scanner = new Scanner(System.in);
    public static String scannedWords() {
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Command enteredCommand(String commandName, Iterable<Command> availableCommands) {
        for (Command command : availableCommands)
            if (commandName.split(" ", 2) [0].equals(command.name()))
                return command;
        return new UnknownCm();
    }

}

