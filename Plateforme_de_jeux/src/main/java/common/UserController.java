package common;


import java.io.Serializable;

import org.hibernate.cfg.Configuration;


import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Properties;
import org.hibernate.SessionFactory;

import javax.faces.bean.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.query.Query;

import javax.faces.bean.ManagedBean;

@Entity
@Table(name="user")
@ManagedBean(name="userController")
@SessionScoped
public class UserController implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int user_id;
	@Column(name="user_name")
	private String user_name;
	@Column(name="user_email")
	private String user_email;
	@Column(name="user_password")
	private String user_password;
	@Column(name="user_picture")
	private String user_picture;
	
	public UserController() {
		super();
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_picture() {
		return user_picture;
	}
	public void setUser_picture(String user_picture) {
		this.user_picture = user_picture;
	}
	
	public boolean login(){
		   try {
		      SessionFactory sessionFactory=(SessionFactory) new Configuration().configure().buildSessionFactory();
		      Session session=( (org.hibernate.SessionFactory) sessionFactory).openSession();
		      session.beginTransaction();
		      Query query=(Query) session.createQuery("from UserController where user_name=:user_name and user_password=:user_password");
		      query.setString("user_name", user_name);
		      query.setString("user_password", user_password);
		      List list=query.list();
		      return (list.size()==1);
		    } catch (Exception e) {
		        System.out.println(e);
		    }
		    return false;
			}

	public boolean signup() {
		Transaction transaction = null;
		try {
		      SessionFactory sessionFactory=(SessionFactory) new Configuration().configure().buildSessionFactory();
		      Session session=( (org.hibernate.SessionFactory) sessionFactory).openSession();
		      transaction = session.beginTransaction();
		      session.save(this);
	          transaction.commit();
	          return true;
		    } catch (Exception e) {
		    	transaction.rollback();
		        System.out.println(e);
		        
		        return false; 
		    }
	}
	
	
	
}
