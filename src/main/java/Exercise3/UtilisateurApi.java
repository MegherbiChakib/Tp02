package Exercise3;

public interface UtilisateurApi {
    boolean creerUtilisateur(Utilisateur utilisateur) throws ServiceException;

    void riseException() throws ServiceException;

    int getIdUtilisateur(int id);
}