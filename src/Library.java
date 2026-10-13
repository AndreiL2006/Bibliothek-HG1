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

}
