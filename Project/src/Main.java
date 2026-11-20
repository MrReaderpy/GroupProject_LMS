import java.util.Scanner;

public class Main {

    public static final String Reset = "\u001B[0m";

    public static final String Green = "\u001B[32m";
    public static final String Blue = "\u001B[34m";
    public static final String Purple = "\u001B[35m";
    public static final String Cyan = "\u001B[36m";
    public static final String Brown = "\u001B[38;2;181;101;29m";
    public static final String White = "\u001B[37m";
    public static final String SvetloBej = "\u001B[38;2;222;184;135m";
    public static final String Derevo = "\u001B[38;2;139;69;19m";
    public static final String ForBook = "\u001B[38;2;205;133;63m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();

        int choice;

        do {
            System.out.println(Brown + "\t\t   ____________________\t\t\t\t  "+Cyan+"  ================================");
            System.out.println(Brown + "\t\t  /                    \\\\ \t\t\t\t  "+Cyan+" LIBRARY MANAGEMENT SYSTEM");
            System.out.println(Brown + "\t\t /"+Purple+"    *  LIBRARY  * "+Brown+"    \\\\ \t\t\t\t"+Cyan+"================================");
            System.out.println(Brown + "\t\t/________________________\\\\ \t\t\t"+Cyan+"1. Add Book               "+ForBook+"__________________");
            System.out.println(SvetloBej + "\t\t  |"+Blue+" [==] [==] [==] [==]"+SvetloBej+" |\t\t\t\t"+Cyan+"2. Update Book    "+ForBook+"       /__________________/|");
            System.out.println(SvetloBej + "\t\t  |"+Blue+" [==] [==] [==] [==]"+SvetloBej+" |\t\t\t\t"+Cyan+"3. Delete Book     "+ForBook+"     |                  | |");
            System.out.println(SvetloBej + "\t\t  |                     |\t\t\t\t"+Cyan+"4. Search Book        "+ForBook+"  |"+White+" ================"+ForBook+" | |");
            System.out.println(SvetloBej + "\t\t  |                     |\t\t\t\t"+Cyan+"5. View All Books      "+ForBook+" | "+Reset+"    J A V A     "+ForBook+" | |");
            System.out.println(SvetloBej + "\t\t  |   "+Derevo+"     ____    "+SvetloBej+"     |\t\t\t\t"+Cyan+"6. Borrow Book   "+ForBook+"       |"+White+" ================"+ForBook+" | |");
            System.out.println(SvetloBej + "\t\t  |   "+Derevo+"    |    |   "+SvetloBej+"     |\t\t\t\t"+Cyan+"7. Return Book    "+ForBook+"      |                  | |");
            System.out.println(SvetloBej + "\t\t  |   "+Derevo+"    |    |   "+SvetloBej+"     |\t\t\t\t"+Cyan+"0. Exit            "+ForBook+"     |__________________|/");
            System.out.print(Green + "\t\t ===========================\t\t\t"+Cyan+"Enter choice: " + Cyan);

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

                    if (bookid != null || !manager.isValid(id)) {
                        System.out.println("You entered an empty string or used an existing ID!");
                        break;
                    } else if (id.length() > 10) {
                        System.out.println("The ID must be less than 11!");
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
                    if (ID.length() > 10) {
                    System.out.println("The ID must be less than 11!");
                    break;
                }

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
                    manager.findBook(sc.nextLine());
                    break;


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