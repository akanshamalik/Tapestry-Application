
import java.io.Serializable;
import java.util.List;

public interface EntityDAO<E> {
	 List<E> list();
	   void save(E entity);
	   void saveOrUpdate(E entity);
	   void update(E entity);
	   void remove(E entity);
	   int count();
	   E find(Serializable id);
}
