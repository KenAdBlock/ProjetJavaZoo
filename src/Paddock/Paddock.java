package Paddock;

import Species.Animal;
import Tools.Tools;

import javax.tools.Tool;
import java.util.ArrayList;
import java.util.Scanner;

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
    private static ArrayList<ArrayList<Animal>> totalAnimal = new ArrayList<>();
    private int foodIndicator = 0;
    private static ArrayList<Paddock> listPaddock = new ArrayList<>();

    public Paddock(String name, int surface, int maxNbAnimals,  String cleanliness) {
        this.name = name;
        this.surface = surface;
        this.maxNbAnimals = maxNbAnimals;
        this.cleanliness = cleanliness;
        listPaddock.add(this);
        Tools.map1.put(this.name, this);
    }// Constructor


    public void setName(String name) {
        this.name = name;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public void setMaxNbAnimals(int maxNbAnimals) {
        this.maxNbAnimals = maxNbAnimals;
    }

    public void setHereNbAnimals(int herNbAnimals) {
        this.hereNbAnimals = herNbAnimals;
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

    @Override
    public String toString() {
        String toString = "Enclos : " + "\n\tnom = " + name + "\n\tsurface = " + surface + "m²\n\tnombre d'animaux maximum = " + maxNbAnimals +
                "\n\tnombre d'animaux présents = " + hereNbAnimals + "\n\ttype d'animal présent = " + typeAnimals + "\n\tdégré de saleté = " + cleanliness +
                "\n\n";
        if(getTypeAnimals().isEmpty())
            toString += "Aucune information sur les animaux car l'enclos est vide.";

        for (Animal a : animalPresent){
            toString += (a + "\n\n");
        }
        return toString;
    }

    public void add(Animal type){
        try{
            if (hereNbAnimals < maxNbAnimals) {
                if (animalPresent.isEmpty() || (animalPresent.get(0)).getClass().getName() == type.getClass().getName()) {
                    animalPresent.add(type);
                    typeAnimals = Tools.hashTypeAnimal(type.getClass().getName().substring(8));
                    type.setPaddock(this);
                    hereNbAnimals++;
                    if (!totalAnimal.contains(animalPresent))
                        totalAnimal.add(animalPresent);
                    else
                        totalAnimal.set(totalAnimal.indexOf(animalPresent), animalPresent);
                }// on ajoute n'importe quel animal vu que l'enclos est vide ou si l'animal à ajouter est du même type que les animaux déjà présent dans l'enclos
                else {
                    System.out.println("Vous ne pouvais pas ajouter un " + Tools.hashTypeAnimal(type.getClass().getName().substring(8)) + " car il y a déja des " + typeAnimals);
                }// l'animal à ajouter n'est pas du même type que les animaux déjà présent
            }
            else
                System.out.println("Enclos plein, vous ne pouvez pas ajouter plus d'animaux ici");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

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
                for(Paddock p : listPaddock){
                    System.out.print(p.getName() + ", ");
                    cpt++;
                    if (cpt == 10) {
                        System.out.println();
                        cpt = 0;
                    }
                }
                System.out.println("?");
                Scanner in = new Scanner(System.in);
                String PaddockChoice = "";
                boolean b = true;
                while(b) {
                    PaddockChoice = in.next();
                    PaddockChoice = PaddockChoice.toLowerCase();
                    for (Paddock p : listPaddock){
                        if(p.getName().equals(PaddockChoice))
                            b = false;
                    }
                }
                Paddock p = Tools.hashPaddock(PaddockChoice);
                p.add(type);
                System.out.println(type.getName() + " à bien été retiré de cette enclos\n");

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
    }// move()

    public void restockFood(int food){
        foodIndicator += food;
    }// restockFood

    public void keepUp(){
        if(cleanliness == "bon")
            System.out.printf("Enclos propre, pas besoin d'entretenir");
        else if( hereNbAnimals != 0)
            System.out.println("Enclos non vide, l'entretient ne peut être effectué");
        else
            cleanliness = "bon";
    }

}// class Paddock
