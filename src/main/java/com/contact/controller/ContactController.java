package com.contact.controller;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.contact.dao.ContactDao;
import com.contact.service.Contact;  
public class ContactController {  
    @Autowired  
    ContactDao dao; 
    
    /*Used to  display a form to input data, mapping is done from jsp using value contactform
     */  
    @RequestMapping("/contactform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Contact());
    	return "contactform"; 
    }  
    /*It saves object into database. */  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("contact") Contact c){  
        dao.save(c);  
        return "redirect:/viewcontact";//will redirect to viewcontact request mapping  
    }  
    
    /*searches for contacts based on name and email */
    @RequestMapping("/searchcontact")
    public String searchcontact(@ModelAttribute("contact") Contact contact, Model m) {
    	String name = contact.getName();
    	String email =  contact.getEmail();
    	List<Contact> contacts = dao.SearchContacts(name, email);
    	m.addAttribute("list",contacts);
    	return "viewSearchableContacts";
    }
    
    /* It provides list of contacts in model object */  
    @RequestMapping("/viewcontact")  
    public String viewcontact(Model m){  
        List<Contact> list=dao.getContacts();  
        m.addAttribute("list",list);
        return "viewcontact";  
    }  
    /* It displays object data into form for the given id.  .*/  
    @RequestMapping(value="/contactedit/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Contact contact=dao.getContactById(id);  
        m.addAttribute("command",contact);
        return "contactedit";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("contact") Contact contact){  
        dao.update(contact);  
        return "redirect:/viewcontact";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewcontact */  
    @RequestMapping(value="/deletecontact/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewcontact";  
    }   
}  