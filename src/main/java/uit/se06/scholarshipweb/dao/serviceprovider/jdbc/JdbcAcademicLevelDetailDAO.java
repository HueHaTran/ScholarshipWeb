package uit.se06.scholarshipweb.dao.serviceprovider.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.model.AcademicLevelDetail;

public class JdbcAcademicLevelDetailDAO extends
		JdbcBaseDAO<AcademicLevelDetail> implements IAcademicLevelDetailDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcAcademicLevelDetailDAO.class);

	public final String COL_ID = "academic_level_detail_id";
	public final String COL_NAME = "academic_level_detail_name";
	public final String COL_ACADEMIC_LEVEL_ID = "academic_level_id";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcAcademicLevelDetailDAO() {
		super(AcademicLevelDetail.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public AcademicLevelDetail findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public AcademicLevelDetail findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<AcademicLevelDetail> list() {
		return getAll();
	}

	@Override
	public List<AcademicLevelDetail> findByAcademicLevelId(int academicLevelId) {
		return listBy(COL_ACADEMIC_LEVEL_ID, String.valueOf(academicLevelId));
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}