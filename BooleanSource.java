public class BooleanSource {

    private double probability;

    /**
     * Creates a Boolean Source object
     *
     * @param p The probability of an event to happen. 0 <= p < 1
     */
    public BooleanSource(double p){

        probability = p;

    }

    /**
     * Determines whether a specific event has happened.
     *
     * @return True if random < probability or false if random > probability.
     */
    public  boolean query(){
        return (Math.random() < probability);
    }

}

