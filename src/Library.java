import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void viewBooks() {

        for (Book book : books) {
            book.displayBookInfo();
            System.out.println("-------------------------");
        }
    }

    public void viewMembers() {

        for (Member member : members) {
            member.displayMemberInfo();
            System.out.println("-------------------------");
        }
    }

    public Book searchBook(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    public Member searchMember(int id) {

        for (Member member : members) {

            if (member.getId() == id) {
                return member;
            }
        }

        return null;
    }

    public void borrowBook(int bookId, int memberId) {

        Book book = searchBook(bookId);
        Member member = searchMember(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
            return;
        }

        book.borrowBook();

        System.out.println(
                book.getTitle() + " borrowed by " + member.getName()
        );
    }

    public void returnBook(int bookId) {

        Book book = searchBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("Book is not borrowed.");
            return;
        }

        book.returnBook();

        System.out.println(
                book.getTitle() + " returned successfully."
        );
    }
}