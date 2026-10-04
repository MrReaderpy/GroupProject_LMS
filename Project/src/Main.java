import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println(" LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Book");
            System.out.println("5. View All Books");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Save Records");
            System.out.println("9. Load Records");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    String id = sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    if (Validator.isValid(id)
                            && Validator.isValid(title)
                            && Validator.isValid(author)
                            && Validator.isValid(category)) {

                        manager.addBook(
                                new Book(id, title, author, category));
                    } else {
                        System.out.println("Invalid input.");
                    }
                    break;

                case 2:
                    System.out.print("Book ID: ");
                    id = sc.nextLine();

                    System.out.print("New Title: ");
                    title = sc.nextLine();

                    System.out.print("New Author: ");
                    author = sc.nextLine();

                    System.out.print("New Category: ");
                    category = sc.nextLine();

                    manager.updateBook(id, title, author, category);
                    break;

                case 3:
                    System.out.print("Book ID: ");
                    manager.deleteBook(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Book ID: ");
                    Book book = manager.findBook(sc.nextLine());

                    if (book != null) {
                        book.display();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    manager.viewAllBooks();
                    break;

                case 6:
                    System.out.print("Book ID: ");
                    manager.issueBook(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Book ID: ");
                    manager.returnBook(sc.nextLine());
                    break;

                case 8:
                    manager.saveRecords();
                    break;

                case 9:
                    manager.loadRecords();
                    break;

                case 0:
                    manager.saveRecords();
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}