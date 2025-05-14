package sample.mapper.postgres;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import sample.model.EmployeeInfo;

@Mapper
public interface AoMapper {
	
	EmployeeInfo getEmployeeInfo(String employeeId);
	
}
