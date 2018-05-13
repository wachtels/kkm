package org.hfu.kkm.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="card")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Card.findAll", query="SELECT c FROM card c"),
	@NamedQuery(name="Card.findCardsByUserId", query="SELECT c FROM card c JOIN"
			+ "user u ON (c.user_id = u.user_id) WHERE c.user_id = :user_id")
	})
public class Card implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="card_id")
	private Integer cardId;
	
	@Basic(optional=false)
	@NotNull
	@Lob
	@Column(name="topic")
	private String topic;
	
	@Basic(optional=false)
	@NotNull
	@Lob
	@Column(name="front")
	private String front;
	
	@Basic(optional=false)
	@NotNull
	@Lob
	@Column(name="back")
	private String back;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="priority")
	private int priority;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="count")
	private int count;
	
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	@ManyToOne(optional=false)
	private User userId;

	public Card() {}
	
	public Card(Integer cardId) {
		this.cardId = cardId;
	}
	
	public Card(Integer cardId, String topic, String front, String back, int priority, int count, User userId) {
		super();
		this.cardId = cardId;
		this.topic = topic;
		this.front = front;
		this.back = back;
		this.priority = priority;
		this.count = count;
		this.userId = userId;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + "]";
	}
	
	
}
