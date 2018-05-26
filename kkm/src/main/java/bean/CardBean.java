package bean;


import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ejb.CardEJB;
import entity.Card;

@ApplicationScoped
@ManagedBean
public class CardBean {

	@Inject
	CardEJB cardEJB;
	
	public List<Card> getAllCards(){
		return cardEJB.getAll();
	}
}
