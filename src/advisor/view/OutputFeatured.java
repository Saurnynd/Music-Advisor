package advisor.view;

import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static advisor.Config.ITEM_PER_PAGE;

public class OutputFeatured implements Output{
    @Override
    public void out(JsonObject obj) {
        var arr = obj.getAsJsonObject("playlists")
                .getAsJsonArray("items");
        int pages = arr.size() / ITEM_PER_PAGE;
        int currentPage = 1;
        boolean isTrue = true;
        while (isTrue) {
            for (int i = (currentPage - 1) * ITEM_PER_PAGE, j = 0; i < arr.size() && j < ITEM_PER_PAGE; i++, j++) {
                System.out.println(((JsonObject) arr.get(i)).get("name").getAsString());
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
