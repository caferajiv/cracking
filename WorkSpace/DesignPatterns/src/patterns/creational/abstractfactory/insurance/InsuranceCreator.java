package patterns.creational.abstractfactory.insurance;

public abstract class InsuranceCreator {
	
	public abstract InsuranceCreator createInsuranceCreator(String type);
	
	public abstract CarInsurance createCarInsurance();
	
	public abstract HomeInsurance createHomeInsurance();
	
	public abstract PersonalInsurance createPersonalInsurance();
	

}
