package gugahh.faculdade.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import gugahh.faculdade.entity.Curso;

public class CursoService {
	
	protected EntityManager entityManager;
	
	public CursoService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	//TODO: implementar
	public Curso findByName(String nomeCurso) {
		return null;
	}
	
	public Curso novoCurso(String nomeCurso) {
		Curso curso = new Curso(nomeCurso);
		entityManager.persist(curso);
		return curso;
	}
	
	public Curso findCurso(long idCurso) {
		Curso curso = entityManager.find(Curso.class, idCurso);
		return curso;
	}
	
	public void removeCurso(long idCurso) {
		Curso curso = this.findCurso(idCurso);
		if (curso != null) {
			entityManager.remove(curso);
		}
	}
	
	public List<Curso> findAll() {
		//Query minhaQuery = entityManager.createNativeQuery("Select * from CURSO", Curso.class);
		//List<Curso> result = minhaQuery.getResultList();
		TypedQuery<Curso> query = entityManager.createQuery("Select c from Curso c order by c.nomeCurso", Curso.class);
		return query.getResultList();
	}

}
