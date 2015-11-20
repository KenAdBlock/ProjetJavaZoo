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
        for(Paddock p : listPaddock){
            System.out.println(p.toString());
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
                System.out.print("\nQuel action voulez-vous faire ?\n" +
                                    "\t1: Créer un enclos\n" +
                                    "\t2: Créer un animal\n" +
                                    "\tq: QUITTER\n" +
                                    "\nChoix : ");
            else if(isAnimalCreated)
                System.out.print("\nQuel action voulez-vous faire ?\n" +
                        "\t1: Créer un enclos\n" +
                        "\t2: Créer un animal\n" +
                        "\t3: Gérer le zoo en tant qu'employé\n" +
                        "\tq: QUITTER\n" +
                        "\nChoix : ");
            else
                System.out.print("\nQuel action voulez-vous faire ?\n" +
                                    "\t1: Créer un enclos\n" +
                                    "\tq: QUITTER\n" +
                                    "\nChoix : ");

            String choiceAction = scannerChoiceAction.next();
            choiceAction = choiceAction.toLowerCase();
            switch (choiceAction) {
                case "1":
                    System.out.print("\nQuel type d'enclos voulez-vous créer ?\n" +
                            "\t1: Enclos (classique)\n" +
                            "\t2: Aquarium\n" +
                            "\t3: Volière\n" +
                            "\tq: QUITTER\n" +
                            "\nChoix : ");

                    String choicePaddock = scannerChoicePaddock.next();
                    choicePaddock = choicePaddock.toLowerCase();
                    switch (choicePaddock) {
                        case "1":case "enclos":
                            Paddock paddock = new Paddock("paddock"+(Paddock.getNbPaddock()+1), Tools.random(40, 500),Tools.random(3,20),"bon");
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un enclos classique !"));
                            this.showAllPaddock();
                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                            if (isPaddockFill) {
                                isPaddockFill = false;
                                System.out.print("Pour cet enclos, voici les animaux que vous pouvez créer : \n" +
                                        "\t1: Loup\n" +
                                        "\t2: Ours\n" +
                                        "\t3: Tigre\n" +
                                        "\tq: QUITTER\n" +
                                        "\nChoix : ");
                                String choiceAnimal = scannerChoiceAnimal.next();
                                choiceAnimal = choiceAnimal.toLowerCase();
                                switch (choiceAnimal) {
                                    case "1":case "loup":
                                        do {
                                            Wolf wolf = new Wolf("wolf"+(Wolf.getNbWolf()+1),(Tools.random(0,2) != 0), Tools.random(25,50), Tools.random(80, 120), Tools.random(2,15));
                                            Wolf.setNbWolf(Wolf.getNbWolf() + 1);
                                            paddock.add(wolf);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un loup !"));
                                            System.out.println(wolf.toString());
                                            if(paddock.getHereNbAnimals()!= paddock.getMaxNbAnimals())
                                                isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill && paddock.getHereNbAnimals()< paddock.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "2":case "ours":
                                        do {
                                            Bear bear = new Bear("bear"+(Bear.getNbBear()+1), (Tools.random(0,2) != 0), Tools.random(10000,50000), Tools.random(120, 150), Tools.random(2,15));
                                            Bear.setNbBear(Bear.getNbBear() + 1);
                                            paddock.add(bear);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un ours !"));
                                            System.out.println(bear.toString());
                                            if(paddock.getHereNbAnimals()!= paddock.getMaxNbAnimals())
                                                isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill && paddock.getHereNbAnimals()< paddock.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "3":case "tigre":
                                        do {
                                            Tiger tiger = new Tiger("tiger"+(Tiger.getNbTiger()+1), (Tools.random(0,2) != 0), Tools.random(10000,25000), Tools.random(120, 150), Tools.random(2,15));
                                            Tiger.setNbTiger(Tiger.getNbTiger() + 1);
                                            paddock.add(tiger);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un tigre !"));
                                            System.out.println(tiger.toString());
                                            if(paddock.getHereNbAnimals()!= paddock.getMaxNbAnimals())
                                                isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill && paddock.getHereNbAnimals()< paddock.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "q":case "quit":case "quitter":case "exit":
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    default:
                                        Tools.notProposedOption();
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                }
                                /*isPaddockFill = false;*/
                            }
                            scannerChoicePaddock.nextLine();
                            break;
                        case "2":case "aquarium":
                            Aquarium aquarium = new Aquarium("aquarium"+(Aquarium.getNbAquarium()+1), Tools.random(40, 500),Tools.random(3,20),"bon", Tools.random(10, 50), 50);
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un aquarium !"));
                            this.showAllPaddock();
                            isPaddockFill =  Tools.askPaddockFill(isPaddockFill);
                            if (isPaddockFill) {
                                isPaddockFill = false;
                                System.out.print("Pour cet aquarium, voici les animaux que vous pouvez créer : \n" +
                                        "\t1: Baleine\n" +
                                        "\t2: Pingouin\n" +
                                        "\t3: Poisson (rouge)\n" +
                                        "\t4: Requin\n" +
                                        "\tq: QUITTER\n" +
                                        "\nChoix : ");
                                String choiceAnimal = scannerChoiceAnimal.next();
                                choiceAnimal = choiceAnimal.toLowerCase();
                                switch (choiceAnimal) {
                                    case "1":case "baleine":
                                        do {
                                            Whale whale = new Whale("whale"+(Whale.getNbWhale()+1), (Tools.random(0,2) != 0), Tools.random(150000000,170000000), Tools.random(2500, 3300), Tools.random(2,15));
                                            Whale.setNbWhale(Whale.getNbWhale() + 1);
                                            aquarium.add(whale);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un baleine !"));
                                            System.out.println(whale.toString());
                                            if(aquarium.getHereNbAnimals()!= aquarium.getMaxNbAnimals())
                                                isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill && aquarium.getHereNbAnimals()< aquarium.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "2":case "pingouin":
                                        do {
                                            Razorbill razorbill = new Razorbill("razorbile"+(Razorbill.getNbRazorbill()+1),(Tools.random(0,2) != 0), Tools.random(20000,30000), Tools.random(80, 120), Tools.random(2,15));
                                            Razorbill.setNbRazorbill(Razorbill.getNbRazorbill() + 1);
                                            aquarium.add(razorbill);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un pingouin !"));
                                            System.out.println(razorbill.toString());
                                            if(aquarium.getHereNbAnimals()!= aquarium.getMaxNbAnimals())
                                                isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill && aquarium.getHereNbAnimals()< aquarium.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "3":case "poisson":
                                        do {
                                            RedFish redFish = new RedFish("redfish"+(RedFish.getNbRedfish()+1),(Tools.random(0,2) != 0), Tools.random(15,40), Tools.random(5, 20), Tools.random(2,8));
                                            RedFish.setNbRedFish(RedFish.getNbRedfish() + 1);
                                            aquarium.add(redFish);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un poisson (rouge) !"));
                                            System.out.println(redFish.toString());
                                            if(aquarium.getHereNbAnimals()!= aquarium.getMaxNbAnimals())
                                                isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill && aquarium.getHereNbAnimals()< aquarium.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "4":case "requin":
                                        do {
                                            Shark shark = new Shark("shark"+(Shark.getNbShark()+1),(Tools.random(0,2) != 0), Tools.random(400000,2500000), Tools.random(150, 350), Tools.random(2,15));
                                            Shark.setNbShark(Shark.getNbShark() + 1);
                                            aquarium.add(shark);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un requin !"));
                                            System.out.println(shark.toString());
                                            if(aquarium.getHereNbAnimals()!= aquarium.getMaxNbAnimals())
                                                isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        }while(isPaddockFill && aquarium.getHereNbAnimals()< aquarium.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "q":case "quit":case "quitter":case "exit":
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    default:
                                        Tools.notProposedOption();
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                }
                                /*isPaddockFill = false;*/
                            }
                            scannerChoicePaddock.nextLine();
                            break;
                        case "3":case "volière":case "voliere":
                            Aviary aviary = new Aviary("aviary"+(Aviary.getNbAviary()+1),Tools.random(40,500),Tools.random(3,10),"bon",Tools.random(5,20));
                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" une volière !"));
                            this.showAllPaddock();
                            isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                            if (isPaddockFill) {
                                isPaddockFill = false;
                                System.out.print("Pour cette voilière, voici les animaux que vous pouvez créer : \n" +
                                        "\t1: Aigle\n" +
                                        "\tq: QUITTER\n" +
                                        "\nChoix : ");
                                String choiceAnimal = scannerChoiceAnimal.next();
                                choiceAnimal = choiceAnimal.toLowerCase();
                                switch (choiceAnimal) {
                                    case "1":case "aigle":
                                        do {
                                            Eagle eagle = new Eagle("eagle"+(Eagle.getNbEagle()+1),(Tools.random(0,2) != 0), Tools.random(10000,25000), Tools.random(80, 120), Tools.random(2,15));
                                            Eagle.setNbEagle(Eagle.getNbEagle()+1);
                                            aviary.add(eagle);
                                            System.out.println(Tools.strColorBlue("Vous avez \"créer\" un aigle !"));
                                            System.out.println(eagle.toString());
                                            if(aviary.getHereNbAnimals()!= aviary.getMaxNbAnimals())
                                                isPaddockFill = Tools.askPaddockFill(isPaddockFill);
                                        } while (isPaddockFill && aviary.getHereNbAnimals()< aviary.getMaxNbAnimals());
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    case "q":case "quit":case "quitter":case "exit":
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                    default:
                                        Tools.notProposedOption();
                                        scannerChoiceAnimal.nextLine();
                                        break;
                                }
                                /*isPaddockFill = false;*/
                            }
                            scannerChoicePaddock.nextLine();
                            break;
                        case "q":case "quit":case "quitter":case "exit":
                            Tools.exitZoo();
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
                    scannerChoiceAction.nextLine();
                    break;
                case "2":
                    if(isPaddockCreated){
                        System.out.println("\nVoici les animaux que vous pouvez créer en fonction des enclos disponibles : ");
                        String showAvailabilityAnimal = "";
                        String showAvailabilityPaddock = "";
                        ArrayList<Paddock> availabilityPaddock = new ArrayList<>();

                        for (Paddock p : listPaddock) {
                            if (!showAvailabilityAnimal.contains(p.getTypeAnimals())){
                                if(p.getTypeAnimals().equals("pas d'animal présent")) {
                                    if (!showAvailabilityAnimal.contains("Loup") && p.getName().substring(0,7).equals("paddock") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t1. Loup\n";isWolf=true;availabilityPaddock.add(p);}
                                    if (!showAvailabilityAnimal.contains("Ours") && p.getName().substring(0,7).equals("paddock") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t2. Ours\n";isBear=true;availabilityPaddock.add(p);}
                                    if (!showAvailabilityAnimal.contains("Tigre") && p.getName().substring(0,7).equals("paddock") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t3. Tigre\n";isTiger=true;availabilityPaddock.add(p);}
                                    if (!showAvailabilityAnimal.contains("Aigle") && p.getName().substring(0,6).equals("avairy") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t4. Aigle\n";isEagle=true;availabilityPaddock.add(p);}
                                    if (!showAvailabilityAnimal.contains("Pingouin") && p.getName().substring(0,8).equals("aquarium") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t5. Pingouin\n";isRazobill=true;availabilityPaddock.add(p);}
                                    if (!showAvailabilityAnimal.contains("Baleine") && p.getName().substring(0,8).equals("aquarium") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t6. Baleine\n";isWhale=true;availabilityPaddock.add(p);}
                                    if (!showAvailabilityAnimal.contains("Requin") && p.getName().substring(0,8).equals("aquarium") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t7. Requin\n";isShark=true;availabilityPaddock.add(p);}
                                    if (!showAvailabilityAnimal.contains("Poisson (rouge)") && p.getName().substring(0,8).equals("aquarium") && p.getHereNbAnimals()<p.getMaxNbAnimals())
                                        {showAvailabilityAnimal += "\t8. Poisson (rouge)\n";isRedFish=true;availabilityPaddock.add(p);}
                                }
                                else if(p.getHereNbAnimals()<p.getMaxNbAnimals()) {
                                    showAvailabilityAnimal += "\t";
                                    if(p.getTypeAnimals().equals("Loup")){showAvailabilityAnimal+="1. " + p.getTypeAnimals()+ "\n";isWolf=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Ours")){showAvailabilityAnimal+="2. " + p.getTypeAnimals()+ "\n";isBear=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Tigre")){showAvailabilityAnimal+="3. " + p.getTypeAnimals()+ "\n";isTiger=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Aigle")){showAvailabilityAnimal+="4. " + p.getTypeAnimals()+ "\n";isEagle=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Pingouin")){showAvailabilityAnimal+="5. " + p.getTypeAnimals()+ "\n";isRazobill=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Baleine")){showAvailabilityAnimal+="6. " + p.getTypeAnimals()+ "\n";isWhale=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Requin")){showAvailabilityAnimal+="7. " + p.getTypeAnimals()+ "\n";isShark=true;availabilityPaddock.add(p);}
                                    else if(p.getTypeAnimals().equals("Poisson rouge")){showAvailabilityAnimal+="8. " + p.getTypeAnimals()+ "\n";isRedFish=true;availabilityPaddock.add(p);}
                                }
                            }
                        }
                        System.out.print(showAvailabilityAnimal + "\tq: QUITTER\nChoix : ");
                        /*for(Paddock p : listPaddock){
                            System.out.print("\t" + cpt2 +". " + p.getName() + " ");
                            cpt++;
                            if (cpt == 5) {
                                System.out.println("");
                                cpt = 0;
                            }
                        }*/
                        String choiceAnimal = scannerChoiceAnimal.next();
                        choiceAnimal = choiceAnimal.toLowerCase();
                        switch (choiceAnimal){
                            case"1":case"loup":
                                if(isWolf){
                                    while(true) {
                                        isWolf = false;
                                        System.out.println("Parmis les enclos suivants, dans lequel voulez-vous ajouter un loup ?");
                                        int cpt = 0;
                                        for (Paddock p : availabilityPaddock) {
                                            if ((p.getTypeAnimals().equals("Loup") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0, 7).equals("paddock")) {
                                                System.out.print(p.getName() + " ");
                                                ++cpt;
                                                if (cpt == 5) {
                                                    System.out.println("");
                                                    cpt = 0;
                                                }
                                            } else
                                                Tools.notProposedOption();
                                        }
                                        if(cpt<5)
                                            System.out.println("\n");
                                    }//faire la boucle pour demander si on veut encore ajouter (boucle inifini pour le moment à cause du while(true)), et effectivement ajouter les animaux ( à copier des ajouts du case"1")
                                }
                                else
                                    Tools.notProposedOption();
                                break;
                            case"2":case"ours":
                                if(isBear){
                                    isBear=false;
                                    System.out.println("Parmis les enclos suivants, dans lequel voulez-vous ajouter un ours ?");
                                    int cpt = 0;
                                    for (Paddock p : availabilityPaddock){
                                        if((p.getTypeAnimals().equals("Ours") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0,7).equals("paddock")){
                                            System.out.print(p.getName() + " ");
                                            ++cpt;
                                            if (cpt == 5){System.out.println("");cpt=0;}
                                        }
                                        else
                                            Tools.notProposedOption();
                                    }
                                }
                                else
                                    Tools.notProposedOption();
                                break;
                            case"3":case"tigre":
                                if(isTiger){
                                    isTiger=false;
                                    System.out.println("Parmis les enclos suivants, dans lequel voulez-vous ajouter un tigre ?");
                                    int cpt = 0;
                                    for (Paddock p : availabilityPaddock){
                                        if((p.getTypeAnimals().equals("Tigre") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0,7).equals("paddock")){
                                            System.out.print(p.getName() + " ");
                                            ++cpt;
                                            if (cpt == 5){System.out.println("");cpt=0;}
                                        }
                                        else
                                            Tools.notProposedOption();
                                    }
                                }
                                else
                                    Tools.notProposedOption();
                                break;
                            case"4":case"aigle":
                                if(isEagle){
                                    isEagle=false;
                                    System.out.println("Parmis les volières suivantes, dans lequel voulez-vous ajouter un aigle ?");
                                    int cpt = 0;
                                    for (Paddock p : availabilityPaddock){
                                        if((p.getTypeAnimals().equals("Aigle") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0,6).equals("aviary")){
                                            System.out.print(p.getName() + " ");
                                            ++cpt;
                                            if (cpt == 5){System.out.println("");cpt=0;}
                                        }
                                        else
                                            Tools.notProposedOption();
                                    }
                                }
                                else
                                    Tools.notProposedOption();
                                break;
                            case"5":case"pingouin":
                                if(isRazobill){
                                    isRazobill=false;
                                    System.out.println("Parmis les aquarium suivants, dans lequel voulez-vous ajouter un pingouin ?");
                                    int cpt = 0;
                                    for (Paddock p : availabilityPaddock){
                                        if((p.getTypeAnimals().equals("pingouin") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0,8).equals("aquarium")){
                                            System.out.print(p.getName() + " ");
                                            ++cpt;
                                            if (cpt == 5){System.out.println("");cpt=0;}
                                        }
                                        else
                                            Tools.notProposedOption();
                                    }
                                }
                                else
                                    Tools.notProposedOption();
                                break;
                            case"6":case"baleine":
                                if(isWhale){
                                    isWhale=false;
                                    System.out.println("Parmis les aquarium suivants, dans lequel voulez-vous ajouter une baleine ?");
                                    int cpt = 0;
                                    for (Paddock p : availabilityPaddock){
                                        if((p.getTypeAnimals().equals("baleine") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0,8).equals("aquarium")){
                                            System.out.print(p.getName() + " ");
                                            ++cpt;
                                            if (cpt == 5){System.out.println("");cpt=0;}
                                        }
                                        else
                                            Tools.notProposedOption();
                                    }
                                }
                                else
                                    Tools.notProposedOption();
                                break;
                            case"7":case"requin":
                                if(isShark){
                                    isShark=false;
                                    System.out.println("Parmis les aquarium suivants, dans lequel voulez-vous ajouter un requin ?");
                                    int cpt = 0;
                                    for (Paddock p : availabilityPaddock){
                                        if((p.getTypeAnimals().equals("requin") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0,8).equals("aquarium")){
                                            System.out.print(p.getName() + " ");
                                            ++cpt;
                                            if (cpt == 5){System.out.println("");cpt=0;}
                                        }
                                        else
                                            Tools.notProposedOption();
                                    }
                                }
                                else
                                    Tools.notProposedOption();
                                break;
                            case"8":case"poisson":
                                if(isRedFish){
                                    isRedFish=false;
                                    System.out.println("Parmis les aquarium suivants, dans lequel voulez-vous ajouter un poisson rouge?");
                                    int cpt = 0;
                                    for (Paddock p : availabilityPaddock){
                                        if((p.getTypeAnimals().equals("poisson rouge") || p.getTypeAnimals().equals("pas d'animal présent")) && p.getName().substring(0,8).equals("aquarium")){
                                            System.out.print(p.getName() + " ");
                                            ++cpt;
                                            if (cpt == 5){System.out.println("");cpt=0;}
                                        }
                                        else
                                            Tools.notProposedOption();
                                    }
                                }
                                else
                                    Tools.notProposedOption();
                                break;
                            case "q":case "quit":case "quitter":case "exit":
                                Tools.exitZoo();
                                break;
                            default:
                                Tools.notProposedOption();
                                scannerChoiceAnimal.nextLine();
                                break;
                        }
                        /*switch (choiceAnimal.substring(0,4)){
                            case "padd":
                                for (Paddock p: listPaddock){
                                    if(p.getName().substring(0,7).equals("paddock")){
                                        System.out.println("Prout 1");
                                    }
                                }
                                break;
                            case "aqua":
                                for (Paddock p: listPaddock){
                                    if(p.getName().substring(0,8).equals("aquarium")){
                                        System.out.println("Prout 1");
                                    }
                                }
                                break;
                            case "avia":
                                for (Paddock p: listPaddock){
                                    if(p.getName().substring(0,6).equals("aviary")){
                                        System.out.println("Prout 1");
                                    }
                                }
                                break;
                        }*/

                       /* System.out.print("\nQuel animal voulez-vous créer ?\n" +
                                "\t1: Aigle\n" +
                                "\t2: Baleine\n" +
                                "\t3: Loup\n" +
                                "\t4: Ours\n" +
                                "\t5: Pingouin\n" +
                                "\t6: Poisson (rouge)\n" +
                                "\t7: Requin\n" +
                                "\t8: Tigre\n" +
                                "\tq: QUITTER\n" +
                                "\nChoix : ");

                        switch (choiceAnimal) {
                            case "1":case "aigle":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un aigle !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "2":case "baleine":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" une baleine !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "3":case "loup":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un loup !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "4":case "ours":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un ours !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "5":case "pingouin":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un pingouin !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "6":case "poisson":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un poisson rouge !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "7":case "requin":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un requin !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "8":case "tigre":
                                System.out.println(Tools.strColorBlue("Vous avez \"créer\" un tigre !"));
                                Tools.askAgain();
                                scannerChoiceAnimal.nextLine();
                                break;
                            case "q":case "quit":case "quitter":case "exit":
                                Tools.exitZoo();
                                break;
                            default:
                                Tools.notProposedOption();
                                scannerChoiceAnimal.nextLine();
                                break;
                        }// switch choiceAnimal*/
                    }
                    else
                        Tools.notProposedOption();
                    if(!totalAnimal.isEmpty())
                        isAnimalCreated = true;
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
