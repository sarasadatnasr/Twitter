import java.util.Scanner;
import java.util.HashMap;
import java.io.*;
class Main extends Methods {
    public static void main(String[] args){
        HashMap<String, String> emailPassword= new HashMap<String, String>();
        HashMap<String,Integer> userNumber = new HashMap<String,Integer>();
        String[][] myFollowing=new String[20][20];
        String[][] myTwitter=new String[20][20];
        String[][][] replies=new String[20][20][6];
        int[][] likes=new int[20][20];
        int j=0,k=0,v=0;
        Menu menu =new Menu();
        String email="";String password ="";String bio="";
        System.out.println("Hi! welcome to twitter");
        System.out.println(menu.getMainMenu());
        Scanner input = new Scanner(System.in);
        int key = input.nextInt();
        while(key!=4){
        switch (key){
 ////////////////////////////////////////////////////////////////////////////////////////////////////////
           case 1:
                    System.out.println("create your own account");
                    System.out.println("enter your email");
                      email = input.next();
                     Account account=new Account();
                     account.setEmail(email);
                    if (!account.checkEmail() || emailPassword.containsKey(email)) {
                        while (!account.checkEmail()) {
                            System.out.println("your email is not valid! try another!");
                            email = input.next();
                         account.setEmail(email);
                        }
                    }
                    if (account.checkEmail()) {
                        System.out.println("enter your password (includes letter and digit and should be at least 6 character)");
                        password = input.next();
                        account.setPassword(password);
                        if (!account.checkPassword()) {
                            while (!account.checkPassword()) {
                                System.out.println("your password is not valid! try another!");
                                password = input.next();
                            }
                        }
                        if (account.checkPassword()) {
                            emailPassword.put(email,password);
                            j++;k=0;v=0;
                            emailPassword.put(email,password);
                            userNumber.put(email,j);
                            System.out.println("Do you desire to set any bio ?");
                            System.out.println("press Y/y as \"yes\" and N/n as \"No\"");
                            String key1 = input.next();
                            if (key1.equals("Y") || key1.equals("y")) {
                                System.out.println("enter your biography:");
                                 bio = input.next();
                                account.setBio(bio);
                                if (!account.checkBio()) {
                                    while (!account.checkBio()) {
                                        System.out.println("your biography is too long! try another!");
                                        bio = input.next();
                                    }
                                } else {
                                    //Users Account(email,password,bio)=new
                                    System.out.println("your biography has saved successfully!");
                                }
                            }
                            if (key1.equals("N") || key1.equals("n")) {
                                System.out.println("ok!you can adjust your bio any other time");
                            }
                        }

                    }

                System.out.println("congratulation! your account has been made");
                    Account newAccount=new Account();
                    Account myAccount =new Account();
                    myAccount.setEverything(email,password,bio);
                    newAccount.userInformation(myAccount);
                System.out.println(menu.getMainMenu());
                key = input.nextInt();
                break;
 //////////////////////////////////////////////////////////////////////////////////////////////////////
            case 2:
            System.out.println("enter your email:");
            email = input.next();
            if(!emailPassword.containsKey(email)){
                while(!emailPassword.containsKey(email)){
                    System.out.println("this email doesnt exist!try again");
                    System.out.println("enter another email:");
                    email = input.next();
                }
            }
            if(emailPassword.containsKey(email)){
            System.out.println("enter yor password:");
            password = input.next();
                if (!Check(email,password,emailPassword)){
            while(!Check(email,password,emailPassword)){
                System.out.println("wrong password !try again");
                System.out.println("enter your password:");
                password = input.next();}
            }}
                if(Check(email,password,emailPassword)) {
                    System.out.println("welcome to your account!");
                    System.out.println(menu.getLoginMenu());
                    int key2 = input.nextInt();
                    while (key2 != 4) {
                        switch (key2) {
 //-----------------------------------------------------------------------------------------------
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
                                System.out.println(menu.getLoginMenu());
                                 key2 = input.nextInt();
                                break;
 //--------------------------------------------------------------------------------------
                            case 2:
                                System.out.println("you arrived as:"+email);
                                int mine = userNumber.get(email);
                                System.out.println("your twitters are:");
                                for (int i = 0; i < myTwitter[mine].length; i++) {
                                  System.out.println("twitter number:" + i);
                                  System.out.println(myTwitter[mine][i]);
                                  System.out.println(likes[mine][i] + "♥people has liked it♥");
                                }
                                System.out.println("you are following:");
                                for(int f=0;f<myFollowing[mine].length;f++){
                                    System.out.println(myFollowing[mine][f]);
                                }
                                System.out.println("They are following you:");
                                for(int x=0;x<myFollowing.length;x++) {
                                    for (int y = 0; y < myFollowing[0].length; y++) {
                                        if (y == mine) {
                                            System.out.println(getKey(userNumber, x));
                                        }
                                    }
                                }
                            System.out.println(menu.getLoginMenu());
                            key2 = input.nextInt();
                            break;
//-------------------------------------------------------------------------------------------
                        case 3:
                            System.out.println(menu.getActivityMenu());
                            int key4 = input.nextInt();
                            while (key4 != 9) {
                            switch (key4) {
                            case 1:
                            System.out.println("whose twitters would you like to read?enter the email:");
                            String othersEmail=input.next();
                            int them=userNumber.get(othersEmail);
                            for(int r=0;r<myTwitter[them].length;r++){
                                System.out.println("twitter number"+r);
                                System.out.println(myTwitter[them][r]);
                                System.out.println(likes[them][r] + "♥people has liked it♥");
                            }
                                System.out.println(menu.getActivityMenu());
                                key4 = input.nextInt();
                            break;
                            case 2:
                                System.out.println("enter email of whom you want to follow:");
                                String follower = input.next();
                                if (emailPassword.containsKey(follower)) {
                                    mine = userNumber.get(email);
                                    myFollowing[mine][v] = follower;
                                    v++;
                                    System.out.println(follower + "added to your followers");
                                } else {
                                    System.out.println("not found");
                                }
                                System.out.println(menu.getActivityMenu());
                                key4 = input.nextInt();
                                break;
                                case 3:
                                    System.out.println("enter email of whom you want to Unfollow:");
                                    String unfollow = input.next();
                                     mine = userNumber.get(email);
                                    for (int a = 0; a < myFollowing[mine].length; a++) {
                                        if (myFollowing[mine][a].equals(unfollow)) {
                                            myFollowing[mine][a] = "";
                                            System.out.println("you have unfollowed:" + unfollow);
                                        } else if (!myFollowing[mine][a].equals(unfollow) && a == myFollowing[mine].length - 1) {
                                            System.out.println("you didnt follow:" + unfollow);
                                        }
                                    }
                                    System.out.println(menu.getActivityMenu());
                                    key4 = input.nextInt();
                                    break;

                                case 4:
                                    System.out.println("enter email of whom you want to block:");
                                    String blocked = input.next();
                                    mine = userNumber.get(email);
                                    for (int a = 0; a < myFollowing[mine].length; a++) {
                                        if (myFollowing[mine][a].equals(blocked)) {
                                            myFollowing[mine][a] = "";
                                            System.out.println("you have blocked:" + blocked);
                                        } else if (!myFollowing[mine][a].equals(blocked) && a == myFollowing[mine].length - 1) {
                                            System.out.println("you had blocked:" + blocked);
                                        }
                                    }
                                    System.out.println(menu.getActivityMenu());
                                    key4 = input.nextInt();
                                    break;

                                case 5:
                                    System.out.println("enter email of twitters writer:");
                                    String heremail = input.next();
                                    int her = userNumber.get(heremail);
                                    System.out.println("enter number of twitter:");
                                    int num = input.nextInt();
                                    likes[her][num]++;
                                    System.out.println(menu.getActivityMenu());
                                    key4 = input.nextInt();
                                    break;

                                case 6:
                                    System.out.println("enter email of twitters writer:");
                                    String heremail1 = input.next();
                                    int her1 = userNumber.get(heremail1);
                                    System.out.println("enter number of twitter:");
                                    int num1 = input.nextInt();
                                    System.out.println("enter which you want to reply:");
                                    String comment=input.next();
                                    for(int counter=0;counter<5;counter++){
                                        if(replies[her1][num1][counter].equals("")){
                                            replies[her1][num1][counter]=comment;
                                        }}
                                    System.out.println("your reply has saved");
                                    System.out.println(menu.getActivityMenu());
                                    key4 = input.nextInt();
                                    break;

                                case 7:
                                case 8:









                            }}
                                if (key4 == 9) {
                                    System.out.println(menu.getLoginMenu());
                                    key2=input.nextInt();}}}

 //------------------------------------------------------------------------------
                    if (key2 == 4) {
                        System.out.println(menu.getMainMenu());
                        key = input.nextInt();
                    }
                }
         break;
///////////////////////////////////////////////////////////////////////////////////////
            case 3:
                System.out.println("here you can see recent twitter(from global users):");
                   for (int p = 0; p < myTwitter.length; p++) {
                      for (int i = 0; i < myTwitter[0].length; i++) {
                          String writer = getKey(userNumber, p);
                          System.out.println("twitt number" + i + ":");
                          System.out.println("is written by:" + writer);
                          System.out.println(myTwitter[p][i]);
                          System.out.println(likes[p][i] + "֎people has liked this twitter ♥");
                      }
                   }

                            System.out.println(menu.getMainMenu());
                            key = input.nextInt();
                            break;

                }
        }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(key==4) {
        System.out.println("hope to see you again!");}
    }}













