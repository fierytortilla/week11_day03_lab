public class Booking {
    private Bedroom bedroom;
    private int numberNights;
    private int nightlyRate;

    public Booking(Bedroom bedroom, int numberNights){
        this.bedroom= bedroom;
        this.numberNights= numberNights;
        this.nightlyRate= bedroom.getNightlyRate();
    }

    public Bedroom getBedroom() {
        return this.bedroom;
    }

    public int getNumberNights() {
        return this.numberNights;
    }

    public int getNightlyRate() {
        return this.nightlyRate;
    }

    public int calculateTotalRate(){
        int result= this.nightlyRate*this.numberNights;
        return result;
    }


}
