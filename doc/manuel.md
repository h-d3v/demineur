# Le démineur, Un classique de Windows 3.1!

## But du jeu

Découvrir toutes les cases sans exploser!

## Déroulement du jeu

Le jeu se joue sur une grille rectangulaire de dimensions variables constituée de cases sous lesquelles peuvent se cacher des bombes. Vous devez découvrir les cases, une à la fois, sans jamais découvrir une bombe. Pour vous aider, les cases adjacentes à au moins une bombe montrent le nombre de bombes auxquelles elles touchent. Les cases se touchent par les côtés et aussi par les coins, chaque case peut donc toucher à un maximum de 8 voisines.

## Fin du jeu

Lorsque vous découvrez une case sous laquelle se cache une bombe, BOUM! C'est la fin de votre carrière de démineur. Si vous parvenez à découvrir toutes les cases sans bombes, vous gagnez la partie.

## Marquer des cases

Pour aider votre recherche, vous pouvez marquer d'un drapeau une case que vous suspectez de cacher une bombe, ou d'un point d'interrogation pour indiquer une sur lequel vous avez un doute.

## Mécanique de jeu

Le jeu demande d'abord au joueur d'entrer son pseudonyme puis, s'il n'existe pas déjà dans la base de données, son nom complet. 

Le jeu affiche alors une liste des 10 meilleurs joueurs plus le joueur qui vient de s'inscrire s'il ne fait pas partie de cette liste avec leurs niveau et nom complet. Par exemple, en supposant que Krusty vient d'entrer son pseudonyme :

1 : BobG (2127) Bob Gratton
2 : Rog21 (1988) Roger Tremblay
...
10 : Zoum (884) Eldéore Thibeault
53 : Krusty99 (81) Krusty Leclown

Ensuite, on lui demande de choisir un niveau de difficulté entre facile, moyen et difficile. Le niveau détermine la taille de la grille et le nombre de bombes dissimulées dans la grille de cette façon : 

 * Facile : 9x9, 10 mines
 * Moyen : 16x16, 40 mines
 * Difficile : 24x24, 99 mines

Avant que la partie ne commence, les 10 meilleurs pointages réalisés pour ce niveau de difficulté sont affichés avec le pseudonyme du joueur et son temps réalisé.

Avant chaque coup, la grille est affichée. Les cases découvertes montrent le nombre de bombes adjacentes, ou rien du tout si la case n'est adjacente à aucune bombe. Les cases non encore découvertes montrent une case vide ou une marque, le cas échéant.

Le joueur est invité à entrer son prochain coup sous la forme A X Y où :

 * A représente une action parmi : (D)écouvrir, (M)arquer d'un drapeau ou ? pour marquer d'un point d'interrogation
 * X la coordonées horizontale de la case cible
 * Y la coordonées verticale de la case cible

Le tout premier coup, *ne peut pas découvrir une bombe*

