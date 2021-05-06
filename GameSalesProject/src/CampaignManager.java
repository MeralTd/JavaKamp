

public class CampaignManager implements CRUDService<Campaign> {

	@Override
	public void save(Campaign input) {
		System.out.println(input.getName() + " added");
		
	}

	@Override
	public void update(Campaign input) {
		System.out.println(input.getName() + " updated");

	}

	@Override
	public void delete(Campaign input) {
		System.out.println(input.getName() + " deleted");
		
	}

}
