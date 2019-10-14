package databases;

import Library.User;

public class Main {
    public static void main(String[] args) {
        User currentUser=User.login();
        boolean isQuit;
        do {
            currentUser.menu();
            isQuit=currentUser.input();

        }while (!isQuit);
        System.out.println("886");
    }

    private void menu(){

    }
}
