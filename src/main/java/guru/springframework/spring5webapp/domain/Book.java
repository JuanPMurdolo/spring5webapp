package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String title;
    private String isbn;
    
    @ManyToOne
    private Publisher publisher;
    
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();;
    
    public Book(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
	}
    
	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + ", authors=" + authors + "}";
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;

		return id != null ? id.equals(other.id) : other.id == null;
	}
	
	
     
}
