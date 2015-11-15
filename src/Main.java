import java.util.Scanner;
import Animals.Bear;
import Animals.Eagle;
import Animals.Wolf;
import Paddock.Paddock;
import Paddock.Aviary;

public class Main {

    public static void main(String[] args) {
        System.out.println("Le zoo ouvre ses portes. Bienvenue !");
/*
        Wolf loupGoerges = new Wolf("wolf1",true, 30000, 160, 5);
        
        Wolf loupMelissa = new Wolf("wolf2",false, 32767, 165, 4);
        Wolf loupKenny = new Wolf("wolf3",true, 30000, 155, 6);
        Wolf loupLynda = new Wolf("wolf4",false, 30000, 155, 6);
        loupGoerges.setNbWolf(4);

        Paddock paddock1 = new Paddock("paddock1", 32, 8, "bon");
        Paddock paddock2 = new Paddock("paddock2", 32, 8, "bon");

        paddock1.add(loupMelissa);
        paddock1.add(loupLynda);
        paddock1.add(loupGoerges);
        paddock1.add(loupKenny);

        loupGoerges.reproduction(loupMelissa);
        loupLynda.reproduction(loupKenny);
        System.out.println(paddock1.toString());


        Eagle eagle1 = new Eagle("eagle1",true,12,12,2);
        Aviary aviary1 = new Aviary("aviary1",32,8,0,"bon",60);

        aviary1.add(eagle1);
        aviary1.add(loupGoerges);

        paddock1.add(loupGoerges);
        paddock1.add(eagle1);

        paddock1.move(eagle1);

        System.out.println(aviary1.toString());
        System.out.println(paddock1.toString());
*/

        boolean isZooOpened = true;
        Scanner in1 = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        while (isZooOpened) {
            boolean isAskAgain = true;
            System.out.print("\nQuel animal voulez-vous créer ?\n" +
                    "\t1: Loup\n" +
                    "\t2: Tigre\n" +
                    "\tq: QUITTER\n" +
                    "\nChoix : ");

            String choiceAnimal = in1.next();
            choiceAnimal = choiceAnimal.toLowerCase();
            switch (choiceAnimal) {
                case "1":
                    System.out.println("Vous avez \"créer\" un loup !");
                    break;
                case "2":
                    System.out.println("Vous avez \"créer\" un tigre !");
                    break;
                case "q":
                    System.out.println("Le zoo ferme ses portes. À demain ! :)");
                    isZooOpened = false;
                    isAskAgain = false;
                    break;
                default:
                    System.out.println("Cette option n'est pas proposée...");
                    break;
            } // switch

            while (isAskAgain) {
                System.out.print("\nVoulez-vous faire une autre action ? (o/n)\n");

                String choiceAgain = in2.next();
                choiceAgain = choiceAgain.toLowerCase();
                switch (choiceAgain) {
                    case "o":
                        isAskAgain = false;
                        break;
                    case "n":
                        System.out.println("Le zoo ferme ses portes. À demain ! :)");
                        isZooOpened = false;
                        isAskAgain = false;
                        break;
                    default:
                        System.out.println("Cette option n'est pas proposée...");
                        break;
                } // switch
            }
        }
    } // main()
} // class Main
