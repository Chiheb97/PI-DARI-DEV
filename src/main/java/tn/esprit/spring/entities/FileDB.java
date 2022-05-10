package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity


public class FileDB implements Serializable {
	private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String type;
  @Lob
  private byte[] data;
  @OneToOne(mappedBy="files")
  @JsonBackReference
 private Annonce annonce;
 
  public FileDB() {
	super();
}

public FileDB(String name, String type, byte[] data) {
    this.name = name;
    this.type = type;
    this.data = data;
    
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public byte[] getData() {
	return data;
}

public void setData(byte[] data) {
	this.data = data;
}

public Annonce getAnnonce() {
	return annonce;
}

public void setAnnonce(Annonce annonce) {
	this.annonce = annonce;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public FileDB(Long id, String name, String type, byte[] data, Annonce annonce) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.data = data;
	this.annonce = annonce;
}

}