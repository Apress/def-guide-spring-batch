package com.example.Chapter13.domain;

public class Customer {

	private final long id;
	private final String firstName;
	private final String middleName;
	private final String lastName;
	private final String address1;
	private final String address2;
	private final String city;
	private final String state;
	private final String postalCode;
	private final String ssn;
	private final String emailAddress;
	private final String homePhone;
	private final String cellPhone;
	private final String workPhone;
	private final int notificationPreferences;

	public Customer(long id, String firstName, String middleName, String lastName, String address1, String address2, String city, String state, String postalCode, String ssn, String emailAddress, String homePhone, String cellPhone, String workPhone, int notificationPreferences) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.ssn = ssn;
		this.emailAddress = emailAddress;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.notificationPreferences = notificationPreferences;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getSsn() {
		return ssn;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public int getNotificationPreferences() {
		return notificationPreferences;
	}
}
