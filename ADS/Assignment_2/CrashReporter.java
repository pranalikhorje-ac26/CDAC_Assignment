class MethodStack {

    private String[] data = new String[10];
    private int top = -1;

    // Push method into stack
    boolean push(String m) {

        if (top == 9) {
            return false;
        }

        top++;
        data[top] = m;

        return true;
    }

    // Remove top method
    String pop() {

        if (top == -1) {
            return null;
        }

        String m = data[top];

        data[top] = null;
        top--;

        return m;
    }

    // Get top method
    String peek() {

        if (top == -1) {
            return null;
        }

        return data[top];
    }

    // Check empty
    boolean isEmpty() {
        return top == -1;
    }

    // Return stack size
    int size() {
        return top + 1;
    }

    // Print stack trace from top to bottom
    void printTrace() {

        for (int i = top; i >= 0; i--) {
            System.out.println("   at " + data[i]);
        }
    }
}

public class CrashReporter {

    public static void main(String[] args) {

        String[] log = {
            "ENTER main",
            "ENTER placeOrder",
            "ENTER validateCart",
            "EXIT validateCart",
            "ENTER processPayment",
            "ENTER connectBank",
            "CRASH"
        };

        MethodStack stack = new MethodStack();

        int maxDepth = 0;

        for (int i = 0; i < log.length; i++) {

            String line = log[i];

            String[] parts = line.split(" ");

            String command = parts[0];

            // ENTER
            if (command.equals("ENTER")) {

                String method = parts[1];

                boolean result = stack.push(method);

                if (!result) {
                    System.out.println("StackOverflowError: call depth exceeded 10");
                    return;
                }

                if (stack.size() > maxDepth) {
                    maxDepth = stack.size();
                }
            }

            // EXIT
            else if (command.equals("EXIT")) {

                String method = parts[1];

                String topMethod = stack.peek();

                if (topMethod == null ||
                    !topMethod.equals(method)) {

                    System.out.println(
                        "Invalid EXIT at line " + (i + 1)
                    );

                    return;
                }

                stack.pop();
            }

            // CRASH
            else if (command.equals("CRASH")) {

                System.out.println(
                    "Application crashed at line " + (i + 1) +
                    ". Stack trace:"
                );

                stack.printTrace();

                System.out.println(
                    "Maximum call depth reached: " + maxDepth
                );

                return;
            }
        }

        System.out.println("Program finished normally");
    }
}