package opgave8.exercise3;

import java.util.Objects;

public class Document {

    private final String title;
    private final String path;

    public Document(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }



    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Document other = (Document) obj;
        return Objects.equals(title, other.title);
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}