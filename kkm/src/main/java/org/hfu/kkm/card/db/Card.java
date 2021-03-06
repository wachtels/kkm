package org.hfu.kkm.card.db;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hfu.kkm.core.BasicEntity;
import org.hfu.kkm.user.db.User;


/**
 * The persistent class for the card database table.
 * 
 */
@Entity
@NamedQuery(name="Card.findAll", query="SELECT c FROM Card c")
public class Card extends BasicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="card_id")
	private int cardId;

	private String back;

	private int count;
	
	private int version;

	private String front;

	private int priority;

	@Size(min=3,max=20)
	private String topic;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Card() {
	}

	public int getCardId() {
		return this.cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getBack() {
		return this.back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getFront() {
		return this.front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}