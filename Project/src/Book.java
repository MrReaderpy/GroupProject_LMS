public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private String status;

    public Book(String bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = "AVAILABLE";
    }

    public String getBookId() {
        return bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return bookId + "," + title + "," + author + "," + category + "," + status;
    }

    public static Book fromString(String line) {
        String[] data = line.split(",");
        Book book = new Book(data[0], data[1], data[2], data[3]);
        book.setStatus(data[4]);
        return book;
    }

    public void display() {
        System.out.println("ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Status: " + status);
        System.out.println("-------------------------");
    }
}