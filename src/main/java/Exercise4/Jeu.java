package Exercise4;

public class Jeu {
    private Banque banque;

    public Jeu(Banque labanque) {
        this.banque = labanque;
    }

/**
    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!estOuvert()) {
            throw new JeuFermeException("Le jeu est fermé");
        }

        int mise = joueur.mise();
        try {
            joueur.debiter(mise);
            int sommeDes = de1.lancer() + de2.lancer();
            if (sommeDes == 7) {
                joueur.crediter(mise * 2);
            }
        } catch (DebitImpossibleException e) {
            // Si le joueur ne peut pas être débité, le jeu est fermé
            fermer();
            throw new JeuFermeException("Le joueur est insolvable");
        }

        // Vérification de la solvabilité de la banque après le jeu
        if (!banque.est_solvable()) {
            fermer();
            throw new JeuFermeException("La banque n'est plus solvable");
        }
    }
 **/

    public void fermer() {

    }

    public boolean estOuvert() {
        return true;
    }
}

