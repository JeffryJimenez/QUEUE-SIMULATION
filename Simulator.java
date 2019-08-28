import java.util.Scanner;

public class Simulator {

    private int numFlights;
    private int numArrive;
    private final int CAPACITY = 35;
    private double arrivalProbablity;
    static private int index = 5;
    private int planeNumber = 0;
    private String[] destination = {"California","New York","Africa","Iraq","Dominican Republic", "Mexico","TheLeafVillage", "Iran", "Detroit","Chicago"};
    private String[] nameArray = {"Juanita","Pablo","Osama","Obama","Pene", "Victor", " edin", "Omega", "Michael", "Juan", "Duarte",
            "Katie", "Jeffry", "Jefferson", "Yoan", "Yin", "Leo", "Leon", "Leonardo", "Lambon", "Vainita", "Toto",
            "Tato", "Kelmi", "Jesus", "Christ", "Christo", "Guevo", "Yandri", "Alejandro", "Yasmin", "Yudy",
            "Maritza", "Luma", "Ana", "David", "Ortiz", "Jordanny", "Yordany", "Enrique","Ysaury", "Frauli",
            "Wandy", "Mayor", "Alfa", "Nene", "Napa", "Naruto", "Sasuke", "Goku", "Kakaroto", "Jordan",
            "Georgie", "George", "Jorge", "Kelvinvin", "Maria", "Eliandri", "Elisaura", "Wilenny", "Wilkin",
            "Wilkania", "Sage","Monica","Pamala","Renate","Leonel","Jeremy","Bradley","Adrien","Philomena",
            "Tamica","Patrica","Ellis","Miguelina","Roxy","Carli","Rex","Theresiam", "Nelly","Starla","Arvilla",
            "Autumn","Karri","Kia","Tamara","Bethann","Wilber","Lauri","Love","Susy","Liberty","Charlott","Irene",
            "Von","Ninfa","Deloras","Brigid","Adelaida","Terina"};
    private PassengerQueue[] passengerQueues = new PassengerQueue[CAPACITY];
    private Airline[] airplane = new Airline[100];
    private int[] airplaneArrival = new int[100];
    /**
     *
     *This constructor creates a plane object.
     *
     * @param numFlights Number of flights waiting to take off.
     * @param arrivalProbability The probability of a plane arriving every 30 minutes.
     */
    public Simulator(int numFlights, double arrivalProbability){
        this.numFlights = numFlights;
        this.arrivalProbablity = arrivalProbability;


    }


