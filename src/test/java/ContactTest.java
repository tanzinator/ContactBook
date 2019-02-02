import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.contact.dao.ContactDao;
import com.contact.service.Contact;

public class ContactTest {
	ContactDao dao;
	
	Contact contact;
	
	
	@Test
	public void TestInsertionOfRecords() {
		contact.setEmail("sample@abc.com");
		contact.setName("tan");
		List<Contact> l = dao.getContacts();
		assertEquals(l.get(0).getEmail(), "sample@abc.com");
		assertEquals(l.get(0).getName(), "tan");
	}

}
