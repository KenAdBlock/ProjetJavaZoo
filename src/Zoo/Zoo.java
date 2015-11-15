package Zoo;

import Employee.Employee;
import java.util.ArrayList;
import Paddock.Paddock;
import Species.Animal;

/**
 * Created by Darkweizer on 15/11/2015.
 */
public class Zoo {

    private String name;
    private Employee employee;
    private int maxNbPaddock;
    private static ArrayList<Paddock> listPaddock = new ArrayList<>();
    private static ArrayList<ArrayList<Animal>> totalAnimal = new ArrayList<>();

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
}
