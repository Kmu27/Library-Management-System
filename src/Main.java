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

            int choice = readInteger(
                    scanner,
                    "Choose an option: "
            );

            switch (choice) {

                case 1:
                    int id = readInteger(
                            scanner,
                            "Enter Book ID: "
                    );

                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();

                    Book book = new Book(id, title, author);

                    boolean bookAdded =
                            library.addBook(book);

                    if (bookAdded) {
                        System.out.println(
                                "Book added successfully."
                        );
                    } else {
                        System.out.println(
                                "Book ID already exists."
                        );
                    }

                    break;

                case 2:
                    int memberId = readInteger(
                            scanner,
                            "Enter Member ID: "
                    );

                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();

                    Member member =
                            new Member(memberId, name);

                    boolean memberAdded =
                            library.addMember(member);

                    if (memberAdded) {
                        System.out.println(
                                "Member added successfully."
                        );
                    } else {
                        System.out.println(
                                "Member ID already exists."
                        );
                    }

                    break;

                case 3:
                    library.viewBooks();
                    break;

                case 4:
                    library.viewMembers();
                    break;

                case 5:
                    int searchBookId = readInteger(
                            scanner,
                            "Enter Book ID: "
                    );

                    Book foundBook =
                            library.searchBook(searchBookId);

                    if (foundBook == null) {
                        System.out.println("Book not found.");
                    } else {
                        foundBook.displayBookInfo();
                    }

                    break;

                case 6:
                    int searchMemberId = readInteger(
                            scanner,
                            "Enter Member ID: "
                    );

                    Member foundMember =
                            library.searchMember(searchMemberId);

                    if (foundMember == null) {
                        System.out.println("Member not found.");
                    } else {
                        foundMember.displayMemberInfo();
                    }

                    break;

                case 7:
                    int borrowBookId = readInteger(
                            scanner,
                            "Enter Book ID: "
                    );

                    int borrowMemberId = readInteger(
                            scanner,
                            "Enter Member ID: "
                    );

                    library.borrowBook(
                            borrowBookId,
                            borrowMemberId
                    );

                    break;

                case 8:
                    int returnBookId = readInteger(
                            scanner,
                            "Enter Book ID: "
                    );

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

    public static int readInteger(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String value =
                    scanner.nextLine().trim();

            try {
                return Integer.parseInt(value);

            } catch (NumberFormatException exception) {

                System.out.println(
                        "Invalid input. Please enter an integer number."
                );
            }
        }
    }
}