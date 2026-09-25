import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileEncryptionDecryption {

    private static final int KEY = 5;

    public static void main(String[] args) {

        BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {

                System.out.println("\n==============================");
                System.out.println(" FILE ENCRYPTION / DECRYPTION ");
                System.out.println("==============================");
                System.out.println("1. Encrypt File");
                System.out.println("2. Decrypt File");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(input.readLine());
                switch (choice) {

                    case 1:

                        System.out.print("Enter source file path: ");
                        String sourceFile = input.readLine();

                        System.out.print("Enter encrypted file path: ");
                        String encryptedFile = input.readLine();

                        encryptFile(sourceFile, encryptedFile);
                        break;

                    case 2:

                        System.out.print("Enter encrypted file path: ");
                        String encryptedInputFile = input.readLine();

                        System.out.print("Enter decrypted file path: ");
                        String decryptedFile = input.readLine();

                        decryptFile(encryptedInputFile, decryptedFile);
                        break;

                    case 3:

                        System.out.println("Program terminated.");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (IOException e) 
        {
            System.out.println("Error while taking input.");
            e.printStackTrace();
        }
    }


    private static void encryptFile(String sourceFile,String encryptedFile) 
    {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            fileInputStream = new FileInputStream(sourceFile);
            fileOutputStream =new FileOutputStream(encryptedFile);
            byte[] inputData = fileInputStream.readAllBytes();
            byte[] encryptedData =new byte[inputData.length];

            for (int i = 0; i < inputData.length; i++) 
            {
                encryptedData[i] = (byte) (inputData[i] + KEY);
            }

            fileOutputStream.write(encryptedData);
            System.out.println("File encrypted successfully.");

        } catch (FileNotFoundException e) 
        {
            System.out.println("File not found.");

        } catch (IOException e) 
        {
            System.out.println("Error while encrypting file.");
            e.printStackTrace();

        } finally
        {
            try {

                if (fileInputStream != null) 
                {
                    fileInputStream.close();
                }

                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
                }

            } catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }


    private static void decryptFile(String encryptedFile,String decryptedFile) 
    {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream =new FileInputStream(encryptedFile);
            fileOutputStream = new FileOutputStream(decryptedFile);
            byte[] encryptedData =fileInputStream.readAllBytes();
            byte[] decryptedData = new byte[encryptedData.length];
            for (int i = 0; i < encryptedData.length; i++)
            {
                decryptedData[i] =(byte) (encryptedData[i] - KEY);
            }

            fileOutputStream.write(decryptedData);
            System.out.println("File decrypted successfully.");

        } catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        } 
        catch (IOException e)
        {
            System.out.println("Error while decrypting file.");
            e.printStackTrace();
        } finally 
        {
            try {

                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }

                if (fileOutputStream != null) 
                {
                    fileOutputStream.close();
                }

            } catch (IOException e)
            {       
                e.printStackTrace();
            }
        }
    }
}
