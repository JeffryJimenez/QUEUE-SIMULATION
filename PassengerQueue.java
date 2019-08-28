public class PassengerQueue {

    private Passenger[] data;
    private int manyItems;
    private int front;
    private int rear;
    private int index;
    private int[] classDistributer = new int[4];

    /**
     * Constructor creates a passenger Queue.
     *
     * This constructor makes a Queue with an initial capacity of 10.
     */
    public PassengerQueue(){
        data = new Passenger[10000];
        manyItems = 0;
        front = 0;
        rear = 0;
        index = 0;

        for(int i = 0; i < classDistributer.length; i++){
            classDistributer[i] = 0;
        }

    }

    /**
     * Add a new passenger into a Queue.
     *
     * This method will add a new passenger into an already created queue.
     *
     * @param p Passenger.
     */
    public void enqueue(Passenger p){

        if(manyItems == 0){
            data[rear] = p;
            manyItems++;

        }
        else {
            data[rear + 1] = p;
            manyItems++;
            rear++;
            index++;
        }

    }

    /**
     * Removes passengers based on their flying class.
     *
     * @return The passenger object being removed.
     */
    public Passenger dequeue(){

        Passenger element;

        PassengerQueue firstClass = new PassengerQueue();
        PassengerQueue business = new PassengerQueue();
        PassengerQueue peconomy = new PassengerQueue();
        PassengerQueue economy = new PassengerQueue();
        PassengerQueue[] priorityQueue = new PassengerQueue[4];

        for(int i = front; i <= index; i++){                                             //inspect index
            if(data[i].getTravelClass().equalsIgnoreCase("First class"))
                firstClass.enqueue(data[i]);
            else if(data[i].getTravelClass().equalsIgnoreCase("business"))
                business.enqueue(data[i]);
            else if(data[i].getTravelClass().equalsIgnoreCase("premium economy"))
                peconomy.enqueue(data[i]);
            else if(data[i].getTravelClass().equalsIgnoreCase("economy"))
                economy.enqueue(data[i]);
        }

        priorityQueue[0] = firstClass;
        priorityQueue[1] = business;
        priorityQueue[2] = peconomy;
        priorityQueue[3] = economy;

        int counter = front;

        if(priorityQueue[0].manyItems != 0)
            for(int i = 0; i < priorityQueue[0].manyItems; i++) {
                data[counter] = passsegengerCreator(priorityQueue[0].peek());
                priorityQueue[0].front++;
                counter++;
            }

        if(priorityQueue[1].manyItems != 0)
            for(int i = 0; i < priorityQueue[1].manyItems; i++) {
                data[counter] = passsegengerCreator(priorityQueue[1].peek()) ;
                priorityQueue[1].front++;
                counter++;
            }

        if(priorityQueue[2].manyItems != 0)
            for(int i = 0; i < priorityQueue[2].manyItems; i++) {
                data[counter] = passsegengerCreator(priorityQueue[2].peek()) ;
                priorityQueue[2].front++;
                counter++;
            }
        if(priorityQueue[3].manyItems != 0)
            for(int i = 0; i < priorityQueue[3].manyItems; i++) {
                data[counter] = passsegengerCreator(priorityQueue[3].peek()) ;
                priorityQueue[3].front++;
                counter++;
            }



        manyItems--;
        front++;
        return data[front - 1];


    }

    /**
     * Glances at the first passenger in the Queue without removing it.
     *
     * @return The first object in the data array.
     */
    public Passenger peek(){
        if(manyItems == 0){
            //exception
        }

        return data[front];

    }

    /**
     * The total number of passenger in the queue.
     *
     * This method disregards the different classes and counts all the passengers int the queue.
     *
     * @return The number of objects/passengers in the data array/queue.
     */
    public int size(){
        return manyItems;
    }

    /**
     * Determine if the array/queue data has no objects/passengers.
     *
     * @return True if manyItems = 0, false otherwise;
     */
    public boolean isEmpty(){
        return manyItems == 0;
    }

    public void print(){
        if(manyItems== 0)
            System.out.println();


        for(int i = 0; i < manyItems; i++){
            if(i==0)
                System.out.print(data[i].toString());
            else if(i == manyItems - 1)
                System.out.println(","+ data[i].toString());
            else
                System.out.print("," + data[i].toString());
        }

        if(manyItems == 1)
            System.out.println();
    }

    /**
     * This is a helper methods which helps me copy passengers more efficiently.
     *
     * @param p Passenger object.
     * @return A copy of a passenger.
     */
    private static Passenger passsegengerCreator(Passenger p){
        Passenger copy = new Passenger(p.getName(), p.getTimeArrival(),p.getDepLocation(),p.getDestination(),p.getTravelClass());
        return copy;
    }

    /**
     * Unloads everything for the queue / resets the queue.
     */
    public void unLoad(){
        while(!isEmpty()){
            dequeue();
        }
    }

    /**
     * Distributes the elements a given queue, with a specific flight class
     *
     * The are constraints to how many people of a specific time can be in a queue, this method makes
     * it easier to manage the distribution of classes.
     *
     * @return the type of class
     */
    public String classDistributer(){
        String[] classE = {"First Class","Business","Premium economy","Economy"};

        if(classDistributer[0] < 5){
            classDistributer[0]++;
            return classE[0];

        }
        else if(classDistributer[1] < 5){
            classDistributer[1]++;
            return  classE[1];
        }
        else if(classDistributer[2] < 10){
            classDistributer[2]++;
            return classE[2];

        }


        return classE[3];


    }

    /**
     * **Do not use**
     *
     * @return The array
     */
    public Passenger[] getData() {
        return data;
    }

    /**
     *
     * @return The amount of items in the data array.
     */
    public int getManyItems() {
        return manyItems;
    }

    /**
     *
     * @return The first element in the queue.
     */
    public int getFront() {
        return front;
    }


    /**
     *
     * @return The last element in the data array.
     */
    public int getRear() {
        return rear;
    }

    /**
     *
     * @return Where the the data array the last element is located.
     */
    public int getIndex() {
        return index;
    }

    /**
     * **Do not use**
     *
     * @param data The array
     */
    public void setData(Passenger[] data) {
        this.data = data;
    }

    /**
     * **Do not use**
     *
     * @param manyItems The many items in the array
     */
    public void setManyItems(int manyItems) {
        this.manyItems = manyItems;
    }

    /**
     * **Do not use**
     *
     * @param front The front of the array.
     */
    public void setFront(int front) {
        this.front = front;
    }

    /**
     * **Do not use**
     *
     * @param rear The last element in the queue
     */
    public void setRear(int rear) {
        this.rear = rear;
    }


    /**
     * **Do not use**
     *
     * @param index Where in the array is the last element.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * **Do not use**
     *
     * @param classDistributer Specific classes.
     */
    public void setClassDistributer(int[] classDistributer) {
        this.classDistributer = classDistributer;
    }
}

