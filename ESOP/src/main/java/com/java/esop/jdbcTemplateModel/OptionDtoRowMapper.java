package com.java.esop.jdbcTemplateModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.java.esop.dto.Optiondto;

public class OptionDtoRowMapper implements RowMapper<Optiondto> {


	@Override
	public Optiondto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Optiondto(rs.getString("grant_id"), rs.getDouble("sum(esopdb.allocation_info.allocation_number)"), rs.getString("employee_number"), rs.getLong("plan_id"));
	}

}

