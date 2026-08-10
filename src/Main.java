import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. View Books");
            System.out.println("4. View Members");
            System.out.println("5. Search Book");
            System.out.println("6. Search Member");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();

                    Book book = new Book(id, title, author);

                    library.addBook(book);

                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    int memberId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();

                    Member member = new Member(memberId, name);

                    library.addMember(member);

                    System.out.println("Member added successfully.");
                    break;

                case 3:
                    library.viewBooks();
                    break;

                case 4:
                    library.viewMembers();
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int searchBookId = scanner.nextInt();

                    Book foundBook = library.searchBook(searchBookId);

                    if (foundBook == null) {
                        System.out.println("Book not found.");
                    } else {
                        foundBook.displayBookInfo();
                    }

                    break;

                case 6:
                    System.out.print("Enter Member ID: ");
                    int searchMemberId = scanner.nextInt();

                    Member foundMember =
                            library.searchMember(searchMemberId);

                    if (foundMember == null) {
                        System.out.println("Member not found.");
                    } else {
                        foundMember.displayMemberInfo();
                    }

                    break;

                case 7:
                    System.out.print("Enter Book ID: ");
                    int borrowBookId = scanner.nextInt();

                    System.out.print("Enter Member ID: ");
                    int borrowMemberId = scanner.nextInt();

                    library.borrowBook(
                            borrowBookId,
                            borrowMemberId
                    );

                    break;

                case 8:
                    System.out.print("Enter Book ID: ");
                    int returnBookId = scanner.nextInt();

                    library.returnBook(returnBookId);

                    break;

                case 9:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Please choose from 1 to 9."
                    );
                    break;
            }
        }
    }
}