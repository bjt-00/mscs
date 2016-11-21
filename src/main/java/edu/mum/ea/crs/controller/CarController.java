package edu.mum.ea.crs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.ea.crs.data.domain.Car;
import edu.mum.ea.crs.enumeration.CarStatus;
import edu.mum.ea.crs.service.CarService;

@Controller
public class CarController extends GenericController {
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);

	private static final String MODEL_ATTRIBUTE = "car";
	private static final String VIEW_DETAIL = "car/carDetail";
	private static final String VIEW_LIST = "car/carList";

	@Autowired
	private CarService carService;	
	private int count;

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String getAll(Model model, @ModelAttribute("project") Car c) {
		Car car = new Car();
		car.setCarModel("Honda");
		car.setManufacturer("M001" + count++);
		car.setColor("Blue");
		car.setYear(2011);
		car.setPlateNo("000000002");
		car.setSpeed(200);
		car.setStatus((short) 1);
		carService.save(car);

		model.addAttribute("cars", carService.findAll());
		if (c.getId() == null) {
			c = new Car();
		}
		model.addAttribute("view", VIEW_LIST);
		model.addAttribute(MODEL_ATTRIBUTE, c);		
		return "dashboard";
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
			}
			this.carService.save(c);
		} catch (Exception e) {
			logger.error("CarController (addOrUpdate): " + e.getMessage());
		}
		model.addAttribute(MODEL_ATTRIBUTE, c);
		model.addAttribute("view", VIEW_DETAIL);
		return "dashboard";
	}

	@RequestMapping(value = "/cars/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Car c, Model model) {
		model.addAttribute("view", VIEW_DETAIL);
		System.out.println("detailPage() ");
		return "dashboard";
	}

	@RequestMapping(value = "/cars/u/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id, Model model) {
		model.addAttribute(MODEL_ATTRIBUTE, carService.findByID(id));
		model.addAttribute("view", VIEW_DETAIL);
		return "dashboard";
	}

	@RequestMapping(value = "/cars/remove", method = RequestMethod.GET)
	public String remove(Long id, Model model) {
		carService.remove(id);
		model.addAttribute("view", VIEW_LIST);
		return "dashboard";
	}

	@RequestMapping(value = "/cars/search", method = RequestMethod.GET)
	public String searchCar(@RequestParam("query") String query, Model model) {
		if (query.length() > 0) {
			model.addAttribute("cars", carService.getCarsByStatus(query, (short) 1));
		} else {
			model.addAttribute("cars", carService.findAll());
		}
		model.addAttribute("view", VIEW_LIST);
		return "dashboard";
	}
}
