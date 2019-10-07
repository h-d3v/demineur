//package quebec.crosemont.g04.demineur;
import java.io.* ;
import java.net.Proxy.Type;
import java.util.*;
import static org.junit.Assert.*;




public class testGrille {
    public static void main (String[]args){

        public static void  testGetLargeur(){
            Grille grilleTest = new Grille(5,5); //objet test
            assertTrue(grilleTest.getLargeur()==5); //S'assurer si la largeur est bel et bien 5.
        
        }
       
        public static void testGetHauteur(){ 
            Grille grilleTest2 = new Grille(5,5);// objet test
            assertTrue(grilleTest.getHauteur()==5);//S'assurer si la hauteur est bel et bien 5.


        }

       public static void testGetCase(){
            Grille grilleTest = new Case(5,5); 
            Case newCase = grilleTest.getCase(2, 3); //voir si la methode retourne vrm un CASE.

            
        }


        public static void testCompterVoisins(){
            Grille voisinsTest = new Grille (10,10);
            int testVoisins = voisinsTest.compterVoisins(3,3);
            System.out.println(testVoisins);


        }



        public static void testInitialiser(){
            Grille initialiserTest = new Grille(10,10);
            initialiserTest.initialiser(x, y, 20);
            
        }


        public static void testDecouvrir() {
            Grille tryDecouvrir = new Grille(10,10);
            Type resultat = tryDecouvrir.decouvrir(4, 4);
            if(resultat instanceof Type ){
                System.out.println("OK");
            }else{
                System.out.println("erreur");
            }



        }
        
        public static void  testToutReveler() {
            Grille testReveler = new Grille(10,10);
            testReveler.toutReveler();




        }
        
        
        public static void testToString () {
            Grille testString = new Grille(10,10);
            String toto = testString.toString();
            System.out.println(toto);



        }
    }
}