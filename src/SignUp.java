import java.util.HashMap;
import java.util.Scanner;
public class SignUp {
        public static boolean Email(String email) {
            boolean isvalid = false;
            if (email.matches("(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6})")) {
                isvalid = true;
            }
            return isvalid;
        }

    public static boolean Password(String password) {
       boolean isvalid = false;
       if (password.length() >= 6) {
           isvalid = true;
       }
            return isvalid;
       }

    public static boolean Bio(String bio) {
            boolean isvalid = false;
            if (bio.length() < 80) {
                isvalid = true;
            }
            return isvalid;
    }
    public static void MainMenu(){
        System.out.println("press 1: to sign up");
        System.out.println("press 2: to log in");
        System.out.println("press 3: to see global twitt");
        System.out.println("press 4: Quit");
    }
public static boolean Check(String email, String password, HashMap<String, String> list){
       boolean isvalid=false;
       String realPassword=list.get(email);
       if(realPassword.equals(password)) {
           isvalid=true;
       }
return isvalid;
}
    public static void LoginMenu(){
        System.out.println("press 1: to write twitt");
        System.out.println("press 2: to see your activity");
        System.out.println("press 3: to go to main screen");
        System.out.println("press 4: to go main menu");
    }
    public static void ActivityMenu(){
        System.out.println("press 1:if you want to follow sb?");
        System.out.println("press 2:if you want to Unfollow sb?");
        System.out.println("press 3:if you want like any twitter?");
        System.out.println("press 4:to go your account");
    }
    public static String getKey(HashMap<String, Integer> mapref, String value) {
        String key = "";
        for (HashMap.Entry<String, Integer> map : mapref.entrySet()) {
            if (map.getValue().toString().equals(value)) {
                key = map.getKey();
            }
        }
        return key;
    }
}

