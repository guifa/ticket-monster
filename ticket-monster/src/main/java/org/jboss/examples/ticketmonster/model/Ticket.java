package org.jboss.examples.ticketmonster.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    private Seat seat;

    @ManyToOne
    @NotNull
    private TicketCategory ticketCategory;

    private float price;

    public Ticket() {

    }

    public Ticket(Seat seat, TicketCategory ticketCategory, float price) {
        this.seat = seat;
        this.ticketCategory = ticketCategory;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

    public float getPrice() {
        return price;
    }

    public Seat getSeat() {
        return seat;
    }

	@Override
	public String toString() {
		return "Ticket [seat=" + seat + ", ticketCategory=" + ticketCategory + ", price=" + price + "]";
	}
    
}
