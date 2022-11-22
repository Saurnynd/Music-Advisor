package advisor.command;

import advisor.server.Request;
import advisor.server.exception.ClientServerException;
import advisor.view.Factory;
import advisor.view.OutputCate;
import advisor.view.OutputPlaylist;
import com.google.gson.JsonObject;

public class PlaylistsCm implements Command {
    @Override
    public String name() {
        return "playlists";
    }

    @Override
    public void execute(String str) {
        String categoryPath = "/v1/browse/categories";
        String categoryId = "";
        String categoryName = str.split(" ",2)[1];
        try {
            var arr = Request.loadData(categoryPath).getAsJsonObject("categories")
                    .getAsJsonArray("items");
            for (int i = 0; i < arr.size(); i++) {
                if (categoryName.equals(((JsonObject) arr.get(i)).get("name").getAsString())) {
                    categoryId = ((JsonObject) arr.get(i)).get("id").getAsString();
                }
            }
            if(categoryId.equals("")){
                System.out.println("Unknown category name.");
                return;
            }
        } catch (ClientServerException e) {
            System.out.println("Error request");
            return;
        }
        String path = "/v1/browse/categories/" + categoryId + "/playlists";
        var factory = new Factory();
        factory.setType(new OutputPlaylist());
        try {
            factory.out(Request.loadData(path));
        } catch (ClientServerException e) {
            System.out.println("Error request");
        }
    }
}