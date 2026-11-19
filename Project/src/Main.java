import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();

        int choice;

        do {
            System.out.println("\t\t   ____________________\t\t\t\t    ================================");
            System.out.println("\t\t  /                    \\\\ \t\t\t\t   LIBRARY MANAGEMENT SYSTEM");
            System.out.println("\t\t /    *  LIBRARY  *     \\\\ \t\t\t\t================================");
            System.out.println("\t\t/________________________\\\\ \t\t\t1. Add Book               __________________");
            System.out.println("\t\t  | [==] [==] [==] [==] |\t\t\t\t2. Update Book           /__________________/|");
            System.out.println("\t\t  | [==] [==] [==] [==] |\t\t\t\t3. Delete Book          |                  | |");
            System.out.println("\t\t  |                     |\t\t\t\t4. Search Book          | ================ | |");
            System.out.println("\t\t  |                     |\t\t\t\t5. View All Books       |     J A V A      | |");
            System.out.println("\t\t  |        ____         |\t\t\t\t6. Borrow Book          | ================ | |");
            System.out.println("\t\t  |       |    |        |\t\t\t\t7. Return Book          |                  | |");
            System.out.println("\t\t  |       |    |        |\t\t\t\t0. Exit                 |__________________|/");
            System.out.print("\t\t ===========================\t\t\tEnter choice: ");

            while (true){
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e){
                    System.out.print("\nInvalid input. Must be number!\nChoice: ");
                }
            }

            System.out.println("\n");

            String id, title, author, category;
            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    id = sc.nextLine();
                    Book bookid = manager.findBookId(id);

                    if (bookid != null && !manager.isValid(id)) {
                        System.out.println("You entered an empty string or used an existing ID!");
                        break;
                    }

                    System.out.print("Title: ");
                    title = sc.nextLine();

                    System.out.print("Author: ");
                    author = sc.nextLine();

                    System.out.print("Category: ");
                    category = sc.nextLine();

                    if (manager.isValid(id)
                            && manager.isValid(title)
                            && manager.isValid(author)
                            && manager.isValid(category)) {

                        manager.addBook(new Book(id, title, author, category));
                        manager.saveRecords();
                    } else {
                        System.out.println("\nInvalid input.\nYou entered an empty string!");
                    }
                    break;

                case 2:
                    System.out.print("Search: ");
                    if (!manager.findBook(sc.nextLine())){
                        break;
                    }

                    System.out.print("What book do you want to update? \nBook ID: ");
                    id = sc.nextLine();

                    System.out.print("New ID: ");
                    String ID = sc.nextLine();

                    System.out.print("New Title: ");
                    title = sc.nextLine();

                    System.out.print("New Author: ");
                    author = sc.nextLine();

                    System.out.print("New Category: ");
                    category = sc.nextLine();

                    if (manager.isValid(ID)
                            && manager.isValid(title)
                            && manager.isValid(author)
                            && manager.isValid(category)) {

                        manager.updateBook(id, title, author, category, ID);
                        manager.saveRecords();
                        break;
                    } else {
                        System.out.println("\nInvalid input.");
                    }
                    break;

                case 3:
                    System.out.print("Search: ");
                    if (!manager.findBook(sc.nextLine())){
                        break;
                    }

                    System.out.print("What book do you want to delete? \nBook ID: ");
                    String BookID3 = sc.nextLine();
                    if (manager.findBookId(BookID3) == null){
                        System.out.println("Wrong ID.");
                        break;
                    }
                    manager.deleteBook(BookID3);
                    manager.saveRecords();
                    break;

                case 4:
                    System.out.print("Search: ");
                    if (!manager.findBook(sc.nextLine())){
                        break;
                    }

                case 5:
                    manager.viewAllBooks();
                    break;

                case 6:
                    System.out.print("Search: ");
                    if (!manager.findBook(sc.nextLine())){
                        break;
                    }

                    System.out.print("What book do you want to borrow?\nBook ID: ");
                    String BookID6 = sc.nextLine();
                    if (manager.findBookId(BookID6) == null){
                        System.out.println("Wrong ID.");
                        break;
                    }
                    manager.borrowBook(BookID6);
                    manager.saveRecords();
                    break;

                case 7:
                    System.out.print("Search: ");
                    if (!manager.findBook(sc.nextLine())){
                        break;
                    }

                    System.out.print("What book do you want to return?\nBook ID: ");
                    String BookID7 = sc.nextLine();
                    if (manager.findBookId(BookID7) == null){
                        System.out.println("Wrong ID.");
                        break;
                    }
                    manager.returnBook(BookID7);
                    manager.saveRecords();
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