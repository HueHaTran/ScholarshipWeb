package uit.se06.scholarshipweb.bus.factory;

import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.viewmodel.OverviewScholarshipViewModel;
import uit.se06.scholarshipweb.viewmodel.ScholarshipViewModel;

public interface IScholarshipBUS extends IBUS<Scholarship> {

	ScholarshipViewModel findViewModelById(int id);

	ScholarshipViewModel findViewModelByName(String name);

	OverviewScholarshipViewModel findOverviewById(int id);

	OverviewScholarshipViewModel convertToOverviewViewModel(
			Scholarship scholarship);

}