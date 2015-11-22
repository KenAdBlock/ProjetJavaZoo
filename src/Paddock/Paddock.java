package Paddock;

import java.util.ArrayList;
import java.util.Scanner;

import Tools.Tools;
import Species.Animal;
import Employee.Employee;
import Zoo.Zoo;

/**
 * Paddock est une classe représentant un enclos "classique".
 * Il possède des caractéristiques de base telles que le nom ou la surface.
 *
 * @author Charles-Henri CARLIER et Kenny COADALEN
 */
public class Paddock {

    /**
     * Le nom de l'enclos.
     */
    private String name;

    /**
     * La surface de l'enclos.
     */
    private int surface;

    /**
     * Le nombre maximum d'animaux que peut acceuillir l'enclos.
     */
    private int maxNbAnimals;

    /**
     * Le nombre d'animaux présents dans l'enclos.
     * Donnée initialisée à zéro puisqu'à la création d'un enclos, aucun animal n'y est présent.
     */
    private int hereNbAnimals = 0;

    /**
     * Une chaîne de caractères représentant le type de(s) l'animal/animaux présent(s) dans l'enclos.
     * Donnée initialisée à "pas d'animal présent" car à la création d'un enclos, aucun animal n'y est présent.
     */
    private String typeAnimals = "pas d'animal présent";

    /**
     * La propreté de l'enclos.
     */
    private String cleanliness;

    /**
     * La liste des animaux présents dans l'enclos.
     */
    private ArrayList<Animal> animalPresent = new ArrayList<>();

    /**
     * La quantité maximum de nourriture que peut contenir l'enclos.
     */
    private int maxQuantityFood = 2000;

    /**
     * L'indicateur de nourriture de l'enclos.
     * Cette valeur ne pourra pas être supérieure à maxQuantityFood.
     */
    private int foodIndicator = 125;

    /**
     * Booléen permettant de vérifier, lors de l'ajout d'un animal dans l'enclos, que cet animal est du bon type.
     */
    protected boolean isGoodType = false;

    /**
     * Booléen permettant de savoir si l'enclos a été nettoyé (s'il est propre).
     */
    protected boolean isKeepUp = false;

    /**
     * Le nombre total d'enclos présents dans le zoo.
     */
    private static int nbPaddock = 0;

    /**
     * Le constructeur de la classe Paddock.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom de l'enclos.
     * @param surface
     *          La surface de l'enclos.
     * @param maxNbAnimals
     *          Le nombre maximum d'animaux présents dans l'enclos.
     * @param cleanliness
     *          La propreté de l'enclos.
     */
    public Paddock(String name, int surface, int maxNbAnimals,  String cleanliness) {
        this.name = name;
        this.surface = surface;
        this.maxNbAnimals = maxNbAnimals;
        this.cleanliness = cleanliness;
        Zoo.getListPaddock().add(this);
        Tools.mapPaddock.put(this.name, this);
        nbPaddock+=1;
    } // Constructor


    /**
     * Modifie le nom de l'enclos par le nouveau mis en paramètre.
     *
     * @param name
     *          Le nom du nouvel enclos.
     */
    public void setName(String name) {
        this.name = name;
    } // setName()

    /**
     * Modifie l'indicateur de nourriture de l'enclos par le nouveau mis en paramètre.
     *
     * @param foodIndicator
     *          Le nouvel indicateur de nourriture.
     */
    public void setFoodIndicator(int foodIndicator) {
        this.foodIndicator = foodIndicator;
    } // setFoodIndicator()

    /**
     * Modifie le nombre d'enclos présents dans le zoo.
     *
     * @param nbPaddock
     *          Le nouveau nombre d'enclos.
     */
    public static void setNbPaddock(int nbPaddock) {
        Paddock.nbPaddock = nbPaddock;
    } // setNbPaddock()


