package book.service;

import book.pojo.Book;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 20:13
 */
public interface BookService {
        List<Book> getBookList();
        Book getBook(Integer id);
}
