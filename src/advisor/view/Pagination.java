package advisor.view;

import com.google.gson.JsonArray;

import static advisor.Config.ITEM_PER_PAGE;

public class Pagination {
    public static void page(JsonArray arr){
        int pages = arr.size()/ITEM_PER_PAGE;

    }

}
