package org.hfu.kkm.statistic.db;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Model
public class StatisticService {

	@PersistenceContext
	EntityManager em;
	
	public void saveStats(Statistic stats) {
		em.merge(stats);
	}
	
	public void deleteStats(Statistic stats) {
		em.remove(stats);
	}
	
	public List<Statistic> getAll(){
		Query q = em.createQuery("SELECT s From Statistic s");
		//Query q = em.createQuery("SELECT c From Card c WHERE c.topic = 'test'");
		return (List<Statistic>) q.getResultList();
	}
	
}
