package org.hfu.kkm.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;

import org.hfu.kkm.card.db.Card;

//@LocalBean
//@Stateless
public class ProgressLearnStrategy implements LearnStrategy{

	@Override
	public void learn(List<Card> cards) {
		Collections.sort(cards, new Comparator<Card>() {
		    @Override
		    public int compare(Card first, Card second) {
		        return first.getPriority() - second.getPriority();
		    }
		});
	}

}
