import java.util.ArrayList;

public class LibraryManager {

    private final ArrayList<Book> bookList;

    public boolean isValid(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public LibraryManager() {
        bookList = BookFileManager.loadBooks();
    }

    public String ValidLength(String Title){
        String shortTitle;
        if (Title.length() > 14){
            shortTitle = Title.substring(0,13) + ".";
        } else {
            shortTitle = Title;
        }
        return shortTitle;
    }

    public static final String ForBook = "\u001B[38;2;205;133;63m";
    public static final String Reset = "\u001B[0m";
    public static final String Cyan = "\u001B[36m";
    public static final String White = "\u001B[37m";

    public void addBook(Book book) {
        bookList.add(book);
        System.out.print(ForBook + "    __________________   __________________\n");
        System.out.print(ForBook + ".-"+White+"/|                  \\ /                  |\\" + ForBook +"-.\n" );
        System.out.print(ForBook + "|"+White+"|||                   |                   |||"+ForBook+"|\n" );
        System.out.printf(ForBook +  "|"+White+"|||"+Reset+"  ID: %-10.10s  "+White+" |"+Reset+" %-14.14s "+White+"   |||"+ForBook+"|%n", book.getBookId() , ValidLength(book.getBookTitle()));
        System.out.print(ForBook +   "|"+White+"|||                   |                   |||"+ForBook+"|\n" );
        System.out.print(ForBook +   "|"+White+"|||                   |                   |||"+ForBook+"|\n");
        System.out.print(ForBook +   "|"+White+"||| "+Reset+" Category:   "+White+"     |"+Reset+" Author:  "+White+"         |||"+ForBook+"|\n" );
        System.out.printf(ForBook +  "|"+White+"||| "+Reset+" %-14.14s "+White+"  | "+Reset+"%-14.14s  "+White+"  |||"+ForBook+"|%n", ValidLength(book.getCategory()), ValidLength(book.getAuthor()));
        System.out.print(ForBook +   "|"+White+"|||                   |                   |||"+ForBook+"|\n" );
        System.out.print(ForBook +   "|"+White+"|||                   |                   |||"+ForBook+"|\n" );
        System.out.print(ForBook +   "|"+White+"|||__________________ | __________________|||"+ForBook+"|\n" );
        System.out.print(ForBook +   "|"+White+"|/===================\\|/===================\\|" + ForBook +"|\n");
        System.out.print(ForBook +   "`--------------------~___~-------------------''\n" +Cyan);
        System.out.println("Book added successfully.");
    }

    public boolean findBook(String title) {
        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookTitle().toLowerCase().contains(title.toLowerCase())) {
                book.display();
                found = true;
            }
        }
        if (!found){
            System.out.println("Book not found");
        }
        return found;
    }

    public Book findBookId(String ID){
        for (Book book : bookList) {
            if (ID.equals(book.getBookId())) {
                return book;
            }
        }
        return null;
    }

    public void deleteBook(String id) {
        Book book = findBookId(id);

        if (book != null) {
            bookList.remove(book);
            System.out.println("Book deleted.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void updateBook(String id, String title,
                           String author, String category, String ID) {

        Book book = findBookId(id);

        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setCategory(category);
            book.setBookId(ID);
            System.out.println("Book updated.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void borrowBook(String id) {

        Book book = findBookId(id);

        if (book.getStatus().equals("AVAILABLE")) {
            book.setStatus("Borrowed");
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    public void returnBook(String id) {

        Book book = findBookId(id);

        book.setStatus("AVAILABLE");
        System.out.println("Book returned successfully.");
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
}