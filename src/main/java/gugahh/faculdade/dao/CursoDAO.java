package gugahh.faculdade.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import gugahh.faculdade.entity.Curso;

public class CursoDAO extends AbstractDAO<Curso> {
	
	public static CursoDAO getDAO(EntityManager em) {
		CursoDAO dao = new CursoDAO();
		dao.em = em;
		return dao;
	}

	@Override
	public Curso findById(long id) {
		Curso curso = em.find(Curso.class, id);
		return curso;
	}
	
	public Curso findByName(String nomeCurso) {
		TypedQuery<Curso> query = em.createQuery("Select c from Curso c where c.nomeCurso = :nomeCurso", Curso.class);
		query.setParameter("nomeCurso", nomeCurso);
		return query.getSingleResult();
	}

	@Override
	public List<Curso> findAll() {
		//TypedQuery<Curso> query = em.createQuery("Select distinct c from Curso c Left Join Fetch c.professores order by c.nomeCurso", Curso.class);
		TypedQuery<Curso> query = em.createQuery("Select c from Curso c order by c.nomeCurso", Curso.class);
		return query.getResultList();
	}
	
	public Curso novoCurso(String nomeCurso) {
		Curso curso = new Curso(nomeCurso);
		em.persist(curso);
		return curso;
	}


}
