package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAng1Application implements CommandLineRunner{
  @Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringAng1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		
		contactRepository.save(new Contact("Slimani", "med", df.parse("01/06/1984"), "slimani1984@gmail.com",665114799, "megd.gp"));
		contactRepository.save(new Contact("kassimi", "amir", df.parse("23/06/1999"), "amir@gmail.com", 2335356, "amr.gp"));
		contactRepository.save(new Contact("Arraji", "khadija", df.parse("01/04/1989"), "khadija123@gmail.com", 660189540, "ked.gp"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom()+" "+c.getPrenom());});
	}
	

}
