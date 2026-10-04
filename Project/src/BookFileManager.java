import java.io.*;
import java.util.ArrayList;

public class BookFileManager {

    private static final String FILE_NAME = "books.txt";

    public static void saveBooks(ArrayList<Book> books) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                writer.println(book);
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static ArrayList<Book> loadBooks() {
        ArrayList<Book> books = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return books;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                books.add(Book.fromString(line));
            }

        } catch (IOException e) {
            System.out.println("Error loading file.");
        }

        return books;
    }
}