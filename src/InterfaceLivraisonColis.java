import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InterfaceLivraisonColis extends JFrame {
    private GestionnaireLivraison gestionnaire;
    private JTable tableColis;
    private DefaultTableModel modeleTableau;

    public InterfaceLivraisonColis() {
        gestionnaire = new GestionnaireLivraison();

        setTitle("Système de Livraison de Colis");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuration du tableau
        String[] colonnes = {"ID", "Expéditeur", "Destinataire", "Adresse", "État"};
        modeleTableau = new DefaultTableModel(colonnes, 0);
        tableColis = new JTable(modeleTableau);

        JScrollPane scrollPane = new JScrollPane(tableColis);

        // Création d'un panneau pour les boutons
        JPanel panelBoutons = new JPanel();

        // Bouton pour ajouter un nouveau colis
        JButton btnAjouterColis = new JButton("Ajouter Colis");
        btnAjouterColis.addActionListener(e -> ajouterColis());
        panelBoutons.add(btnAjouterColis);

        // Configuration de la mise en page
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panelBoutons, BorderLayout.SOUTH);

        // Démarrer la mise à jour périodique
        demarrerMiseAJourPeriodique();
    }

    private void demarrerMiseAJourPeriodique() {
        // Crée un Timer qui met à jour l'interface toutes les 2 secondes
        Timer timer = new Timer(2000, e -> rafraichirListeColis());
        timer.start();
    }

    private void ajouterColis() {
        // Boîte de dialogue pour saisir les informations du colis
        String expediteur = JOptionPane.showInputDialog("Nom de l'expéditeur :");
        String destinataire = JOptionPane.showInputDialog("Nom du destinataire :");
        String adresse = JOptionPane.showInputDialog("Adresse de livraison :");

        if (expediteur != null && destinataire != null && adresse != null) {
            Colis nouveauColis = new Colis(expediteur, destinataire, adresse);
            SimulationLivraison simulation = new SimulationLivraison(gestionnaire, nouveauColis);
            simulation.start();
        }
    }

    private void rafraichirListeColis() {
        // Récupérer les colis actuels
        List<Colis> listeColis = gestionnaire.getColis();

        // Utiliser SwingUtilities.invokeLater pour assurer la mise à jour thread-safe
        SwingUtilities.invokeLater(() -> {
            // Synchroniser avec le modèle de tableau
            synchronized (modeleTableau) {
                // Nettoyer le tableau existant
                modeleTableau.setRowCount(0);

                // Ajouter les colis actuels
                for (Colis c : listeColis) {
                    modeleTableau.addRow(new Object[]{
                            c.getId(),
                            c.getExpediteur(),
                            c.getDestinataire(),
                            c.getAdresse(),
                            c.getEtat()
                    });
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfaceLivraisonColis interfaceLivraison = new InterfaceLivraisonColis();
            interfaceLivraison.setVisible(true);
        });
    }
}