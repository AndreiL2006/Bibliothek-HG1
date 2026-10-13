import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getBooksByAuthor(String targetauthor){
        List<Book> result = new ArrayList<>();
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getAuthor().equals(targetauthor)){
                result.add(books.get(i));
            }
        }
        return result;
    }

    public double getAveragePageCount(List<Book> inputBooks){
        if(inputBooks.isEmpty()){
            return 0;
        }

        int totalPages = 0;
        for(Book book : inputBooks){
           totalPages += book.getPages();
        }

        return (double) totalPages / inputBooks.size();
    }

    public List<Book> getBooksWithinBudget(List<Book> inputBooks, double maxPrice){
        List<Book> finalList = new ArrayList<>();
        for(Book b : inputBooks){
            if(b.getPrice() <= maxPrice){
                finalList.add(b);
            }
        }
        return finalList;
    }

}
