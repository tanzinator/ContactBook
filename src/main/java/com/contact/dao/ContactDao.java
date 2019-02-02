package com.contact.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.contact.service.Contact;  
  
public class ContactDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Contact c){  
    String sql="insert into contact(name,email) values('"+c.getName()+"',"+c.getEmail()+"')";  
    return template.update(sql);  
}  
public int update(Contact c){  
    String sql="update contact set name='"+c.getName()+",email='"+c.getEmail()+"' where id="+c.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from contact where id="+id+"";  
    return template.update(sql);  
}  
public Contact getContactById(int id){  
    String sql="select * from contact where id=?";
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Contact>(Contact.class)); 
}  
public List<Contact> getContacts(){  
    return template.query("select * from contact",new RowMapper<Contact>(){  
        public Contact mapRow(ResultSet rs, int row) throws SQLException {  
            Contact c=new Contact();  
            c.setId(rs.getInt(1));  
            c.setName(rs.getString(2));  
            c.setEmail(rs.getString(4));  
            return c;  
        }  
    });  
}

public List<Contact> SearchContacts(String name, String email) {
	 String query = "select * from contact where name=? and email = ?";
	 return  (List<Contact>) template.queryForObject(query, new Object[]{name, email},new BeanPropertyRowMapper<Contact>(Contact.class));
}
	
}  