package tn.advyteam.serviceImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.advyteam.entities.DemandeMission;
import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Mission;
import tn.advyteam.service.GestionMissionLocal;
import tn.advyteam.service.GestionMissionRemote;


@Stateful
@LocalBean
public class GestionMissionService implements GestionMissionLocal{
	
@PersistenceContext
EntityManager em;




public List<Mission> findAllMission(){
	TypedQuery<Mission> querry = em.createQuery("select m from Mission m",Mission.class);
	return querry.getResultList();
}
public void deletemissionfromdb(Mission m) {
	em.remove(m);
}
public int lastaddmission(DemandeMission dm) {
	em.persist(dm);
	return dm.getId();
}
@Override
public int AddMission(Mission m) {
	// TODO Auto-generated method stub
	em.persist(m);
	return m.getId();
}
@Override
public int addDemandeMission(DemandeMission d) {
	em.persist(d);
	return d.getId();
}
@Override
public void affecter(int idDem,int idMiss) {
		Mission mi = em.find(Mission.class, idMiss);
		DemandeMission dm = em.find(DemandeMission.class, idDem);
		Employee e = new Employee();
		e.setId(1);
		e.setNom("slim");
		e.setPrenom("slim");
		dm.setEmployees(e);
		dm.setMissions(mi);

}


public List<DemandeMission> findAllDemandeMission(){
	TypedQuery<DemandeMission> querry = em.createQuery("select m from DemandeMission m",DemandeMission.class);
	return querry.getResultList();
}
}
