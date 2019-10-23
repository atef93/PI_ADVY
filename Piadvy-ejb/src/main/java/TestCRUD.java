

import javax.inject.Inject;

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Employee;
import tn.advyteam.serviceImp.EmployeServiceImp;

public class TestCRUD {

	public static void main(String[] args) {
		
		
		EmployeServiceImp employeServiceImp = new EmployeServiceImp();
		
		//Developpeur developpeur = new Developpeur("Atef", "Jlassi");
		Employee employee = new Employee("jihed", "ousleti");
		
		employeServiceImp.addemploye(employee);
		
	}

}
