package view;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.CardEJB;
import ejb.UserEJB;
import entity.Card;
import entity.User;

@Named("web")
@RequestScoped
public class Web {

	@Inject
	CardEJB cardEJB;
	
	@Inject
	UserEJB userEJB;
	
	private String back;

	private int count = 0;

	private String front;

	private int priority = 10;

	private String topic;
	private User user = new User(); // ToDo
	
	public String saveCard() {
        try {
        	Card card = new Card();
        	card.setTopic(topic);
        	card.setFront(front);
        	card.setBack(back);
        	card.setPriority(priority);
        	card.setCount(count);
        	card.setUser(user);
            cardEJB.saveCard(card);
            return "/addCard.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return "error";
        }
    }
}
