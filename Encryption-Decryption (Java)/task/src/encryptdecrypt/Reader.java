package encryptdecrypt;

import java.util.Scanner;

public class Reader {

    private static final Scanner scanner = new Scanner(System.in);
    public static String readString(){

        return scanner.nextLine();
    }

    public static int readInt(){
        return scanner.nextInt();

    }
}
