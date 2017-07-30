package org.jboss.examples.ticketmonster.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToMany(fetch = EAGER, cascade = ALL)
    @JoinColumn
    @NotEmpty
    @Valid
    private Set<Ticket> tickets = new HashSet<Ticket>();

    @ManyToOne
    private Performance performance;

    @NotEmpty
    private String cancellationCode;

    @NotNull
    private Date createdOn = new Date();

    @NotEmpty
    @Email(message = "Not a valid email format")
    private String contactEmail;

    public float getTotalTicketPrice() {
        float totalPrice = 0.0f;
        for (Ticket ticket : tickets) {
            totalPrice += (ticket.getPrice());
        }
        return totalPrice;
    }

    public Long getId() {
        return id;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCancellationCode() {
        return cancellationCode;
    }

    public void setCancellationCode(String cancellationCode) {
        this.cancellationCode = cancellationCode;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    /* equals() and hashCode() for Booking, using the synthetic identity of the object */

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}
