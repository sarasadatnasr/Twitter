public class ListOfMenues {
    private String ActivityMenu;
    private String LoginMenu;
    private String MainMenu;
    public ListOfMenues() {
        ActivityMenu = "";
        LoginMenu = "";
        MainMenu = "";
    }

    public String getActivityMenu() {
        return   "press 1: if you want to read your followers twitter☺"
                + "\n" + "press 2: if you want to follow sb☺"
                + "\n" + "press 3: if you want to Unfollow sb"
                + "\n" + "press 4: if you block anyone"
                + "\n" + "press 5: if you want like any twitter♥"
                + "\n" + "press 6: if you want reply any twitter"
                + "\n" + "press 7: if you want retweet any twitter"
                + "\n" + "press 8: to go your account";
    }

    public String getLoginMenu() {
        return  "press 1: to write twitter"
                + "\n" +"press 2: to see your activity"
                + "\n" +"press 3: to do some activity"
                + "\n" +"press 4: to logout";
    }
    public String getMainMenu(){
        return  "press 1: to sign up"
                + "\n" +"press 2: to log in"
                + "\n" +"press 3: to see global twitter"
                + "\n" +"press 4: Quit";
    }
}

