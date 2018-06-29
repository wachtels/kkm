package org.hfu.kkm.card.ui;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.hfu.kkm.card.db.Card;
import org.hfu.kkm.card.db.CardService;
import org.hfu.kkm.tools.LearnContext;
import org.hfu.kkm.tools.ProgressLearnStrategy;
import org.hfu.kkm.user.db.User;
import org.primefaces.event.RowEditEvent;

@RequestScoped
@ManagedBean //Named
public class CardController {

	@Inject
	CardService cardEJB;
	
	private List<Card> cardList;
	private int currentCard=0;

    @PostConstruct
    public void init() {
    	cardList = getAllCards();
    	//cardList = cardEJB.getAllByUser();
    	/*LearnContext ctx = new LearnContext();
        ctx.setLearnStrategy(new ProgressLearnStrategy());
        ctx.createArchive((ArrayList<Card>) cardList);*/
    }
    
    /*public void refresh() {
    	cardList = getAllCards();
    }*/

    public List<Card> getCardList() {
        return cardList;
    }
    
    public Card getCurrentCard() {
        return cardList.get(currentCard);
    }
    
    public Card getNextCard() {
    	++currentCard;
    	if(cardList.size()>currentCard) {
    		return cardList.get(currentCard);
    	}else {
    		--currentCard;
    		return cardList.get(currentCard);
    	}
    	
    }
	
	public List<Card> getAllCards(){
		return cardEJB.getAll();
	}
	
	public List<String> getTopics(){
		return cardEJB.getAllTopics();
	}
	
	public List<Card> getCardsFromTopic(){
		currentCard=0;
		cardList = cardEJB.getCardsFromTopic(topic);
		//cardEJB.getCardsFromTopic(topic);
		//return cardEJB.getCardsFromTopic(topic);
		return null;
	}
	
	private String topic,front,back;
	
	public void add() {
		User user = new User();
		user.setUserId(1);
		
		Card card = new Card();
    	card.setTopic(topic);
    	card.setFront(front);
    	card.setBack(back);
    	card.setPriority(10);
    	card.setCount(0);
    	card.setUser(user);
        cardEJB.saveCard(card);
	}
	
	public void deleteCard() {
		cardEJB.deleteCard(null);
	}
	
	public void rowEditAction(RowEditEvent event) {
		Card object = (Card) event.getObject();
        int zwischenId = object.getCardId();
        cardEJB.saveCard(object);

        FacesMessage message = new FacesMessage("Row successfully updated");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}
}
