import java.util.Scanner;
import java.util.HashMap;
import java.io.*;
public class LoginMenu extends MainMenu{
    private int key2;
    // Setter
    public void setKey2(int c) {
        this.key2 = c;
    }

    // Getter
    public int getKey2() {
        return key2;
    }
    public void LoginMenuFunction(){
        LoginMenu loginmenu1=new LoginMenu();
        ListOfMenues menu=new ListOfMenues();
        Scanner input=new Scanner(System.in);
        System.out.println("welcome to your account!");
        System.out.println(menu.getLoginMenu());
        key2 = input.nextInt();
        while (key2!= 4) {
            switch (key2) {
                //-----------------------------------------------------------------------------
                case 1:
                    System.out.println("write your twitter here (at last 140 characters):");
                    String twitter = input.next();
                    System.out.println("are you sure you want to share it? press Y/y as \"yes\" and N/n as \"no\"");
                    String key3 = input.next();
                    if (key3.equals("Y") || key3.equals("y")) {
                        System.out.println(email);
                        int mine =userNumber.get(email);
                        int k=0;
                        while(myTwitter[mine][k]!=null){ k++;}
                        myTwitter[mine][k] = twitter;
                        System.out.println("your twitter just is shared");
                    } else if (key3.equals("N") || key3.equals("n")) {
                        System.out.println("your twitter has deleted");
                    }
                    System.out.println(menu.getLoginMenu());
                     key2 = input.nextInt();
                    break;
//-----------------------------------------------------------------------------------
                case 2:
                    System.out.println("you arrived as:" + email);
                    int mine = userNumber.get(email);
                    System.out.println("your twitters are:");
                    for (int i = 0; i < myTwitter[mine].length; i++) {
                        System.out.println("twitter number:" + i);
                        System.out.println(myTwitter[mine][i]);
                        System.out.println(likes[mine][i] + "♥people has liked it♥");
                    }
                    System.out.println("you are following:");
                    for (int f = 0; f < myFollowing[mine].length; f++) {
                        System.out.println(myFollowing[mine][f]);
                    }
                    System.out.println("They are following you:");
                    for (int x = 0; x < myFollowing.length; x++) {
                        for (int y = 0; y < myFollowing[0].length; y++) {
                            if (y == mine) {
                                System.out.println(getKey(userNumber, x));
                            }
                        }
                    }
                    System.out.println(menu.getLoginMenu());
                     key2 = input.nextInt();
                    break;
                //-------------------------------------------------------------------------------
                case 3:
                    ActivityMenu activity = new ActivityMenu();
                    activity.ActivityMenuFunction();
                    LoginMenu menu1=new LoginMenu();
                    key2=temp;

            }
        }
                    if (key2 == 4) {
                        System.out.println(menu.getMainMenu());
                       temp= input.nextInt();

                    }
            }
    }