    /**
     * Simulates People arriving at an airport and taking a specific time.
     *
     * This methods scans for three particular events that can happen at any given Minute, and Uses BooleanSource
     * to determine whether a new passenger will take a plane or not.
     *
     * @param duration The amount of minutes the simulation lasts.
     */
    public void simulate(int duration){


        BooleanSource arrival = new BooleanSource(arrivalProbablity);
        Scanner in = new Scanner(System.in);
        int currentSecond;


        for(currentSecond = 0; currentSecond <= duration; currentSecond++){

            if(currentSecond == 0){
                numArrive = numFlights;
            }
            else {
                numArrive = 0;
                for(int i = 0; i < numFlights; i++){
                    if(!airplane[i].isInFlight())
                        numArrive++;
                }
            }


            System.out.println("Minute: " + currentSecond);
            System.out.println("There are " + numArrive + " airplanes at the airport");


            int currentplane = 1;
            for(int i = 0; i < numFlights; i++){
                if(!airplane[i].isInFlight() && airplane[i].isReady()) {
                    System.out.println("Flight " + currentplane + " is to " + airplane[i].getDestinationAirport() + " with " + passengerQueues[i].getManyItems() + " passengers");
                    currentplane++;
                }
            }

            currentplane = 1;
            for(int i = 0; i < numFlights; i++){
                if(!airplane[i].isInFlight() && airplane[i].isReady()){
                    System.out.print(currentplane+ "(" + airplane[i].getDestinationAirport() + "): ");
                    passengerQueues[i].print();
                    currentplane++;
                }

            }




            //Event 3 Determine whether a new plane arrived
            if(currentSecond !=0 && currentSecond%20 == 0){
                planeNumber = numFlights;
                passengerQueues[planeNumber] = new PassengerQueue();
                airplane[planeNumber] = new Airline(destination[(int)Math.random()*6], destination[(int)Math.random()*6] , 30);

                numFlights++;
                airplane[planeNumber].setReady(false);
                airplane[planeNumber].setRefule(10);

                airplaneArrival[planeNumber] = currentSecond;
            }

            //is there a plane on standby
            for(int i = 0; i < numFlights; i++){
                if(!airplane[i].isReady() && !airplane[i].isRefulling()){
                    System.out.println("A flight that returned at " + airplaneArrival[i] + " minutes is ready to depart. \nwould you like it to depart? ");
                    String depart = in.next();

                    if(depart.equalsIgnoreCase("Y")){
                        System.out.println("Where would you like it to go: ");
                        String destination = in.next();
                        airplane[i].setDestination(destination);
                        airplane[i].setReady(true);
                    }
                    else if(depart.equalsIgnoreCase("N")){
                        airplane[i].setRefule(5);
                    }


                }
            }



            //Event 1 Passenger distribution
            for(int i = 0; i < numFlights; i++){
                for(double j = 0; j < 1; j = j + .5) {
                    if (arrival.query() && !airplane[i].isInFlight() && airplane[i].isReady() && airplane[i].getTimeToTakeOff() > 5 && passengerQueues[i].getManyItems() != CAPACITY && !airplane[i].isRefulling() && j+currentSecond != 0) {
                        Passenger passenger = new Passenger(nameArray[(int) (Math.random() * 100)], currentSecond + j, airplane[i].getDepartureAirport(), airplane[i].getDestinationAirport(), passengerQueues[i].classDistributer());
                        passengerQueues[i].enqueue(passenger);
                    }
                }
            }


            //event 2 is a plane ready to depart
            for(int i = 0; i < numFlights; i++){
                if(airplane[i].getTimeToTakeOff() == 0 && !airplane[i].isInFlight() && airplane[i].isReady()){
                    airplane[i].setInFligth(21);
                    passengerQueues[i].unLoad();
                }
            }




            //time moderation
            for(int i = 0; i < numFlights; i++){
                if(!airplane[i].isInFlight() && airplane[i].isReady()){
                    airplane[i].reduceRemainingTime();
                }

                if(airplane[i].isInFlight()){
                    airplane[i].reduceFlightTime();
                    if(airplane[i].getInFligth() == 0)
                        airplaneArrival[i] = currentSecond;
                }

                if(!airplane[i].isReady() && airplane[i].getRefule() != 0){
                    airplane[i].reduceRefuling();
                }

            }






            System.out.println("\n\n\n\n\n");

            if(currentSecond == duration){
                System.out.println("Thank You for working with us. If you need more updates, please let us know! \nGood Bye!");
            }





        }



    }

    /**
     * Sets up and Saves information for the simulation
     *
     * This helps the simulation run smoothly without clutters of code.
     */
    public void simulator(){


        int duration;
        int numOfFlights;
        double arrivalProb;
        String[] destination2;



        Scanner in = new Scanner(System.in);


        numOfFlights = numFlights;


        destination2 = new String[numOfFlights];


        for(int i = 0; i < numOfFlights; i++){
            System.out.print("Enter the destination of fight " + (i + 1) + ": ");
            destination2[i] = in.next();

        }

        for(int i = 0;i  < numOfFlights; i++){

            passengerQueues[i] = new PassengerQueue();

            airplane[i] = new Airline(destination[(int)Math.random()*6], destination2[i], 30 );
            airplane[i].setReady(true);
            planeNumber++;


        }



        System.out.print("Enter the duration of the simulation: ");
        duration = in.nextInt();

        simulate(duration);



    }

    /**
     * Main Method runs the simulation
     *
     */
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to ARK Private International Airport!");

        System.out.print("Enter the number of planes waiting to take off: ");
        int numOfFlights = in.nextInt();

        System.out.print("Enter the arrival probability: ");
        double arrivalProb = in.nextDouble();

        Simulator simulator = new Simulator(numOfFlights, arrivalProb);
        simulator.simulator();




    }
}
