

import java.util.Scanner;

public class Main {
    public static final boolean fullSpeed = false;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password - ");
        String password = scanner.nextLine();
        for(int i = 0; i < 50;i++)
        {
            System.out.println("");
        }
        String crackedPass = "";
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < password.length();i++) {
            for (int j = 32; j < 127; j++) {
                char ch = (char) j;
                if (ch == password.charAt(i)) {
                    crackedPass += ch;
                    System.out.println(ANSI_GREEN + crackedPass + ANSI_RESET);
                    if (!fullSpeed) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
                else
                {
                    System.out.println(ANSI_GREEN + crackedPass +ANSI_RED+ch+ ANSI_RESET);
                }
                if (!fullSpeed) {
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        long currentTime = System.currentTimeMillis();
        long timeTaken = currentTime-startTime;
        System.out.println(ANSI_GREEN+"Code - " +ANSI_BLUE+ password + ANSI_GREEN+" || Cracked Code - " +ANSI_PURPLE+ crackedPass +ANSI_GREEN+ " || Time taken - " + timeTaken + " ms"+ANSI_RESET);
    }


}
