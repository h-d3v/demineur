package quebec.crosemont.g04.demineur;

public class Test {
    public static void main(String[] args) {
        System.out.println("Init de 10/10, construteur Grille()");
        Grille uneGrille= new Grille();
        System.out.println("init 1st");
        uneGrille.initialiser(1,1,20);
        System.out.println(uneGrille);

        System.out.println("Test unitaire de la fonction compterVoisins() pour les cases8-7 0-0 et 9-9\n");

        System.out.println(uneGrille.compterVoisins(8,7));
        System.out.println(uneGrille.compterVoisins(9,9));
        System.out.println(uneGrille.compterVoisins(0,0));
        System.out.println("Test unitaire de la fonction marquer()");
        uneGrille.cases[1][1].marquer();
        System.out.println(uneGrille);
        uneGrille.cases[1][1].marquer();
        System.out.println(uneGrille);

        uneGrille.cases[1][1].marquer();
        System.out.println(uneGrille);
        System.out.println("Test unitaire de la fonction toutReveler()");
        uneGrille.toutReveler();
        System.out.println(uneGrille);




    }
}
