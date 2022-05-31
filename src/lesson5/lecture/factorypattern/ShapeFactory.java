package lesson5.lecture.factorypattern;

import static lesson5.lecture.factorypattern.ShapeType.TRIANGLE;

/**
 * Concrete Product
 */
public abstract class ShapeFactory {
    public static Shape getShape(ShapeType name) {
        Shape shape = null;
        switch (name) {
            case TRIANGLE:
                shape = new Triangle();
                break;
            case CIRCLE:
                shape = new Circle();
                break;
            case RECTANGLE:
                shape = new Rectangle();
                break;
        }
        return shape;
    }
}