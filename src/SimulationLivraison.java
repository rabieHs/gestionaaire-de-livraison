class SimulationLivraison extends Thread {
    private GestionnaireLivraison gestionnaire;
    private Colis colis;

    public SimulationLivraison(GestionnaireLivraison gestionnaire, Colis colis) {
        this.gestionnaire = gestionnaire;
        this.colis = colis;
    }

    @Override
    public void run() {
        try {
            // Enregistrement initial du colis
            gestionnaire.enregistrerColis(colis);

            // Simulation du attend
            gestionnaire.mettreAJourEtatColis(colis.getId(), EtatColis.EN_ATTENTE);
            Thread.sleep(2000);

            // Simulation du transit
            gestionnaire.mettreAJourEtatColis(colis.getId(), EtatColis.EN_TRANSIT);
            Thread.sleep(2000); // Simulation du temps de transit

            // Simulation de la livraison
            gestionnaire.mettreAJourEtatColis(colis.getId(), EtatColis.LIVRE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}