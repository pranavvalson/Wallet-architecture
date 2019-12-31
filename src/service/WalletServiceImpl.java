package service;

import java.util.Set;

import dao.IWalletDao;
import entities.Wallet;
import exceptions.InsufficientBalance;
import exceptions.MobileNotValid;

public class WalletServiceImpl implements IWalletService {
	private IWalletDao dao;
	
	public WalletServiceImpl(IWalletDao dao) {
		this.dao = dao;
	}

	public WalletServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCustomer(Wallet w) {
		if(w.getMobileNo().length() == 0 || w.getMobileNo().length()<10) {
			throw new MobileNotValid("Mobile number no valid");
		}
		dao.addCustomer(w);
	}

	@Override
	public void addBalance(String mobile, int balance) {
		dao.addBalance(mobile, balance);
	} 
 
	@Override
	public Wallet findByNumber(String mobile) {
		if(mobile.length() == 0 || mobile.length()<10) {
			throw new MobileNotValid("Mobile number no valid");
		}
		return findByNumber(mobile);
	}
 
	@Override
	public Set<Wallet> allCustomers() {
		Set<Wallet> customers = dao.allCustomers();
        return customers; 
	}

	@Override
	public void transferBalance(Wallet sender, Wallet reciever, int balance) {
		if(balance > sender.getBalance()) {
			throw new InsufficientBalance(sender.getName()+" Have insufficient balance");
		}
		dao.transferBalance(sender, reciever, balance);
		
	}
}
