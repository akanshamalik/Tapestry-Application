
public class HibernateEntityDAOSource implements EntityDAOSource {
	 public <E> EntityDAO<E> get(Class<E> entityClass) {
	      return new HibernateEntityDAOImpl<E>(type);
	   }
}
