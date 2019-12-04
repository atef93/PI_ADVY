package tn.advyteam.service;

import tn.advyteam.entities.DemandeMission;
import tn.advyteam.entities.Mission;

public interface GestionMissionLocal {
public int AddMission(Mission m);
public int addDemandeMission(DemandeMission d);
public void affecter(int idDem,int idMiss);
}