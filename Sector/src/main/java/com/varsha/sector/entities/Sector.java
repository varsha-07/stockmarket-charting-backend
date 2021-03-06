package com.varsha.sector.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Sector {

	@Id
	private String id = UUID.randomUUID().toString();

	private String sectorName;
	private String writeUp;

	@DBRef
	private List<Company> companies = new ArrayList<>();
}
