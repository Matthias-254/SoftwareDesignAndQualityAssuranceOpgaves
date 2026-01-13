package opgave8.exercise2;

public class BookDAO {

    private IConnection connection;

    public BookDAO(IConnection connection) {
        this.connection = connection;
    }

    public boolean save(Book book) {
        boolean opened = connection.open();
        if (!opened) {
            return false;
        }

        boolean inserted = connection.insert(book);
        connection.close();

        return inserted;
    }


    public Book findById(int id) {
        boolean opened = connection.open();
        if (!opened) {
            // In a real application we might throw an exception,
            // but for this exercise we just return null.
            return null;
        }

        Book result = connection.selectByID(id);
        connection.close();

        return result;
    }
}