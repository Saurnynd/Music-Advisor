package advisor.command;

public class UnknownCm implements Command {
    @Override
    public String name() {
        return "Unknown command";
    }

    @Override
    public void execute(String str) {
        System.out.println("Unknown command entered");
    }
}