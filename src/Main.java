import java.util.Scanner;
import Tools.Tools;
import Animals.*;
import Paddock.*;

public class Main {

    public static void main(String[] args) {
        run();
    } // main()

    public static void run() {
        System.out.println(Tools.strColorBlue("Le zoo ouvre ses portes ! Bienvenue."));
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

        Scanner scannerChoiceAction = new Scanner(System.in);
        Scanner scannerChoiceAnimal = new Scanner(System.in);
        Scanner scannerChoicePaddock = new Scanner(System.in);

        while (true) {
            System.out.print("\nQuel action voulez-vous faire ?\n" +
                                "\t1: Créer un animal\n" +
                                "\t2: Ajouter un enclos\n" +
                                "\tq: QUITTER\n" +
                                "\nChoix : ");

            String choiceAction = scannerChoiceAction.next();
            choiceAction = choiceAction.toLowerCase();
            switch (choiceAction) {
                case "1":
                    System.out.print("\nQuel animal voulez-vous créer ?\n" +
                                        "\t1: Aigle\n" +
                                        "\t2: Baleine\n" +
                                        "\t3: Loup\n" +
                                        "\t4: Ours\n" +
                                        "\t5: Pingouin\n" +
                                        "\t6: Poisson rouge\n" +
                                        "\t7: Requin\n" +
                                        "\t8: Tigre\n" +
                                        "\tq: QUITTER\n" +
                                        "\nChoix : ");

                    String choiceAnimal = scannerChoiceAnimal.next();
                    choiceAnimal = choiceAnimal.toLowerCase();
                    switch (choiceAnimal) {
                        case "1":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un aigle !"));
                            Tools.askAgain();
                            break;
                        case "2":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" une baleine !"));
                            Tools.askAgain();
                            break;
                        case "3":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un loup !"));
                            Tools.askAgain();
                            break;
                        case "4":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un ours !"));
                            Tools.askAgain();
                            break;
                        case "5":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un pingouin !"));
                            Tools.askAgain();
                            break;
                        case "6":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un poisson rouge !"));
                            Tools.askAgain();
                            break;
                        case "7":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un requin !"));
                            Tools.askAgain();
                            break;
                        case "8":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un tigre !"));
                            Tools.askAgain();
                            break;
                        case "q":case "quit":case "quitter":
                            Tools.exitZoo();
                            break;
                        default:
                            Tools.notProposedOption();
                            break;
                    } // switch choiceAnimal
                    break;
                case "2":
                    System.out.print("\nQuel type d'enclos voulez-vous créer ?\n" +
                                        "\t1: Enclos d'aigle\n" +
                                        "\t2: Enclos de baleine\n" +
                                        "\t3: Enclos de loup\n" +
                                        "\t4: Enclos d'ours\n" +
                                        "\t5: Enclos de pingouin\n" +
                                        "\t6: Enclos de poisson rouge\n" +
                                        "\t7: Enclos de requin\n" +
                                        "\t8: Enclos de tigre\n" +
                                        "\tq: QUITTER\n" +
                                        "\nChoix : ");

                    String choicePaddock = scannerChoicePaddock.next();
                    choicePaddock = choicePaddock.toLowerCase();
                    switch (choicePaddock) {
                        case "1":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un enclos d'aigle !"));
                            Tools.askAgain();
                            break;
                        case "2":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un enclos de baleine !"));
                            Tools.askAgain();
                            break;
                        case "3":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un enclos de loup !"));
                            Tools.askAgain();
                            break;
                        case "4":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un enclos d'ours !"));
                            Tools.askAgain();
                            break;
                        case "5":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un enclos de pingouin !"));
                            Tools.askAgain();
                            break;
                        case "6":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un enclos de poisson rouge !"));
                            Tools.askAgain();
                            break;
                        case "7":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un enclos de requin !"));
                            Tools.askAgain();
                            break;
                        case "8":
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un enclos de tigre !"));
                            Tools.askAgain();
                            break;
                        case "q":case "quit":case "quitter":
                            Tools.exitZoo();
                            break;
                        default:
                            Tools.notProposedOption();
                            break;
                    } // switch choicePaddock
                    break;
                case "q":case "quit":case "quitter":
                    Tools.exitZoo();
                    break;
                default:
                    Tools.notProposedOption();
                    break;
            } // switch choiceAction
        } // while ()
    } // run()

} // class Main