Lorsqu'une case est découverte, si elle ne cachait pas de bombe et n'était elle-même adjacente à aucune bombe, tous ses voisins sont automatiquement découverts (et ceci afin d'accélérer le jeu puisqu'on sait maintenant qu'ils ne cachent pas de bombe). Le même traitement est appliqué à ces voisins nouvellement découverts.

Lorsque toutes les cases ne cachant pas de bombe sont découvertes, le jeu se termine par un «BRAVO!!». Si une bombe est découverte, le jeu se termine par un «BOUM!!!». Dans tous les cas, la grille entièrement découverte est affichée une dernière fois.

La partie est alors enregistrée avec la date de début et de fin.

## Exemple de déroulement 

    Choisissez la taille de la grille (Largeur Hauteur): 5 5
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║⬜║⬜║⬜║⬜║⬜║
      ╠══╬══╬══╬══╬══╣
     1║⬜║⬜║⬜║⬜║⬜║
      ╠══╬══╬══╬══╬══╣
     2║⬜║⬜║⬜║⬜║⬜║
      ╠══╬══╬══╬══╬══╣
     3║⬜║⬜║⬜║⬜║⬜║
      ╠══╬══╬══╬══╬══╣
     4║⬜║⬜║⬜║⬜║⬜║
      ╚══╩══╩══╩══╩══╝
    Prochain mouvement (A X Y): d 2 2
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║  ║  ║ 1║⬜║⬜║
      ╠══╬══╬══╬══╬══╣
     1║  ║  ║ 1║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     2║ 1║ 1║  ║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     3║⬜║ 3║ 2║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     4║⬜║⬜║⬜║⬜║⬜║
      ╚══╩══╩══╩══╩══╝
    Prochain mouvement (A X Y): m 3 0
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║  ║  ║ 1║🚩║⬜║
      ╠══╬══╬══╬══╬══╣
     1║  ║  ║ 1║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     2║ 1║ 1║  ║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     3║⬜║ 3║ 2║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     4║⬜║⬜║⬜║⬜║⬜║
      ╚══╩══╩══╩══╩══╝
    Prochain mouvement (A X Y): m 0 3
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║  ║  ║ 1║🚩║⬜║
      ╠══╬══╬══╬══╬══╣
     1║  ║  ║ 1║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     2║ 1║ 1║  ║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     3║🚩║ 3║ 2║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     4║⬜║⬜║⬜║⬜║⬜║
      ╚══╩══╩══╩══╩══╝
    Prochain mouvement (A X Y): d 4 4
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║  ║  ║ 1║🚩║⬜║
      ╠══╬══╬══╬══╬══╣
     1║  ║  ║ 1║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     2║ 1║ 1║  ║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     3║🚩║ 3║ 2║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     4║⬜║⬜║⬜║⬜║ 2║
      ╚══╩══╩══╩══╩══╝
    Prochain mouvement (A X Y): m 4 3
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║  ║  ║ 1║🚩║⬜║
      ╠══╬══╬══╬══╬══╣
     1║  ║  ║ 1║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     2║ 1║ 1║  ║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     3║🚩║ 3║ 2║ 3║🚩║
      ╠══╬══╬══╬══╬══╣
     4║⬜║⬜║⬜║⬜║ 2║
      ╚══╩══╩══╩══╩══╝
    Prochain mouvement (A X Y): m 3 4
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║  ║  ║ 1║🚩║⬜║
      ╠══╬══╬══╬══╬══╣
     1║  ║  ║ 1║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     2║ 1║ 1║  ║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     3║🚩║ 3║ 2║ 3║🚩║
      ╠══╬══╬══╬══╬══╣
     4║⬜║⬜║⬜║🚩║ 2║
      ╚══╩══╩══╩══╩══╝
    Prochain mouvement (A X Y): m 4 1
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║  ║  ║ 1║🚩║⬜║
      ╠══╬══╬══╬══╬══╣
     1║  ║  ║ 1║ 3║🚩║
      ╠══╬══╬══╬══╬══╣
     2║ 1║ 1║  ║ 3║⬜║
      ╠══╬══╬══╬══╬══╣
     3║🚩║ 3║ 2║ 3║🚩║
      ╠══╬══╬══╬══╬══╣
     4║⬜║⬜║⬜║🚩║ 2║
      ╚══╩══╩══╩══╩══╝
    Prochain mouvement (A X Y): m 4 2
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║  ║  ║ 1║🚩║⬜║
      ╠══╬══╬══╬══╬══╣
     1║  ║  ║ 1║ 3║🚩║
      ╠══╬══╬══╬══╬══╣
     2║ 1║ 1║  ║ 3║🚩║
      ╠══╬══╬══╬══╬══╣
     3║🚩║ 3║ 2║ 3║🚩║
      ╠══╬══╬══╬══╬══╣
     4║⬜║⬜║⬜║🚩║ 2║
      ╚══╩══╩══╩══╩══╝
    Prochain mouvement (A X Y): d 4 0
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║  ║  ║ 1║🚩║ 2║
      ╠══╬══╬══╬══╬══╣
     1║  ║  ║ 1║ 3║🚩║
      ╠══╬══╬══╬══╬══╣
     2║ 1║ 1║  ║ 3║🚩║
      ╠══╬══╬══╬══╬══╣
     3║🚩║ 3║ 2║ 3║🚩║
      ╠══╬══╬══╬══╬══╣
     4║⬜║⬜║⬜║🚩║ 2║
      ╚══╩══╩══╩══╩══╝
    Prochain mouvement (A X Y): d 2 4
    Bravo!
       0  1  2  3  4
      ╔══╦══╦══╦══╦══╗
     0║  ║  ║ 1║💣║ 2║
      ╠══╬══╬══╬══╬══╣
     1║  ║  ║ 1║ 3║💣║
      ╠══╬══╬══╬══╬══╣
     2║ 1║ 1║  ║ 3║💣║
      ╠══╬══╬══╬══╬══╣
     3║💣║ 3║ 2║ 3║💣║
      ╠══╬══╬══╬══╬══╣
     4║💣║💣║ 2║💣║ 2║
      ╚══╩══╩══╩══╩══╝
