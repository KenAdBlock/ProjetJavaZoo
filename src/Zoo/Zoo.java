package Zoo;

import Animals.*;
import Employee.Employee;
import java.util.ArrayList;
import java.util.Scanner;

import Paddock.Paddock;
import Paddock.Aquarium;
import Paddock.Aviary;
import Species.Animal;
import Tools.Tools;

import javax.tools.Tool;

/**
 * Created by Darkweizer on 15/11/2015.
 */
public class Zoo {

    private String name;
    private Employee employee;
    private int maxNbPaddock;
    private static ArrayList<Paddock> listPaddock = new ArrayList<>();
    private static ArrayList<ArrayList<Animal>> totalAnimal = new ArrayList<>();

    private Zoo(String name, Employee employee, int maxNbPaddock) {
        this.name = name;
        this.employee = employee;
        this.maxNbPaddock = maxNbPaddock;
    }

    private static Zoo INSTANCE = new Zoo("Ho Land", Employee.getINSTANCE(), 10);

    public static Zoo getINSTANCE() {
        return INSTANCE;
    }

    public static ArrayList<Paddock> getListPaddock() {
        return listPaddock;
    }

    public static ArrayList<ArrayList<Animal>> getTotalAnimal() {
        return totalAnimal;
    }

    public void showNbTotalAnimal(){
        int cpt = 0;
        for(ArrayList<Animal> a : totalAnimal){
            for(Animal a1 : a){
                ++cpt;
            }
        }
        System.out.println("Le nombre d'animal présent dans le zoo est de " + cpt);
    }

    public void showTotalAnimal(){
        int cpt = 0;
        for(ArrayList<Animal> a : totalAnimal){
            for(Animal a1 : a){
                System.out.print(a1.getName() + " ");
                ++cpt;
                if (cpt == 10){
                    cpt = 0;
                    System.out.println("");
                }
            }
        }
    }

    public void showAllPaddock(){
        System.out.println("\nListe de tout les enclos, avec les animaux présents à l'intérieur : ");
        for(Paddock p : listPaddock){
            System.out.println("\t" + p.toString());
        }
    }

