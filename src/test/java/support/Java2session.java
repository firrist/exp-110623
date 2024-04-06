package support;

import org.apache.xerces.impl.xs.SchemaSymbols;

import java.util.Scanner;

public class Java2session {
    public static void main(String[] args) {
        int val = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a number: ");

        try {
            val = scanner.nextInt();
        } catch (Exception ex) {
            System.out.println("Error occured.");
        }

        if (val == 0) {
            System.out.println("The value is 0");
        } else if (val < 0) {
            System.out.println("Val is negative");
        } else if (val > 0) {
            System.out.println("Val is positive.");
        }
    }
}



//package support;
//
// public class Java2session {
//    public static void main(String[] args) {
//        int val = 0;
//                Scanner scanner = new Scanner(System.in);
//        System.out.println("Provide a number: ");
//
//        try {
//            //val means value (number we are checking)
//            val = scanner.nextInt();
//        } catch (Exception ex) {
//            System.out.println("Error occured. ");
//        }
//        if (val==0){
//            System.out.println("The number is zero);
//        } else if (val > 0){
//            System.out.println("The number is positive);
//        } else if(val < 0) {
//            System.out.println("The number is negative);
//
//        }
//
//
//        else {
//            //this will be executed if non of previous conditions met
//        }
//    }
//}
//
//public static String checkNumber(int num) {
//    if (num > 0) {
//        return "Positive";
//    } else if (num < 0) {
//        return "Negative";
//    } else {
//        return "Zero";
//    }
//}