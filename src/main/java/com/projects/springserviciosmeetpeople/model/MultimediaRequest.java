package com.projects.springserviciosmeetpeople.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultimediaRequest {
	private String _iduserTo;
	private String type;
	private String category;
}
