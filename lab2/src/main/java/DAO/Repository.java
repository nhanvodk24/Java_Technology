package org.dao;

import java.util.List;

/**
 * Interface for creating repository classes
 * Please create your own repository and implement this interface
 * @param <T> type of object managed by the repository (e.g. Product)
 */
public interface Repository <T>{
    void add(T item);
    List<T> readAll();
    T read(String id);
    boolean update(T item);
    boolean delete(String id);
}