    public void run() {

/*      Wolf loupGoerges = new Wolf("wolf1",true, 30000, 160, 5);

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
        boolean isPaddockFill = false;
        boolean isPaddockCreated = false;
        boolean isAnimalCreated = false;
        boolean isWolf = false;
        boolean isBear = false;
        boolean isTiger = false;
        boolean isEagle = false;
        boolean isRazobill = false;
        boolean isShark = false;
        boolean isWhale = false;
        boolean isRedFish = false;

        while (true) {
            if(isPaddockCreated && !isAnimalCreated)
                System.out.print("Quel action voulez-vous faire ?\n" +
                                    "\t1: Créer un enclos\n" +
                                    "\t2: Créer un animal\n" +
                                    "\tq: QUITTER (ZOO)\n" +
                                    "\nChoix : ");
            else if(isAnimalCreated)
                System.out.print("Quel action voulez-vous faire ?\n" +
                                    "\t1: Créer un enclos\n" +
                                    "\t2: Créer un animal\n" +
                                    "\t3: Gérer le zoo en tant qu'employé\n" +
                                    "\tq: QUITTER (ZOO)\n" +
                                    "\nChoix : ");
            else
                System.out.print("\nQuel action voulez-vous faire ?\n" +
                                    "\t1: Créer un enclos\n" +
                                    "\tq: QUITTER (ZOO)\n" +
                                    "\nChoix : ");

            String choiceAction = scannerChoiceAction.next();
            choiceAction = choiceAction.toLowerCase();
            boolean isNotFinishChoiceMenuMain = true;
            switch (choiceAction) {
                case "1":
                    while(isNotFinishChoiceMenuMain){
                        System.out.print("\nQuel type d'enclos voulez-vous créer ?\n" +
                                            "\t1: Enclos (classique)\n" +
                                            "\t2: Aquarium\n" +
                                            "\t3: Volière\n" +
                                            "\tq: QUITTER (CHOIX)\n" +
                                            "\nChoix : ");

                        String choicePaddock = scannerChoicePaddock.next();
                        choicePaddock = choicePaddock.toLowerCase();
                        switch (choicePaddock) {
                            case "1":case "enclos":
                                Paddock paddock = new Paddock("paddock"+(Paddock.getNbPaddock()+1), Tools.random(40, 500),Tools.random(3,20),"bon");
                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un enclos classique !"));
                                this.showAllPaddock();
                                isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                if (isPaddockFill) {
                                    boolean isNotFinishChoiceAnimal = true;
                                    while(isNotFinishChoiceAnimal){
                                        isPaddockFill = false;
                                        System.out.print("Pour cet enclos, voici les animaux que vous pouvez créer : \n" +
                                                        "\t1: Loup\n" +
                                                        "\t2: Ours\n" +
                                                        "\t3: Tigre\n" +
                                                        "\tq: QUITTER (CHOIX)\n" +
                                                        "\nChoix : ");
                                        String choiceAnimal = scannerChoiceAnimal.next();
                                        choiceAnimal = choiceAnimal.toLowerCase();
                                        switch (choiceAnimal) {
                                            case "1":case "loup":
                                                do {
                                                    Wolf wolf = new Wolf("wolf"+(Wolf.getNbWolf()+1),(Tools.random(0,2) != 0), Tools.random(25,50), Tools.random(80, 120), Tools.random(2,15));
                                                    Wolf.setNbWolf(Wolf.getNbWolf() + 1);
                                                    paddock.add(wolf);
                                                    System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un loup !"));
                                                    System.out.println(wolf.toString());
                                                    if(paddock.getHereNbAnimals()!= paddock.getMaxNbAnimals())
                                                        isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                }while(isPaddockFill && paddock.getHereNbAnimals()< paddock.getMaxNbAnimals());
                                                scannerChoiceAnimal.nextLine();
                                                isNotFinishChoiceMenuMain = false;
                                                isNotFinishChoiceAnimal = false;
                                                break;
                                            case "2":case "ours":
                                                do {
                                                    Bear bear = new Bear("bear"+(Bear.getNbBear()+1), (Tools.random(0,2) != 0), Tools.random(10000,50000), Tools.random(120, 150), Tools.random(2,15));
                                                    Bear.setNbBear(Bear.getNbBear() + 1);
                                                    paddock.add(bear);
                                                    System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un ours !"));
                                                    System.out.println(bear.toString());
                                                    if(paddock.getHereNbAnimals()!= paddock.getMaxNbAnimals())
                                                        isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                }while(isPaddockFill && paddock.getHereNbAnimals()< paddock.getMaxNbAnimals());
                                                scannerChoiceAnimal.nextLine();
                                                isNotFinishChoiceMenuMain = false;
                                                isNotFinishChoiceAnimal = false;
                                                break;
                                            case "3":case "tigre":
                                                do {
                                                    Tiger tiger = new Tiger("tiger"+(Tiger.getNbTiger()+1), (Tools.random(0,2) != 0), Tools.random(10000,25000), Tools.random(120, 150), Tools.random(2,15));
                                                    Tiger.setNbTiger(Tiger.getNbTiger() + 1);
                                                    paddock.add(tiger);
                                                    System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un tigre !"));
                                                    System.out.println(tiger.toString());
                                                    if(paddock.getHereNbAnimals()!= paddock.getMaxNbAnimals())
                                                        isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                }while(isPaddockFill && paddock.getHereNbAnimals()< paddock.getMaxNbAnimals());
                                                scannerChoiceAnimal.nextLine();
                                                isNotFinishChoiceMenuMain = false;
                                                isNotFinishChoiceAnimal = false;
                                                break;
                                            case "q":case "quit":case "quitter":case "exit":
                                                isNotFinishChoiceAnimal = false;
                                                scannerChoiceAnimal.nextLine();
                                                break;
                                            default:
                                                Tools.notProposedOption();
                                                scannerChoiceAnimal.nextLine();
                                                break;
                                        }
                                    }//while(isNotFinishChoiceAnimal)
                                }
                                scannerChoicePaddock.nextLine();
                                break;
                            case "2":case "aquarium":
                                Aquarium aquarium = new Aquarium("aquarium"+(Aquarium.getNbAquarium()+1), Tools.random(40, 500),Tools.random(3,20),"bon", Tools.random(10, 50), 50);
                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un aquarium !"));
                                this.showAllPaddock();
                                isPaddockFill =  Tools.askPaddockFill(isPaddockFill);
                                if (isPaddockFill) {
                                    boolean isNotFinishChoiceAnimal = true;
                                    while(isNotFinishChoiceAnimal){
                                        isPaddockFill = false;
                                        System.out.print("Pour cet aquarium, voici les animaux que vous pouvez créer : \n" +
                                                "\t1: Baleine\n" +
                                                "\t2: Pingouin\n" +
                                                "\t3: Poisson (rouge)\n" +
                                                "\t4: Requin\n" +
                                                "\tq: QUITTER (CHOIX)\n" +
                                                "\nChoix : ");
                                        String choiceAnimal = scannerChoiceAnimal.next();
                                        choiceAnimal = choiceAnimal.toLowerCase();
                                        switch (choiceAnimal) {
                                            case "1":case "baleine":
                                                do {
                                                    Whale whale = new Whale("whale"+(Whale.getNbWhale()+1), (Tools.random(0,2) != 0), Tools.random(150000000,170000000), Tools.random(2500, 3300), Tools.random(2,15));
                                                    Whale.setNbWhale(Whale.getNbWhale() + 1);
                                                    aquarium.add(whale);
                                                    System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un baleine !"));
                                                    System.out.println(whale.toString());
                                                    if(aquarium.getHereNbAnimals()!= aquarium.getMaxNbAnimals())
                                                        isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                }while(isPaddockFill && aquarium.getHereNbAnimals()< aquarium.getMaxNbAnimals());
                                                scannerChoiceAnimal.nextLine();
                                                isNotFinishChoiceMenuMain = false;
                                                isNotFinishChoiceAnimal = false;
                                                break;
                                            case "2":case "pingouin":
                                                do {
                                                    Razorbill razorbill = new Razorbill("razorbile"+(Razorbill.getNbRazorbill()+1),(Tools.random(0,2) != 0), Tools.random(20000,30000), Tools.random(80, 120), Tools.random(2,15));
                                                    Razorbill.setNbRazorbill(Razorbill.getNbRazorbill() + 1);
                                                    aquarium.add(razorbill);
                                                    System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un pingouin !"));
                                                    System.out.println(razorbill.toString());
                                                    if(aquarium.getHereNbAnimals()!= aquarium.getMaxNbAnimals())
                                                        isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                }while(isPaddockFill && aquarium.getHereNbAnimals()< aquarium.getMaxNbAnimals());
                                                scannerChoiceAnimal.nextLine();
                                                isNotFinishChoiceMenuMain = false;
                                                isNotFinishChoiceAnimal = false;
                                                break;
                                            case "3":case "poisson":
                                                do {
                                                    RedFish redFish = new RedFish("redfish"+(RedFish.getNbRedfish()+1),(Tools.random(0,2) != 0), Tools.random(15,40), Tools.random(5, 20), Tools.random(2,8));
                                                    RedFish.setNbRedFish(RedFish.getNbRedfish() + 1);
                                                    aquarium.add(redFish);
                                                    System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un poisson (rouge) !"));
                                                    System.out.println(redFish.toString());
                                                    if(aquarium.getHereNbAnimals()!= aquarium.getMaxNbAnimals())
                                                        isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                }while(isPaddockFill && aquarium.getHereNbAnimals()< aquarium.getMaxNbAnimals());
                                                scannerChoiceAnimal.nextLine();
                                                isNotFinishChoiceMenuMain = false;
                                                isNotFinishChoiceAnimal = false;
                                                break;
                                            case "4":case "requin":
                                                do {
                                                    Shark shark = new Shark("shark"+(Shark.getNbShark()+1),(Tools.random(0,2) != 0), Tools.random(400000,2500000), Tools.random(150, 350), Tools.random(2,15));
                                                    Shark.setNbShark(Shark.getNbShark() + 1);
                                                    aquarium.add(shark);
                                                    System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un requin !"));
                                                    System.out.println(shark.toString());
                                                    if(aquarium.getHereNbAnimals()!= aquarium.getMaxNbAnimals())
                                                        isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                }while(isPaddockFill && aquarium.getHereNbAnimals()< aquarium.getMaxNbAnimals());
                                                scannerChoiceAnimal.nextLine();
                                                isNotFinishChoiceMenuMain = false;
                                                isNotFinishChoiceAnimal = false;
                                                break;
                                            case "q":case "quit":case "quitter":case "exit":
                                                isNotFinishChoiceAnimal = false;
                                                scannerChoiceAnimal.nextLine();
                                                break;
                                            default:
                                                Tools.notProposedOption();
                                                scannerChoiceAnimal.nextLine();
                                                break;
                                        }
                                    }//while(isNotFinishChoiceAnimal)
                                }
                                scannerChoicePaddock.nextLine();
                                break;
                            case "3":case "volière":case "voliere":
                                Aviary aviary = new Aviary("aviary"+(Aviary.getNbAviary()+1),Tools.random(40,500),Tools.random(3,10),"bon",Tools.random(5,20));
                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" une volière !"));
                                this.showAllPaddock();
                                isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                if (isPaddockFill) {
                                    boolean isNotFinishChoiceAnimal = true;
                                    while(isNotFinishChoiceAnimal){
                                        isPaddockFill = false;
                                        System.out.print("Pour cette voilière, voici les animaux que vous pouvez créer : \n" +
                                                "\t1: Aigle\n" +
                                                "\tq: QUITTER (CHOIX)\n" +
                                                "\nChoix : ");
                                        String choiceAnimal = scannerChoiceAnimal.next();
                                        choiceAnimal = choiceAnimal.toLowerCase();
                                        switch (choiceAnimal) {
                                            case "1":case "aigle":
                                                do {
                                                    Eagle eagle = new Eagle("eagle"+(Eagle.getNbEagle()+1),(Tools.random(0,2) != 0), Tools.random(10000,25000), Tools.random(80, 120), Tools.random(2,15));
                                                    Eagle.setNbEagle(Eagle.getNbEagle()+1);
                                                    aviary.add(eagle);
                                                    System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un aigle !"));
                                                    System.out.println(eagle.toString());
                                                    if(aviary.getHereNbAnimals()!= aviary.getMaxNbAnimals())
                                                        isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                } while (isPaddockFill && aviary.getHereNbAnimals()< aviary.getMaxNbAnimals());
                                                scannerChoiceAnimal.nextLine();
                                                isNotFinishChoiceMenuMain = false;
                                                isNotFinishChoiceAnimal = false;
                                                break;
                                            case "q":case "quit":case "quitter":case "exit":
                                                scannerChoiceAnimal.nextLine();
                                                isNotFinishChoiceAnimal = false;
                                                break;
                                            default:
                                                Tools.notProposedOption();
                                                scannerChoiceAnimal.nextLine();
                                                break;
                                        }
                                    }//while(isNotFinishChoiceAnimal)
                                }
                                scannerChoicePaddock.nextLine();
                                break;
                            case "q":case "quit":case "quitter":case "exit":
                                isNotFinishChoiceMenuMain = false;
                                scannerChoicePaddock.nextLine();
                                break;
                            default:
                                Tools.notProposedOption();
                                scannerChoicePaddock.nextLine();
                                break;
                        } // switch choicePaddock
                        if(!listPaddock.isEmpty())
                            isPaddockCreated = true;
                        if(!totalAnimal.isEmpty())
                            isAnimalCreated = true;
                    }//while(isNotFinishChoiceMenuMain)
                    scannerChoiceAction.nextLine();
                    break;
                case "2":
                    if(isPaddockCreated){
                        while(isNotFinishChoiceMenuMain){
                        System.out.println("\nVoici les animaux que vous pouvez créer en fonction des enclos disponibles : ");
                        String showAvailabilityAnimal = "";
                        String showAvailabilityPaddock = "";
                        ArrayList<Paddock> availabilityPaddock = new ArrayList<>();

                        for (Paddock p : listPaddock) {
                            if (!showAvailabilityAnimal.contains(p.getTypeAnimals())) {
                                if (p.getTypeAnimals().equals("pas d'animal présent")) {
                                    if (!showAvailabilityAnimal.contains("Loup") && p.getName().substring(0,7).equals("paddock") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t1: Loup\n";isWolf=true;}
                                    if (!showAvailabilityAnimal.contains("Ours") && p.getName().substring(0,7).equals("paddock") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t2: Ours\n";isBear=true;}
                                    if (!showAvailabilityAnimal.contains("Tigre") && p.getName().substring(0,7).equals("paddock") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t3: Tigre\n";isTiger=true;}
                                    if (!showAvailabilityAnimal.contains("Aigle") && p.getName().substring(0,6).equals("avairy") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t4: Aigle\n";isEagle=true;}
                                    if (!showAvailabilityAnimal.contains("Pingouin") && p.getName().substring(0,8).equals("aquarium") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t5: Pingouin\n";isRazobill=true;}
                                    if (!showAvailabilityAnimal.contains("Baleine") && p.getName().substring(0,8).equals("aquarium") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t6: Baleine\n";isWhale=true;}
                                    if (!showAvailabilityAnimal.contains("Requin") && p.getName().substring(0,8).equals("aquarium") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t7: Requin\n";isShark=true;}
                                    if (!showAvailabilityAnimal.contains("Poisson (rouge)") && p.getName().substring(0,8).equals("aquarium") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t8: Poisson (rouge)\n";isRedFish=true;}
                                    availabilityPaddock.add(p);
                                }
                                else if(p.getHereNbAnimals()<p.getMaxNbAnimals()) {
                                    showAvailabilityAnimal += "\t";
                                    if(p.getTypeAnimals().equals("Loup")){showAvailabilityAnimal+="1: " + p.getTypeAnimals()+ "\n";isWolf=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Ours")){showAvailabilityAnimal+="2: " + p.getTypeAnimals()+ "\n";isBear=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Tigre")){showAvailabilityAnimal+="3: " + p.getTypeAnimals()+ "\n";isTiger=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Aigle")){showAvailabilityAnimal+="4: " + p.getTypeAnimals()+ "\n";isEagle=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Pingouin")){showAvailabilityAnimal+="5: " + p.getTypeAnimals()+ "\n";isRazobill=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Baleine")){showAvailabilityAnimal+="6: " + p.getTypeAnimals()+ "\n";isWhale=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Requin")){showAvailabilityAnimal+="7: " + p.getTypeAnimals()+ "\n";isShark=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Poisson rouge")){showAvailabilityAnimal+="8: " + p.getTypeAnimals()+ "\n";isRedFish=true;availabilityPaddock.add(p);}
                                }
                            }
                            else if(p.getHereNbAnimals()<p.getMaxNbAnimals())
                                availabilityPaddock.add(p);
                        }
                        System.out.print(showAvailabilityAnimal + "\tq: QUITTER (CHOIX)\n\nChoix : ");

                        String choiceAnimal = scannerChoiceAnimal.next();
                        choiceAnimal = choiceAnimal.toLowerCase();
                        boolean isNotFinishAddAnimal = true;
                        while(isNotFinishAddAnimal){
                            switch (choiceAnimal) {
                                case "1":case "loup":
                                    if (isWolf) {
                                        while(isNotFinishAddAnimal) {
                                            System.out.println("\nParmis les enclos suivants, dans lequel voulez-vous ajouter un loup ?");
                                            int cpt = 0;
                                            System.out.print("\t");
                                            for (Paddock p : availabilityPaddock) {
                                                if ((p.getTypeAnimals().equals("Loup") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0, 7).equals("paddock")) {
                                                    System.out.print(p.getName() + " ");
                                                    ++cpt;
                                                    if (cpt == 5) {
                                                        System.out.println("\t");
                                                        cpt = 0;
                                                    }
                                                }
                                            }
                                            System.out.print("\n\tq: QUITTER (CHOIX)\n\nChoix : ");

                                            String choicePaddock = scannerChoicePaddock.next();
                                            choicePaddock = choicePaddock.toLowerCase();

                                            switch (choicePaddock) {
                                                case "q":case "quit":case "quitter":case "exit":
                                                    isNotFinishAddAnimal = false;
                                                    isNotFinishChoiceMenuMain = false;
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                                default:
                                                    boolean isNotValid = false;
                                                    for (Paddock p : listPaddock) {
                                                        if (p.getName().equals(choicePaddock)) {
                                                            do {
                                                                Wolf wolf = new Wolf("wolf" + (Wolf.getNbWolf() + 1), (Tools.random(0, 2) != 0), Tools.random(25, 50), Tools.random(80, 120), Tools.random(2, 15));
                                                                Wolf.setNbWolf(Wolf.getNbWolf() + 1);
                                                                p.add(wolf);
                                                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un loup !"));
                                                                System.out.println(wolf.toString());
                                                                if (p.getHereNbAnimals() != p.getMaxNbAnimals())
                                                                    isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                            }
                                                            while (isPaddockFill && p.getHereNbAnimals() < p.getMaxNbAnimals());
                                                            isWolf = false;
                                                            isNotFinishAddAnimal = false;
                                                        } else
                                                            isNotValid = true;
                                                    }
                                                    if (isNotValid)
                                                        Tools.notProposedOption();
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                            }
                                        } //while(isNotFinishAddAnimal)
                                    }
                                    else{
                                        Tools.notProposedOption();}
                                    scannerChoiceAnimal.nextLine();
                                    break;
                                case "2":case "ours":
                                    if (isBear) {
                                        while(isNotFinishAddAnimal) {
                                            System.out.println("\nParmis les enclos suivants, dans lequel voulez-vous ajouter un ours ?");
                                            int cpt = 0;
                                            System.out.print("\t");
                                            for (Paddock p : availabilityPaddock) {
                                                if ((p.getTypeAnimals().equals("Ours") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0, 7).equals("paddock")) {
                                                    System.out.print(p.getName() + " ");
                                                    ++cpt;
                                                    if (cpt == 5) {
                                                        System.out.println("\t");
                                                        cpt = 0;
                                                    }
                                                }
                                            }
                                            System.out.print("\n\tq: QUITTER (CHOIX)\n\nChoix : ");

                                            String choicePaddock = scannerChoicePaddock.next();
                                            choicePaddock = choicePaddock.toLowerCase();

                                            switch (choicePaddock) {
                                                case "q":case "quit":case "quitter":case "exit":
                                                    isNotFinishAddAnimal = false;
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                                default:
                                                    boolean isNotValid = false;
                                                    for (Paddock p : listPaddock) {
                                                        if (p.getName().equals(choicePaddock)) {
                                                            do {
                                                                Bear bear = new Bear("bear"+(Bear.getNbBear()+1), (Tools.random(0,2) != 0), Tools.random(10000,50000), Tools.random(120, 150), Tools.random(2,15));
                                                                Bear.setNbBear(Bear.getNbBear() + 1);
                                                                p.add(bear);
                                                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un ours !"));
                                                                System.out.println(bear.toString());
                                                                if (p.getHereNbAnimals() != p.getMaxNbAnimals())
                                                                    isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                            }
                                                            while (isPaddockFill && p.getHereNbAnimals() < p.getMaxNbAnimals());
                                                            isBear = false;
                                                            isNotFinishAddAnimal = false;
                                                        } else
                                                            isNotValid = true;
                                                    }
                                                    if (isNotValid)
                                                        Tools.notProposedOption();
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                            }
                                        } //while(isNotFinishAddAnimal)
                                    }
                                    else{
                                        Tools.notProposedOption();}
                                    scannerChoiceAnimal.nextLine();
                                    break;
                                case "3":case "tigre":
                                    if (isTiger) {
                                        while(isNotFinishAddAnimal) {
                                            System.out.println("\nParmis les enclos suivants, dans lequel voulez-vous ajouter un tigre ?");
                                            int cpt = 0;
                                            System.out.print("\t");
                                            for (Paddock p : availabilityPaddock) {
                                                if ((p.getTypeAnimals().equals("Tigre") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0, 7).equals("paddock")) {
                                                    System.out.print(p.getName() + " ");
                                                    ++cpt;
                                                    if (cpt == 5) {
                                                        System.out.println("\t");
                                                        cpt = 0;
                                                    }
                                                }
                                            }
                                            System.out.print("\n\tq: QUITTER (CHOIX)\n\nChoix : ");

                                            String choicePaddock = scannerChoicePaddock.next();
                                            choicePaddock = choicePaddock.toLowerCase();

                                            switch (choicePaddock) {
                                                case "q":case "quit":case "quitter":case "exit":
                                                    isNotFinishAddAnimal = false;
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                                default:
                                                    boolean isNotValid = false;
                                                    for (Paddock p : listPaddock) {
                                                        if (p.getName().equals(choicePaddock)) {
                                                            do {
                                                                Tiger tiger = new Tiger("tiger"+(Tiger.getNbTiger()+1), (Tools.random(0,2) != 0), Tools.random(10000,25000), Tools.random(120, 150), Tools.random(2,15));
                                                                Tiger.setNbTiger(Tiger.getNbTiger() + 1);
                                                                p.add(tiger);
                                                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un tigre !"));
                                                                System.out.println(tiger.toString());
                                                                if (p.getHereNbAnimals() != p.getMaxNbAnimals())
                                                                    isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                            }
                                                            while (isPaddockFill && p.getHereNbAnimals() < p.getMaxNbAnimals());
                                                            isTiger = false;
                                                            isNotFinishAddAnimal = false;
                                                        } else
                                                            isNotValid = true;
                                                    }
                                                    if (isNotValid)
                                                        Tools.notProposedOption();
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                            }
                                        } //while(isNotFinishAddAnimal)
                                    }
                                    else{
                                        Tools.notProposedOption();}
                                    scannerChoiceAnimal.nextLine();
                                    break;
                                case "4":case "aigle":
                                    if (isEagle) {
                                        while(isNotFinishAddAnimal) {
                                            System.out.println("\nParmis les volières suivantes, dans laquelle voulez-vous ajouter un aigle ?");
                                            int cpt = 0;
                                            System.out.print("\t");
                                            for (Paddock p : availabilityPaddock) {
                                                if ((p.getTypeAnimals().equals("Aigle") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0, 6).equals("aviary")) {
                                                    System.out.print(p.getName() + " ");
                                                    ++cpt;
                                                    if (cpt == 5) {
                                                        System.out.println("\t");
                                                        cpt = 0;
                                                    }
                                                }
                                            }
                                            System.out.print("\n\tq: QUITTER (CHOIX)\n\nChoix : ");

                                            String choicePaddock = scannerChoicePaddock.next();
                                            choicePaddock = choicePaddock.toLowerCase();

                                            switch (choicePaddock) {
                                                case "q":case "quit":case "quitter":case "exit":
                                                    isNotFinishAddAnimal = false;
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                                default:
                                                    boolean isNotValid = false;
                                                    for (Paddock p : listPaddock) {
                                                        if (p.getName().equals(choicePaddock)) {
                                                            do {
                                                                Eagle eagle = new Eagle("eagle"+(Eagle.getNbEagle()+1),(Tools.random(0,2) != 0), Tools.random(10000,25000), Tools.random(80, 120), Tools.random(2,15));
                                                                Eagle.setNbEagle(Eagle.getNbEagle() + 1);
                                                                p.add(eagle);
                                                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un aigle !"));
                                                                System.out.println(eagle.toString());
                                                                if (p.getHereNbAnimals() != p.getMaxNbAnimals())
                                                                    isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                            }
                                                            while (isPaddockFill && p.getHereNbAnimals() < p.getMaxNbAnimals());
                                                            isEagle = false;
                                                            isNotFinishAddAnimal = false;
                                                        } else
                                                            isNotValid = true;
                                                    }
                                                    if (isNotValid)
                                                        Tools.notProposedOption();
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                            }
                                        } //while(isNotFinishAddAnimal)
                                    }
                                    else{
                                        Tools.notProposedOption();}
                                    scannerChoiceAnimal.nextLine();
                                    break;
                                case "5":case "pingouin":
                                    if (isRazobill) {
                                        while(isNotFinishAddAnimal) {
                                            System.out.println("\nParmis les aquariums suivants, dans lequel voulez-vous ajouter un pingouin ?");
                                            int cpt = 0;
                                            System.out.print("\t");
                                            for (Paddock p : availabilityPaddock) {
                                                if ((p.getTypeAnimals().equals("Pingouin") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0, 8).equals("aquariumk")) {
                                                    System.out.print(p.getName() + " ");
                                                    ++cpt;
                                                    if (cpt == 5) {
                                                        System.out.println("\t");
                                                        cpt = 0;
                                                    }
                                                }
                                            }
                                            System.out.print("\n\tq: QUITTER (CHOIX)\n\nChoix : ");

                                            String choicePaddock = scannerChoicePaddock.next();
                                            choicePaddock = choicePaddock.toLowerCase();

                                            switch (choicePaddock) {
                                                case "q":case "quit":case "quitter":case "exit":
                                                    isNotFinishAddAnimal = false;
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                                default:
                                                    boolean isNotValid = false;
                                                    for (Paddock p : listPaddock) {
                                                        if (p.getName().equals(choicePaddock)) {
                                                            do {
                                                                Razorbill razorbill = new Razorbill("razorbile"+(Razorbill.getNbRazorbill()+1),(Tools.random(0,2) != 0), Tools.random(20000,30000), Tools.random(80, 120), Tools.random(2,15));
                                                                Razorbill.setNbRazorbill(Razorbill.getNbRazorbill() + 1);
                                                                p.add(razorbill);
                                                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un pingouin !"));
                                                                System.out.println(razorbill.toString());
                                                                if (p.getHereNbAnimals() != p.getMaxNbAnimals())
                                                                    isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                            }
                                                            while (isPaddockFill && p.getHereNbAnimals() < p.getMaxNbAnimals());
                                                            isRazobill = false;
                                                            isNotFinishAddAnimal = false;
                                                        } else
                                                            isNotValid = true;
                                                    }
                                                    if (isNotValid)
                                                        Tools.notProposedOption();
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                            }
                                        } //while(isNotFinishAddAnimal)
                                    }
                                    else{
                                        Tools.notProposedOption();}
                                    scannerChoiceAnimal.nextLine();
                                    break;
                                case "6":
                                case "baleine":
                                    if (isWhale) {
                                        while(isNotFinishAddAnimal) {
                                            System.out.println("\nParmis les aquarium suivants, dans lequel voulez-vous ajouter une baleine ?");
                                            int cpt = 0;
                                            System.out.print("\t");
                                            for (Paddock p : availabilityPaddock) {
                                                if ((p.getTypeAnimals().equals("Baleine") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0, 8).equals("aquariumk")) {
                                                    System.out.print(p.getName() + " ");
                                                    ++cpt;
                                                    if (cpt == 5) {
                                                        System.out.println("\t");
                                                        cpt = 0;
                                                    }
                                                }
                                            }
                                            System.out.print("\n\tq: QUITTER (CHOIX)\n\nChoix : ");

                                            String choicePaddock = scannerChoicePaddock.next();
                                            choicePaddock = choicePaddock.toLowerCase();

                                            switch (choicePaddock) {
                                                case "q":case "quit":case "quitter":case "exit":
                                                    isNotFinishAddAnimal = false;
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                                default:
                                                    boolean isNotValid = false;
                                                    for (Paddock p : listPaddock) {
                                                        if (p.getName().equals(choicePaddock)) {
                                                            do {
                                                                Whale whale = new Whale("whale"+(Whale.getNbWhale()+1), (Tools.random(0,2) != 0), Tools.random(150000000,170000000), Tools.random(2500, 3300), Tools.random(2,15));
                                                                Whale.setNbWhale(Whale.getNbWhale() + 1);
                                                                p.add(whale);
                                                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" une baleine !"));
                                                                System.out.println(whale.toString());
                                                                if (p.getHereNbAnimals() != p.getMaxNbAnimals())
                                                                    isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                            }
                                                            while (isPaddockFill && p.getHereNbAnimals() < p.getMaxNbAnimals());
                                                            isWhale = false;
                                                            isNotFinishAddAnimal = false;
                                                        } else
                                                            isNotValid = true;
                                                    }
                                                    if (isNotValid)
                                                        Tools.notProposedOption();
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                            }
                                        } //while(isNotFinishAddAnimal)
                                    }
                                    else{
                                        Tools.notProposedOption();}
                                    scannerChoiceAnimal.nextLine();
                                    break;
                                case "7":case "requin":
                                    if (isShark) {
                                        while(isNotFinishAddAnimal) {
                                            System.out.println("\nParmis les aquariums suivants, dans lequel voulez-vous ajouter un pingouin ?");
                                            int cpt = 0;
                                            System.out.print("\t");
                                            for (Paddock p : availabilityPaddock) {
                                                if ((p.getTypeAnimals().equals("Requin") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0, 8).equals("aquariumk")) {
                                                    System.out.print(p.getName() + " ");
                                                    ++cpt;
                                                    if (cpt == 5) {
                                                        System.out.println("\t");
                                                        cpt = 0;
                                                    }
                                                }
                                            }
                                            System.out.print("\n\tq: QUITTER (CHOIX)\n\nChoix : ");

                                            String choicePaddock = scannerChoicePaddock.next();
                                            choicePaddock = choicePaddock.toLowerCase();

                                            switch (choicePaddock) {
                                                case "q":case "quit":case "quitter":case "exit":
                                                    isNotFinishAddAnimal = false;
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                                default:
                                                    boolean isNotValid = false;
                                                    for (Paddock p : listPaddock) {
                                                        if (p.getName().equals(choicePaddock)) {
                                                            do {
                                                                Shark shark = new Shark("shark"+(Shark.getNbShark()+1),(Tools.random(0,2) != 0), Tools.random(400000,2500000), Tools.random(150, 350), Tools.random(2,15));
                                                                Shark.setNbShark(Shark.getNbShark() + 1);
                                                                p.add(shark);
                                                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un requin !"));
                                                                System.out.println(shark.toString());
                                                                if (p.getHereNbAnimals() != p.getMaxNbAnimals())
                                                                    isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                            }
                                                            while (isPaddockFill && p.getHereNbAnimals() < p.getMaxNbAnimals());
                                                            isShark = false;
                                                            isNotFinishAddAnimal = false;
                                                        } else
                                                            isNotValid = true;
                                                    }
                                                    if (isNotValid)
                                                        Tools.notProposedOption();
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                            }
                                        } //while(isNotFinishAddAnimal)
                                    }
                                    else{
                                        Tools.notProposedOption();}
                                    scannerChoiceAnimal.nextLine();
                                    break;
                                case "8":case "poisson":
                                    if (isRedFish) {
                                        while(isNotFinishAddAnimal) {
                                            System.out.println("\nParmis les aquarium suivants, dans lequel voulez-vous ajouter un poisson rouge ?");
                                            int cpt = 0;
                                            System.out.print("\t");
                                            for (Paddock p : availabilityPaddock) {
                                                if ((p.getTypeAnimals().equals("Poisson rouge") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0, 8).equals("aquariumk")) {
                                                    System.out.print(p.getName() + " ");
                                                    ++cpt;
                                                    if (cpt == 5) {
                                                        System.out.println("\t");
                                                        cpt = 0;
                                                    }
                                                }
                                            }
                                            System.out.print("\n\tq: QUITTER (CHOIX)\n\nChoix : ");

                                            String choicePaddock = scannerChoicePaddock.next();
                                            choicePaddock = choicePaddock.toLowerCase();

                                            switch (choicePaddock) {
                                                case "q":case "quit":case "quitter":case "exit":
                                                    isNotFinishAddAnimal = false;
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                                default:
                                                    boolean isNotValid = false;
                                                    for (Paddock p : listPaddock) {
                                                        if (p.getName().equals(choicePaddock)) {
                                                            do {
                                                                RedFish redFish = new RedFish("redfish"+(RedFish.getNbRedfish()+1),(Tools.random(0,2) != 0), Tools.random(15,40), Tools.random(5, 20), Tools.random(2,8));
                                                                RedFish.setNbRedFish(RedFish.getNbRedfish() + 1);
                                                                p.add(redFish);
                                                                System.out.println(Tools.strColorBlue("\nVous avez \"créer\" un poisson rouge !"));
                                                                System.out.println(redFish.toString());
                                                                if (p.getHereNbAnimals() != p.getMaxNbAnimals())
                                                                    isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                                            }
                                                            while (isPaddockFill && p.getHereNbAnimals() < p.getMaxNbAnimals());
                                                            isRedFish = false;
                                                            isNotFinishAddAnimal = false;
                                                        } else
                                                            isNotValid = true;
                                                    }
                                                    if (isNotValid)
                                                        Tools.notProposedOption();
                                                    scannerChoicePaddock.nextLine();
                                                    break;
                                            }
                                        } //while(isNotFinishAddAnimal)
                                    }
                                    else{
                                        Tools.notProposedOption();}
                                    scannerChoiceAnimal.nextLine();
                                    break;
                                case "q":case "quit":case "quitter":case "exit":
                                    isNotFinishAddAnimal = false;
                                    isNotFinishChoiceMenuMain = false;
                                    break;
                                default:
                                    Tools.notProposedOption();
                                    scannerChoiceAnimal.nextLine();
                                    break;
                            }
                        }//while(isNotFinishAddAnimal)
                    }//while(isNotFinishChoiceMenuMain)
                    if(!totalAnimal.isEmpty())
                        isAnimalCreated = true;//while(isNotFinishChoiceMenuMain)
                    }
                    scannerChoiceAction.nextLine();
                    break;
                case "3":case "gérer":case "gerer":
                    if(isAnimalCreated) {
                        System.out.println(Tools.strColorBlue("\nVous entrez dans le mode gestion du zoo."));

                        /* Code... */
                    }
                    else
                        Tools.notProposedOption();
                    //scannerChoice____.nextLine();
                    break;
                case "q":case "quit":case "quitter":case "exit":
                    Tools.exitZoo();
                    break;
                default:
                    Tools.notProposedOption();
                    scannerChoiceAction.nextLine();
                    break;
            } // switch choiceAction
        } // while ()
    } // run()
}
