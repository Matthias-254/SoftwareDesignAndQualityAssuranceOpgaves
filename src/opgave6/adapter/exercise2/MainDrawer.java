package opgave6.adapter.exercise2;

import java.awt.Point;

public class MainDrawer {

    public void drawAllKindsOfFigures(IFigureDrawable drawer){
        drawer.drawCircle(new Point(1,2),15.6f);
        drawer.drawCircle(new Point(1,3),15.6f);
        drawer.drawCircle(new Point(2,2),15.6f);
        drawer.drawCircle(new Point(5,2),15.6f);
        drawer.drawCircle(new Point(2,2),15.6f);
        drawer.drawCircle(new Point(5,2),15.6f);
        drawer.drawCircle(new Point(2,2),15.6f);


        drawer.drawRectangle(new Point(1,2), 10, 50);
        drawer.drawRectangle(new Point(1,3), 10, 50);
        drawer.drawRectangle(new Point(1,5), 10, 50);
        drawer.drawRectangle(new Point(1,6), 10, 50);
        drawer.drawRectangle(new Point(2,2), 10, 50);
        drawer.drawRectangle(new Point(56,2), 10, 50);
        drawer.drawRectangle(new Point(3,2), 10, 50);
        drawer.drawRectangle(new Point(3,2), 25, 50);

        drawer.drawSquare(new Point(1,2),15);
        drawer.drawSquare(new Point(1,3),15);
        drawer.drawSquare(new Point(1,4),15);
        drawer.drawSquare(new Point(2,2),15);
        drawer.drawSquare(new Point(2,5),15);
        drawer.drawSquare(new Point(2,2),15);
        drawer.drawSquare(new Point(2,2),15);

        drawer.drawTriangle(new Point(1,2), new Point(3,5), new Point(5,5));

    }

}