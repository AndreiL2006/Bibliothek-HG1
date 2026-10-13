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

    public Book getMostExpensiveBook(List<Book> inputBook){
        if(inputBook.isEmpty()){
            return null;
        }
        Book mostExpensive = inputBook.get(0);
        for(Book b: inputBook){
            if(b.getPrice() > mostExpensive.getPrice()){
                mostExpensive = b;
            }
        }
        return mostExpensive;
    }

    public List<Book> getBooksByMinPages(List<Book> inputBooks, int minPages){
        List<Book> resultList = new ArrayList<>();
        for(Book b: inputBooks){
            if(b.getPages() >= minPages){
                resultList.add(b);
            }
        }
        return resultList;
    }

    public List<Book> getBestBookPair(List<Book> inputBooks, double budget){
        Book bestBook1 = null;
        Book bestBook2 = null;
        double maxPriceFound = -1;
        int maxPagesFound = -1;

        for(int i = 0; i < inputBooks.size(); i++){
            Book book1 = inputBooks.get(i);
            for(int j = i + 1; j < inputBooks.size(); j++){
                Book book2 = inputBooks.get(j);

                double currentTotalPrice = book1.getPrice() + book2.getPrice();
                int currentTotalPages = book1.getPages() + book2.getPages();
                if(currentTotalPrice <= budget){
                    if(currentTotalPrice > maxPriceFound){
                        bestBook1 = book1;
                        bestBook2 = book2;
                        maxPriceFound = currentTotalPrice;
                        maxPagesFound = currentTotalPages;
                    }
                    else if(currentTotalPrice == maxPriceFound){
                        if(currentTotalPages > maxPagesFound){
                            bestBook1 = book1;
                            bestBook2 = book2;
                            maxPagesFound = currentTotalPages;
                        }
                    }
                }
            }
        }
        List<Book> result = new ArrayList<>();
        if(bestBook1 != null && bestBook2 != null){
            result.add(bestBook1);
            result.add(bestBook2);
        }
        return result;
    }

}
