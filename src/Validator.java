import java.io.File;

public class Validator {
    public static boolean isValidKey(int key, char[] alphabet) {

        if (key >= 0 && key < alphabet.length - 1) {
            return true;
        } else {
            System.out.println("Некорректный ключ");
            return false;
        }
   }
    public static boolean isFileExists(String filePath) {

        File file = new File(filePath);
        if (file.exists()) {
            return true;
        } else {
            System.out.println("Файл не найден");
            return false;
        }
    }
}
