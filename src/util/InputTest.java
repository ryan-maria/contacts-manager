package util;

import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Input input = new Input(sc);
//        System.out.println(input.getString());
//        System.out.println(input.yesNo("Do you want to continue"));
        System.out.println(input.getInt(1, 10));

    }
}
