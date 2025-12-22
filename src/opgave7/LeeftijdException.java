package opgave7;

public class LeeftijdException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public LeeftijdException(){
        super("Leeftijd is niet correct! Deze gebruiker kan niet worden opgeslagen!");

    }
}