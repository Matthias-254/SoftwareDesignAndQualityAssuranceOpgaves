package opgave4_command.exercise2;

import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {
        Farmer farmer1 = new Farmer();
        Farmer farmer2 = new Farmer();
        Soldier soldier = new Soldier();
        Sniper sniper = new Sniper();

        ArrayList<AttackCommand> list = new ArrayList<AttackCommand>();
        list.add(new FarmerAttack(farmer1));
        list.add(new FarmerAttack(farmer2));
        list.add(new SoldierAttack(soldier));
        list.add(new SniperAttack(sniper));

        for (AttackCommand a: list){
            a.fight();
        }


    }

}