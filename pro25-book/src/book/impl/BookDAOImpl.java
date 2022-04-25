package book.impl;

import book.DAO.BookDAO;
import book.pojo.Book;
import book.pojo.User;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 20:10
 */
public class BookDAOImpl  extends BaseDAO<Book> implements BookDAO {


    @Override
    public List<Book> getBookList() {
        return executeQuery("select * from t_book where bookStatus=0");
    }

    @Override
    public Book getBook(Integer id) {
         return load("select *  from t_book where id = ?",id);
    }
}
