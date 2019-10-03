package quebec.crosemont.g04.demineur;

public class Test {
    public static void main(String[] args) {
        System.out.println("Init de 10/10, construteur Grille()");
        Grille uneGrille= new Grille();
        System.out.println("init 1st 3,3");
        uneGrille.initialiser(0,0,20);
        System.out.println(uneGrille);

        System.out.println("=======================Decouvrir 1,9 no bombe====================");

        uneGrille.decouvrir(1,9);
        System.out.println(uneGrille);
        System.out.println("=======================Decouvrir 2,7 no bombe autour====================");
        uneGrille.decouvrir(2,7);
        System.out.println(uneGrille);

        System.out.println("Test affichage de la fonction toutReveler()");
        uneGrille.toutReveler();
        System.out.println(uneGrille);




    }
}
