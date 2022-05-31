package lesson5.lecture.factorypattern;

/**
 * Concrete Product
 */
public class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Triangle Drawn.");
    }
}
