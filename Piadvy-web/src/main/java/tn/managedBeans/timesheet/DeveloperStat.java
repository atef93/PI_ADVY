package tn.managedBeans.timesheet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Projet;
import tn.advyteam.entities.Timesheet;
import tn.advyteam.service.GestionTimesheetRemote;

@ManagedBean
public class DeveloperStat {

	// private BarChartModel barModel;

	// private List<Timesheet> timesheetsdp = new ArrayList<>();
	private List<Developpeur> developpeurs = new ArrayList<>();
	private Developpeur developpeur;
	public List<Projet> projet = new ArrayList<>();
	private int idD;
	private int idP;

	@EJB
	GestionTimesheetRemote timesheetServiceImp;

	public DeveloperStat() {

	}

	@PostConstruct
	public void init() {

		developpeurs = timesheetServiceImp.getAllDeveloppeur();
		// timesheetsdp = timesheetServiceImp.getTimesheetDP(idP, idD);
		// createBarModels();

	}

	public String consulteDevPr(int id) throws IOException {

//		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//		String idS = params.get("idD");
//		idD = Integer.parseInt(idS);
		projet = timesheetServiceImp.getAllProjetByEmploye(id);
		idD = id;
		//FacesContext.getCurrentInstance().getExternalContext().redirect("listDeveloper.xhtml");
		return "projetsDev.xhtml";

	}

	public void consulteRondement(int idD, int idP) {
//		int he = 0;
//		int ht = 0;
//		List<Timesheet> timesheets = timesheetServiceImp.getTimesheetDP(idP, idD);
//		for (Timesheet t : timesheets) {
//			he += t.getHeureEstime();
//			ht += t.getHeurePasse();
//		}

		System.out.println("========= totale d'heure estimé ============= ");

//		if (ht > 160) {
//			System.out.println("A revoire");
//		}
//
//		else if (ht < 140) {
//			System.out.println("très bien");
//		}
//
//		else {
//			System.out.println("dans les normes");
//		}

		//return "statistic.xhtml";

	}

	public List<Developpeur> getDeveloppeurs() {
		return developpeurs;
	}

	public void setDeveloppeurs(List<Developpeur> developpeurs) {
		this.developpeurs = developpeurs;
	}

	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}

	public List<Projet> getProjet() {
		return projet;
	}

	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}

	public int getIdD() {
		return idD;
	}

	public void setIdD(int idD) {
		this.idD = idD;
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	// ====================================================== les statistique
	// =================================//
//	
//	
//	public void itemSelect(ItemSelectEvent event) {
//		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
//				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
//
//		FacesContext.getCurrentInstance().addMessage(null, msg);
//	}
//
//	public BarChartModel getBarModel() {
//		return barModel;
//	}
//
//	private BarChartModel initBarModel() {
//		BarChartModel model = new BarChartModel();
//
////		projet = timesheetServiceImp.getAllProjetByEmploye(idD);
//		
////		List<String> namesp = new ArrayList<String>();
////		
////		for(Projet p: projet) {
////			namesp.add(p.getTitre());
////		}
//		
//		
//		ChartSeries boys = new ChartSeries();
//		boys.setLabel("Boys");
//		boys.set(projet.get(0).getTitre(), 120);
//		boys.set(projet.get(0).getTitre(), 100);
//		boys.set(projet.get(0).getTitre(), 44);
//		boys.set(projet.get(0).getTitre(), 150);
//		boys.set(projet.get(0).getTitre(), 25);
//		
//		
//		
//
//		ChartSeries girls = new ChartSeries();
//		girls.setLabel("Girls");
//		girls.set("2004", 52);
//		girls.set("2005", 60);
//		girls.set("2006", 110);
//		girls.set("2007", 135);
//		girls.set("2008", 120);
//		
//		
//
//		ChartSeries others = new ChartSeries();
//		others.setLabel("Others");
//		others.set("2004", 120);
//		others.set("2005", 100);
//		others.set("2006", 44);
//		others.set("2007", 150);
//		others.set("2008", 25);
//		
//		ChartSeries others2 = new ChartSeries();
//		others2.setLabel("Others");
//		others2.set("2004", 120);
//		others2.set("2005", 100);
//		others2.set("2006", 44);
//		others2.set("2007", 150);
//		others2.set("2008", 25);
//	
//		model.addSeries(boys);
//		model.addSeries(girls);
//		model.addSeries(others);
//		model.addSeries(others2);
//	
//		return model;
//	}
//
//	private void createBarModels() {
//		createBarModel();
//
//	}
//
//	private void createBarModel() {
//		barModel = initBarModel();
//
//		barModel.setTitle("Bar Chart");
//		barModel.setLegendPosition("ne");
//
//		Axis xAxis = barModel.getAxis(AxisType.X);
//		xAxis.setLabel("Gender");
//
//		Axis yAxis = barModel.getAxis(AxisType.Y);
//		yAxis.setLabel("Births");
//		yAxis.setMin(0);
//		yAxis.setMax(200);
//	}
//
//	public void setBarModel(BarChartModel barModel) {
//		this.barModel = barModel;
//	}

}
