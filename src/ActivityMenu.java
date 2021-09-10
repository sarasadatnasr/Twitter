import java.util.Scanner;
import java.util.HashMap;
import java.io.*;
public class ActivityMenu extends LoginMenu{
     int key4;
    // Setter
    public void setKey4(int c) {
        this.key4 = c;
    }
    // Getter
    public int getKey4() {
        return key4;
    }
public  void ActivityMenuFunction(){
    ActivityMenu activity=new ActivityMenu();
    ListOfMenues menu=new ListOfMenues();
    Scanner input=new Scanner(System.in);
    System.out.println(menu.getActivityMenu());
    System.out.println(menu.getActivityMenu());
    activity.setKey4(input.nextInt());
    while (key4!=8) {
        switch (activity.getKey4()) {
            case 1:
                System.out.println("whose twitters would you like to read?enter the email:");
                String othersEmail=input.next();
                int them=userNumber.get(othersEmail);
                for(int r=0;r<myTwitter[them].length;r++){
                    if(myTwitter[them][r]!=null){
                    System.out.println("twitter number"+r);
                    System.out.println(myTwitter[them][r]);
                    System.out.println(likes[them][r] + "♥people has liked it♥");
                    System.out.println("people replies are:");
                    for(int g=0;g<replies[them][r].length;g++){
                        System.out.println(g+":"+replies[them][r][g]);
                    }
                    }
                }
                System.out.println(menu.getActivityMenu());
                key4=input.nextInt();
                break;
            case 2:
                System.out.println("enter email of whom you want to follow:");
                String follower = input.next();
                if (emailPassword.containsKey(follower)) {
                   int mine = userNumber.get(email);
                   int v=0;
                   while (!myFollowing[mine][v].equals("")){v++;}
                    myFollowing[mine][v] = follower;

                    System.out.println(follower + "added to your followers");
                } else {
                    System.out.println("not found");
                }
                System.out.println(menu.getActivityMenu());
                key4= input.nextInt();
                break;
            case 3:
                System.out.println("enter email of whom you want to Unfollow:");
                String unfollow = input.next();
                int mine = userNumber.get(email);
                for (int a = 0; a < myFollowing[mine].length; a++) {
                    if (myFollowing[mine][a].equals(unfollow)) {
                        myFollowing[mine][a] = "";
                        System.out.println("you have unfollowed:" + unfollow);
                    } else if (!myFollowing[mine][a].equals(unfollow) && a == myFollowing[mine].length - 1) {
                        System.out.println("you didnt follow:" + unfollow);
                    }
                }
                System.out.println(menu.getActivityMenu());
                key4=input.nextInt();
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
                key4=input.nextInt();
                break;

            case 5:
                System.out.println("enter email of twitters writer:");
                String heremail = input.next();
                int her = userNumber.get(heremail);
                System.out.println("enter number of twitter:");
                int num = input.nextInt();
                likes[her][num]++;
                System.out.println("♥you liked it♥");
                System.out.println(menu.getActivityMenu());
                key4=input.nextInt();
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
                System.out.println("your reply just sent");}
                    }
                System.out.println("your reply has saved");
                System.out.println(menu.getActivityMenu());

                break;

            case 7:
                System.out.println("enter email of twitters writer for retweet:");
                String her2 = input.next();
                int her3=userNumber.get(her2);
                System.out.println("enter number of twitter:");
                int num2 = input.nextInt();
                int mine1=userNumber.get(email);
                for(int u=0;u<myTwitter[mine1].length;u++){
                   if(myTwitter[mine1][u]==null ){
                       myTwitter[mine1][u]=myTwitter[her3][num2];
                       System.out.println("Done!");
                   }
                }
               break;
        }
    }
    if (key4==8) {
        System.out.println(menu.getLoginMenu());
        temp=input.nextInt();
    }
}
}


