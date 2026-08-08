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
}