public class Airline {

    static final int CAPACITY = 100;
    private String departureAirport;
    private String destinationAirport;
    private int timeToTakeOff;
    private int inFligth;
    private int refule;
    private boolean ready;

    /**
     * This constructor creates an Airplane object with all the necessary information.
     *
     * @param departureAirport The name of the current airport.
     * @param destinationAirport The airport where the fight is heading.
     * @param timeToTakeOff If the value is less than 5, the plane is getting ready and boarding over.
     */
    public Airline(String departureAirport, String destinationAirport, int timeToTakeOff){
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.timeToTakeOff = timeToTakeOff;
        this.inFligth = 0;
        this.refule = 0;
    }


    /**
     * Reduces the time a plane is in the air by one minute.
     *
     * If the plane is done flying, this method updates the plane profile.
     */
    public void reduceFlightTime(){
        inFligth--;
        if (inFligth == 0){
            timeToTakeOff = 30;
            refule = 10;
            ready = false;
        }

    }

    public boolean isInFlight(){
        return inFligth != 0;
    }

    /**
     * Determines whether a plane is currently refueling or not.
     *
     * @return True if the plane is refueling, false otherwise.
     */
    public boolean isRefulling(){
        return refule != 0;
    }

    /**
     * Reduces the time fulling by 1 minute.
     */
    public void reduceRefuling(){

        refule--;

    }



    /**
     * This method the time untill take off of a plane.
     *
     * It reduces the time by 1 minute since the simulation updates every minute.
     */
    public void reduceRemainingTime(){
        timeToTakeOff = timeToTakeOff- 1;
    }


    /**
     *
     * @return True is a plane is ready to start boarding, false otherwise.
     */
    public boolean isReady() {
        return ready;
    }

    /**
     *
     * @param departureAirport The airport the plane is currently at.
     */
    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    /**
     *
     * @param destinationAirport Destination of a plane.
     */
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    /**
     *
     * @param timeToTakeOff How long until the plane starts its journey (In minutes).
     */
    public void setTimeToTakeOff(int timeToTakeOff) {
        this.timeToTakeOff = timeToTakeOff;
    }

    /**
     *
     * @param ready True is a plane is ready to start boarding, false otherwise.
     */
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    /**
     *
     * @param refule The amount of time in minutes it takes for a plane to refuel, after a flight.
     */
    public void setRefule(int refule) {
        this.refule = refule;
    }


    /**
     *
     * @param inFligth The amount of time (in minutes) it takes to a play to go to its destination and return.
     */
    public void setInFligth(int inFligth) {
        this.inFligth = inFligth;
    }

    /**
     *
     * @param destination Where is the planes Destination.
     */
    public void setDestination(String destination){
        this.destinationAirport = destination;
    }

    /**
     *
     * @return The capacity of an airplane.
     */
    public static int getCAPACITY() {
        return CAPACITY;
    }

    /**
     *
     * @return The departure airport.
     */
    public String getDepartureAirport() {
        return departureAirport;
    }

    /**
     *
     * @return The destination airport.
     */
    public String getDestinationAirport() {
        return destinationAirport;
    }

    /**
     *
     * @return The time the plane has been in the air (IN FLIGHT).
     */
    public int getInFligth(){
        return inFligth;
    }

    /**
     *
     * @return The amount of time remaining until the plane has to take off.
     */
    public int getTimeToTakeOff() {
        return timeToTakeOff;
    }

    /**
     *
     * @return The amount of time left the plane has refiling.
     */
    public int getRefule(){
        return refule;
    }

}

