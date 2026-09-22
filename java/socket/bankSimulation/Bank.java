

package bankSimulation;


import java.util.List;
import java.util.ArrayList;

public class Bank
{
	private List<BankAccount> accounts = new ArrayList<>(0);

	public Bank()
	{}

	public void newAccount(String username, String cpf)
	{
		final int accountNumber = (int) Math.random() * Math.pow(10,8);
		BankAccount account = new BankAccount(username, lastAccountNumber, cpf, 0.0);
		accounts.add(account);
	}

	public void deposit(int accountNumber, double amount)
	{
		
		BankAccount account = accounts[accountNumber];
		account.deposit(amount);
	}

	public void withdraw(int accountNumber, double amount)
	{
		BankAccount account = accounts[accountNumber];
		account.withdraw(amount);
	}

	public void getBalance(int accountNumber)
	{
		BankAccount account = accounts[accountNumber];
		return account.getBalance();
	}
}
