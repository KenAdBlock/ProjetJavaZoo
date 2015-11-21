import Tools.Tools;
import Zoo.Zoo;

public class Main {

    public static void main(String[] args) {
        System.out.println(Tools.strColorBlue("Le zoo " + Zoo.getINSTANCE().getName() +  " ouvre ses portes ! Bienvenue."));
        Zoo.getINSTANCE().run();
    } // main()


} // class Main