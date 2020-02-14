package org.sid.web;

import java.util.List;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ContactRestService {
	@Autowired
	private ContactRepository contactRepository;
	@GetMapping("/contact")
	public List<Contact> getContact() {
		return contactRepository.findAll();
	}
	@GetMapping("/contact/{id}")
	public Contact getContact(@PathVariable Long id) {
		return contactRepository.findById(id).get();
	}	
	@PostMapping("/contact")
	public Contact save(@RequestBody Contact c) {
		return contactRepository.save(c);
	}
	@DeleteMapping("/contact/{id}")
	public Boolean delete(@PathVariable Long id) {
		 contactRepository.deleteById(id);
		 return true;
	}
	@PutMapping("/contact/{id}")
	public Contact save(@PathVariable Long id,@RequestBody Contact c) {
		c.setId(id);
		return contactRepository.save(c);	
	}
	@GetMapping("/chercherContact")
	public Page<Contact> chercher(@RequestParam(name="mc",defaultValue ="")String mc,
			@RequestParam(name="page",defaultValue ="0")int page,
			@RequestParam(name="size",defaultValue ="5")int size) {
		return contactRepository.chercher("%"+mc+"%",PageRequest.of(page, size));
	}
}
