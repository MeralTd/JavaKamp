package oopIntro;

public class AddressManager {
	public void addAddress(Address address) {
		System.out.println("Address added : "+ address.id);
	}
	
	public void deleteAddress(Address address) {
		System.out.println("Address deleted : "+ address.id);
	}
}
