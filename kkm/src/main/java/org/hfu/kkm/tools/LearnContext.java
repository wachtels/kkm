package org.hfu.kkm.tools;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;

import org.hfu.kkm.card.db.Card;

//@LocalBean
//@Stateless
public class LearnContext {
	private LearnStrategy strategy;

	public void setLearnStrategy(LearnStrategy strategy) {
		this.strategy = strategy;
	}

	public void createArchive(ArrayList<Card> cards) {
		strategy.learn(cards);
	}
}
