package advisor.command;

import advisor.server.Request;
import advisor.server.exception.ClientServerException;
import advisor.view.Factory;
import advisor.view.OutputCate;

public class CategoriesCm implements Command {
    @Override
    public String name() {
        return "categories";
    }

    @Override
    public void execute(String str) {
        String path = "/v1/browse/categories";
        var factory = new Factory();
        factory.setType(new OutputCate());
        try {
            factory.out(Request.loadData(path));
        } catch (ClientServerException e) {
            System.out.println("Error request");
        }
    }
}