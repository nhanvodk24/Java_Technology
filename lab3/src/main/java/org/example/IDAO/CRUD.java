package org.example.IDAO;
import org.example.POJO.Manufacture;

import java.util.List;

public interface CRUD<T>{
    boolean add(T t);
    T get(String id);
    List<T> getAll();
    boolean remove(String id);
    boolean remove(T t);
    boolean update(T t);
}
