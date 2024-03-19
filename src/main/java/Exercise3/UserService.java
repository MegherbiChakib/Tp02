            package Exercise3;

            public class UserService implements UtilisateurApi {
                private final UtilisateurApi utilisateurApi;
                public UserService(UtilisateurApi utilisateurApi) {
                    this.utilisateurApi = utilisateurApi;
                }
                public boolean creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
                    if (utilisateur.getNom() == null || utilisateur.getPrenom() == null || utilisateur.getEmail() == null) {
                        riseException();
                        return false;
                    }
                    else {
                        utilisateurApi.creerUtilisateur(utilisateur);
                        return true;
                    }

                }

                @Override
                public void riseException() throws ServiceException {
                    throw new ServiceException("Echec de la création de l'utilisateur : certaines informations sont manquantes.");
                }

                @Override
                public int getIdUtilisateur(int id) {
                    return id;
                }

            }