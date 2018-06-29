package org.hfu.kkm.statistic.db;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the statistic database table.
 * 
 */
@Entity
@NamedQuery(name="Statistic.findAll", query="SELECT s FROM Statistic s")
public class Statistic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="statistic_id")
	private int statisticId;

	private int easy;

	private int hard;

	private int medium;

	private String topic;

	@Column(name="user_id")
	private int userId;

	public Statistic() {
	}

	public int getStatisticId() {
		return this.statisticId;
	}

	public void setStatisticId(int statisticId) {
		this.statisticId = statisticId;
	}

	public int getEasy() {
		return this.easy;
	}

	public void setEasy(int easy) {
		this.easy = easy;
	}

	public int getHard() {
		return this.hard;
	}

	public void setHard(int hard) {
		this.hard = hard;
	}

	public int getMedium() {
		return this.medium;
	}

	public void setMedium(int medium) {
		this.medium = medium;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}