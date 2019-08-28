public class Passenger {

    private String name;
    private String depLocation;
    private String destination;
    private double timeArrival;
    private String travelClass;

    /**
     * Constructor for a passenger.
     *
     * Makes an individual passenger object with all the available specifications.
     *
     * @param name Name of the passenger.
     * @param timeArrival time of arrival of the passenger.
     * @param depLocation Departure location of the passenger.
     * @param destination Destination of the passenger.
     * @param travelClass The travel class of the passenger.
     */
    public Passenger(String name, double timeArrival, String depLocation, String destination, String travelClass){
        this.name = name;
        this.timeArrival = timeArrival;
        this.depLocation = depLocation;
        this.destination = destination;
        this.travelClass = travelClass;
    }

    /**
     * Sets he name of a given passenger.
     *
     * @param name The name of the passenger.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the departure location of a passenger.
     *
     * @param depLocation The departure location.
     */
    public void setDepLocation(String depLocation) {
        this.depLocation = depLocation;
    }

    /**
     * Set the destination of a given passenger.
     *
     * @param destination The destination.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Sets the time f arrival of a given passenger.
     *
     * @param timeArrival The time of arrival.
     */
    public void setTimeArrival(int timeArrival) {
        this.timeArrival = timeArrival;
    }

    /**
     * Set the travel class of a given passenger.
     *
     * @param travelClass The travel class.
     */
    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    /**
     * Gets the name of a passenger.
     *
     * @return the name of the passenger.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the departure location of a given passenger.
     *
     * @return The departure location.
     */
    public String getDepLocation() {
        return depLocation;
    }

    /**
     * Gets the destination of a given passenger.
     *
     * @return The destination of  a passenger.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Gets the time of arrival of a given passenger.
     *
     * @return The time of arrival of the passenger.
     */
    public double getTimeArrival() {
        return timeArrival;
    }

    /**
     * Gets what type of travel class a given passenger has.
     *
     * @return The travel class of a passenger.
     */
    public String getTravelClass() {
        return travelClass;
    }

    /**
     * This method overrides toString.
     *
     * This method prints out information about a given passenger.
     *
     * @return Information about a passenger in tubular form.
     */
    public String toString(){
        return "[" + name + ", " + travelClass + ", " + timeArrival + "]";
    }
}
