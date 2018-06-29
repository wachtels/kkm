package org.hfu.kkm.user.db;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Model
public class UserService {

	@PersistenceContext
	EntityManager em;
	
	public void saveUser(User user) {
		em.merge(user);
	}
	
	public void deleteUser(User user) {
		em.remove(user);
	}
	
	public List<User> getAll(){
		Query q = em.createQuery("SELECT user From User user");
		return (List<User>) q.getResultList();
	}
}
