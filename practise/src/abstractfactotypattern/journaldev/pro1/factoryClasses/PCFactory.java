package abstractfactotypattern.journaldev.pro1.factoryClasses;
import abstractfactotypattern.journaldev.pro1.abstractClasses.Computer;
import abstractfactotypattern.journaldev.pro1.concreateClasses.PC;
import abstractfactotypattern.journaldev.pro1.interfaces.ComputerAbstractFactory;

public class PCFactory implements ComputerAbstractFactory {
	
	private String ram;
	private String hdd;
	private String cpu;
	
	public PCFactory(String ram, String hdd, String cpu) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public Computer createComputer() {
		// TODO Auto-generated method stub
		return new PC(ram,hdd,cpu);
	}

}
