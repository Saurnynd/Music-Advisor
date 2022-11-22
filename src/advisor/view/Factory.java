package advisor.view;

import com.google.gson.JsonObject;

public class Factory {
    Output type;

    public void setType(Output type) {
        this.type = type;
    }
    public void out(JsonObject el){
        this.type.out(el);
    }
}
