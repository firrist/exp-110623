import java.sql.SQLOutput;

public class JavaPractice {
    public static void main(String[] args) {
        System.out.println("This is Java practice");

        String label = "The result: ";
//        int x = 10;
//        int y = 7;
        System.out.println(label + (x()+y()));
        printResult(5, 6);


    }
    static int x() {
        return 10;
    }
    static int y() {
        return 7;
    }

    static void printResult(int x, int y){
        System.out.println(x + y);

    }
}
