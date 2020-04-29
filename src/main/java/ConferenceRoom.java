import java.util.ArrayList;

public class ConferenceRoom {
    private int capacity;
    private String roomName;
    private ArrayList<Guest> guests;


    public ConferenceRoom(int capacity, String roomName){
        this.capacity= capacity;
        this.roomName= roomName;
        this.guests= new ArrayList<Guest>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getRoomName(){
        return this.roomName;
    }

    public ArrayList<Guest> getGuests(){
        return this.guests;
    }

    public void checkInGuest(Guest guest){
        this.guests.add(guest);
    }
}
