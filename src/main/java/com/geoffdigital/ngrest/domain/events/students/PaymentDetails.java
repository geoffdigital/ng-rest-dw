package com.geoffdigital.ngrest.domain.events.students;

import java.util.Date;
import java.util.UUID;

public class PaymentDetails {

	private UUID id;
	private Date dateTimeOfSubmission;

	public PaymentDetails() {
		id = null;
	}

	public PaymentDetails(UUID id) {
		this.id = id;
	}

	public Date getDateTimeOfSubmission() {
		return this.dateTimeOfSubmission;
	}

	public void setDateTimeOfSubmission(Date dateTimeOfSubmission) {
		this.dateTimeOfSubmission = dateTimeOfSubmission;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
}
