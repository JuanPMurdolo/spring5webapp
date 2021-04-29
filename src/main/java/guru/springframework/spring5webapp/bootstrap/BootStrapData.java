package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Started in Bootstrap");
		Publisher publicador = new Publisher();
		publicador.setAddress("123 calle falsa");
		publicador.setCity("berisso");
		publicador.setZip("1921");
		publicador.setState("Buenos Aires");
		publicador.setName("Surfeando");

		publisherRepository.save(publicador);

		Author eric = new Author("J.K.", "Rowling");
		Book harryPotter = new Book("Harry Potter y La piedra filosofal", "123123");
		eric.getBook().add(harryPotter);
		harryPotter.getAuthors().add(eric);

		harryPotter.setPublisher(publicador);
		publicador.getBooks().add(harryPotter);

		authorRepository.save(eric);
		bookRepository.save(harryPotter);

		Author john = new Author("Frank", "Kafka");
		Book silence = new Book("Metamorfosis", "123125");
		john.getBook().add(silence);
		silence.getAuthors().add(john);
		silence.setPublisher(publicador);
		publicador.getBooks().add(silence);

		authorRepository.save(john);
		bookRepository.save(silence);
		publisherRepository.save(publicador);

		System.out.println("Boostrap");
		System.out.println("Numero de libros: " + bookRepository.count());
		System.out.println("Numero de libros publicados por" + " " + publicador.getName() + ": " + publisherRepository.count());
	}

}
