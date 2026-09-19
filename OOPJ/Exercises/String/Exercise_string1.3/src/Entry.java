public class Entry {

	public static void main(String[] args) {

		String string1 = "Python Exercises";
		String string2 = "se";

		String string3 = "Python Exercise";

		System.out.println("\"" + string1 + "\" ends with \"" + string2 + "\"? " + string1.endsWith(string2));

		System.out.println("\"" + string3 + "\" ends with \"" + string2 + "\"? " + string3.endsWith(string2));

	}

}