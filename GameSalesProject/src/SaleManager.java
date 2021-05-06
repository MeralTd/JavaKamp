
public class SaleManager implements SaleService {

	@Override
	public void sale(Customer customer, Game game) {
		System.out.println(customer.getFirstName() + " bought game " +game.getGameName());
	}

	@Override
	public void campaignSale(Campaign campaign, Game game, Customer customer) {
		System.out.println("User "+ customer.getFirstName() + " buys game "+ game.getGameName() +" from campaign "+ campaign.getName());

		
	}

}
