package uit.se06.scholarshipweb.dao.factory;

import uit.se06.scholarshipweb.model.Scholarship;

public interface IScholarshipDAO extends IDAO<Scholarship> {
	/**
	 * for getting general information (not detail, for showing in list of
	 * scholarships)
	 * 
	 * @param id
	 * @return
	 */
	Scholarship findShortInfoById(int id);

}
