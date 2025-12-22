package opgave4_command.exercise2;

public class Sniper {
    private int scopeMagnification;
    float caliberOfBullets;

    public void aim() {
        System.out.println("aim");
    }

    public void shoot() {
        System.out.println("shoot");
    }

    public int getScopeMagnification() {
        return scopeMagnification;
    }

    public void setScopeMagnification(int scopeMagnification) {
        this.scopeMagnification = scopeMagnification;
    }

    public float getCaliberOfBullets() {
        return caliberOfBullets;
    }

    public void setCaliberOfBullets(float caliberOfBullets) {
        this.caliberOfBullets = caliberOfBullets;
    }
}