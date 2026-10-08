class Patient {

    String name;
    Patient prev;
    Patient next;

    public Patient(String name) {
        this.name = name;
        prev = null;
        next = null;
    }
}

public class WaitingList {

    private Patient head;
    private Patient tail;
    private int size;

    // Add normal patient at the end
    public void addNormal(String name) {

        Patient newPatient = new Patient(name);

        if (head == null) {
            head = tail = newPatient;
        } else {
            tail.next = newPatient;
            newPatient.prev = tail;
            tail = newPatient;
        }

        size++;
    }

    // Add emergency patient at the front
    public void addEmergency(String name) {

        Patient newPatient = new Patient(name);

        if (head == null) {
            head = tail = newPatient;
        } else {
            newPatient.next = head;
            head.prev = newPatient;
            head = newPatient;
        }

        size++;
    }

    // Remove patient from front
    public String callNext() {

        if (head == null) {
            return null;
        }

        String name = head.name;

        Patient temp = head;

        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }

        temp.next = null;

        size--;

        return name;
    }

    // Remove patient by name
    public boolean leave(String name) {

        Patient temp = head;

        // Search patient
        while (temp != null) {

            if (temp.name.equals(name)) {

                // Patient is head
                if (temp.prev == null) {
                    head = temp.next;
                } else {
                    temp.prev.next = temp.next;
                }

                // Patient is tail
                if (temp.next == null) {
                    tail = temp.prev;
                } else {
                    temp.next.prev = temp.prev;
                }

                temp.prev = null;
                temp.next = null;

                size--;

                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    // Display from front to back
    public void display() {

        Patient temp = head;

        System.out.print("Front: ");

        while (temp != null) {
            System.out.print(temp.name);

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    // Display from back to front
    public void displayReverse() {

        Patient temp = tail;

        System.out.print("Back : ");

        while (temp != null) {
            System.out.print(temp.name);

            if (temp.prev != null) {
                System.out.print(" <-> ");
            }

            temp = temp.prev;
        }

        System.out.println();
    }

    // Return number of patients
    public int waiting() {
        return size;
    }

    public static void main(String[] args) {

        WaitingList list = new WaitingList();

        // Normal patients
        list.addNormal("Riya");
        list.addNormal("Sam");

        // Emergency patient
        list.addEmergency("Tom");

        // Normal patient
        list.addNormal("Uma");

        System.out.println("After adding patients:");
        list.display();
        list.displayReverse();

        // Call next patient
        System.out.println("\nCalling next patient:");
        System.out.println(list.callNext() + ", please go to the doctor");

        list.display();
        list.displayReverse();

        // Sam leaves
        System.out.println("\nSam leaves:");
        list.leave("Sam");

        list.display();
        list.displayReverse();

        // Add emergency patient
        System.out.println("\nVik is an emergency patient:");
        list.addEmergency("Vik");

        list.display();
        list.displayReverse();

        // Waiting count
        System.out.println("\nWaiting patients: " + list.waiting());
    }
}