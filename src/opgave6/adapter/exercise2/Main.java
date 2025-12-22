package opgave6.adapter.exercise2;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MainDrawer dr = new MainDrawer();
        dr.drawAllKindsOfFigures(new FigureDrawerAdapter(new FigureDrawer()));

    }

}
