package opgave7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private int maxBooks;
    private List<Book> books;

    public Person(String name) {
        super();
        this.name = name;
        this.maxBooks = 3;
        this.books = new ArrayList<Book>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMaxBooks() {
        return maxBooks;
    }
    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book checkoutBook(Book book) {
        if (book.isAvailable() && (books.size()+1) != maxBooks) {
            books.add(book);
            book.setAvailable(false);
            return book;
        }
        else
            return null;
    }

    public Book checkinBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            // book.setAvailable(true);
            return book;
        }
        else
            return null;
    }
    @Override
    public String toString() {
        return name + " (" + maxBooks + " out of "+ books.size() +" books)";
    }
    @Override
    public int hashCode() {
        return Objects.hash(books, maxBooks, name);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(books, other.books) && maxBooks == other.maxBooks && Objects.equals(name, other.name);
    }

}