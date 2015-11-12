import Animals.Wolf;

public class Main {

    public static void main(String[] args) {
        System.out.println("Mon zoo !");
        Wolf loupGoerges = new Wolf("wolf1",true, 30000, 160, 5);
        Wolf loupMelissa = new Wolf("wolf2",false, 35000, 165, 4);
        Wolf loupKenny = new Wolf("wolf3",true, 30000, 155, 6);
        Wolf loupLynda = new Wolf("wolf3",false, 30000, 155, 6);
        loupGoerges.setNbWolf(4);

        //loupGoerges.reproduction(loupKenny);
        //loupGoerges.reproduction(loupMelissa);
        //loupLynda.reproduction(loupKenny);
        System.out.println(loupMelissa.toString());

    }
}
