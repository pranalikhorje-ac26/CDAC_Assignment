
public class AttendanceReport {

    // Count present days
    static int countPresent(int[] att) {

        int count = 0;

        for (int i = 0; i < att.length; i++) {

            if (att[i] == 1) {
                count++;
            }
        }

        return count;
    }

    // Calculate attendance percentage
    static double percentage(int present, int total) {

        if (total == 0) {
            return 0.0;
        }

        return (present * 100.0) / total;
    }

    // Find longest streak
    static void longestStreak(int[] att, int value) {

        int current = 0;
        int best = 0;
        int bestEnd = -1;

        for (int i = 0; i < att.length; i++) {

            if (att[i] == value) {
                current++;

                if (current > best) {
                    best = current;
                    bestEnd = i;
                }

            } else {
                current = 0;
            }
        }

        if (best == 0) {
            System.out.println("Longest streak   : 0 days");
        } else {

            int start = bestEnd - best + 1;

            System.out.println(
                    "Longest "
                    + (value == 1 ? "presence" : "absence")
                    + " : " + best+ " days (day " + (start + 1)+ " to day " + (bestEnd + 1) + ")");
        }
    }

    // Calculate days needed to reach 75%
    static int daysNeeded(int present, int total) {

        int days = 0;

        while ((present * 100.0) / total < 75) {

            present++;
            total++;
            days++;
        }

        return days;
    }

    public static void main(String[] args) {

        int[] att = {
            1, 1, 0, 1, 1,
            1, 1, 0, 0, 1,
            1, 1, 1, 1, 0
        };

        int total = att.length;

        int present = countPresent(att);

        double percentage = percentage(present, total);

        System.out.println("Days present       : "+ present + " of " + total);

        System.out.println("Attendance         : "+ String.format("%.2f", percentage) + " %");

        if (percentage >= 75) {
            System.out.println("Eligible           : YES");
        } else {
            System.out.println("Eligible           : NO");
        }

        longestStreak(att, 1);
        longestStreak(att, 0);

        if (percentage < 75) {
            int needed = daysNeeded(present, total);
            System.out.println("Days needed for 75%: " + needed);
        }
    }
}
