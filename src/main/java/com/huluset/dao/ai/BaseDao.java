package com.huluset.dao.ai;

import org.springframework.jdbc.core.JdbcTemplate;

public interface BaseDao {
	public JdbcTemplate getJdbcTemplate();
}
