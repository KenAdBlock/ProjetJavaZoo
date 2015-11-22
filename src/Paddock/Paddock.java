package Paddock;

import Employee.Employee;
import Species.Animal;
import Tools.Tools;
import java.util.ArrayList;
import java.util.Scanner;
import Zoo.Zoo;

/**
 * Created by Darkweizer on 12/11/2015.
 */
public class Paddock {
    private String name;
    private int surface;
    private int maxNbAnimals;
    private int hereNbAnimals = 0;
    private String typeAnimals = "pas d'animal présent";
    private String cleanliness;
    private ArrayList<Animal> animalPresent = new ArrayList<>();
    private int maxQuantityFood = 2000;
    private int foodIndicator = 125;//maxQuantityFood;
    protected boolean isGoodType = false;
    protected boolean isKeepUp = false;
    private static int nbPaddock = 0;

    public Paddock(String name, int surface, int maxNbAnimals,  String cleanliness) {
        this.name = name;
        this.surface = surface;
        this.maxNbAnimals = maxNbAnimals;
        this.cleanliness = cleanliness;
        Zoo.getListPaddock().add(this);
        Tools.map1.put(this.name, this);
        nbPaddock+=1;
    }
    public Paddock(){}// Constructor


    public void setName(String name) {
        this.name = name;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public void setMaxNbAnimals(int maxNbAnimals) {
        this.maxNbAnimals = maxNbAnimals;
    }

    public void setHereNbAnimals(int hereNbAnimals) {
        this.hereNbAnimals = hereNbAnimals;
    }

    public void setTypeAnimals(String typeAnimals) {
        this.typeAnimals = typeAnimals;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }

    public void setFoodIndicator(int foodIndicator) {
        this.foodIndicator = foodIndicator;
    }// Setter

    public static void setNbPaddock(int nbPaddock) {
        Paddock.nbPaddock = nbPaddock;
    }



    public String getName() {
        return name;
    }

    public int getSurface() {
        return surface;
    }

    public int getMaxNbAnimals() {
        return maxNbAnimals;
    }

    public int getHereNbAnimals() {
        return hereNbAnimals;
    }

    public String getTypeAnimals() {
        return typeAnimals;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public int getFoodIndicator() {
        return foodIndicator;
    }// Getter

    public static int getNbPaddock() {
        return nbPaddock;
    }

    public int getMaxQuantityFood() {
        return maxQuantityFood;
    }

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
    }

    public void add(Animal type){
        try {
            //if (type.getTypeAnimal().equals("autre") || isGoodType) {

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
            /*}
            else
                System.out.println(type.getName() + " ne peut pas entrer dans " + this.getName());*/
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

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

    public void restockFood(int food){
        foodIndicator += food;

    }// restockFood

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
    }

}// class Paddock
