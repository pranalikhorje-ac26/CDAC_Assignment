public class Entry {

	public static void main(String[] args) {

		String string = "The quick brown fox jumps over the lazy dog.";

		System.out.println("a  b c  d e  f  g h i  j");
		System.out.println("=========================");

		for (char character = 'a'; character <= 'j'; character++) {

			System.out.print(string.indexOf(character) + " ");

		}

		System.out.println("\n");

		System.out.println("k  l  m  n  o  p q  r  s  t");
		System.out.println("===========================");

		for (char character = 'k'; character <= 't'; character++) {

			System.out.print(string.indexOf(character) + " ");

		}

		System.out.println("\n");

		System.out.println("u  v  w  x  y  z");
		System.out.println("================");

		for (char character = 'u'; character <= 'z'; character++) {

			System.out.print(string.indexOf(character) + " ");

		}

	}

}