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
@Document(collection = "category")
public class Category implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8263153303280018791L;

	@Id
	private String _id  = new ObjectId().toString();
	
	private String name;
}
