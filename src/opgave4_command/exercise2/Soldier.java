package opgave4_command.exercise2;

public class Soldier {
    private int numberOfBullets;
    private float caliberOfBullets;

    public void takeRifle() {
        System.out.println("takeRifle");
    }
    public void shootRifle() {
        System.out.println("shootRifle");
    }
    public void putOnHelmet() {
        System.out.println("putOnHelmet");
    }
    public int getNumberOfBullets() {
        return numberOfBullets;
    }
    public void setNumberOfBullets(int numberOfBullets) {
        this.numberOfBullets = numberOfBullets;
    }
    public float getCaliberOfBullets() {
        return caliberOfBullets;
    }
    public void setCaliberOfBullets(float caliberOfBullets) {
        this.caliberOfBullets = caliberOfBullets;
    }
}