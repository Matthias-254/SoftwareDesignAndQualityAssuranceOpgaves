package opgave2_strategy.exercise2;

public abstract class Character {
    protected WeaponBehavior weapon;
    private String name;

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void useWeapon() {
        System.out.print("I'm a " + getClass().getSimpleName() + " and I'm ");
        weapon.fight();
    }

    public static void main(String[] args) {
        King king = new King();
        Dwarf dwarf = new Dwarf();
        Elf elf = new Elf();
        Hobbit hobbit = new Hobbit();

        king.useWeapon();
        dwarf.useWeapon();
        elf.useWeapon();
        hobbit.useWeapon();

        king.setWeapon(new Axe());
        king.useWeapon();
    }
}
