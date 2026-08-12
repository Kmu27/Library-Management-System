import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    public static void saveBooks(ArrayList<Book> books) {

        try {
            FileWriter writer = new FileWriter("books.txt");

            for (Book book : books) {
                writer.write(
                        book.getId() + "," +
                        book.getTitle() + "," +
                        book.getAuthor() + "," +
                        book.isAvailable() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    public static void saveMembers(ArrayList<Member> members) {

        try {
            FileWriter writer = new FileWriter("members.txt");

            for (Member member : members) {
                writer.write(
                        member.getId() + "," +
                        member.getName() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving members.");
        }
    }

    public static void loadBooks(ArrayList<Book> books) {

        try {
            File file = new File("books.txt");

            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                boolean available =
                        Boolean.parseBoolean(parts[3]);

                Book book = new Book(
                        id,
                        title,
                        author,
                        available
                );

                books.add(book);
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Error loading books.");
        }
    }

    public static void loadMembers(ArrayList<Member> members) {

        try {
            File file = new File("members.txt");

            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];

                Member member = new Member(
                        id,
                        name
                );

                members.add(member);
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Error loading members.");
        }
    }
}