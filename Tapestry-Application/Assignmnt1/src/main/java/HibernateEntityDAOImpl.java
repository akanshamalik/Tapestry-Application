import java.io.Serializable;
import java.util.List;

import org.apache.tapestry5.services.Session;

public abstract class HibernateEntityDAOImpl<E> implements EntityDAO<E> {
	private Class<?> type;

	   public HibernateEntityDAOImpl(Class<E> type) {
	      this.type = type;
	   }

	   protected Session getSession() {
	      return getSession();
	   }

	   public E find(Serializable id) {
	      return (E) getSession().get(type, id);
	   }

	   public void save(E entity) {
	      getSession().save(entity);
	   }

	   public void update(E entity) {
	      getSession().update(entity);
	   }

	   public void remove(E entity) {
	      getSession().delete(entity);
	   }

	   public void saveOrUpdate(E entity) {
	      getSession().saveOrUpdate(entity);
	   }

	   public List<E> list(){
	      return (List<E>)getSession().createCriteria(type).query();
	   }

	   public int count(){
	      return (int)getSession().createCriteria(type).setProjection(Projections.rowCount()).uniqueResult();
	   }
}
