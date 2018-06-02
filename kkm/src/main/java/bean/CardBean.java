package bean;


import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ejb.CardEJB;
import entity.Card;
import entity.User;

@ApplicationScoped
@ManagedBean
public class CardBean {

	@Inject
	CardEJB cardEJB;
	
	private List<Card> cardList;
	private int currentCard=0;

    @PostConstruct
    public void init() {
    	cardList = getAllCards();
    }

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
