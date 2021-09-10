import java.util.Scanner;

class MainMenu extends Main {private int key;
    // Setter
    public void setKey(int c) {
        this.key = c;
    }
    // Getter
    public int getKey() {
        return key;
    }
    public  void MainMenuFunction() throws Exception {
        int j=0;
        Tools account=new Tools();
        ListOfMenues menu =new ListOfMenues();
        System.out.println("Hi! welcome to twitter");
        System.out.println(menu.getMainMenu());
        Scanner input = new Scanner(System.in);
        key = input.nextInt();
        while(key!=4){
            switch (key){
 /////////////////////////////////////////////////////////////////////////////////////////
                case 1:
                    System.out.println("create your own account");
                    System.out.println("enter your email");
                    account.setEmail(input.next());
                    if (!account.checkEmail() || emailPassword.containsKey(account.getEmail())) {
                        while (!account.checkEmail()) {
                            System.out.println("your email is not valid! try another!");
                            account.setEmail(input.next());
                        }
                    }
                    if (account.checkEmail()) {
                        System.out.println("enter your password (includes letter and digit and should be at least 6 character)");
                        account.setPassword(input.next());
                        if (!account.checkPassword()) {
                            while (!account.checkPassword()) {
                                System.out.println("your password is not valid! try another!");
                                account.setPassword(input.next());
                            }
                        }
                        if (account.checkPassword()) {
                            emailPassword.put(email,password);
                            userNumber.put(email,j);
                            j++;
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
                    Tools newAccount=new Tools();
                    Tools myAccount =new Tools();
                    //newAccount.userInformation(myAccount);
                    System.out.println(menu.getMainMenu());
                    key = input.nextInt();
                    break;

///////////////////////////////////////////////////////////////////////////////////////////////
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
                        LoginMenu login=new LoginMenu();
                        login.LoginMenuFunction();}
                        key=temp;
                        break;
//////////////////////////////////////////////////////////////////////////////////////////////
                case 3:
                    System.out.println("here you can see recent twitter(from global users):");
                            System.out.println(myTwitter);
                    System.out.println(menu.getMainMenu());
                    key = input.nextInt();
                    break;
            }
        }
        if(key==4) {
            System.out.println("hope to see you again!");}
    }
}
