package lesson5.lecture.factorypattern;

/**
 * Concrete product
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle is drawn.");
    }
}