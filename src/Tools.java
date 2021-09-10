import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Tools {
   public Tools(){}
   static public String email;
   static public String password;
   static public String bio;
   static HashMap<String, String> emailPassword = new HashMap<String, String>();
   public static boolean Check(String email, String password, HashMap<String, String> list){
        boolean isvalid=false;
        String realPassword=list.get(email);
        if(realPassword.equals(password)) {
            isvalid=true;
        }
        return isvalid;
    }
    public  static String getKey(HashMap<String, Integer> mapref, int value) {
        String key = "";
        for (HashMap.Entry<String, Integer> map : mapref.entrySet()) {
            if (map.getValue().toString().equals(value)) {
                key = map.getKey();
            }
        }
        return key;
    }
   public void setEmailPassword() {
        final String outputFilePath = "D:\\Git\\Twitter\\emailPassword.txt";

        File file = new File(outputFilePath);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : emailPassword.entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                //new line
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                //always close the writer
                bf.close();
            } catch (Exception e) {
            }
        }
    }
//----------------------------------------------------------------
    static HashMap<String,Integer> userNumber = new HashMap<String,Integer>();
    public void setUserNumber() {
        final String outputFilePath = "D:\\Git\\Twitter\\userNumber.txt";
        File file = new File(outputFilePath);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, Integer> entry : userNumber.entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                //new line
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                //always close the writer
                bf.close();
            } catch (Exception e) {
            }
        }
    }

//---------------------------------------------------------------
    static LinkedList<Account> listOfAccounts=new LinkedList<>();
    static LinkedList<Twitters> listOfTwitters=new LinkedList<>();
    static int key;
    static int key2;
    static int key4;
    static int temp;
//---------------------------------------------------------------
    static String[][] myFollowing=new String[20][20];
    public void setMyFollowing() throws Exception {
        FileWriter writer = new FileWriter("E:/input.txt");
        for (int i = 0; i <myFollowing.length ; i++) {
            for(int j=0;j<myFollowing[0].length;j++){
            writer.write(myFollowing[i][j] + "\n");
        }
        writer.close();
    }
}
 //----------------------------------------------------------------
    static String[][] myTwitter=new String[20][20];;
    public void setMyTwitter() throws Exception {
        FileWriter writer = new FileWriter("E:/input.txt");
        for (int i = 0; i <myTwitter.length ; i++) {
            for(int j=0;j<myTwitter[0].length;j++){
                writer.write(myFollowing[i][j] + "\n");
            }
            writer.close();
        }
    }
//-------------------------------------------------------------------
static int[][] likes=new int[20][20];
    public void setLikes() throws Exception {
        FileWriter writer = new FileWriter("E:/input.txt");
        for (int i = 0; i <likes.length ; i++) {
            for(int j=0;j<myTwitter[0].length;j++){
                writer.write(myFollowing[i][j] + "\n");
            }
            writer.close();
        }
    }
//----------------------------------------------------------------
    static String[][][] replies=new String[20][20][6];
    public void setReplies() throws Exception {
        FileWriter writer = new FileWriter("E:/input.txt");
        for (int i = 0; i <replies.length ; i++) {
            for(int j=0;j<myTwitter[0].length;j++){
                writer.write(myFollowing[i][j] + "\n");
            }
            writer.close();
        }
    }
//-------------------------------------------------------------------
    // Getter
    public String getEmail() {
        return email;
    }

    // Setter
    public void setEmail(String c) {
        this.email = c;
    }

    // Getter
    public String getPassword() {
        return password;
    }

    // Setter
    public void setPassword(String c) {
        this.password = c;
    }

    // Getter
    public String getBio() {
        return bio;
    }

    // Setter
    public void setBio(String c) {
        this.bio = c;
    }
    public static boolean checkEmail() {
        boolean isvalid = false;
        if (email.matches("(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6})")) {
            isvalid = true;
        }
        return isvalid;
    }
    public static boolean checkPassword(){
        boolean isvalid = false;
        if (password.length() >= 6) {
            isvalid = true;
        }
        return isvalid;
    }
    public  boolean checkBio() {
        boolean isvalid = false;
        if (bio.length() < 80) {
            isvalid = true;
        }
        return isvalid;
    }

}

