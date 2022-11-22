package advisor.command;

import advisor.server.Request;
import advisor.server.exception.ClientServerException;
import advisor.view.Factory;
import advisor.view.OutputCate;
import advisor.view.OutputFeatured;
import com.google.gson.JsonObject;

public class FeaturedCm implements Command {
    @Override
    public String name() {
        return "featured";
    }

    @Override
    public void execute(String args) {
        String path = "/v1/browse/featured-playlists";
        var factory = new Factory();
        factory.setType(new OutputFeatured());
        try {
            factory.out(Request.loadData(path));
        } catch (ClientServerException e) {
            System.out.println("Error request");
        }
    }
}