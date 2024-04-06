package support;

public class Test {
    public static void main(String[] args) {
        Rectangle01 rect1 = new Rectangle01(100, 50);
        rect1.width = 100;
        rect1.height = 50;
        System.out.println("Rect1 perimeter: " + rect1.getPerimeter());
        System.out.println("Rect1 area: " + rect1.getArea());

        Rectangle01 rect2 = new Rectangle01(10, 30);
        rect1.width = 10;
        rect1.height = 30;
        System.out.println("Rect2 perimeter: " + rect2.getPerimeter());
        System.out.println("Rect2 area: " + rect2.getArea());


    }
}

class Rectangle01 {
    public double width;
    public double height;

    public Rectangle01 (double width, double height) {
        this.height = height;
        this.width = width;

    }

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return 2 * (width + height);

    }
}