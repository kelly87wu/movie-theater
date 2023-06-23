package com.jpmc.theater;

public class Reservation {
	private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    public double totalFee() {
    	System.out.println(showing.getMovieFee());
    	System.out.println(audienceCount);
        return showing.getMovieFee() * audienceCount;
    }
    
    public Customer getCustomer() {
    	return customer;
    }
}