package opgave8.exercise2;

public interface IConnection {
    boolean open();

    boolean close();

    boolean insert(Book book);

    Book selectByID(int id);
}