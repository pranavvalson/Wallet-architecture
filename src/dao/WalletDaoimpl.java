package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import entities.Wallet;
import exceptions.NumberNotFoundException;

public class WalletDaoimpl implements IWalletDao {
	private Map<String, Wallet> store=new HashMap<>();
	

	@Override
	public void addCustomer(Wallet w) {
		store.put(w.getMobileNo(), w);		
	}

	@Override
	public void addBalance(String mobile, int balance) {
		Wallet wallet = store.get(mobile);
		wallet.addBalance(balance);
	}

	@Override
	public Wallet findByNumber(String mobile) {
		Wallet wallet = store.get(mobile);
		if(wallet == null) {
			throw new NumberNotFoundException("Number not found!");
		}
		return wallet; 
	}

	@Override
	public void transferBalance(Wallet sender, Wallet reciever, int balance) {
		sender.setBalance(sender.getBalance()-balance);
		reciever.setBalance(reciever.getBalance()+balance);
		
	}

	@Override 
	public Set<Wallet> allCustomers() {
		Collection<Wallet> wallet = store.values();
        Set<Wallet> customers = new HashSet<>(wallet);
        return customers;
	}


}
