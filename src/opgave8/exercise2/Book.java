package opgave8.exercise2;

import java.util.Objects;

public class Book {

    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id     = id;
        this.title  = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }



    @Override
    public int hashCode() {
        return Objects.hash(author, id, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(author, other.author) && id == other.id && Objects.equals(title, other.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}