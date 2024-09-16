import java.util.Arrays;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        for (String s : Arrays.asList("Добро пожаловать! Это криптоанализатор Шифр Цезаря.",
                "Что бы вы хотели сделать?",
                "1. Шифровка",
                "2. Расшифровка",
                "3. Расшифровка методом Brute Force",
                "4. Выход",
                "Введите соответствующую цифру: ")) {
            System.out.println(s);
        }

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1:
                System.out.print("Введите путь к файлу: ");
                String pathText = scanner.nextLine();
                if (!Validator.isFileExists(pathText)) {
                    System.out.println("Файл не найден. Перезапустите программу и введите путь к файлу.");
                    break;
                }

                System.out.print("Введите ключ: ");
                int shiftEncrypt = scanner.nextInt();
                if (!Validator.isValidKey(shiftEncrypt, Alphabet.ALPHABET)) {
                    System.out.println("Некорректный ключ. Перезапустите программу и введите кдюч.");
                    break;
                }
                scanner.nextLine();

                System.out.print("Введите путь для зашифрованного файла: ");
                String pathEncrypted = scanner.nextLine();
                if (!Validator.isFileExists(pathEncrypted)) {
                    System.out.println("Файл не найден. Перезапустите программу и введите путь для зашифрованного файла.");
                    break;
                }

                String text = FileWR.readFile(pathText);
                String enc = Cipher.encrypt(text, shiftEncrypt);
                FileWR.writeFile(enc, pathEncrypted);
                break;

            case 2:
                System.out.println("Введите путь к файлу: ");
                String pathEncrText = scanner.nextLine();
                if (!Validator.isFileExists(pathEncrText)) {
                    System.out.println("Файл не найден. Перезапустите программу и введите путь к файлу.");
                    break;
                }

                System.out.print("Введите ключ: ");
                int shiftDecrypt = scanner.nextInt();
                if (!Validator.isValidKey(shiftDecrypt, Alphabet.ALPHABET)) {
                    System.out.println("Некорректный ключ. Перезапустите программу и введите кдюч.");
                    break;
                }
                scanner.nextLine();

                System.out.print("Введите путь для расшифрованного файла: ");
                String pathDecrypted = scanner.nextLine();
                if (!Validator.isFileExists(pathDecrypted)) {
                    System.out.println("Файл не найден. Перезапустите программу и введите путь для расшифрованного файла.");
                    break;
                }

                String encryptedText = FileWR.readFile(pathEncrText);
                String decr = Cipher.decrypt(encryptedText, shiftDecrypt);
                FileWR.writeFile(decr, pathDecrypted);
                break;

            case 3:
                System.out.println("Введите путь к зашифрованному файлу: ");
                String pathEncr = scanner.nextLine();
                if (!Validator.isFileExists(pathEncr)) {
                    System.out.println("Файл не найден. Перезапустите программу и введите путь к файлу.");
                    break;
                }

                System.out.print("Введите путь для расшифрованного файла: ");
                String pathDecr = scanner.nextLine();
                if (!Validator.isFileExists(pathDecr)) {
                    System.out.println("Файл не найден. Перезапустите программу и введите путь для расшифрованного файла.");
                    break;
                }
                String encrText = FileWR.readFile(pathEncr);
                //String decrText = Cipher.decryptByBruteForce(encrText);
                //FileWR.writeFile(decrText, pathDecr);
                break;



            case 4:
                System.out.println("Пока!");
                break;
        }
    }
}
