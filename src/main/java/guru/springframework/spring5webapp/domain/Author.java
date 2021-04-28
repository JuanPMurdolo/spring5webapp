package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String firstName;
    private String lastName;
    
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
    
	public Author() {
	}

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Book> getBook() {
		return books;
	}
	public void setBook(Set<Book> book) {
		this.books = book;
	}
	
	
	@Override
	public String toString() {
		return "Author{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", book=" + books + "}";
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

		Author other = (Author) obj;

		return id != null ? id.equals(other.id) : other.id == null;
	}
	
}
