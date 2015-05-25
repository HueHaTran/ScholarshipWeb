package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "country", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "country_name"), })
@Indexed
public class Country implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "country_id", unique = true, nullable = false)
	private int countryId;

	@Column(name = "country_name", unique = true, nullable = false)
	@Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
	private String countryName;

	// "mappedBy"'s value is property'name, not column'name
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	private List<Province> provinces;

	// "mappedBy"'s value is property'name, not column'name
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentCitizenship")
	private List<ScholarshipSpecification> scholarshipsWithStudentCitizenship;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Country() {
	}

	public Country(int countryId, String countryName) {
		setId(countryId);
		setName(countryName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return countryId;
	}

	public void setId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return countryName;
	}

	public void setName(String countryName) {
		this.countryName = countryName;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	public List<ScholarshipSpecification> getScholarshipsWithStudentCitizenship() {
		return scholarshipsWithStudentCitizenship;
	}

	public void setScholarshipsWithStudentCitizenship(
			List<ScholarshipSpecification> scholarshipsWithStudentCitizenship) {
		this.scholarshipsWithStudentCitizenship = scholarshipsWithStudentCitizenship;
	}
}
