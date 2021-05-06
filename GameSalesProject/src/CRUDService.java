
public interface CRUDService<T>{
    void save(T input);
    void update(T input);
    void delete(T input);
}
