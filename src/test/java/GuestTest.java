import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GuestTest {
    Guest guest1;

    @Before
    public void before(){
        guest1= new Guest("Sara");
    }

    @Test
    public void getGuestName(){
        assertEquals("Sara", guest1.getName());
    }
}
