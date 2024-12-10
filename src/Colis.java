class Colis {
    private String id;
    private String expediteur;
    private String destinataire;
    private String adresse;
    private EtatColis etat;

    public Colis(String expediteur, String destinataire, String adresse) {
        this.id = genererIdUnique();
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.adresse = adresse;
        this.etat = EtatColis.EN_ATTENTE;
    }

    // Génération d'un ID unique pour chaque colis
    private String genererIdUnique() {
        return "COLIS-" + System.currentTimeMillis();
    }

    // Getters et setters
    public String getId() { return id; }
    public String getExpediteur() { return expediteur; }
    public String getDestinataire() { return destinataire; }
    public String getAdresse() { return adresse; }
    public EtatColis getEtat() { return etat; }
    public void setEtat(EtatColis etat) { this.etat = etat; }
}