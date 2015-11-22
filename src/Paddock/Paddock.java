package Paddock;

import java.util.ArrayList;
import java.util.Scanner;

import Tools.Tools;
import Species.Animal;
import Zoo.Zoo;

/**
 * Paddock est une classe représentant un enclos "classique".
 * Il possède des caractéristiques de base telles que le nom ou la surface.
 *
 * @author Charles-Henri CARLIER et Kenny COADALEN
 */
public class Paddock {

    /**
     *
     */
    private String name;

    /**
     *
     */
    private int surface;

    /**
     *
     */
    private int maxNbAnimals;

    /**
     *
     */
    private int hereNbAnimals = 0;

    /**
     *
     */
    private String typeAnimals = "pas d'animal présent";

    /**
     *
     */
    private String cleanliness;

    /**
     *
     */
    private ArrayList<Animal> animalPresent = new ArrayList<>();

    /**
     *
     */
    private int maxQuantityFood = 2000;

    /**
     *
     */
    private int foodIndicator = 125;//maxQuantityFood;

    /**
     *
     */
    protected boolean isGoodType = false;

    /**
     *
     */
    protected boolean isKeepUp = false;

    /**
     *
     */
    private static int nbPaddock = 0;

    /**
     *
     *
     * @param name
     * @param surface
     * @param maxNbAnimals
     * @param cleanliness
     */
    public Paddock(String name, int surface, int maxNbAnimals,  String cleanliness) {
        this.name = name;
        this.surface = surface;
        this.maxNbAnimals = maxNbAnimals;
        this.cleanliness = cleanliness;
        Zoo.getListPaddock().add(this);
        Tools.map1.put(this.name, this);
        nbPaddock+=1;
    }// Constructor

    /**
     *
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    } // setName()

    /**
     *
     *
     * @param surface
     */
    public void setSurface(int surface) {
        this.surface = surface;
    } // setSurface()

    /**
     *
     *
     * @param maxNbAnimals
     */
    public void setMaxNbAnimals(int maxNbAnimals) {
        this.maxNbAnimals = maxNbAnimals;
    } // setMaxNbAnimals()

    /**
     *
     *
     * @param hereNbAnimals
     */
    public void setHereNbAnimals(int hereNbAnimals) {
        this.hereNbAnimals = hereNbAnimals;
    } // setHereNbAnimals()

    /**
     *
     *
     * @param typeAnimals
     */
    public void setTypeAnimals(String typeAnimals) {
        this.typeAnimals = typeAnimals;
    } // setTypeAnimals()

    /**
     *
     *
     * @param cleanliness
     */
    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    } // setCleanliness()

    /**
     *
     *
     * @param foodIndicator
     */
    public void setFoodIndicator(int foodIndicator) {
        this.foodIndicator = foodIndicator;
    } // setFoodIndicator()

    /**
     *
     *
     * @param nbPaddock
     */
    public static void setNbPaddock(int nbPaddock) {
        Paddock.nbPaddock = nbPaddock;
    } // setNbPaddock()


    /**
     *
     *
     * @return
     */
    public String getName() {
        return name;
    } // getName()

    /**
     *
     *
     * @return
     */
    public int getSurface() {
        return surface;
    } // getSurface()

    /**
     *
     *
     * @return
     */
    public int getMaxNbAnimals() {
        return maxNbAnimals;
    } // getMaxNbAnimals()

    /**
     *
     *
     * @return
     */
    public int getHereNbAnimals() {
        return hereNbAnimals;
    } // getHereNbAnimals()

    /**
     *
     *
     * @return
     */
    public String getTypeAnimals() {
        return typeAnimals;
    } // getTypeAnimals()

    /**
     *
     *
     * @return
     */
    public String getCleanliness() {
        return cleanliness;
    } // getCleanliness()

    /**
     *
     *
     * @return
     */
    public int getFoodIndicator() {
        return foodIndicator;
    } // getFoodIndicator()

    /**
     *
     * @return
     */
    public static int getNbPaddock() {
        return nbPaddock;
    } // getNbPaddock()

    /**
     *
     * @return
     */
    public int getMaxQuantityFood() {
        return maxQuantityFood;
    } // getMaxQuantityFood()

    /**
     *
     *
     * @return
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
     *
     *
     * @param type
     */
    public void add(Animal type){
        try {
            if (type.getTypeAnimal().equals("autre") || isGoodType) {

                if (hereNbAnimals < maxNbAnimals) {
                    if (animalPresent.isEmpty() || (animalPresent.get(0)).getClass().getName() == type.getClass().getName()) {
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
     *
     *
     * @param type
     */
    public void move(Animal type){
        try{
            if(animalPresent.isEmpty()) {
                System.out.println("Il n'y a pas d'animal dans cette enclos\n");
            }// pas d'animal présent donc il n'est pas retiré
            else if(animalPresent.contains(type)) {
                animalPresent.remove(animalPresent.indexOf(type));
                hereNbAnimals--;
                if (hereNbAnimals == 0)
                    typeAnimals = "pas d'animal présent";
                System.out.println("Dans quel enclos voulez-vous transferer " + type.getName() + " parmis : ");
                int cpt = 0;
                for(Paddock p : Zoo.getListPaddock()){
                    if (p.getName() != this.getName()){
                        System.out.print(p.getName() + " ");
                        cpt++;
                        if (cpt == 5) {
                            System.out.println("");
                            cpt = 0;
                        }
                    }
                }
                System.out.println("?");
                Scanner in = new Scanner(System.in);
                String PaddockChoice = "";
                boolean b = true;
                while(b) {
                    PaddockChoice = in.next();
                    PaddockChoice = PaddockChoice.toLowerCase();
                    for (Paddock p : Zoo.getListPaddock()){
                        if(p.getName().equals(PaddockChoice))
                            b = false;
                    }
                }
                Paddock p = Tools.hashPaddock(PaddockChoice);
                p.add(type);
                System.out.println(type.getName() + " à bien été retiré de " + this.getName() + " pour être mis dans " + PaddockChoice +"\n");

            }// il est présent et est retiré
            else if(animalPresent.get(0).getClass().getName() != type.getClass().getName()){
                System.out.println(type.getName() + " ne peut être dans cette enclos car il contient des " + typeAnimals + " et non des " + Tools.hashTypeAnimal(type.getClass().getName().substring(8)) + "\n");
            }// le type d'animal à retiré n'est pas le même que ceux déjà présent donc il n'est pas retiré
            else{
                System.out.println(type.getName() + " n'est pas dans cette enclos" + "\n");
            }// l'animal n'est pas dans cette enclos donc il n'est pas retiré
        }
        catch (Exception e){
            e.printStackTrace();
        }
    } // move()

    /**
     *
     *
     * @param food
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
