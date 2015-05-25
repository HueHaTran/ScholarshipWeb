package uit.se06.scholarshipweb.dao.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.AcademicLevelDetail;

public interface IAcademicLevelDetailDAO extends IDAO<AcademicLevelDetail> {
	List<AcademicLevelDetail> findByAcademicLevelId(int academicLevelId);
}
