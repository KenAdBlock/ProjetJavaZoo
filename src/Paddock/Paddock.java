package Paddock;

/**
 * Created by Darkweizer on 12/11/2015.
 */
public class Paddock {
    private String name;
    private int surface;
    private int maxNbAnimals;
    private int hereNbAnimals;
    private String typeAnimals;
    private String cleanliness;

    public Paddock(String name, int surface, int maxNbAnimals, int hereNbAnimals, String typeAnimals, String cleanliness) {
        this.name = name;
        this.surface = surface;
        this.maxNbAnimals = maxNbAnimals;
        this.hereNbAnimals = hereNbAnimals;
        this.typeAnimals = typeAnimals;
        this.cleanliness = cleanliness;
    }

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

    @Override
    public String toString() {
        String toString = "Enclos : " + "\n\tnom = " + name + "\n\tsurface = " + surface + "m²\n\tnombre d'animaux maximum = " + maxNbAnimals +
                "\n\tnombre d'animaux présents = " + hereNbAnimals + "\n\ttype d'animal présent = " + typeAnimals + "\n\tdégré de saleté = " + cleanliness +
                "\n\n";
        if(getTypeAnimals().isEmpty())
            toString += "Aucune information sur les animaux car l'enclos est vide.";
        /*else
            toString += getTypeAnimals().;*/ // chercher comvertir string en class

        return toString;
    }
}
