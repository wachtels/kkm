package org.hfu.kkm.user.db;

import java.io.Serializable;
import javax.persistence.*;

import org.hfu.kkm.card.db.Card;

import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	private String name;

	@Lob
	private byte[] picture;

	//bi-directional many-to-one association to Card
	@OneToMany(mappedBy="user")
	private List<Card> cards;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Card addCard(Card card) {
		getCards().add(card);
		card.setUser(this);

		return card;
	}

	public Card removeCard(Card card) {
		getCards().remove(card);
		card.setUser(null);

		return card;
	}

}