    /**
     * Récupère le nom de l'enclos.
     *
     * @return Le nom de l'enclos.
     */
    public String getName() {
        return name;
    } // getName()

    /**
     * Récupère le nombre maximum d'animaux que peut contenir l'enclos.
     *
     * @return Le nombre maximum d'animaux de l'enclos.
     */
    public int getMaxNbAnimals() {
        return maxNbAnimals;
    } // getMaxNbAnimals()

    /**
     * Récupère le nombre d'animaux présents dans l'enclos.
     *
     * @return Le nombre d'animaux présents.
     */
    public int getHereNbAnimals() {
        return hereNbAnimals;
    } // getHereNbAnimals()

    /**
     * Récupère le type d'animal présent dans l'enclos.
     *
     * @return Une chaîne de caractère, représentant le type d'animal.
     */
    public String getTypeAnimals() {
        return typeAnimals;
    } // getTypeAnimals()

    /**
     * Récupère l'indicateur de nourriture de l'enclos.
     *
     * @return L'indicateur de nourriture.
     */
    public int getFoodIndicator() {
        return foodIndicator;
    } // getFoodIndicator()

    /**
     * Récupère le nombre total d'enclos du zoo.
     *
     * @return Le nombre total d'enclos.
     */
    public static int getNbPaddock() {
        return nbPaddock;
    } // getNbPaddock()

    /**
     * Récupère la quantité maximum de nourriture que peut contenir l'enclos.
     *
     * @return La quantité maximum de nourriture de l'enclos.
     */
    public int getMaxQuantityFood() {
        return maxQuantityFood;
    } // getMaxQuantityFood()

    /**
     * Permet d'obtenir, de façon textuelle, toutes les caractéristiques de l'enclos.
     *
     * @return Une chaîne de caractères, représentant les caractéristiques de l'enclos
     */
    @Override
    public String toString() {
        String toString = "Enclos : " + "\n\t\tnom = " + name + "\n\t\tsurface = " + surface + "m²\n\t\tnombre d'animaux maximum = " + maxNbAnimals +
                "\n\t\tnombre d'animaux présents = " + hereNbAnimals + "\n\t\ttype d'animal présent = " + typeAnimals + "\n\t\tdégré de saleté = " + cleanliness +
                "\n\n";
        if(getTypeAnimals().isEmpty())
            toString += "Aucune information sur les animaux car l'enclos est vide.";

        for (Animal a : animalPresent){
            toString += ("\t\t" + a + "\n");
        }
        return toString;
    } // toString()

