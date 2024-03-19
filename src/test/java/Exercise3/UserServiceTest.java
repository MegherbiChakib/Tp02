package Exercise3;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    //définition dun mocker
    @Mock
    private UtilisateurApi utilisateurApiMock;
    // creation dun utilisateure
    public Utilisateur utilisateur = new Utilisateur("megherbi","chakib",null);
    public Utilisateur utilisateur2 = new Utilisateur("megherbi","chakib","meg@gmail.com");
    @Test
    public void ExceptionTest() throws ServiceException{
        //definition du comportement du mocker
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenThrow(new ServiceException("Echec de la création de l'utilisateur : certaines informations sont manquantes."));
        //faire la verification pour lException
        Assert.assertThrows(ServiceException.class,()->utilisateurApiMock.creerUtilisateur(utilisateur));// jais pas trouve une maniere de verifier le message envoyer
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);

    }


    @Test
    public void succesTest() throws ServiceException{
        //definition du comportement du mocker
        when(utilisateurApiMock.creerUtilisateur(utilisateur2)).thenReturn(true);
        //faire la verification pour lException
        Assert.assertTrue(utilisateurApiMock.creerUtilisateur(utilisateur2));
        verify(utilisateurApiMock, never()).riseException();

    }

    @Test
    public void question3() throws ServiceException{
        // Définition d'un ID fictif
        int idUtilisateur = 123;

// Configuration du mock pour renvoyer l'ID fictif lors de l'appel à creerUtilisateur(utilisateur)
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);
        when(utilisateurApiMock.getIdUtilisateur(idUtilisateur)).thenReturn(idUtilisateur);

// Appel de la méthode à tester
        utilisateurApiMock.creerUtilisateur(utilisateur);

// Vérification de l'ID de l'utilisateur
        int idRetourne = utilisateurApiMock.getIdUtilisateur(idUtilisateur);
        Assert.assertEquals(idUtilisateur, idRetourne);

    }

    @Test
    public void question4() throws ServiceException{
        // Définition d'un ID fictif
        int idUtilisateur = 123;


        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);
        when(utilisateurApiMock.getIdUtilisateur(idUtilisateur)).thenReturn(idUtilisateur);


        utilisateurApiMock.creerUtilisateur(utilisateur);

        // Création d'un ArgumentCaptor
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);

        // Vérification des arguments capturés
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        // Vérification des valeurs des arguments capturés
        Assert.assertEquals(utilisateur.getNom(), utilisateurCapture.getNom());
        Assert.assertEquals(utilisateur.getPrenom(), utilisateurCapture.getPrenom());
        Assert.assertEquals(utilisateur.getEmail(), utilisateurCapture.getEmail());
    }

}
