

package bankSimulation;

public class BankAccount
{
	private final int accountNumber;
	public String name;
	private String cpf;
	private double balance;

	public BankAccount(String name, int accountNumber, String cpf, double initialBalance)
	{
		this.name = name;
		this.accountNumber = accountNumber;
		this.cpf = formatCpf(cpf);
		initialBalance = balance;
	}

	public BankAccount()
	{}

	public void setName(String name) { this.name = name; }
	public void setCpf(String cpf) { this.cpf = formatCpf(cpf); }

	public void deposit(double amount) { balance += amount; } // setBalance

	public double withdraw(double amount)
	{
		if(amount > balance) return 0.0;
		balance -= amount;
		return amount;
	}
}
