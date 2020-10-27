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
@Document(collection = "profileComment")
public class ProfileComment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6652372442990779378L;
	
	@Id
	private String _id  = new ObjectId().toString();
	private String _iduserTo;
	private String _idUserFrom;
	private String commentary;
}
