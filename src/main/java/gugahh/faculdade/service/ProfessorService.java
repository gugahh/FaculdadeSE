package gugahh.faculdade.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import gugahh.faculdade.entity.Professor;

public class ProfessorService {
	
		protected EntityManager entityManager;
		
		public ProfessorService(EntityManager entityManager) {
			this.entityManager = entityManager;
		}
		
		public Professor novoProfessor(String nomeProfessor, Date dataNascimento) {
			Professor professor = new Professor();
			professor.setNome(nomeProfessor);
			professor.setDataNascimento(dataNascimento);
			
			entityManager.persist(professor);
			return professor;
		}
		
		public void updateProfessor(Professor professor) {
			entityManager.persist(professor);
		}
		
		public Professor findProfessor(long idProfessor) {
			Professor professor = entityManager.find(Professor.class, idProfessor);
			return professor;
		}
		
		public void removeProfessor(int idProfessor) {
			Professor professor = this.findProfessor(idProfessor);
			if (professor != null) {
				entityManager.remove(professor);
			}
		}
		
		public List<Professor> findAll() {
			TypedQuery<Professor> query = entityManager.createQuery("Select p from Professor p order by p.nome", Professor.class);
			return query.getResultList();
		}

	}
