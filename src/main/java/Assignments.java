public class Assignments {
    public static void main(String[] args) {
        printString();
        printInt();
        printBoolean();
        sumOfStrings();
        mathOperations();
        comparison();
        multiCompare();

    }
    public static void printString(){
        String testString = "This is our string";
        System.out.print(testString);
    }

    public static void printInt(){
        int myInt = 100;
        System.out.println(myInt);
    }

    public static void printBoolean(){
        System.out.println(true);
    }

    public static void sumOfStrings(){
        String str1="Test Automation";
        String str2="@PortnovSchool";
        System.out.println(str1+str2);
    }
    public static void mathOperations(){
        int x = 10;
        int y = 5;

        System.out.println(x+y);
        System.out.println(x-y);
        System.out.println(x*y);
        System.out.println(x/y);

    }

    public static void comparison(){
        System.out.println(2 == 2);
        System.out.println( 2 != 2);
        System.out.println(2 > 2);
        System.out.println(2 < 2);
        System.out.println(2 <= 2);
        System.out.println(2 >= 2);
    }

    public static void multiCompare(){
        System.out.println("Multi comparison ======");
        System.out.println(2 == 2 && 2 != 3);
        System.out.println(2 == 2 || 2 != 3);
    }

}
