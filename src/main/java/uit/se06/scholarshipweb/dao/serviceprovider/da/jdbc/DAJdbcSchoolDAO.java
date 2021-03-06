package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.ISchoolDAO;
import uit.se06.scholarshipweb.model.School;

public class DAJdbcSchoolDAO extends DAJdbcBaseDAO<School> implements
		ISchoolDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcSchoolDAO.class);

	public static final String COL_ID = "school_id";
	public static  final String COL_NAME = "school_name";
	public static  final String COL_PROVICE_ID = "province_id";
	public static  final String COL_ADDRESS = "address";
	public static  final String COL_PHONE = "phone";
	public static  final String COL_WEBSITE = "website";
	public static  final String COL_FAX = "fax";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcSchoolDAO() {
		super(School.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public School findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public School findByName(String name) {
		return findBy(COL_NAME, name);
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
