package managebean;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Eletrodomestico;
import util.JPAUtil;


@ManagedBean
@RequestScoped
public class EletrodomesticoMB {
	
	private Eletrodomestico eletrodomestico = new Eletrodomestico();
	private List<Eletrodomestico> eletrodomesticos = new ArrayList<>();

	public void salvar(Eletrodomestico eletrodomestico){
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(eletrodomestico);
		manager.getTransaction().commit();
				
		FacesMessage msg = new FacesMessage("Eletrodomestico salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		manager.close();

		
	}
	
	public void remove(Long id){
		EntityManager manager = JPAUtil.getEntityManager();
		
		Eletrodomestico e = manager.find(Eletrodomestico.class, id);
		manager.getTransaction().begin();
		manager.remove(e);
		manager.getTransaction().commit();
		manager.close();
		
		FacesMessage msg = new FacesMessage("Registro excluído com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	@SuppressWarnings("unchecked")
	public List<Eletrodomestico> getEletrodomesticos() {
		if(this.eletrodomesticos.isEmpty()){
		EntityManager manager = JPAUtil.getEntityManager();
		Query query =   manager.createQuery("select e From Eletrodomestico e",Eletrodomestico.class) ;
		this.eletrodomesticos = query.getResultList() ;
		}
		return eletrodomesticos;
	}

	public void setEletrodomesticos(List<Eletrodomestico> eletrodomesticos) {
		this.eletrodomesticos = eletrodomesticos;
	}

	public Eletrodomestico getEletrodomestico() {
		return eletrodomestico;
	}

	public void setEletrodomestico(Eletrodomestico eletrodomestico) {
		this.eletrodomestico = eletrodomestico;
	}
}
