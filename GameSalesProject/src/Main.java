
public class Main {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer(1,"Meral","Taþdemir",2000,"12345678911");
		Campaign campaign1 = new Campaign(1,"Black Friday");
        
		CustomerManager customerManager = new CustomerManager();
        customerManager.save(customer1);
        customerManager.checkIfRealPerson(customer1);

        CampaignManager campaingManager = new CampaignManager();
        campaingManager.save(campaign1);

        Game game1 = new Game(1,"Dixit",280);
        
        SaleService sale = new SaleManager();
        sale.sale(customer1,game1);
	}

}
