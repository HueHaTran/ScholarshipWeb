package uit.se06.scholarshipweb.dao.serviceprovider.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.ITerminalIllDAO;
import uit.se06.scholarshipweb.model.TerminalIll;

public class JdbcTerminalIllDAO extends JdbcBaseDAO<TerminalIll> implements
		ITerminalIllDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcTerminalIllDAO.class);

	public final String COL_ID = "terminal_ill_id";
	public final String COL_NAME = "terminal_ill_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcTerminalIllDAO() {
		super(TerminalIll.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public TerminalIll findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public TerminalIll findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<TerminalIll> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}