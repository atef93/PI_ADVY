package tn.advyteam.service;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.advyteam.entities.Contrat;
import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Employee;

@Remote
public interface GestionEmployeRemote {
    public void addemploye (Developpeur developpeur);
    public List<Employee> emps();
    public Employee find (int id ) ;
    public void  delete (int id);
    public void addContrat (Contrat contrat); 
	public void ajoutercontratemploye(Developpeur developpeur, Contrat contrat);
	public void addemploye (Employee developpeur);
 
}