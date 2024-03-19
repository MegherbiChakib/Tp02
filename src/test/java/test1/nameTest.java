package test1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)

public class nameTest {
    @Mock
    private name nameMock;

    @Test
    public void nameTest(){
        when(nameMock.namePrint()).thenReturn("chakib");
        Assert.assertEquals("chakib",nameMock.namePrint());

        //verifier avec virify
        verify(nameMock).namePrint();


    }

}
