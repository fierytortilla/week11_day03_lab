import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    ArrayList<Bedroom> bedrooms;
    ArrayList<ConferenceRoom> conferenceRooms;
    HashMap<String,DiningRoom> diningRoomHashMap;
    HashMap<Bedroom,Integer> bedroomHashMap;

    public Hotel(){
        this.bedrooms= new ArrayList<Bedroom>();
        this.conferenceRooms= new ArrayList<ConferenceRoom>();
        this.diningRoomHashMap= new HashMap<String, DiningRoom>();
        this.bedroomHashMap= new HashMap<Bedroom,Integer>();
    }

    public ArrayList<Bedroom> getBedrooms() {
        return this.bedrooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return this.conferenceRooms;
    }

    public void addBedroomIntoHashMap(Bedroom bedroom){
        if(!this.bedroomHashMap.containsKey(bedroom)) {
            this.bedroomHashMap.put(bedroom, bedroom.getCapacity());
        }
    }

    public void checkGuestIntoBedroom(Guest guest) {
        ArrayList<Bedroom> vacantBedrooms= this.getVacantBedrooms();
        if(vacantBedrooms.size()>0){
            vacantBedrooms.get(0).checkInGuest(guest);
        }
    }

    public void checkGuestIntoConferenceRoom(Guest guest, ConferenceRoom conferenceRoom) {
        String conferenceRoomName = conferenceRoom.getRoomName();
        conferenceRoom.checkInGuest(guest);
    }

    public Booking bookBedroom(Guest guest, Bedroom bedroom, int numberNights){
        int currentCapacity= this.bedroomHashMap.get(bedroom);
        if(currentCapacity>0){
            currentCapacity-=1;
            this.bedroomHashMap.put(bedroom, currentCapacity);
            bedroom.checkInGuest(guest);
            Booking booking= new Booking(bedroom, numberNights);
            return booking;
        }
        return null;
    }

    public void addToDiningRoomHashMap(DiningRoom diningRoom){
        if(!this.diningRoomHashMap.containsKey(diningRoom.getDiningRoomName())) {
            this.diningRoomHashMap.put(diningRoom.getDiningRoomName(), diningRoom);
        }
    }

    public HashMap<String,DiningRoom> getDiningRoomHashMap() {
        return this.diningRoomHashMap;
    }

    public ArrayList<Bedroom> getVacantBedrooms(){
        ArrayList<Bedroom> vacantBedrooms= new ArrayList<Bedroom>();
        for(Bedroom bedroom : this.bedroomHashMap.keySet()){
            int currentCapacity= this.bedroomHashMap.get(bedroom);
            if(currentCapacity==bedroom.getCapacity()){
                vacantBedrooms.add(bedroom);
            }
        }
        return vacantBedrooms;
    }
}
