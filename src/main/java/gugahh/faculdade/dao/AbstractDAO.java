package gugahh.faculdade.dao;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class AbstractDAO<T> {
	
	protected EntityManager em;
	
	/**
	 * Make an instance managed and persistent.
	 * @param t - entity instance
	 */
	public void persist(T t) {
		em.persist(t);
	}
	
	/**
	 * Merge the state of the given entity into the current persistence context.
	 * @param t - entity instance
	 * @return the managed instance that the state was merged to
	 */
	public T merge(T t) {
		T retorno = em.merge(t);
		return retorno;
	}
	
	public abstract T findById(long id);
	
	public abstract List<T> findAll();
	
	public void remove(long id) {
		T t = this.findById(id);
		if (t != null) {
			em.remove(t);
		}
	}

}
