public class SleeperCoach {

    private boolean[] booked;
    private int n;

    // Constructor
    public SleeperCoach(int n) {
        this.n = n;
        booked = new boolean[n + 1];
    }

    // Find berth type
    static String berthType(int seatNo) {

        int x = seatNo % 8;

        if (x == 1 || x == 4) {
            return "LB";
        } 
        else if (x == 2 || x == 5) {
            return "MB";
        } 
        else if (x == 3 || x == 6) {
            return "UB";
        } 
        else if (x == 7) {
            return "SL";
        } 
        else {
            return "SU";
        }
    }

    // Book a berth
    public int book(String preferred) {

        // Convert to uppercase
        preferred = preferred.toUpperCase();

        // First try preferred berth type
        for (int s = 1; s <= n; s++) {

            if (!booked[s] &&berthType(s).equals(preferred)) {

                booked[s] = true;

                System.out.println("Berth " + s + " (" +berthType(s) + ") allotted");

                return s;
            }
        }

        // If preferred type is not available,
        // give any free berth
        for (int s = 1; s <= n; s++) {

            if (!booked[s]) {

                booked[s] = true;

                System.out.println("No " + preferred +" free. Berth " + s +" (" + berthType(s) +") allotted instead");
                return s;
            }
        }

        // Coach is full
        System.out.println("Waiting List");

        return -1;
    }

    // Cancel booking
    public boolean cancel(int seatNo) {

        if (seatNo < 1 || seatNo > n) {

            System.out.println("Invalid berth number");

            return false;
        }

        if (!booked[seatNo]) {

            System.out.println("Berth " + seatNo + " is not booked");

            return false;
        }

        booked[seatNo] = false;

        System.out.println( "Berth " + seatNo + " cancelled");

        return true;
    }

    // Count available berths
    public int available() {

        int count = 0;

        for (int s = 1; s <= n; s++) {

            if (!booked[s]) {
                count++;
            }
        }

        return count;
    }

    // Print complete berth chart
    public void printChart() {

        for (int s = 1; s <= n; s++) {

            if (booked[s]) {
                System.out.print(s + ":" + berthType(s) + ":X  ");
            } else {
                System.out.print(s + ":" + berthType(s) + ":_  ");
            }

            if (s % 4 == 0) {
                System.out.println();
            }
        }
    }

    // Count free berths by type
    public void availableByType() {

        int lb = 0;
        int mb = 0;
        int ub = 0;
        int sl = 0;
        int su = 0;

        for (int s = 1; s <= n; s++) {

            if (!booked[s]) {

                String type = berthType(s);

                if (type.equals("LB")) {
                    lb++;
                }
                else if (type.equals("MB")) {
                    mb++;
                }
                else if (type.equals("UB")) {
                    ub++;
                }
                else if (type.equals("SL")) {
                    sl++;
                }
                else if (type.equals("SU")) {
                    su++;
                }
            }
        }

        System.out.println("LB free: " + lb);
        System.out.println("MB free: " + mb);
        System.out.println("UB free: " + ub);
        System.out.println("SL free: " + sl);
        System.out.println("SU free: " + su);
    }

    public static void main(String[] args) {

        SleeperCoach coach = new SleeperCoach(16);

        // Already booked: 1, 2, 4, 7
        coach.booked[1] = true;
        coach.booked[2] = true;
        coach.booked[4] = true;
        coach.booked[7] = true;

        System.out.println("Initial chart:");
        coach.printChart();

        System.out.println();

        // Book LB
        coach.book("LB");

        // Book SL
        coach.book("SL");

        // Book SL again
        coach.book("SL");

        // Cancel berth 4
        coach.cancel(4);

        // Book LB
        coach.book("LB");

        System.out.println();

        System.out.println("Available berths: " + coach.available() );

        System.out.println();

        System.out.println("Available by type:");
        coach.availableByType();

        System.out.println();

        System.out.println("Final chart:");
        coach.printChart();
    }
}