    /**
     * Permet d'ajouter un animal à l'enclos.
     *
     * @param type
     *          L'animal à ajouter.
     */
    public void add(Animal type){
        try {
            if (type.getTypeAnimal().equals("autre") || isGoodType) {

                if (hereNbAnimals < maxNbAnimals) {
                    if (animalPresent.isEmpty() || (animalPresent.get(0)).getClass().getName().equals(type.getClass().getName())) {
                        animalPresent.add(type);
                        typeAnimals = Tools.hashTypeAnimal(type.getClass().getName().substring(8));
                        type.setPaddock(this);
                        hereNbAnimals++;
                        if (!Zoo.getTotalAnimal().contains(animalPresent))
                            Zoo.getTotalAnimal().add(animalPresent);
                        else
                            Zoo.getTotalAnimal().set(Zoo.getTotalAnimal().indexOf(animalPresent), animalPresent);
                    }// on ajoute n'importe quel animal vu que l'enclos est vide ou si l'animal à ajouter est du même type que les animaux déjà présent dans l'enclos
                    else {
                        System.out.println("Vous ne pouvais pas ajouter un " + Tools.hashTypeAnimal(type.getClass().getName().substring(8)) + " car il y a déja des " + typeAnimals);
                    }// l'animal à ajouter n'est pas du même type que les animaux déjà présent
                } else
                    System.out.println("Enclos plein, vous ne pouvez pas ajouter plus d'animaux ici");
            }
            else
                System.out.println(type.getName() + " ne peut pas entrer dans " + this.getName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    } // add()

    /**
     * Permet de déplacer un animal d'un enclos à un autre.
     *
     * @param animal
     *          L'animal à déplacer.
     */
    public void move(Animal animal){
        Scanner scannerChoiceMoveAnimalPaddock = new Scanner(System.in);
        boolean isNotFinishChoiceActionManagementMoveAnimal = true;
        while (isNotFinishChoiceActionManagementMoveAnimal) {
            System.out.println("\nParmis les enclos suivants, dans lequel voulez-vous déplacer " + animal.getName() + " ?");
            int cpt = 0;
            System.out.print("\t");
            String paddockToMoveAnimal = "";
            for(Paddock p : Zoo.getListPaddock()){
                if (!p.getName().equals(this.getName()) && ((p.getTypeAnimals().equals(animal.getTypeAnimal()) && p.getHereNbAnimals()<p.getMaxNbAnimals() ) || (p.getTypeAnimals().equals("pas d'animal présent") && animal.getPaddock().getName().substring(0,5).equals(p.getName().substring(0,5))))){
                    paddockToMoveAnimal += p.getName() + " ";
                    cpt++;
                    if (cpt == 5) {
                        paddockToMoveAnimal += "\n\t";
                        cpt = 0;
                    }
                }
            }
            if(paddockToMoveAnimal.equals(""))
                paddockToMoveAnimal = "Pas d'enclos disponible pour le changement !";
            System.out.print(paddockToMoveAnimal +
                            "\n\tq: QUITTER (CHOIX)\n" +
                            "\nChoix : ");
            String choiceMoveAnimalPaddock = scannerChoiceMoveAnimalPaddock.next();
            choiceMoveAnimalPaddock = choiceMoveAnimalPaddock.toLowerCase();
            switch (choiceMoveAnimalPaddock) {
                case "q":case "quit":case "quitter":case "exit":
                    isNotFinishChoiceActionManagementMoveAnimal = false;
                    scannerChoiceMoveAnimalPaddock.nextLine();
                    break;
                default:
                    if (paddockToMoveAnimal.contains(choiceMoveAnimalPaddock)) {
                        animalPresent.remove(animalPresent.indexOf(animal));
                        hereNbAnimals--;
                        if(hereNbAnimals == 0)
                            typeAnimals = "pas d'animal présent";
                        Paddock paddock = Tools.hashPaddock(choiceMoveAnimalPaddock);
                        paddock.add(animal);
                        animal.setPaddock(paddock);
                        isNotFinishChoiceActionManagementMoveAnimal = false;

                        System.out.println(Tools.strColorBlue("\nL'employé " + Employee.getINSTANCE().getName() + " a bien retiré " + animal.getName() + " de " + name + " pour le mettre dans " + paddock.getName()));

                    }
                    else
                        Tools.notProposedOption();
                    scannerChoiceMoveAnimalPaddock.nextLine();
                    break;
                }//switch(choiceMoveAnimalPaddock)
            }//while(isNotFinishChoiceActionManagementMoveAnimal)
        //return false;
    }// move()

    /**
     * Permet de réapprovisionner l'enclos en nourriture.
     *
     * @param food
     *          L'indicateur de nourriture à ajouter pour le réapprovisionnement.
     */
    public void restockFood(int food){
        foodIndicator += food;
    } // restockFood

    /**
     * Permet de nettoyer l'enclos.
     */
    public void keepUp(){
        if(cleanliness == "bon")
            System.out.println("Enclos propre, pas besoin d'entretenir");
        else if( hereNbAnimals != 0)
            System.out.println("Enclos non vide, l'entretient ne peut être effectué");
        else {
            cleanliness = "bon";
            System.out.println("L'enclos est maintenant propre");
            isKeepUp = true;
        }
    } // keepUp()
} // class Paddock
