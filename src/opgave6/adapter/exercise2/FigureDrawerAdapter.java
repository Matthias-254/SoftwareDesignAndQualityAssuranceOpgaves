package opgave6.adapter.exercise2;

import java.awt.Point;;

public class FigureDrawerAdapter implements IFigureDrawable {

    private FigureDrawer figureDrawer;

    public FigureDrawerAdapter(FigureDrawer figureDrawer) {
        super();
        this.figureDrawer = figureDrawer;
    }

    @Override
    public void drawCircle(Point centre, float diameter) {
        // TODO Auto-generated method stub
        figureDrawer.drawCircle(centre, diameter/2);
    }

    @Override
    public void drawRectangle(Point leftup, int height, int width) {
        // TODO Auto-generated method stub
        figureDrawer.drawRectangle(leftup, new Point(leftup.x+width,leftup.y+height));
    }

    @Override
    public void drawTriangle(Point one, Point two, Point three) {
        // TODO Auto-generated method stub
        figureDrawer.drawTriangle(one, two, three);

    }

    @Override
    public void drawSquare(Point rightup, int size) {
        // TODO Auto-generated method stub
        figureDrawer.drawSquare(new Point(rightup.x - size,rightup.y), size);
    }

}