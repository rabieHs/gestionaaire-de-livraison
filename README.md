# Système de Gestion de Livraison de Colis

## Description du Projet
Un système de gestion de livraison de colis développé en Java utilisant des threads, des sémaphores et une interface graphique Swing. Le projet simule le processus de livraison de colis avec synchronisation et gestion concurrente.

## Fonctionnalités
- Enregistrement concurrent des colis
- Simulation de la livraison
- Interface graphique intuitive
- Gestion des états de livraison
- Synchronisation des threads

## Prérequis
- Java JDK 8 ou supérieur
- Environnement de développement Java (Eclipse, IntelliJ, NetBeans)

## Technologies Utilisées
- Java Swing
- Multithreading
- Sémaphores
- Gestion concurrente

## Structure du Projet
```
projet-livraison/
├── src/
│   ├── Colis.java
│   ├── EtatColis.java
│   ├── GestionnaireLivraison.java
│   ├── SimulationLivraison.java
│   └── InterfaceLivraisonColis.java
└── README.md
```

## Installation
1. Clonez le repository
```bash
git clone https://github.com/votre-username/projet-livraison.git
```

2. Compilez le projet
```bash
javac *.java
```

3. Exécutez l'application
```bash
java InterfaceLivraisonColis
```

## Utilisation
1. Lancez l'application
2. Cliquez sur "Ajouter Colis"
3. Saisissez les informations du colis
4. Observez la simulation de livraison

## Mécanismes de Synchronisation
- `Semaphore` : Limite l'accès concurrent
- Méthodes `synchronized` : Garantit l'accès exclusif aux ressources

## Captures d'Écran
*Captures d'écran de l'application (à ajouter)*

## Améliorations Potentielles
- Persistance des données
- Authentification utilisateur
- Gestion avancée des erreurs

## Auteur
[Votre Nom]

## Licence
Projet open-source sous licence MIT

## Contribution
Les contributions sont les bienvenues. Veuillez soumettre une pull request.