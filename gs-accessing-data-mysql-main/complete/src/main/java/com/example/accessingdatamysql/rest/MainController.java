package com.example.accessingdatamysql.rest;

import com.example.accessingdatamysql.repositories.ContactRepository;
import com.example.accessingdatamysql.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/demo")
public class MainController {
	@Autowired private ContactRepository contactRepository;

	@PostMapping(path="/add",consumes = "application/json", produces = "application/json")
	public @ResponseBody String addNewUser (@RequestBody Contact contact) {
		contactRepository.save(contact);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Contact> getAllUsers() {
		return contactRepository.findAll();
	}

	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String deleteUser(@PathVariable("id") Long id) {
		Optional<Contact> optionalContact = contactRepository.findById(id);
		if (optionalContact.isPresent()) {
			contactRepository.deleteById(id);
			return "Deleted";
		} else {
			return "Contact not found";
		}
	}
	@PutMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
	public @ResponseBody
	String updateUser(@PathVariable("id") Long id, @RequestBody Contact updatedContact) {
		Optional<Contact> optionalContact = contactRepository.findById(id);
		if (optionalContact.isPresent()) {
			Contact contact = optionalContact.get();
			contact.setName(updatedContact.getName());
			contact.setNumber(updatedContact.getNumber());
			contactRepository.save(contact);
			return "Updated";
		} else {
			return "Contact not found";
		}
	}
}
