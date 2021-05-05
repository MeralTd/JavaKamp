package oopIntro;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1,"meral","taşdemir","meral@meral.com","123456");
		User user2 = new User(2,"meral2","taşdemir","meral@gmail.com","1234");
		
		User[] users = {user1,user2};
		
		for (User user : users) {
			System.out.println(user.firstName);
		}

		Address address = new Address(1,"Turkey","1111","İzmir",35);
		
		AddressManager addressManager = new AddressManager();
		addressManager.addAddress(address);
		addressManager.deleteAddress(address);
	}

}
