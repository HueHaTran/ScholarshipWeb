package uit.se06.scholarshipweb.dao.serviceprovider.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IReligionDAO;
import uit.se06.scholarshipweb.model.Religion;

public class JdbcReligionDAO extends JdbcBaseDAO<Religion> implements
		IReligionDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcReligionDAO.class);

	public final String COL_ID = "religion_id";
	public final String COL_NAME = "religion_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcReligionDAO() {
		super(Religion.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Religion findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Religion findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Religion> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}