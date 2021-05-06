

public class CustomerManager implements CRUDService<Customer>, CustomerCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		if (customer.getFirstName() != null && customer.getLastName() != null && customer.getNationalityId() != null)
        {
			System.out.println(customer.getFirstName() + " E-devlet login approved");
            return true;
        }
        else
        {
        	System.out.println("User not found");
            return false;
        }
	}

	@Override
	public void save(Customer input) {
		System.out.println(input.getFirstName() + " added");

	}

	@Override
	public void update(Customer input) {
		System.out.println(input.getFirstName() + " updated");
		
	}

	@Override
	public void delete(Customer input) {
		System.out.println(input.getFirstName() + " deleted");
		
	}

}
