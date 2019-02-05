/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.Chapter07.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Michael Minella
 */
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	private Long id;

	@Column(name = "firstName")
	private String firstName;
	@Column(name = "middleInitial")
	private String middleInitial;
	@Column(name = "lastName")
	private String lastName;
//	private String addressNumber;
//	private String street;
	private String address;
	private String city;
	private String state;
	private String zipCode;

//	private List<Transaction> transactions;

	public Customer() {
	}

//	public Customer(String firstName, String middleName, String lastName, String addressNumber, String street, String city, String state, String zipCode) {
//		this.firstName = firstName;
//		this.middleName = middleName;
//		this.lastName = lastName;
//		this.addressNumber = addressNumber;
//		this.street = street;
//		this.city = city;
//		this.state = state;
//		this.zipCode = zipCode;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public String getAddressNumber() {
//		return addressNumber;
//	}
//
//	public void setAddressNumber(String addressNumber) {
//		this.addressNumber = addressNumber;
//	}
//
//	public String getStreet() {
//		return street;
//	}
//
//	public void setStreet(String street) {
//		this.street = street;
//	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

//	public List<Transaction> getTransactions() {
//		return transactions;
//	}
//
//	@XmlElementWrapper(name = "transactions")
//	@XmlElement(name = "transaction")
//	public void setTransactions(List<Transaction> transactions) {
//		this.transactions = transactions;
//	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", middleInitial='" + middleInitial + '\'' +
				", lastName='" + lastName + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zipCode='" + zipCode + '\'' +
				'}';
	}

//	@Override
//	public String toString() {
//		StringBuilder output = new StringBuilder();
//
//		output.append(firstName);
//		output.append(" ");
//		output.append(middleInitial);
//		output.append(". ");
//		output.append(lastName);
//
//		if(transactions != null&& transactions.size() > 0) {
//			output.append(" has ");
//			output.append(transactions.size());
//			output.append(" transactions.");
//		} else {
//			output.append(" has no transactions.");
//		}
//
//		return output.toString();
//	}

	//	@Override
//	public String toString() {
//		return "Customer{" +
//				"firstName='" + firstName + '\'' +
//				", middleInitial='" + middleInitial + '\'' +
//				", lastName='" + lastName + '\'' +
//				", address='" + address + '\'' +
////				", addressNumber='" + addressNumber + '\'' +
////				", street='" + street + '\'' +
//				", city='" + city + '\'' +
//				", state='" + state + '\'' +
//				", zipCode='" + zipCode + '\'' +
//				'}';
//	}
}
