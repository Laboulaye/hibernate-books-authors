package dao.impl;

import dao.BookDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import table.Book;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl  implements BookDao {

    public void addBook(Book book) throws SQLException {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteBook(Book book) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public Book getBook(int id) throws SQLException {
        Book result = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            result = session.get(Book.class, id);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }

    public List<Book> getBooks() throws SQLException {
        List<Book> books = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            books = session.createCriteria(Book.class).list();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }
}
