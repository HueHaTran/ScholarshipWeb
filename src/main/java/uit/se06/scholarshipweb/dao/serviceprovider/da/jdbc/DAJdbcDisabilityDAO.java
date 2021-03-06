package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IDisabilityDAO;
import uit.se06.scholarshipweb.model.Disability;

public class DAJdbcDisabilityDAO extends DAJdbcBaseDAO<Disability> implements
		IDisabilityDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcDisabilityDAO.class);

	public final String COL_ID = "disability_id";
	public final String COL_NAME = "disability_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcDisabilityDAO() {
		super(Disability.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Disability findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Disability findByName(String name) {
		return findBy(COL_NAME, name);
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
