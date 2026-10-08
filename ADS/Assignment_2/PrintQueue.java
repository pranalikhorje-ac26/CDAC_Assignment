
class Job {
    String id;
    String owner;
    int pages;

    public Job(String id, String owner, int pages) {
        this.id = id;
        this.owner = owner;
        this.pages = pages;
    }
}

class Node {
    Job job;
    Node next;

    public Node(Job j) {
        job = j;
        next = null;
    }
}

public class PrintQueue {

    private Node front;
    private Node rear;
    private int size;

    // Add job at rear
    public void enqueue(Job j) {

        Node newNode = new Node(j);

        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Remove job from front
    public Job dequeue() {

        if (front == null) {
            return null;
        }

        Job j = front.job;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;

        return j;
    }

    // See first job
    public Job peek() {

        if (front == null) {
            return null;
        }

        return front.job;
    }

    // Check empty
    public boolean isEmpty() {
        return front == null;
    }

    // Return number of jobs
    public int size() {
        return size;
    }

    // Cancel job using ID
    public boolean cancel(String id) {

        if (front == null) {
            return false;
        }

        // If first job has to be deleted
        if (front.job.id.equals(id)) {

            front = front.next;
            size--;

            // Queue became empty
            if (front == null) {
                rear = null;
            }

            return true;
        }

        // Find previous node
        Node temp = front;

        while (temp.next != null) {

            if (temp.next.job.id.equals(id)) {

                // Delete the node
                temp.next = temp.next.next;

                // If deleted node was rear
                if (temp.next == null) {
                    rear = temp;
                }

                size--;

                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    // Print finishing time of every job
    public void printSchedule() {

        Node temp = front;

        int time = 0;

        while (temp != null) {

            time = time + temp.job.pages * 6;

            System.out.println(
                temp.job.id + " (" + temp.job.owner +
                ") finishes at " + time + " seconds"
            );

            temp = temp.next;
        }
    }

    // Display queue
    public void display() {

        Node temp = front;

        while (temp != null) {

            System.out.print(
                "[" + temp.job.id + " " +
                temp.job.owner + " " +
                temp.job.pages + "] -> "
            );

            temp = temp.next;
        }

        System.out.println("null");
    }

    // Display front and rear
    public void showFrontRear() {

        if (front == null) {
            System.out.println("Front = null");
            System.out.println("Rear = null");
        } else {
            System.out.println("Front = " + front.job.id);
            System.out.println("Rear = " + rear.job.id);
        }
    }

    // Main
    public static void main(String[] args) {

        PrintQueue q = new PrintQueue();

        Job j1 = new Job("J1", "Ravi", 25);
        Job j2 = new Job("J2", "Asha", 10);
        Job j3 = new Job("J3", "Karan", 5);

        // Enqueue
        q.enqueue(j1);
        q.enqueue(j2);
        q.enqueue(j3);

        System.out.println("Queue:");
        q.display();

        System.out.println("\nSchedule:");
        q.printSchedule();

        // Cancel J2
        System.out.println("\nCancel J2:");
        q.cancel("J2");

        q.display();

        System.out.println("\nSchedule after cancellation:");
        q.printSchedule();

        System.out.println("\nFront and Rear:");
        q.showFrontRear();
    }
}