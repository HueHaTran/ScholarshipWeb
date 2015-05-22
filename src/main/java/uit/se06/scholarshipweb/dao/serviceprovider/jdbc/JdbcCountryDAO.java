package uit.se06.scholarshipweb.dao.serviceprovider.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.ICountryDAO;
import uit.se06.scholarshipweb.model.Country;

public class JdbcCountryDAO extends JdbcBaseDAO<Country> implements ICountryDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcCountryDAO.class);

	public final String COL_ID = "country_id";
	public final String COL_NAME = "country_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcCountryDAO() {
		super(Country.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Country findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Country findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Country> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}