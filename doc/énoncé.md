Vous allez faire de toutes pièces un jeu de démineur en ligne de commande. Si vous aviez eu cette idée en 1983, vous seriez riche aujourd'hui!

Le jeu doit se rapprocher le plus possible de la version classique pour Windows 3.0. Pour l'instant, toutes les interactions se font dans un terminal, mais éventuellement, rien ne nous empêchera d'y ajouter une interface graphique.

## Vous devez :

 * créer une divergence à partir du projet Démineur sur gitlab [https://git.dti.crosemont.quebec/plafrance/demineur.git](https://git.dti.crosemont.quebec/plafrance/demineur.git)
 * créer les classes du package quebec.crosemont.g04.demineur demandées selon le schéma UML et le document d'analyse (à venir)
 * tester ces classes grâce à des tests unitaires JUnit
 * documenter votre code avec les commentaires javadoc.
 * gérer votre code grâce au gestionnaire de versions git
 
## Remise : 

C'est le code disponible sur votre divergence sur le gitlab du département au moment de la remise qui sera évaluée.

Date de remise : 1er octobre 23h59


## Gestion du projet :

Le projet se fait en équipes de deux ou trois personnes.

L'un des coéquipier devra être responsable de créer la divergence et de fusionner les branches de ses coéquipiers et les changements au _master_ du projet original. *N'oubliez pas de rendre votre projet privé sur gitlab*

Pour ce faire, il devra :

 * ajouter un _remote_ à son propre projet :

    git remote add upstream https://git.dti.crosemont.quebec/plafrance/demineur.git
	
 * synchroniser les changements au master original, en faisant, à partir de son propre _master_ :
 
    git pull upstream master
	
  et éventuellement régler les conflits.	
