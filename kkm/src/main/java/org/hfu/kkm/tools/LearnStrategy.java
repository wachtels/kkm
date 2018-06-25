package org.hfu.kkm.tools;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;

import org.hfu.kkm.card.db.Card;

//@LocalBean
//@Stateless
public interface LearnStrategy {
	public void learn(ArrayList<Card> cards);
}
