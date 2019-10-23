package tn.advyteam.service;

import java.util.List;

import javax.ejb.Local;

import tn.advyteam.entities.Contrat;
import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Employee;

@Local
public interface GestionEmployeLocal {
    public void addemploye (Developpeur developpeur);
    public List<Employee> emps();
    public Employee find (int id ) ;
    public void  delete (int id);
    public void addContrat (Contrat contrat); 
	public void ajoutercontratemploye(Developpeur developpeur, Contrat contrat);
	public void addemploye (Employee developpeur);
    
}
