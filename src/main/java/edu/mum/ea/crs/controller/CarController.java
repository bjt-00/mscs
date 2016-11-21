package edu.mum.ea.crs.controller;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.ea.crs.data.domain.Car;
import edu.mum.ea.crs.service.CarService;

@Controller
public class CarController extends GenericController {
	private static Logger logger = LogManager.getLogger();

	private static final String MODEL_ATTRIBUTE = "car";
	private static final String VIEW_DETAIL = "car/carDetail";
	private static final String VIEW_LIST = "car/carList";

	@Autowired
	private CarService carService;	
	private int count;

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String getAll(Model model, @ModelAttribute("project") Car c) {
		logger.info("CarController getAll ");
		Car car = new Car();
		car.setCarModel("Honda");
		car.setManufacturer("M001" + count++);
		car.setColor("Blue");
		car.setYear(2011);
		car.setPlateNo("000000002");
		car.setSpeed(200);
		car.setStatus(Car.STATUS_AVAILABLE);
		carService.save(car);

		model.addAttribute("cars", carService.findAll());
		if (c.getId() == null) {
			c = new Car();
		}	
		model.addAttribute(MODEL_ATTRIBUTE, c);	
		addStatus(model);
		return getView(VIEW_LIST, model);
	}

	@RequestMapping(value = "/cars/save", method = RequestMethod.POST)
	public String addOrUpdate(@ModelAttribute(MODEL_ATTRIBUTE) Car c, Model model) {
		try {
			if (c.getId() == null) {
				// new add it
				model.addAttribute("msg", "Save Successfully");
				logger.info("CarController (addOrUpdate): save new car record");
			} else {
				// existing , call update
				model.addAttribute("msg", "Update Successfully");
				logger.info("CarController (addOrUpdate): update car record");
			}
			this.carService.save(c);
		} catch (Exception e) {
			logger.error("CarController (addOrUpdate): " + e.getMessage());
		}
		model.addAttribute(MODEL_ATTRIBUTE, c);		
		addStatus(model);
		return getView(VIEW_DETAIL, model);
	}

	@RequestMapping(value = "/cars/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Car c, Model model) {		
		addStatus(model);
		return getView(VIEW_DETAIL, model);
	}

	@RequestMapping(value = "/cars/u/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id, Model model) {
		logger.info("CarController get");
		model.addAttribute(MODEL_ATTRIBUTE, carService.findByID(id));
		addStatus(model);
		return getView(VIEW_DETAIL, model);
	}

	@RequestMapping(value = "/cars/remove", method = RequestMethod.GET)
	public String remove(Long id, Model model) {
		carService.remove(id);
		model.addAttribute("view", VIEW_LIST);
		return getView(VIEW_LIST, model);		
	}

	@RequestMapping(value = "/cars/search", method = RequestMethod.GET)
	public String searchCar(@RequestParam("query") String query, Model model) {
		if (query.length() > 0) {
			model.addAttribute("cars", carService.getCarsByStatus(query, (short) 1));
		} else {
			model.addAttribute("cars", carService.findAll());
		}		
		return getView(VIEW_LIST, model);
	}
	
	private void addStatus(Model model) {
		String[] status = {Car.STATUS_AVAILABLE, Car.STATUS_NOT_AVAILABLE};
		model.addAttribute("carStatus", Arrays.asList(status));
	}
	
	private void reserve(Model model) {
		String[] status = {Car.STATUS_AVAILABLE, Car.STATUS_NOT_AVAILABLE};
		model.addAttribute("carStatus", Arrays.asList(status));
	}
}
