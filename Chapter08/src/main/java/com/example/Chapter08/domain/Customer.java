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
package com.example.Chapter08.domain;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Michael Minella
 */
public class Customer {

	@NotNull(message="First name is required")
	@Pattern(regexp="[a-zA-Z]+", message="First name must be alphabetical")
	private String firstName;

	@Size(min=1, max=1)
	@Pattern(regexp="[a-zA-Z]", message="Middle initial must be alphabetical")
	private String middleInitial;

	@NotNull(message="Last name is required")
	@Pattern(regexp="[a-zA-Z]+", message="Last name must be alphabetical")
	private String lastName;

	@NotNull(message="Address is required")
	@Pattern(regexp="[0-9a-zA-Z\\. ]+")
	private String address;

	@NotNull(message="City is required")
	@Pattern(regexp="[a-zA-Z\\. ]+")
	private String city;

	@NotNull(message="State is required")
	@Size(min=2,max=2)
	@Pattern(regexp="[A-Z]{2}")
	private String state;

	@NotNull(message="Zip is required")
	@Size(min=5,max=5)
	@Pattern(regexp="\\d{5}")
	private String zip;

	public Customer() {
	}

	public Customer(Customer original) {
		this.firstName = original.getFirstName();
		this.middleInitial = original.getMiddleInitial();
		this.lastName = original.getLastName();
		this.address = original.getAddress();
		this.city = original.getCity();
		this.state = original.getState();
		this.zip = original.getZip();
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"firstName='" + firstName + '\'' +
				", middleInitial='" + middleInitial + '\'' +
				", lastName='" + lastName + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zip='" + zip + '\'' +
				'}';
	}
}
