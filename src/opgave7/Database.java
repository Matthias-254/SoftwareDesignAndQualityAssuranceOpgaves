package opgave7;

import java.util.ArrayList;

public class Database {
    //simulatie databank
    private ArrayList<User> lijst = new ArrayList<User>();

    public boolean save(User g) {
        if (g.getName().equals(""))
            throw new NaamException();
        if (g.getAge() == 0)
            throw new LeeftijdException();
        return lijst.add(g);
    }
}