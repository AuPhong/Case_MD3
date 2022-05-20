package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
    List<T> findAll();
    void save(T t);
    boolean edit(T t) throws SQLException;
    boolean delete(int id) throws SQLException;
    T findById(int id);
}
