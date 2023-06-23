package com.jpmc.theater;

import java.time.LocalDateTime;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;
    
    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }
 
    private int getDate() {
        return this.showStartTime.getDayOfMonth();
    } 

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    public double getMovieFee() {
        return this.calculateTicketPrice();
        
    }
    
    private boolean isShowingBetween11AMAnd4PM() {
    	//check if the movie's showtime is between 11AM and 4 PM
         LocalDateTime showtime = this.getStartTime();
    	int hours = showtime.getHour();
    	return hours >= 11 && hours <=16;
} 
	private boolean isShowingOn7th() {
	    // Check if the movie is showing on the 7th
	    int date = this.getDate();
	    return date == 7;
	}

    public double calculateTicketPrice() {
    	double originPrice = movie.getTicketPrice();
  
        double discount = 0;
	    if (Movie.MOVIE_CODE_SPECIAL == movie.getSpecialCode()) {
	    	discount = originPrice * 0.2;  // 20% discount for special movie
        }

		if (sequenceOfTheDay == 1) {
            discount = Math.max(3, discount); // $3 discount for 1st show
        } else if (sequenceOfTheDay == 2) {
        	discount = Math.max(2, discount); // $2 discount for 2nd show
        }

        
        if (isShowingOn7th()) {
        	discount = Math.max(1, discount); // $1 discount
          }

        if (isShowingBetween11AMAnd4PM()) {
        	discount = Math.max(originPrice * 0.2, discount); // 25% discount
         }
         return originPrice - discount;
      }
 

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

}
