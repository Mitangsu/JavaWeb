package book.impl;

import book.DAO.BookDAO;
import book.pojo.Book;
import book.service.BookService;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 20:14
 */

public class BookServiceImpl implements BookService {


    private BookDAO bookDAO ;

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
