package com.geoffdigital.ngrest.domain.events.students;

import com.geoffdigital.ngrest.domain.events.UpdateEvent;

import java.util.UUID;

public class SetStudentPaymentEvent extends UpdateEvent {

	private UUID id;
	private PaymentDetails paymentDetails;

	public SetStudentPaymentEvent(UUID id, PaymentDetails paymentDetails) {
		this.id = id;
		this.paymentDetails = paymentDetails;
	}

	public UUID getId() {
		return id;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}
	
}
