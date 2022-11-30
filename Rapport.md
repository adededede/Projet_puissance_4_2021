# Rapport projet A31 : Puissance4

Dans ce rapport nous allons présenter nos choix de conceptions ainsi que les problèmes que nous avons rencontrés lors de la réalisation du projet d’A31.

##  Choix de conceptions

### Variantes

L’implémentation des variantes est _réalisable_. 

Effectivement, grâce à la classe jeton qui désigne le jeton et sa couleur (grâce à une classe énum ; jaune ou rouge) il sera possible d’ajouter un nouvel attribut, état par exemple, qui désignera la spécificité du jeton comme demandé pour la variante __"Power Up"__.

Ensuite, pour la version __"Pop Out"__ il suffira de créer une nouvelle vue grille où les cases de la grille seront cliquable, d’ajouter à ces cases cliquables des écouteurs qui permettront d’éjecter le jeton concerné. Il faudra, auparavant, vérifier si le jeton sélectionné est en bas de colonne (sur la ligne 0) et s’il appartient bien au joueur courant.

Puis, quant à la variante __"Pop 10"__, il sera nécessaire de créer un décorateur de la vue vueGrilleClassique qui appellera une méthode remplirGrille qui permettra de remplir la grille avant de lancer la partie. Ensuite les règles du jeu sont à implémenter dans le contrôleur. 

Enfin, la version __"5 in a row"__ est implémentable grâce à un décorateur de la vue vueGrilleClassique qui rajoute deux colonnes préremplis aux extrémités de la grille.

Pour le choix des différents jetons la vue a une liste de jeton que le Joueur possède dans sa main. Si le joueur a des nouveaux jetons dans sa main la vue s'adaptera.
Néanmoins il restera des modifications à faire pour le contrôleur et la vue qui sont encore trop dépendant du type de partie.
Nous aurions pu utiliser des templates pour le controleur et la vue mais nous ne l'avons pas implémenté par manque de temps.

### Conceptions spécifiques

Pour notre projet nous avons choisi de faire une classe jeton car un jeton peut avoir un type dans la variante "Power Up". Nous avons choisi d'ajouter à cette classe une classe enum permettant de différencier les jetons en deux groupes (par couleur). 

Nous avons aussi crée les classes suivantes:
*   Partie
*   Joueur
*   Plateau
*   ControleurClassique
*   VueGrilleClassique

Chacunes de ces classes a un rôle bien précis. En effet, la classe controleur est chargé de gérer la partie et la vue. La vue affiche la partie visuelle du jeu. La classe joueur elle gère les joueurs qui eux possèdent une collections de jetons. Et le plateau correspond à la grille possède différents attributs tel que la hauteur et la largeur. Elle reçoit les jetons que les joueurs placent.

##  Problèmes rencontrés

Les problèmes rencontrés furent principalement le manque de temps et le distanciel. C'est pourquoi nous avons choisi de nous concentrer sur la version de "base", afin d'avoir un programme fonctionnel plutôt que d'essayer de faire toutes les variantes possibles. 

Par ailleurs, le diagramme de classe fut aussi complexe à mettre en place et changea de nombreuses fois au cours du projet. 

Nous avons aussi remarqué trop tard des difficultés qui se poserait à nous dans le développement de nouvelles versions. Par exemple la classe *Couleur* n'est pas un bon nommage pour les actions, de plus les jetons n'ont pas "d'action" c'est une erreur de conception qu'il faudrait implémenter.

Nous avons aussi eu des problèmes avec le git mais rien d'insurmontable. (des problèmes de versions de fichiers)
