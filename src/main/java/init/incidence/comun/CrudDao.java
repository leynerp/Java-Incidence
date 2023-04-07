package init.incidence.comun;

import java.util.List;
public interface CrudDao<T,TSearch> {
    void saveData(T data, Operation op);
    void  deleteData(int id);
    List<T> getAll(int start, int limit);
    List<T> getByParams(int start, int limit, TSearch search);
    T getById(int id);

}
