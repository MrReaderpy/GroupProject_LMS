import java.util.ArrayList;

public class LibraryManager {

    private ArrayList<Book> bookList;

    public LibraryManager() {
        bookList = BookFileManager.loadBooks();
    }

    public void addBook(Book book) {

        if (findBook(book.getBookId()) != null) {
            System.out.println("Duplicate Book ID!");
            return;
        }

        bookList.add(book);
        System.out.println("Book added successfully.");
    }

    public Book findBook(String id) {
        for (Book book : bookList) {
            if (book.getBookId().equalsIgnoreCase(id)) {
                return book;
            }
        }
        return null;
    }

    public void deleteBook(String id) {
        Book book = findBook(id);

        if (book != null) {
            bookList.remove(book);
            System.out.println("Book deleted.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void updateBook(String id, String title,
                           String author, String category) {

        Book book = findBook(id);

        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setCategory(category);
            System.out.println("Book updated.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void issueBook(String id) {

        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.getStatus().equals("AVAILABLE")) {
            book.setStatus("ISSUED");
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book already issued.");
        }
    }

    public void returnBook(String id) {

        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found.");
        } else {
            book.setStatus("AVAILABLE");
            System.out.println("Book returned successfully.");
        }
    }

    public void viewAllBooks() {

        if (bookList.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : bookList) {
            book.display();
        }
    }

    public void saveRecords() {
        BookFileManager.saveBooks(bookList);
    }

    public void loadRecords() {
        bookList = BookFileManager.loadBooks();
        System.out.println("Records loaded.");
    }
}