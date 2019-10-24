package tn.managedBeans.evaluation;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.advyteam.entities.EvaluationType;


@ManagedBean
@ApplicationScoped
public class Data {
public EvaluationType[] getEvaluationType() {
	return EvaluationType.values();
}

}
