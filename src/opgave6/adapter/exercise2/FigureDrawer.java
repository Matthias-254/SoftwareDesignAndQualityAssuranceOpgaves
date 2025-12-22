package opgave6.adapter.exercise2;

import java.awt.Point;

public class FigureDrawer {

    public void drawCircle(Point centre, float radius){
        System.out.println("Drawing CIRCLE with centre " + centre + " and radius " + radius);
    }

    public void drawRectangle(Point leftup, Point rightDown){
        System.out.println("Drawing RECT with leftup " + leftup + " and rightdown " + rightDown);
    }

    public void drawTriangle(Point one, Point two, Point three){
        System.out.println("Drawing TRIANGLE with points " + one + " and " + two + " and " + three);
    }

    public void drawSquare(Point leftup,int size){
        System.out.println("Drawing SQUARE with leftup " + leftup + " and size " + size);
    }

}