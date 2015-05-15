package uit.se06.scholarshipweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uit.se06.scholarshipweb.bus.CountryBUS;
import uit.se06.scholarshipweb.bus.FilterBUS;
import uit.se06.scholarshipweb.dao.impl.util.HibernateUtil;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.viewmodel.FilterPersonalInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FilterController {

	private static final Logger logger = LoggerFactory
			.getLogger(FilterController.class);

	private FilterBUS bus;
	private CountryBUS busCountry;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FilterController() {
		logger.info("Enter Filter's controller");// test
		SessionFactory sessionFactory = HibernateUtil
				.getSessionAnnotationFactory();
		bus = new FilterBUS(sessionFactory);
		busCountry = new CountryBUS(sessionFactory);
	}

	// ============================================================
	// REQUESTS
	// ============================================================

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView home(Locale locale) {
		logger.info("Welcome to " + this.getClass().getCanonicalName()
				+ "! The client locale is {}.", locale);

		ModelAndView data = new ModelAndView("filter");
		FilterPersonalInfo entity = bus.getPersonalInfo();

		data.addObject("meta_data_gender", entity.getGenders());
		data.addObject("meta_data_country", entity.getCountries());
		// data.addObject("meta_data_province", entity.getProvinces());
		data.addObject("meta_data_religion", entity.getReligion());
		data.addObject("meta_data_disability", entity.getDisabilities());
		data.addObject("meta_data_terminal_ill", entity.getTerminalIllnesses());

		return data;
	}

	@RequestMapping(value = "/get_province", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<Province> getProvincesFromCountry(
			HttpServletRequest request, @RequestBody String countryId) {
		logger.info("super cool!!!!!!!!!!! " + countryId);

		int id;
		try {
			id = Integer.parseInt(countryId);
		} catch (NumberFormatException e) {
			logger.info("Exception in " + this.getClass().getCanonicalName()
					+ ": " + e.toString());
			return new ArrayList<Province>();
		}

		List<Province> s = busCountry.listProvinceByCountry(id);
		logger.info("super cool!!!!!!!!!!!2 " + s.size());

		return s;
		// return s;
	}
}
