import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {

        System.out.println(Text.HELLO_TEXT);

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        switch (number) {
            case 1:
                System.out.print(Text.ENTER_PATH_ENCRYPT);
                String pathText = scanner.nextLine();
                if (!Validator.isFileExists(pathText)) {
                    System.out.println(Text.ERROR_PATH_ENCRYPT);
                    break;
                }

                System.out.print(Text.ENTER_KEY);
                int shiftEncrypt = Integer.parseInt(scanner.nextLine());
                if (!Validator.isValidKey(shiftEncrypt, Alphabet.ALPHABET)) {
                    System.out.println(Text.ERROR_KEY);
                    break;
                }

                System.out.print(Text.ENTER_PATH_SAVE);
                String pathEncrypted = scanner.nextLine();
                FileWR.createFile(pathEncrypted);
                if (!Validator.isFileExists(pathEncrypted)) {
                    System.out.println(Text.ERROR_PATH_DECRYPT);
                    break;
                }

                String text = FileWR.readFile(pathText);
                String enc = Cipher.encrypt(text, shiftEncrypt);
                FileWR.writeFile(enc, pathEncrypted);
                break;

            case 2:
                System.out.println(Text.ENTER_PATH_DECRYPT);
                String pathEncrText = scanner.nextLine();
                if (!Validator.isFileExists(pathEncrText)) {
                    System.out.println(Text.ERROR_PATH_DECRYPT);
                    break;
                }

                System.out.print("Введите ключ: ");
                int shiftDecrypt = Integer.parseInt(scanner.nextLine());
                if (!Validator.isValidKey(shiftDecrypt, Alphabet.ALPHABET)) {
                    System.out.println(Text.ERROR_KEY);
                    break;
                }

                System.out.print(Text.ENTER_PATH_ENCRYPT);
                String pathDecrypted = scanner.nextLine();
                FileWR.createFile(pathDecrypted);

                if (!Validator.isFileExists(pathDecrypted)) {
                    System.out.println(Text.ERROR_PATH_ENCRYPT);
                    break;
                }

                String encryptedText = FileWR.readFile(pathEncrText);
                String decr = Cipher.decrypt(encryptedText, shiftDecrypt);
                FileWR.writeFile(decr, pathDecrypted);
                break;

            case 3:
                System.out.println(Text.ENTER_PATH_DECRYPT);
                String pathEncr = scanner.nextLine();
                if (!Validator.isFileExists(pathEncr)) {
                    System.out.println(Text.ERROR_PATH_DECRYPT);
                    break;
                }

                System.out.print(Text.ENTER_PATH_SAVE);
                String pathDecr = scanner.nextLine();
                FileWR.createFile(pathDecr);
                if (!Validator.isFileExists(pathDecr)) {
                    System.out.println(Text.ERROR_PATH_ENCRYPT);
                    break;
                }
                String encrText = FileWR.readFile(pathEncr);
                String decrText = Cipher.decryptByBruteForce(encrText);
                FileWR.writeFile(decrText, pathDecr);

                break;

            case 4:
                System.out.println(Text.GOOD_BYE);
                break;
        }
    }
}
