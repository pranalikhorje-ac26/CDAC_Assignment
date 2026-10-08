import java.util.Scanner;

public class Catalogue {

    // ================= BOOK NODE =================
    static class BookNode {
        private int id;
        private String title;
        private BookNode left;
        private BookNode right;

        public BookNode() {
            id = 0;
            title = "";
            left = null;
            right = null;
        }

        public BookNode(int id, String title) {
            this.id = id;
            this.title = title;
            left = null;
            right = null;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }
    }

    // ================= BST FIELD =================
    private BookNode root;

    public Catalogue() {
        root = null;
    }

    // ================= INSERT =================
    public void insert(int id, String title) {

        BookNode newNode = new BookNode(id, title);

        if (root == null) {
            root = newNode;
            return;
        }

        BookNode trav = root;

        while (true) {

            // Go left
            if (id < trav.id) {

                if (trav.left != null) {
                    trav = trav.left;
                }
                else {
                    trav.left = newNode;
                    break;
                }
            }

            // Go right
            else if (id > trav.id) {

                if (trav.right != null) {
                    trav = trav.right;
                }
                else {
                    trav.right = newNode;
                    break;
                }
            }

            // Duplicate
            else {
                System.out.println("Duplicate Book ID");
                return;
            }
        }
    }

    // ================= SEARCH =================
    public BookNode search(int id) {

        BookNode trav = root;
        System.out.print("Path: ");
        while (trav != null) {
            System.out.print(trav.id);

            if (id == trav.id) {
                System.out.println();
                return trav;
            }

            System.out.print(" -> ");

            if (id < trav.id) {
                trav = trav.left;
            }
            else {
                trav = trav.right;
            }
        }

        System.out.println("(no child)");
        return null;
    }

    // ================= INORDER =================
    public void inorder(BookNode trav) {

        if (trav == null)
            return;

        inorder(trav.left);

        System.out.print(trav.id + " ");

        inorder(trav.right);
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    // ================= PREORDER =================
    public void preorder(BookNode trav) {

        if (trav == null)
            return;

        System.out.print(trav.id + " ");

        preorder(trav.left);

        preorder(trav.right);
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    // ================= POSTORDER =================
    public void postorder(BookNode trav) {

        if (trav == null)
            return;

        postorder(trav.left);

        postorder(trav.right);

        System.out.print(trav.id + " ");
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    // ================= COUNT =================
    public int count(BookNode trav) {

        if (trav == null)
            return 0;

        return 1 + count(trav.left) + count(trav.right);
    }

    public int count() {
        return count(root);
    }

    // ================= HEIGHT =================
    public int height(BookNode trav) {

        if (trav == null)
            return -1;

        int h1 = height(trav.left);
        int h2 = height(trav.right);

        int max = h1 > h2 ? h1 : h2;

        return max + 1;
    }

    public int height() {
        return height(root);
    }

    // ================= MIN =================
    public int min() {

        if (root == null)
            return -1;

        BookNode trav = root;

        while (trav.left != null) {
            trav = trav.left;
        }

        return trav.id;
    }

    // ================= MAX =================
    public int max() {

        if (root == null)
            return -1;

        BookNode trav = root;

        while (trav.right != null) {
            trav = trav.right;
        }

        return trav.id;
    }

    // ================= LEVEL ORDER =================
    // public void levelOrder() {

    //     if (root == null)
    //         return;

    //     Queue<BookNode> q = new Queue<>(20);

    //     q.offer(root);

    //     while (!q.isEmpty()) {

    //         BookNode trav = q.poll();

    //         System.out.print(trav.id + " ");

    //         if (trav.left != null)
    //             q.offer(trav.left);

    //         if (trav.right != null)
    //             q.offer(trav.right);
    //     }

    //     System.out.println();
    // }

    // ================= MAIN =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Catalogue c = new Catalogue();

        // Insert books
        c.insert(105, "Java Programming");
        c.insert(62, "Data Structures");
        c.insert(148, "Database Systems");
        c.insert(40, "C Programming");
        c.insert(87, "Operating Systems");
        c.insert(120, "Computer Networks");
        c.insert(173, "Artificial Intelligence");
        c.insert(95, "Machine Learning");

        System.out.println("Inorder:");
        c.inorder();

        System.out.println("Preorder:");
        c.preorder();

        System.out.println("Postorder:");
        c.postorder();

        // System.out.println("Level Order:");
        // c.levelOrder();

        System.out.println("Count: " + c.count());

        System.out.println("Height: " + c.height());

        System.out.println("Minimum ID: " + c.min());

        System.out.println("Maximum ID: " + c.max());

        // Search
        System.out.print("\nEnter Book ID to search: ");
        int id = sc.nextInt();

        BookNode temp = c.search(id);

        if (temp == null) {
            System.out.println("Not Found");
        }
        else {
            System.out.println("Found");
            System.out.println("Book ID: " + temp.getId());
            System.out.println("Title: " + temp.getTitle());
        }

        sc.close();
    }
}