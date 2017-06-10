package gugahh.faculdade.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import gugahh.faculdade.entity.Professor;

public class ProfessorDAO extends AbstractDAO<Professor> {
	
	public static ProfessorDAO getDAO(EntityManager em) {
		ProfessorDAO dao = new ProfessorDAO();
		dao.em = em;
		return dao;
	}
	
	@Override
	public Professor findById(long id) {
		Professor professor = em.find(Professor.class, id);
		return professor;
	}
	
	public Professor findByName(String nome) {
		TypedQuery<Professor> query = em.createQuery("Select p from Professor p where p.nome = :nome", Professor.class);
		query.setParameter("nome", nome);
		return query.getSingleResult();
	}

	@Override
	public List<Professor> findAll() {
		TypedQuery<Professor> query = em.createQuery("Select p from Professor p order by p.nome", Professor.class);
		return query.getResultList();
	}
	
	public Professor novoProfessor(String nomeProfessor, Date dataNascimento) {
		Professor professor = new Professor();
		professor.setNome(nomeProfessor);
		professor.setDataNascimento(dataNascimento);
		
		em.persist(professor);
		return professor;
	}

}
