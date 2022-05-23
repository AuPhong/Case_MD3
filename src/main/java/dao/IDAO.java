package dao;

import java.util.List;

public interface IDAO<T> {
    List<T> findAll();
    void save(T t);
    void edit(T t);
    void delete(T t);
    T findById(int id);
}
