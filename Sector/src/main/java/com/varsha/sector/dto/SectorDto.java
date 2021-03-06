package com.varsha.sector.dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SectorDto {
	@Id
	private String id;

	private String sectorName;
	private String writeUp;
}
