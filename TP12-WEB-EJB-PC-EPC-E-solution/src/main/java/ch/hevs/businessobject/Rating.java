package ch.hevs.businessobject;

import javax.persistence.Embeddable;

@Embeddable
public class Rating {
	private int ratingNumber;
	
	public Rating() {}
	
	public Rating(int ratingNumber) {
		this.ratingNumber = ratingNumber;
	}

	public int getRatingNumber() {
		return ratingNumber;
	}

	public void setRatingNumber(int ratingNumber) {
		this.ratingNumber = ratingNumber;
	}
}
