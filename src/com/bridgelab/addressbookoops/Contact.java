package com.bridgelab.addressbookoops;

public class Contact {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private Long zip;
	private Long phone;
	private String email;

	public Contact(String firstName, String lastName, String address, String city, String state, Long zip, Long phone,
			String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
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

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public Long getZip() {
		return zip;
	}

	public Long getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Contact))
			return false;

		Contact other = (Contact) obj;
		if (!(firstName.equalsIgnoreCase(other.getfirstName())))
			return false;
		if (!(lastName.equalsIgnoreCase(other.getlastName())))
			return false;
		if (!(address.equalsIgnoreCase(other.getAddress())))
			return false;
		if (!(city.equalsIgnoreCase(other.getCity())))
			return false;
		if (!state.equalsIgnoreCase(other.getState()))
			return false;
		if (!zip.equals(other.getZip()))
			return false;
		if (!(phone.equals(other.getPhone())))
			return false;
		return email.equals(other.getEmail());
	}

	@Override
	public String toString() {
		return "Contacts{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zip=" + zip +
				", phone=" + phone +
				", email='" + email + '\'' +
				'}';
	}


}
