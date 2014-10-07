package com.geoffdigital.ngrest.domain.events.students;

import java.util.Date;

public class StudentStatusDetails {

	private Date statusDate;
	private String status;

	public StudentStatusDetails(Date statusDate, String status) {
		this.status = status;
		this.statusDate = statusDate;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public String getStatus() {
		return status;
	}
	
}
