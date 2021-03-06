package com.varsha.sector.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.varsha.sector.dto.CompanyDto;
import com.varsha.sector.dto.SectorDto;
import com.varsha.sector.entities.Company;
import com.varsha.sector.entities.Sector;

@Component
public class Mapper {

	public Sector toSector(SectorDto sectorDto) {
		ModelMapper mapper = new ModelMapper();
		Sector sector = mapper.map(sectorDto, Sector.class);
		return sector;
	}

	public SectorDto toSectorDto(Sector sector) {
		ModelMapper mapper = new ModelMapper();
		SectorDto sectorDto = mapper.map(sector, SectorDto.class);
		return sectorDto;
	}

	public List<SectorDto> toSectorDtoList(List<Sector> sectors) {
		ModelMapper mapper = new ModelMapper();
		List<SectorDto> sectorDtoList = Arrays.asList(mapper.map(sectors, SectorDto[].class));
		return sectorDtoList;
	}

	public List<Sector> toSectorList(SectorDto sectorDtos) {
		ModelMapper mapper = new ModelMapper();
		List<Sector> ipoList = Arrays.asList(mapper.map(sectorDtos, Sector[].class));
		return ipoList;
	}

	public Company toCompany(CompanyDto companyDto) {
		ModelMapper mapper = new ModelMapper();
		Company company = mapper.map(companyDto, Company.class);
		return company;
	}

	public List<CompanyDto> toCompanyDtoList(List<Company> companies) {
		ModelMapper mapper = new ModelMapper();
		List<CompanyDto> companyDtoList = Arrays.asList(mapper.map(companies, CompanyDto[].class));
		return companyDtoList;
	}
}
