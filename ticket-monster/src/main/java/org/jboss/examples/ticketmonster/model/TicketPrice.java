package org.jboss.examples.ticketmonster.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "section_id", "show_id", "ticketcategory_id" }))
public class TicketPrice implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Show show;

    @ManyToOne
    @NotNull
    private Section section;

    @ManyToOne
    @NotNull
    private TicketCategory ticketCategory;

    private float price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public TicketCategory getTicketCategory() {
		return ticketCategory;
	}

	public void setTicketCategory(TicketCategory ticketCategory) {
		this.ticketCategory = ticketCategory;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TicketPrice [section=" + section + ", ticketCategory=" + ticketCategory + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + ((show == null) ? 0 : show.hashCode());
		result = prime * result + ((ticketCategory == null) ? 0 : ticketCategory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketPrice other = (TicketPrice) obj;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (show == null) {
			if (other.show != null)
				return false;
		} else if (!show.equals(other.show))
			return false;
		if (ticketCategory == null) {
			if (other.ticketCategory != null)
				return false;
		} else if (!ticketCategory.equals(other.ticketCategory))
			return false;
		return true;
	}


}
