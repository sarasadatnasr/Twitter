import java.util.ArrayList;
public class Account {
    public Account(String str){}
    ArrayList<Account> list=new ArrayList<Account>();
    ArrayList<Account> twitter=new ArrayList<Account>();
    public Account(String e,String w,String b){}
    private String email;
    private String password;
    private String bio;
    public void setEverything(String e,String p,String b) {
        this.email=e;
        this.password=p;
        this.bio=b;
    }
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
    public Account() {
        email = "";
       password = "";
    }


    public boolean checkEmail() {
        boolean isvalid = false;
        if (email.matches("(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6})")) {
            isvalid = true;
        }
        return isvalid;
    }

    public boolean checkPassword(){
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

    public void userInformation(Account account){
        list.add(account);
    }

}

