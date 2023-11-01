package guru.springframework.spring6webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String publisherName;
	private String address;
	
	@ManyToMany
	@JoinTable(name = "author_books", joinColumns = @JoinColumn(name = "book_id"),
			   inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();
	
	@ManyToOne
	private Publisher publisher;

	
	
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return publisherName;
	}
	public void setTitle(String title) {
		this.publisherName = title;
	}
	public String getIsbn() {
		return address;
	}
	public void setIsbn(String isbn) {
		this.address = isbn;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + publisherName + ", isbn=" + address + ", authors=" + authors + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}
	
	

	
	
}
