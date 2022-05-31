package lesson5.lecture.factorypattern;

/**
 * Concrete Product
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle is drawn.");
    }
}