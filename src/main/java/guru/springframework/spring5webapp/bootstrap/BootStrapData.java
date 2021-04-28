package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.*;
import guru.springframework.spring5webapp.repositories.*;

@Component
public class BootStrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("J.K.", "Rowling");
		Book harryPotter = new Book("Harry Potter y La piedra filosofal", "123123");
		eric.getBook().add(harryPotter);
		harryPotter.getAuthors().add(eric);
		Publisher publicador = new Publisher("Surfeando", "123 calle falsa", "berisso", "Buenos Aires", "1921");
		
		harryPotter.setPublisher(publicador);
		publicador.getBooks().add(harryPotter);
		
		authorRepository.save(eric);
		bookRepository.save(harryPotter);
		publisherRepository.save(publicador);

		
		Author john = new Author("Frank", "Kafka");
		Book silence = new Book("Metamorfosis", "123125");
		silence.setPublisher(publicador);
		john.getBook().add(silence);
		silence.getAuthors().add(john);
		publicador.getBooks().add(silence);
		
		authorRepository.save(john);
		bookRepository.save(silence);
		
		System.out.println("Boostrap");
		System.out.println("Numero de libros" + bookRepository.count());
		System.out.println("Numero de libros publicados por" + publicador.getName() + publisherRepository.count());
	}

}
