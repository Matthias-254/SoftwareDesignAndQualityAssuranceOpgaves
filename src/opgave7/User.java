package opgave7;

public class User {
    private String name;
    private String firstname;
    private int age
            ;

    public User(){
        name = "";
        firstname = "";
        age = 18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}