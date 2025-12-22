package opgave5.composite.exercise4;

public abstract class TreeComponent {
    private String name;

    public TreeComponent(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void add(TreeComponent o) {
        throw new UnsupportedOperationException();
    }

    public TreeComponent remove(int i) {
        throw new UnsupportedOperationException();
    }

    public void remove(TreeComponent o) {
        throw new UnsupportedOperationException();
    }

    public TreeComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
}