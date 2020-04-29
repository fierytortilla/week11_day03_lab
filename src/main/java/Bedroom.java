import java.util.ArrayList;

public class Bedroom {
    private int roomNumber;
    private int capacity;
    private String roomType;
    private ArrayList<Guest> guests;
    private int nightlyRate;


    public Bedroom(int roomNumber, int capacity, String roomType, int nightlyRate){
        this.roomNumber= roomNumber;
        this.capacity= capacity;
        this.roomType= roomType;
        this.nightlyRate= nightlyRate;
        this.guests= new ArrayList<Guest>();
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public int getNightlyRate() {
        return this.nightlyRate;
    }

    public ArrayList<Guest> getGuests(){
        return this.guests;
    }

    public void checkInGuest(Guest guest){
        this.guests.add(guest);
    }


}
