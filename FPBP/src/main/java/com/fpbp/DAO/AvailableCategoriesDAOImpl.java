package com.fpbp.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/*
 * AvailableCategoriesDAOImpl used to fetch the values for Categories
 * for Donors and Seekers 
 */

@Repository
public class AvailableCategoriesDAOImpl extends JdbcDaoSupport implements AvailableCategoriesDAO {

	 @Autowired 
     DataSource dataSource;
     
     @PostConstruct
     private void initialize(){
         setDataSource(dataSource);
     }
     
	public List<String> seekHelpCategories() {
	
		 String sql = "SELECT seek_help FROM available_categories ";
         List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
         List<String> result = new ArrayList<String>();
         for(Map<String, Object> row:rows){
        	result.add((String) row.get("seek_help"));
         }
		return result;
	}

	public List<String> donateHelpCategories() {
		
		 String sql = "SELECT donate FROM available_categories ";
         List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
         List<String> result = new ArrayList<String>();
         for(Map<String, Object> row:rows){
        	result.add((String) row.get("donate"));
         }
		return result;
	}
}
