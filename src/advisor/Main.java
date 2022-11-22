package advisor;

import advisor.menu.EntryMenu;

import static advisor.Config.*;


public class Main {
    public static void cofig(String[] args) {
        AUTH_SERVER = (args != null && args.length > 1 && args[0].equals("-access")) ?
                args[1] :
                "https://accounts.spotify.com";
        API_SERVER = (args != null && args.length > 2 && args[2].equals("-resource")) ?
                args[3] :
                "https://api.spotify.com";
        ITEM_PER_PAGE = (args != null && args.length > 4 && args[4].equals("-page")) ?
                Integer.parseInt(args[5]) :
                5;
    }

    public static void main(String[] args) {
        cofig(args);
        new EntryMenu().enter();
    }
}