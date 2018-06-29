package org.hfu.kkm.card.ui;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.hfu.kkm.card.db.Card;
import org.hfu.kkm.card.db.CardService;
import org.hfu.kkm.tools.LearnContext;
import org.hfu.kkm.tools.ProgressLearnStrategy;
import org.hfu.kkm.user.db.User;
import org.primefaces.event.RowEditEvent;

@Model
public class CardController {

	@Inject
	CardService cardService;
	
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
		return cardService.getAll();
	}
	
	public List<String> getTopics(){
		return cardService.getAllTopics();
	}
	
	public List<Card> getCardsFromTopic(){
		currentCard=0;
		cardList = cardService.getCardsFromTopic(topic);
		//cardEJB.getCardsFromTopic(topic);
		//return cardEJB.getCardsFromTopic(topic);
		return null;
	}
	
	private String topic,front,back;
	
	public void add() {
			if(topic.length()>=3) {
			User user = new User();
			user.setUserId(1);
			
			Card card = new Card();
	    	card.setTopic(topic);
	    	card.setFront(front);
	    	card.setBack(back);
	    	card.setPriority(10);
	    	card.setCount(0);
	    	card.setUser(user);
	        cardService.saveCard(card);
	        FacesMessage message = new FacesMessage("Card successfully added");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}else {
			FacesMessage message = new FacesMessage("Topic length to short.");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void deleteCard() {
		cardService.deleteCard(null);
	}
	
	public void rowEditAction(RowEditEvent event) {
		Card object = (Card) event.getObject();
        int zwischenId = object.getCardId();
        cardService.saveCard(object);

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
