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

Le jeu demande d'abord au joueur la taille de la grille désirée, sous forme d'une paire d'entiers : Largeur et Hauteur. La grille doit comporter un minimum de 5 et un maximum de 2 147 483 647 cases dans chaque dimension. Sous les cases, ⌈(Largeur × Hauteur ÷ 10)⌉ bombes sont dispersées au hasard.

Avant chaque coup, la grille est affichée. Les cases découvertes montrent le nombre de bombes adjacentes, ou rien du tout si la case n'est adjacente à aucune bombe. Les cases non encore découvertes montrent une case vide ou une marque, le cas échéant.

Le joueur est invité à entrer son prochain coup sous la forme A X Y où :

 * A représente une action parmis : (D)écouvrir, (M)arquer d'un drapeau ou ? pour marquer d'un point d'interrogation
 * X la coordonées horizontale de la case cible
 * Y la coordonées verticale de la case cible

Le tout premier coup, *ne peut pas découvrir une bombe*

Lorsqu'une case est découverte, si elle ne cachait pas de bombe et n'était elle-même adjacente à aucune bombe, tous ses voisins sont automatiquement découverts (et ceci afin d'accélérer le jeu puisqu'on sait maintenant qu'ils ne cachent pas de bombe). Le même traitement est appliqué à ces voisins nouvellement découverts.

Lorsque toutes les cases ne cachant pas de bombe sont découvertes, le jeu se termine par un «BRAVO!!». Si une bombe est découverte, le jeu se termine par un «BOUM!!!». Dans tous les cas, la grille entièrement découverte est affichée une dernière fois.

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
