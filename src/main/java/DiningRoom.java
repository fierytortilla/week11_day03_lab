import java.util.ArrayList;

public class DiningRoom {
    private String diningRoomName;
    private ArrayList<Guest> guests;

    public DiningRoom(String diningRoomName) {
        this.diningRoomName = diningRoomName;
        this.guests= new ArrayList<Guest>();
    }

    public String getDiningRoomName() {
        return this.diningRoomName;
    }

    public ArrayList<Guest> getGuests() {
        return this.guests;
    }

    public void addGuest(Guest guest){
        this.guests.add(guest);
    }
}
