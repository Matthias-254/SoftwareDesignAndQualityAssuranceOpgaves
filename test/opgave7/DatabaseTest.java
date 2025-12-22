package opgave7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private User g;
    private Database d;

    @BeforeEach
    public void setUp() throws Exception {
        g = new User();
        g.setFirstname("Alan");
        d = new Database();
    }

    @Test
    public void testLeeftijdException() {
        g.setName("Turing");
        // default leeftijd is 18
        g.setAge(0);
        // leeftijd 0 moet exception geven

        LeeftijdException ex = assertThrows(LeeftijdException.class, () -> d.save(g),
                "We verwachten een LeeftijdException");

        assertEquals("Leeftijd is niet correct! Deze gebruiker kan niet worden opgeslagen!", ex.getMessage(),
                "Foutboodschap is niet correct");
    }

    @Test
    public void testNameException() {
        // firstname = Alan, name = empty string, dit moet exception geven
        assertThrows(NaamException.class, () -> d.save(g), "@assertThrows voor NaamException");
    }

    @Test
    public void testOpslaan() {
        g.setName("Turing");
        g.setAge(41);

        assertTrue(d.save(g));
    }

}