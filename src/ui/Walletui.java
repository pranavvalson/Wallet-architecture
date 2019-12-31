package ui;

import java.util.Collection;
import java.util.Set;

import dao.WalletDaoimpl;
import entities.Wallet;
import service.*;

public class Walletui {
	
	private IWalletService service = new WalletServiceImpl(new WalletDaoimpl()); 
	
	public static void  main(String[] args) {
		Walletui ui = new Walletui();
		ui.runUi();
	}
	
	public void runUi() {
		try {
			Wallet w1 = new Wallet("9895553766", "Pranav", 500); 
			Wallet w2 = new Wallet("9895550000", "Sid", 200);
			service.addCustomer(w1);
			service.addCustomer(w2);
			 
			Set<Wallet> customers = service.allCustomers();
			print(customers);
			
			service.transferBalance(w1, w2, 100);
			
			System.out.println("After Transfer.....");
			Set<Wallet> newcustomers = service.allCustomers();
			print(newcustomers); 
			
		} catch(Throwable e) {
			e.printStackTrace(); 
			System.out.println("Something went wrong...");
		} 
	}
	
	public void print(Collection<Wallet> customers) {
		for(Wallet w: customers) { 
			System.out.println(w);
		}
	}

}
