import Animals.Bear;
import Animals.Wolf;
import Paddock.Paddock;

public class Main {

    public static void main(String[] args) {
        System.out.println("Mon zoo !");
        Wolf loupGoerges = new Wolf("wolf1",true, 30000, 160, 5);
        Wolf loupMelissa = new Wolf("wolf2",false, 35000, 165, 4);
        Wolf loupKenny = new Wolf("wolf3",true, 30000, 155, 6);
        Wolf loupLynda = new Wolf("wolf4",false, 30000, 155, 6);
        loupGoerges.setNbWolf(4);

        Bear ours1 = new Bear("ours1",true,30000,160,5);
        ours1.setNbBear(1);
        Paddock paddock1 = new Paddock("paddock1", 32,8,"bon");
        Paddock paddock2 = new Paddock("paddock2", 28, 8, "bon");

        //loupGoerges.reproduction(loupKenny);
        //loupGoerges.reproduction(loupMelissa);
        //loupLynda.reproduction(loupKenny);
        paddock1.add(loupGoerges);
        paddock1.add(loupMelissa);
        paddock1.add(loupKenny);
        paddock1.restockFood(100);
        loupGoerges.setHungerIndicator(30);
        loupMelissa.setHungerIndicator(60);
        loupKenny.setHungerIndicator(50);
        loupGoerges.eat();
        loupMelissa.eat();
        loupKenny.eat();
        System.out.println(paddock1.toString());

    }
}
