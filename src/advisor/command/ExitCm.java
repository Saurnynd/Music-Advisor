package advisor.command;

public class ExitCm implements Command {
    @Override
    public String name() {
        return "exit";
    }

    @Override
    public void execute(String args) {
        System.out.println("---GOODBYE!---");
    }
}