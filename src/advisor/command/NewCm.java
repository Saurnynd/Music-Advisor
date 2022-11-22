package advisor.command;

import advisor.server.Request;
import advisor.server.exception.ClientServerException;
import advisor.view.Factory;
import advisor.view.OutputCate;
import advisor.view.OutputNew;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class NewCm implements Command {
    @Override
    public String name() {
        return "new";
    }

    @Override
    public void execute(String args) {

        String path = "/v1/browse/new-releases";
        var factory = new Factory();
        factory.setType(new OutputNew());
        try {
            factory.out(Request.loadData(path));
        } catch (ClientServerException e) {
            System.out.println("Error request");
        }
    }
}