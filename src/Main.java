import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args){
        Library library = new Library();

        Book b1 = new Book("Clean Code", "Robert Martin", 45.0, 464);
        Book b2 = new Book("1984", "George Orwell", 18.0, 328);
        Book b3 = new Book("Animal Farm", "George Orwell", 12.0, 112);
        Book b4 = new Book("Java Basics", "Max Müller", 35.0, 520);
        Book b5 = new Book("The Hobbit", "J. R. R. Tolkien", 28.0, 310);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        library.addBook(b5);

        List<Book> allBooks = Arrays.asList(b1, b2, b3, b4, b5);

        System.out.println("1. Books by an author");
        System.out.println("Author: George Orwell");
        System.out.println("Result:");
        List<Book> orwellBooks = library.getBooksByAuthor("George Orwell");
        for(Book b : orwellBooks){
            System.out.println(b.getTitle());
        }
        System.out.println();


        System.out.println("2. Average number of pages");
        System.out.println("Result:");
        List<Book> booksForAvg = Arrays.asList(b1, b2, b3);
        double avg = library.getAveragePageCount(booksForAvg);
        System.out.printf("%.2f\n\n", avg);

        System.out.println("3. Books within a price limit");
        System.out.println("Maximum price: 30 Euros");
        System.out.println("Result:");
        List<Book> budgetBooks = library.getBooksWithinBudget(allBooks, 30.0);
        for (Book b : budgetBooks) {
            System.out.println(b.getTitle() + " -> " + (int) b.getPrice() + " Euros");
        }
        System.out.println();


        System.out.println("4. Most expensive book");
        System.out.println("Result:");
        List<Book> booksForExpensive = Arrays.asList(b2, b3, b5); // 1984, Animal Farm, The Hobbit
        Book mostExpensive = library.getMostExpensiveBook(booksForExpensive);
        if (mostExpensive != null) {
            System.out.println(mostExpensive.getTitle() + " (" + (int) mostExpensive.getPrice() + " Euros)");
        }
        System.out.println();

        System.out.println("5. Books with a minimum number of pages");
        System.out.println("Minimum number: 300 pages");
        System.out.println("Result:");
        List<Book> longBooks = library.getBooksByMinPages(allBooks, 300);
        for (Book b : longBooks) {
            System.out.println(b.getTitle());
        }
        System.out.println();


    }
}