package advisor.view;

import advisor.server.Request;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Scanner;

import static advisor.Config.ITEM_PER_PAGE;

public class OutputNew implements Output {
    @Override
    public void out(JsonObject obj) {
        var arr = obj.getAsJsonObject("albums")
                .getAsJsonArray("items");
        int pages = arr.size() / ITEM_PER_PAGE;
        int currentPage = 1;
        boolean isTrue = true;
        while (isTrue) {
            for (int i = (currentPage - 1) * ITEM_PER_PAGE, j = 0; i < arr.size() && j < ITEM_PER_PAGE; i++, j++) {
                System.out.println(((JsonObject) arr.get(i)).get("name").getAsString());

                JsonArray artists = ((JsonObject) arr.get(i)).get("artists").getAsJsonArray();
                System.out.print("[");
                for (int k = 0; k < artists.size(); k++) {
                    System.out.print(((JsonObject) artists.get(k)).get("name").getAsString());
                    if (k + 1 != artists.size()) System.out.print(", ");
                }
                System.out.println("]");

                System.out.println(((JsonObject) arr.get(i)).get("external_urls")
                        .getAsJsonObject().get("spotify").getAsString());
                System.out.println();
            }
            System.out.println("---PAGE " + currentPage + " OF " + pages + "---");
            switch (new Scanner(System.in).next()) {
                case "next":
                    if (currentPage == pages) {
                        System.out.println("No more pages.");
                        break;
                    }
                    currentPage++;
                    break;
                case "prev":
                    if (currentPage == 1) {
                        System.out.println("No more pages.");
                        break;
                    }
                    currentPage--;
                    break;
                default:
                    isTrue = false;
            }
        }
    }
}
