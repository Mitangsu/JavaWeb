package book.DAO;

import book.pojo.Book;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 20:09
 */
public interface BookDAO {
    List<Book> getBookList();
    Book getBook(Integer id);
}
