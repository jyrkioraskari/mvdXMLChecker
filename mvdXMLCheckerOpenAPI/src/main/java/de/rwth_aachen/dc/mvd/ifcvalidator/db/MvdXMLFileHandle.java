package de.rwth_aachen.dc.mvd.ifcvalidator.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MvdXMLFileHandle")
public class MvdXMLFileHandle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "file_path")
    private String file_path;

    public MvdXMLFileHandle() {
	super();
    }

    public MvdXMLFileHandle(String file_path) {
	super();
	this.file_path = file_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    @Override
    public String toString() {
	return "mvdXMLFileHandle [id=" + id + ", file_path=" + file_path + "]";
    }    

    
    
}
