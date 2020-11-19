# GiveMeACar Test

## Projet fil rouge réalisé par Trystan, Vivien et Gino

Le but de se projet est de maitrîser les technologies tel que JAVA, Spring, React, les bases de données et de répondre à cet intitulé:

Afin d’appuyer le développement national et international de l’activité de location, nous voulons
développer une plateforme de location en ligne Givemeacar.

### Le concept

Aujourd’hui pour se déplacer en voiture (ou camionnette), il faut soit acheter une voiture, soit en
louer une. Dans une location classique, on loue une voiture dans une agence et on la restitue dans la
même agence, voire dans une autre agence (one way). Dans les grandes villes, il est possible de louer
des véhicules électriques à des bornes, cependant le périmètre est restreint.
Jaipasdevoiture invente un nouveau concept : louer une voiture n’importe où et la restituer
n’importe où. Pour trouver un véhicule, le loueur recherche sur son smartphone les véhicules les plus
proches de sa position.

### Les besoins

#### Gestion des agences

Nous pouvons créer une agence sur tout le territoire Grand-Ouest. Cette agence est identifiée par la
ville.
L’agence de Nantes est le siège social.
Les autres agences sont : Quimper, Morlaix, Pontivy, Rennes, Nantes, Angers, Laval, La Roche-surYon.
Les agences ont un stock propre de véhicules. Elles sont responsables du bon fonctionnement de la
location sur leur territoire.
Une agence connaît son stock : nombre de véhicules, les véhicules disponibles, les véhicules à réviser.

#### Parc de véhicules

Dans un premier temps, ce seront uniquement des véhicules thermiques.
Il faut pouvoir entrer un nouveau véhicule en stock et le sortir du stock. C’est une agence qui fait
cette action.
Un véhicule est révisé tous les 6 mois par une agence.
Un véhicule peut être indisponible à la location.
Un véhicule peut changer d’agence selon les besoins.

#### Le véhicule

Le véhicule est un véhicule de tourisme. Il est composé d’une marque et d’un modèle de voiture.
Il a un prix de location basé sur la minute.
Le véhicule est disponible à la location, indisponible, loué.
Le véhicule est géolocalisable.
Le véhicule est connecté au stock. Il indique sa position, s’il est occupé, et son niveau de carburant. Si
le réservoir est rempli de moitié, le véhicule lance une alerte et se met en indisponible.
Cette connectivité se fera grâce à des objets connectés ou une application Android.

#### La recherche d’un véhicule disponible

C’est une recherche pour un besoin immédiat.
Il n’y a pas de recherche programmée dans le temps, car on n’a pas la possibilité de savoir où seront
situés les véhicules.
Sur son smartphone, le visiteur indique un rayon de recherche et la durée de location.
Tous les véhicules situés dans le rayon et disponibles sont affichés en premier.
Ensuite viennent les véhicules situés dans un rayon multiplié par 2, ou les véhicules situés dans le
rayon mais libres à un autre moment de la journée.

#### La location

Pour louer un véhicule, l'utilisateur utilise une application sur son téléphone.
Il doit s’identifier sur le site. Le loueur indique la voiture, l’heure de début et le temps de location
estimé. Le prix calculé de la location est indicatif. Il est calculé sur un forfait de base + un prix à la
minute.
Le forfait est le même pour tous. Le prix à la minute dépend du véhicule.
A la fin de la location, le loueur indique l’heure de fin. La tarification réelle se base sur les mêmes
tarifs, mais est calculée sur le temps réel d’utilisation. Le montant réel est affiché sur le smartphone.

#### L’alimentation en carburant

La société Jaipasdevoiture souhaite dans un futur être responsable de l’alimentation en carburant
des véhicules.
En attendant cette fonctionnalité, c’est le loueur qui fait le plein d’essence. Il envoie sur son
smartphone le montant et une photo du ticket d’essence. Le montant sera déduit de la facture.

#### La facturation

Toute location entraîne une facturation. Cette facturation est déléguée à l’ERP Odoo.
Cette facturation est matérialisée par l’écriture des données dans un fichier csv.

#### Sortie du stock

Les véhicules sortis du stock sont mis à la vente sur un site de e-commerce. Nous utiliserons un CMS
pour cela.
