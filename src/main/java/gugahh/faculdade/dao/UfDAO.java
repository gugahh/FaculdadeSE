package gugahh.faculdade.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import gugahh.faculdade.entity.Pais;
import gugahh.faculdade.entity.UF;

public class UfDAO extends AbstractDAO<UF> {
	
	public static UfDAO getDAO(EntityManager em) {
		UfDAO dao = new UfDAO();
		dao.em = em;
		return dao;
	}

	@Override
	public UF findById(long id) {
		UF uf = em.find(UF.class, id);
		return uf;
	}
	
	@Override
	public List<UF> findAll() {
		TypedQuery<UF> query = em.createQuery("Select u from UF u order by u.nome", UF.class);
		return query.getResultList();
	}
	
	public UF findBySigla(String sigla) {
		TypedQuery<UF> query = em.createQuery("Select u from UF u where u.sigla = :sigla", UF.class);
		query.setParameter("sigla", sigla);
		//query.setHint("org.hibernate.cacheable", true);
		return query.getSingleResult();
	}
	
	public UF novaUF(String sigla, String nome, Pais pais) {
		UF uf = new UF(sigla, nome, pais);
		em.persist(uf);
		return uf;
	}

}
