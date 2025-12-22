package opgave5.composite.exercise4;

import java.util.ArrayList;
import java.util.List;

public class Location extends TreeComponent {

    private List<TreeComponent> children;

    public Location(String name) {
        super(name);
        children = new ArrayList<TreeComponent>();
    }

    public void add(TreeComponent o) {
        children.add(o);
    }

    public TreeComponent remove(int i) {
        return (TreeComponent) children.remove(i);
    }

    public void remove(TreeComponent o) {
        children.remove(o);
    }

    public TreeComponent getChild(int i) {
        return children.get(i);
    }
}