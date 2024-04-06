//package support;
//
//public class Loops {
//    public static void main(String[] args) {
//        boolean condition = true;
//        while (condition) {
//            condition = false;
//
//        }
//    }
//}

//package support;
//
//public class Loops {
//    public static void main(String[] args) throws InterruptedException {
//
//        int x = 0;
//        while (x < 100){
//            System.out.println("The value of x: " + x);
//            Thread.sleep(500);
//        }
//
//    }
//}

//package support;
//
//public class Loops {
//    public static void main(String[] args) throws InterruptedException {
//
//        int x = 0;
//        while (x < 100){
//            System.out.println("The value of x: " + x);
//            x++;
//                    }
//for (int y = 0; y < 100; y++) {
//    System.out.println("The value of y: " + y);
//        }
//String[] strings = new String[5] ;
//        strings[0] = "1";
//        strings[1] = "2";
//        strings[2] = "3";
//        strings[3] = "4";
//        strings[4] = "5";
//
//        for (int i = 0; i < strings.length; i++){
//            System.out.println("Array value: " + strings[i]);
//        }
//
//
//    }
//}

package support;

public class Loops {
    public static void main(String[] args) throws InterruptedException {

//        int x = 0;
//        while (x < 100){
//            System.out.println("The value of x: " + x);
//            x++;
//        }
//        for (int y = 0; y < 100; y++) {
//            System.out.println("The value of y: " + y);
//        }
        String[] strings = new String[5] ;
    strings[0] = "Test";
    strings[1] = "One";
    strings[2] = "Portnov";
    strings[3] = "Tech";
    strings[4] = "100";
       for (int i = 0; i < strings.length; i++) {
        if (strings[i] == "Portnov") {
        System.out.println("MATCH" + i);
    }
            }



    }
}

