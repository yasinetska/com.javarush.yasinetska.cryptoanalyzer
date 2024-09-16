import java.io.*;
import java.nio.file.Files;

public class FileWR {
    public static String readFile(String filePath) {

        String line = "";
        String text = "";
        File file = new File(filePath);

        try (BufferedReader bufferedReader = Files.newBufferedReader(file.toPath())){
            StringBuilder stringBuilder = new StringBuilder();

            while (bufferedReader.ready()) {
                if (file.exists()) {
                    line = bufferedReader.readLine();
                    text = stringBuilder.append(line).toString();
                }
            }
        } catch (FileNotFoundException nfe) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }


    public static void writeFile(String content, String filePath) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {

            bufferedWriter.append(content);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
