package org.jboss.examples.ticketmonster.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

@Embeddable
public class Seat {

    @Min(1)
    private int rowNumber;

    @Min(1)
    private int number;

    @ManyToOne
    private Section section;

    public Seat() {
    }

    public Seat(Section section, int rowNumber, int number) {
        this.section = section;
        this.rowNumber = rowNumber;
        this.number = number;
    }

    public Section getSection() {
        return section;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getNumber() {
        return number;
    }

	@Override
	public String toString() {
		return "Seat [rowNumber=" + rowNumber + ", number=" + number + ", section=" + section + "]";
	}   
    
}
