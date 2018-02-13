package com.circle;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean 
@SessionScoped 
public class MenuBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private MenuModel model;
	
	@PostConstruct
    public void init() {
     	model = new DefaultMenuModel();
		
		DefaultSubMenu firstSubmenu = new DefaultSubMenu("Circle Prime");
		
		DefaultMenuItem item = new DefaultMenuItem("External");
		item.setUrl("http://www.primefaces.org");
		item.setIcon("ui-icon-home");
		firstSubmenu.addElement(item);
		model.addElement(firstSubmenu);
	
		DefaultSubMenu secondSubmenu = new DefaultSubMenu("Square Prime");
		
		item = new DefaultMenuItem("Save");
		item.setIcon("ui-icon-disk");
		item.setCommand("#{menuBean.save}");
		item.setUpdate("messages");
		secondSubmenu.addElement(item);
		
		item = new DefaultMenuItem("Delete");
		item.setIcon("ui-icon-close");
		item.setCommand("#{menuBean.delete}");
		item.setAjax(false);
		secondSubmenu.addElement(item);
		
		model.addElement(secondSubmenu);
		
	}

	public MenuModel getModel() { 
		return model; 
	}
	
	public void save() {
        addMessage("Success", "Data saved");
    }
     
    public void update() {
        addMessage("Success", "Data updated");
    }
     
    public void delete() {
        addMessage("Success", "Data deleted");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
