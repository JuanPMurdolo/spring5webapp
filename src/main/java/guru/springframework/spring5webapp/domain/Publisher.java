package guru.springframework.spring5webapp.domain;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    
    @OneToMany
    @JoinColumn(name= "publisher_id")
    private Set<Book> books = new HashSet<>();
    
	public Publisher(String name, String address, String city, String state, String zip) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return "Publisher{" +"id=" + id + ", name=" + name + ", books=" + books + "address=" + address + "city=" + city + "state=" + state + "zip=" + zip + "}";
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
		Publisher other = (Publisher) obj;

		return id != null ? id.equals(other.id) : other.id == null;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
    
    

}
