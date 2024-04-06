package support;

public class VoidExample {

    private String name = "test class";
    private static final String STATIC_NAME = "test class";
    private static final double PI = 3.14;
    public static void main(String[] args) {
        Person oleg = new Person("Oleg", "Kan");
        Person anna = new Person("Anna", "Kan");

        System.out.println(oleg.fullName());
        System.out.println(anna.fullName());
        System.out.println(Person.getType());
    }

    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    private static int getAge(Person p) {
        return p.age;
    }

    static class Person {
        int age;
        String firstName;
        String lastName;

        Person (String firstName,  String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String fullName() {
            return firstName + " " + lastName;
        }

        public static String getType() {
            return "Human";
        }
    }

    static class Animal {
        public static String getType() {
            return "Animal";
        }
    }


    private void printTimeNonStatic() {
        String s1 = "";

        System.out.println("Current time: ");
        System.out.println(System.currentTimeMillis());
    }

    private static void printTime() {
        String s1 = "";

        System.out.println("Current time: ");
        System.out.println(System.currentTimeMillis());
    }

    private static void printTimeStatic() {
        System.out.println("Current time: ");
        System.out.println(getCurrentTime());
    }
}
