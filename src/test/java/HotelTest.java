import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel1;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    ConferenceRoom conferenceRoom1;
    ConferenceRoom conferenceRoom2;
    Guest guest1;
    Guest guest2;
    DiningRoom diningRoom1;
    DiningRoom diningRoom2;

    @Before
    public void before(){
        hotel1= new Hotel();
        bedroom1= new Bedroom(1,2, "double", 100);
        bedroom2= new Bedroom(2,1, "single", 70);
        bedroom3= new Bedroom(3, 2, "double", 100);
        conferenceRoom1= new ConferenceRoom(20, "Ben Navis");
        conferenceRoom2= new ConferenceRoom(15, "Three Sisters");
        guest1= new Guest("2Pac");
        guest2= new Guest("Snoop Dogg");
        diningRoom1= new DiningRoom("The Kind of Fancy Restaurant (please ignore the rats)");
        diningRoom2= new DiningRoom("The Fancy Bar");
    }

    @Test
    public void canCheckInGuests(){
        hotel1.addBedroomIntoHashMap(bedroom1);
        hotel1.addBedroomIntoHashMap(bedroom2);
        hotel1.addBedroomIntoHashMap(bedroom3);
        hotel1.checkGuestIntoBedroom(guest1);
        assertEquals(1, bedroom1.getGuests().size());
        hotel1.checkGuestIntoConferenceRoom(guest2, conferenceRoom2);
        assertEquals(1, conferenceRoom2.getGuests().size());
    }

    @Test
    public void canAddDiningRooms(){
        hotel1.addToDiningRoomHashMap(diningRoom1);
        hotel1.addToDiningRoomHashMap(diningRoom2);
        hotel1.addToDiningRoomHashMap(diningRoom1);
        assertEquals(2, hotel1.getDiningRoomHashMap().size());
    }

    @Test
    public void canMakeBookings(){
        hotel1.addBedroomIntoHashMap(bedroom2);
        Booking booking1= hotel1.bookBedroom(guest1, bedroom2, 3);
        assertEquals(210, booking1.calculateTotalRate());
        assertEquals(1, bedroom2.getGuests().size());
        Booking booking2= hotel1.bookBedroom(guest2, bedroom2, 3);
        assertEquals(1, bedroom2.getGuests().size());
    }

    @Test
    public void onlyMakeBookingsInVacantRooms(){
        hotel1.addBedroomIntoHashMap(bedroom1);
        hotel1.addBedroomIntoHashMap(bedroom2);
        hotel1.addBedroomIntoHashMap(bedroom3);
        Booking booking1= hotel1.bookBedroom(guest1, bedroom2, 3);
        ArrayList<Bedroom> vacantBedrooms= hotel1.getVacantBedrooms();
        assertEquals(2, vacantBedrooms.size());

    }
}
