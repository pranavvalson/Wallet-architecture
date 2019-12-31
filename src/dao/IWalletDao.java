package dao;

import java.util.Set;

import entities.Wallet;

public interface IWalletDao {
	
	void addCustomer(Wallet w);
	
	void addBalance(String mobile, int balance);
	
	Wallet  findByNumber(String mobile);
	
	Set<Wallet> allCustomers();

	void transferBalance(Wallet sender, Wallet reciever, int balance);

}
