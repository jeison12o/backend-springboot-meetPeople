package com.projects.springserviciosmeetpeople.document;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4221944959315803050L;

	@Id
	private String _id  = new ObjectId().toString();
	
	private String name;
	
	private String email;
	
	private String phoneNumber;
	
	private String nameUser;
	
	private String urlPhotoProfile;
	
	private boolean active;
	
	private String password;
}
