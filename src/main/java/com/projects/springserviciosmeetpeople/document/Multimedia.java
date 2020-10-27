package com.projects.springserviciosmeetpeople.document;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "multimedia")
public class Multimedia implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 4469484532344044015L;
	
	@Id
	private String _id  = new ObjectId().toString();
	private String _iduserTo;
	private String type;
	private String url;
	private Date dateCreation;
	private String category;
}
