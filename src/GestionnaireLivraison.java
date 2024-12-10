import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

class GestionnaireLivraison {
    private List<Colis> colis;
    private Semaphore semaphore;

    public GestionnaireLivraison() {
        this.colis = new ArrayList<>();
        // Limite le nombre de threads pouvant accéder simultanément
        this.semaphore = new Semaphore(1);
    }

    // Méthode synchronisée pour enregistrer un colis
    public synchronized void enregistrerColis(Colis nouveauColis) throws InterruptedException {
        semaphore.acquire(); // Acquisition du sémaphore
        try {
            colis.add(nouveauColis);
            System.out.println("Colis enregistré : " + nouveauColis.getId());
        } finally {
            semaphore.release(); // Libération du sémaphore
        }
    }

    // Méthode synchronisée pour mettre à jour l'état d'un colis
    public synchronized void mettreAJourEtatColis(String idColis, EtatColis nouvelEtat) throws InterruptedException {
        semaphore.acquire();
        try {
            for (Colis c : colis) {
                if (c.getId().equals(idColis)) {
                    c.setEtat(nouvelEtat);
                    System.out.println("Mise à jour de l'état du colis " + idColis + " : " + nouvelEtat);
                    break;
                }
            }
        } finally {
            semaphore.release();
        }
    }

    // Méthode synchronisée pour récupérer la liste des colis
    public synchronized List<Colis> getColis() {
        return new ArrayList<>(colis);
    }
}