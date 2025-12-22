package opgave7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Person person;

    @BeforeEach
    public void setUp() throws Exception {
        library = new Library();
        book1 = new Book("The Selfish Gene", "Richard Dawkins");
        person = new Person("Alan Turing");

        library.addBook(book1);
        library.addPatron(person);
    }

    public void addMoreBookforCertainTests() {
        book2 = new Book("1984", "George Orwell");
        book3 = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams");
        book4 = new Book("The Hobbit", "J.R.R. Tolkien");
        book5 = new Book("Effective Java", "Joshua Bloch");
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
    }

    @Test
    public void testPatronBorrowBookRosy() {
        assertEquals(book1, person.checkoutBook(book1), "null result or other book");
        assertFalse(book1.isAvailable(), "book still available");
    }

    @Test
    public void testPatronBorrowBookTwiceTheSame() {
        person.checkoutBook(book1);
        assertEquals(null, person.checkoutBook(book1));

    }

    @Test
    public void testPatronBorrowBookNotAddedBook() {
        Book notAddedBook = new Book("Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari");
        assertEquals(null, person.checkoutBook(notAddedBook));

    }

    @Test
    public void testDefaultMaxBooksRosy() {
        addMoreBookforCertainTests();
        assertEquals(3, person.getMaxBooks(), "problem with default value");
        assertEquals(book1, person.checkoutBook(book1), "problem adding first book");
        assertEquals(book2, person.checkoutBook(book2), "problem adding second book");
        assertEquals(book3, person.checkoutBook(book3), "problem adding third book");
    }

    @Test
    public void testDefaultMaxBooksNonRosy() {
        addMoreBookforCertainTests();
        assertEquals(3, person.getMaxBooks(), "problem with default value");
        assertEquals(book1, person.checkoutBook(book1), "problem adding first book");
        assertEquals(book2, person.checkoutBook(book2), "problem adding second book");
        assertEquals(book3, person.checkoutBook(book3), "problem adding third book");
        assertEquals(null, person.checkoutBook(book4), "adding fourth book succeeded!!");
    }

    @Test
    public void testCustomMaxBooksRosy() {
        addMoreBookforCertainTests();
        person.setMaxBooks(4);

        assertEquals(4, person.getMaxBooks(), "problem with setting custom value");
        assertEquals(book1, person.checkoutBook(book1), "problem adding first book");
        assertEquals(book2, person.checkoutBook(book2), "problem adding second book");
        assertEquals(book3, person.checkoutBook(book3), "problem adding third book");
        assertEquals(book4, person.checkoutBook(book4), "problem adding fourth book");
    }

    @Test
    public void testCustomMaxBooksNonRosy() {
        addMoreBookforCertainTests();
        assertEquals(3, person.getMaxBooks(), "problem with default value");
        assertEquals(book1, person.checkoutBook(book1), "problem adding first book");
        assertEquals(book2, person.checkoutBook(book2), "problem adding second book");
        assertEquals(book3, person.checkoutBook(book3), "problem adding third book");
        assertEquals(book3, person.checkoutBook(book4), "problem adding fourth book");
        assertEquals(null, person.checkoutBook(book5), "adding fifth book succeeded!!");
    }

    @Test
    public void testPatronPrint() {
        person.checkoutBook(book1);
        assertEquals("John Doe (1 out of 3 books)", person.toString());
    }

    @Test
    public void testListBooksPatron() {
        addMoreBookforCertainTests();
        person.checkoutBook(book1);
        person.checkoutBook(book2);
        assertEquals(2, person.getBooks().size());
        assertTrue(person.getBooks().contains(book1));
        assertTrue(person.getBooks().contains(book2));
    }

    @Test
    public void testAddingDuplicateBookToLibrary() {
        book2 = new Book("I, Robot", "Isaac Asimov");
        assertFalse(library.getBooks().contains(book2));
        library.addBook(book2);
        assertFalse(library.addBook(book2));
    }

    @Test
    public void testAddingBookToLibrary() {
        book2 = new Book("The Colour of Magic", "Terry Pratchett");
        assertFalse(library.getBooks().contains(book2));
        assertTrue(library.addBook(book2));
        assertTrue(library.getBooks().contains(book2));
    }

    @Test
    public void testAddingPatron() {
        Person personX = new Person("Alan Turing");
        assertFalse(library.getPatrons().contains(personX));
        assertTrue(library.addPatron(personX));
        assertTrue(library.getPatrons().contains(personX));
    }

    @Test
    public void testAddingPatronTwice() {
        Person personX = new Person("Alan Turing");
        assertFalse(library.getPatrons().contains(personX));
        assertTrue(library.addPatron(personX));
        assertFalse(library.addPatron(personX));

    }

    @Test
    public void testRemoveBook() {
        assertTrue(library.getBooks().contains(book1));
        assertTrue(library.removeBook(book1));
        assertFalse(library.getBooks().contains(book1));
    }

    @Test
    public void testRemoveNotAddedBook() {
        book2 = new Book("Night Watch", "Terry Pratchett");
        assertFalse(library.getBooks().contains(book2));
        int nrOfBooks = library.getBooks().size();
        assertFalse(library.removeBook(book2));
        assertEquals(nrOfBooks, library.getBooks().size());

    }

    @Test
    public void testRemovePatron() {
        assertTrue(library.getPatrons().contains(person));
        assertTrue(library.removePatron(person));
        assertFalse(library.getPatrons().contains(person));
    }

    @Test
    public void testRemoveNotAddedPatron() {
        Person person2 = new Person("Arthur Dent");
        assertFalse(library.getPatrons().contains(person2));
        int nrOfPatrons = library.getPatrons().size();
        assertFalse(library.removePatron(person2));
        assertEquals(nrOfPatrons, library.getPatrons().size());
    }

    @Test
    public void testAvailabilityWhenPatronBorrowsBook() {
        assertTrue(library.isBookAvailable(book1));
        person.checkoutBook(book1);
        assertFalse(library.isBookAvailable(book1));

    }

    @Test
    public void testAvailabilityWhenPatronBorrowsAndReturnsBook() {
        assertTrue(library.isBookAvailable(book1));
        person.checkoutBook(book1);
        assertFalse(library.isBookAvailable(book1));
        person.checkinBook(book1);
        assertTrue(library.isBookAvailable(book1));
    }

    @Test
    public void testAvailableBooksList() {
        book2 = new Book("So Long, and Thanks for All the Fish", "Douglas Adams");
        int nrOfBooksAvailable = library.returnAvailableBooks().size();
        library.addBook(book2);
        assertEquals(nrOfBooksAvailable + 1, library.returnAvailableBooks().size());

    }

}