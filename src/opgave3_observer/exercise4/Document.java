package opgave3_observer.exercise4;

public class Document {
    private String name;
    private int numberBytes;
    private boolean isColor;

    public Document(String name, int numberBytes, boolean isColor) {
        super();
        this.name = name;
        this.numberBytes = numberBytes;
        this.isColor = isColor;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumberBytes() {
        return numberBytes;
    }
    public void setNumberBytes(int numberBytes) {
        this.numberBytes = numberBytes;
    }
    public boolean isColor() {
        return isColor;
    }
    public void setColor(boolean isColor) {
        this.isColor = isColor;
    }

}