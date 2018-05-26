package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Card;

@LocalBean
@Stateless
public class CardEJB {

	@PersistenceContext
	EntityManager em;
	
	public void saveCard(Card card) {
		em.merge(card);
	}
	
	public void deleteCard(Card card) {
		em.remove(card);
	}
	
	public List<Card> getAll(){
		Query q = em.createQuery("SELECT card From Card card");
		return (List<Card>) q.getResultList();
	}
}
