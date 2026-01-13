package opgave8.exercise2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.easymock.EasyMock.*;

class BookDAOTest {

    private IConnection connectionMock;
    private BookDAO dao;

    @BeforeEach
    public void setUp() {
        connectionMock = createMock(IConnection.class);
        dao = new BookDAO(connectionMock);
    }


    @Test
    public void save_ShouldOpenInsertCloseAndReturnTrue() {
        // Arrange
        Book book = new Book(1, "Dune", "Frank Herbert");



        expect(connectionMock.open()).andReturn(true);
        expect(connectionMock.insert(book)).andReturn(true);
        expect(connectionMock.close()).andReturn(true);

        replay(connectionMock);

        // Act
        boolean result = dao.save(book);

        // Assert
        assertTrue(result);
        verify(connectionMock);
    }

    @Test
    public void findById_ExistingBook_ShouldReturnBook() {
        // Arrange
        int id = 42;
        Book expectedBook = new Book(id, "Neuromancer", "William Gibson");

        expect(connectionMock.open()).andReturn(true);
        expect(connectionMock.selectByID(id)).andReturn(expectedBook);
        expect(connectionMock.close()).andReturn(true);

        replay(connectionMock);

        // Act
        Book actualBook = dao.findById(id);

        // Assert
        assertNotNull(actualBook);
        assertEquals(expectedBook, actualBook);
        verify(connectionMock);
    }

    @Test
    public void findById_NonExistingBook_ShouldReturnNull() {
        // Arrange
        int id = 99;

        expect(connectionMock.open()).andReturn(true);
        expect(connectionMock.selectByID(id)).andReturn(null);
        expect(connectionMock.close()).andReturn(true);

        replay(connectionMock);

        // Act
        Book actualBook = dao.findById(id);

        // Assert
        assertNull(actualBook);
        verify(connectionMock);
    }

    @Test
    public void save_WhenOpenFails_ShouldReturnFalseAndNotInsert() {
        // Arrange
        Book book = new Book(2, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams");

        expect(connectionMock.open()).andReturn(false);

        replay(connectionMock);

        // Act
        boolean result = dao.save(book);

        // Assert
        assertFalse(result);
        verify(connectionMock);
    }

}