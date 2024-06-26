import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<File> folderList = Arrays.asList(
                new File("C://Games"),
                new File("C://Games//src"),
                new File("C://Games//savegames"),
                new File("C://Games//res"),
                new File("C://Games//temp"),
                new File("C://Games//src//main"),
                new File("C://Games//src//test"),
                new File("C://Games//res//drawables"),
                new File("C://Games//res//vectors"),
                new File("C://Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("C://Games//src//main//Main.java"),
                new File("C://Games//src//main//Utils.java"),
                new File("C://Games//temp//temp.txt")
        );

        StringBuilder tempLog = new StringBuilder();

        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) tempLog.append("Каталог " + folder + " " + " создан \n");
            else tempLog.append("Каталог " + folder + " " + " не создан \n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) tempLog.append("Файл " + file + " " + " создан \n");
                else tempLog.append("Файл " + file + " " + " не создан \n");
            } catch (IOException ex) {
                tempLog.append(ex.getMessage() + " \n ");
            }
        });
        try (FileWriter log = new FileWriter("C://Games//temp//temp.txt", false)) {
            log.write(tempLog.toString());
            log.flush();
        } catch (IOException ex) {
            tempLog.append(ex.getMessage() + " \n ");
        }
        try (FileReader reader = new FileReader("C://Games//temp//temp.txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}