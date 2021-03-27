import sun.security.util.Password;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
class Main extends SignUp{
    public static void main(String[] args){
        HashMap<String, String> emailPassword= new HashMap<String, String>();
        HashMap<String,Integer> userNumber = new HashMap<String,Integer>();
        String[][] myFollower=new String[20][20];
        String[][] myTwitter=new String[20][20];
        int[][] likes=new int[20][20];
        int j=0,k=0,v=0;

        String email="";String password ="";
        System.out.println("Hi! welcome to twitter");
        MainMenu();
        Scanner input = new Scanner(System.in);
        int key = input.nextInt();
        while(key!=4){
        switch (key){
            case 1:
                    System.out.println("create your own account");
                    System.out.println("enter your email");
                     email = input.next();
                    if (!Email(email) || emailPassword.containsKey(email)) {
                        while (!Email(email)) {
                            System.out.println("your email is not valid! try another!");
                            email = input.next();
                        }
                    }
                    if (Email(email)) {
                        System.out.println("enter your password (includes letter and digit and should be at least 6 character)");
                        password = input.next();
                        if (!Password(password)) {
                            while (!Password(password)) {
                                System.out.println("your password is not valid! try another!");
                                password = input.next();
                            }
                        }
                        if (Password(password)) {
                            emailPassword.put(email,password);
                            j++;k=0;v=0;
                            emailPassword.put(email,password);
                            userNumber.put(email,j);
                            System.out.println("Do you desire to set any bio ?");
                            System.out.println("press Y/y to sign yes and N/n to sign No");
                            String key1 = input.next();
                            if (key1.equals("Y") || key1.equals("y")) {
                                System.out.println("enter your biography:");
                                String bio = input.next();
                                if (Bio(bio)) {
                                    System.out.println("your biography has saved successfully!");
                                } else {
                                    while (!Bio(bio)) {
                                        System.out.println("your biography is too long! try another!");
                                        bio = input.next();
                                    }
                                }
                            }
                            if (key1.equals("N") || key1.equals("n")) {
                                System.out.println("ok!you can adjust your bio any other time");
                            }
                        }

                    }

                System.out.println("congratulation! your account has been made");
                    MainMenu();
                key = input.nextInt();
                break;
 //////////////////////////////////////////////////////////////////////////////////////////////////////
            case 2:
            System.out.println("enter your email:");
            email = input.next();
                System.out.println("enter yor password:");
            password = input.next();
                if (!Check(email,password,emailPassword)){
            System.out.println("wrong password or email!try again");
            while(!Check(email,password,emailPassword)){
                System.out.println("enter your email:");
                email = input.next();
                System.out.println("enter your password:");
                password = input.next();}
            }
                if(Check(email,password,emailPassword)) {
                    System.out.println("welcome to your account!");
                    LoginMenu();
                    int key2 = input.nextInt();
                    while (key2 != 4) {
                        switch (key2) {
                            case 1:
                                System.out.println("write your twitter here (at last 140 characters):");
                                String twitter = input.next();
                                System.out.println("are you sure you want to share it? press Y/y as \"yes\" and N/n as \"no\"");
                                String key3 = input.next();
                                if (key3.equals("Y") || key3.equals("y")) {
                                    int mine = userNumber.get(email);
                                    myTwitter[mine][k] = twitter;
                                    k++;
                                    System.out.println("your twitter just is shared");
                                } else if (key3.equals("N") || key3.equals("n")) {
                                    System.out.println("your twitter is deleted");
                                }
                                break;
                            case 2:
                                int mine = userNumber.get(email);
                                System.out.println("your twitters are:");
                                for (int i = 0; i < myTwitter[mine].length; i++) {
                                    if (!myTwitter[mine][i].equals(null)) {
                                        System.out.println("twitter number:" + i);
                                        System.out.println(myTwitter[mine][i]);
                                    }
                                    System.out.println(likes[mine][i] + "♥people has liked it♥");
                                }
                                break;
                        }
                        LoginMenu();
                        key2 = input.nextInt();
                    }
                    if (key2 == 4) {
                        MainMenu();
                        key = input.nextInt();
                        break;
                    }
                }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case 3:
                        System.out.println("here you can see recent twiits(from global users):");
                        for (int p = 0; p < myTwitter.length; p++) {
                            for (int i = 0; i < myTwitter[0].length; i++) {
                                String writer = getKey(userNumber, myTwitter[p][i]);
                                System.out.println("֎twitt number" + i + ":");
                                System.out.println("֎is written by:" + writer);
                                System.out.println(myTwitter[p][i]);
                                System.out.println(likes[p][i] + "֎people has liked this twitt ♥");
                            }
                        }
                        ActivityMenu();
                        int key4 = input.nextInt();
                        while (key4 != 4) {
                            switch (key4) {
                                case 1:
                                    System.out.println("enter email of whom you want to follow:");
                                    String follower = input.next();
                                    if (emailPassword.containsKey(follower)) {
                                        int mine = userNumber.get(email);
                                        myFollower[mine][v] = follower;
                                        v++;
                                        System.out.println(follower + "added to your followers");
                                    } else {
                                        System.out.println("not found");
                                    }
                                case 2:
                                    System.out.println("enter email of whom you want to Unfollow:");
                                    String unfollow = input.next();
                                    int mine = userNumber.get(email);
                                    for (int a = 0; a < myFollower[mine].length; a++) {
                                        if (myFollower[mine][a].equals(unfollow)) {
                                            myFollower[mine][a] = "";
                                            System.out.println("you have unfollowed:" + unfollow);
                                        } else if (myFollower[mine][a].equals(unfollow) && a == myFollower[mine].length - 1) {
                                            System.out.println("you didnt follow:" + unfollow);
                                        }
                                    }
                                case 3:
                                    System.out.println("enter email of twitters writer:");
                                    String heremail = input.next();
                                    int her = userNumber.get(heremail);
                                    System.out.println("enter number of twitter:");
                                    int num = input.nextInt();
                                    likes[her][num]++;
                            }
                            ActivityMenu();
                            key4 = input.nextInt();
                        }

                        if (key4 == 4) {
                            MainMenu();
                            key = input.nextInt();
                            break;
                        }
                }
        }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(key==4) {
        System.out.println("hope to see you again!");}
    }}













