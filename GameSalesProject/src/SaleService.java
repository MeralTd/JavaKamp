
public interface SaleService {
	
	void sale(Customer customer, Game game);
    void campaignSale(Campaign campaign, Game game, Customer customer);
}
