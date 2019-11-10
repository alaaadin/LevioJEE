package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	
	 @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String Logo;
	private float Latitude;
	private float Longitude;
	@Enumerated(EnumType.STRING)
	private TypeClient Typeclient;
	@Enumerated(EnumType.STRING)
	private Categories categories;
	
	

	
	public Client(int id, String name, String logo, int latitude, int longitude) {
		super();
		this.id = id;
		this.name = name;
		Logo = logo;
		Latitude = latitude;
		Longitude = longitude;
	}

	public Client(String name, String logo, float latitude, float longitude, TypeClient typeclient, Categories categories) {
		super();
		this.name = name;
		this.Logo = logo;
		this.Latitude = latitude;
		this.Longitude = longitude;
		this.Typeclient = typeclient;
		this.categories = categories;
	}

	public Client() {
		super();
	}

	public Client(String name, float latitude, float longitude, TypeClient typeclient, Categories categories) {
		super();
		this.name = name;
		Latitude = latitude;
		Longitude = longitude;
		Typeclient = typeclient;
		this.categories = categories;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getIdClient() {
		return id;
	}

	public void setIdClient(int id) {
		this.id = id;
	}


	public String getNomC() {
		return name;
	}

	public void setNomC(String name) {
		this.name = name;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}

	public float getLatitude() {
		return Latitude;
	}

	public void setLatitude(int latitude) {
		Latitude = latitude;
	}
	public Client(int id, String name, int latitude, int longitude) {
		super();
		this.id = id;
		this.name = name;
		Latitude = latitude;
		Longitude = longitude;
	}

	public float getLongitude() {
		return Longitude;
	}




	

	public void setLongitude(int longitude) {
		Longitude = longitude;
	}




	public TypeClient getTypeclient() {
		return Typeclient;
	}




	public void setTypeclient(TypeClient typeclient) {
		Typeclient = typeclient;
	}




	public Categories getCategories() {
		return categories;
	}




	public void setCategories(Categories categories) {
		this.categories = categories;
	}




	

 
	
	

}