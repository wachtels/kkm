package tools;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;

import entity.Card;

//@LocalBean
//@Stateless
public interface LearnStrategy {
	public void learn(ArrayList<Card> cards);
}
