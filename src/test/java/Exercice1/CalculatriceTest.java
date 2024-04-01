    package Exercice1;
    import org.junit.Assert;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.mockito.Mock;
    import org.mockito.junit.MockitoJUnitRunner;
    import static org.mockito.Mockito.*;
    @RunWith(MockitoJUnitRunner.class)

    public class CalculatriceTest {
        @Mock
        private Calculatrice calculatrice;
        @Test
        public void testAdditionner() {
            // Définition du comportement de la méthode "additionner"
            when(calculatrice.additionner(2, 3)).thenReturn(5);
            //TODO : Appel de la méthode à tester
            int x=calculatrice.additionner(2,3);
            //TODO : Vérification du résultat
            Assert.assertEquals(x,5);


    //TODO : Vérification que la méthode "additionner" a été appelée
            verify(calculatrice).additionner(2,3);

    // avec les arguments 2 et 3, utiliser la directive « verify »
    //TODO : Vérification qu'aucune autre méthode n'a été appelée sur
    //l'objet après l'appel de la méthode "additionner", utiliser la
    // méthode « verifyNoMoreInteractions »
            verifyNoMoreInteractions(calculatrice);
    // TODO : Vérification de l'état de l'objet après l'appel de la
    // méthode "additionner", penser à utiliser la méthode
    // « getState() » de la directive « verify » : // exemple :

            //La methode getState ne veut pas marcher
            when(calculatrice.getState()).thenReturn("hello");
            String s= calculatrice.getState();
            Assert.assertEquals("hello",s);
            verify(calculatrice).getState();




            //les etapes de travaille
            // 1/ declaration de moker
            // 2/cree la fonction de teste
            //      a/imulé lé le travaille de moker en utiliant when(moker.fonction()).thenReturn();
            //      b/verfifie le travaoille de moker avec assert
            //      on peut savoire si une methode a ete appeler verify(moker).function()
            //      verify no more
        }
    }