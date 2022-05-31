package lesson5.lecture.factorypattern;

/**
 * Client
 */
public class Main {
    public static void main(String[] args) {
        //requests for circle shape
        Shape circle = ShapeFactory.getShape(ShapeType.CIRCLE);
        circle.draw();

        //requests for rectangle shape
        Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
        circle.draw();


    }
}
