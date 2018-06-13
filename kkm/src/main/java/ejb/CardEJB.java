package ejb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
		Query q = em.createQuery("SELECT c From Card c");
		//Query q = em.createQuery("SELECT c From Card c WHERE c.topic = 'test'");
		return (List<Card>) q.getResultList();
	}
	
	public List<String> getAllTopics(){
		//Query q = em.createQuery("SELECT c.topic From Card c JOIN User u ON (c.user_id = u.user_id) WHERE c.user_id = 2");
		Query q = em.createQuery("SELECT c.topic From Card c");
		List<String> al = (List<String>) q.getResultList();
		List<String> deDupStringList = new ArrayList<>(new HashSet<>(al));
		return deDupStringList;
	}
	
	public List<Card> getKnownAll(){
		Query q = em.createQuery("SELECT c From Card c WHERE c.priority < 8");
		return (List<Card>) q.getResultList();
	}
	
	public List<Card> getAllByUser(){
		Query q = em.createQuery("SELECT c FROM Card c JOIN User u ON (c.user_id = u.user_id) WHERE c.user_id = :user_id");
		return (List<Card>) q.getResultList();
	}

	public List<Card> getCardsFromTopic(String topic) {
		System.out.println("topic: "+topic);
		Query q = em.createQuery("SELECT c From Card c WHERE c.topic = '"+topic+"'");
		List<Card> al = (List<Card>) q.getResultList();
		return al;
	}
}
