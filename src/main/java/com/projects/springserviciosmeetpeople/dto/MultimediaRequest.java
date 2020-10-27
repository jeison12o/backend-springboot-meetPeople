package com.projects.springserviciosmeetpeople.dto;

import org.springframework.web.multipart.MultipartFile;

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
	private MultipartFile file;
}
