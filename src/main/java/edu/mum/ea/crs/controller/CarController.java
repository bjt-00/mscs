package edu.mum.ea.crs.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.ea.crs.data.dao.CarDao;
import edu.mum.ea.crs.data.domain.Car;

@Controller
public class CarController {
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	private static final String MODEL_ATTRIBUTE = "car";
	private static final String VIEW_DETAIL = "car/carDetail";
	private static final String VIEW_LIST = "car/carList";

	@Resource
	private CarDao carDao;

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String getAll(Model model, @ModelAttribute("project") Car c) {
		Car car = new Car();
		car.setCarModel("Honda");
		car.setManufacturer("M001");
		car.setColor("Blue");
		car.setYear(2011);
		car.setPlateNo("000000002");
		car.setSpeed(200);
		car.setStatus((short)0);
		carDao.save(car);
		
		model.addAttribute("cars", carDao.findAll());
		if (c.getId() == null) {
			c = new Car();
		}
		model.addAttribute("view", VIEW_LIST);
		model.addAttribute(MODEL_ATTRIBUTE, c);
		System.out.println("CarController getAll() " + c.getId());
		return "dashboard";
	}

	@RequestMapping(value = "/cars/add", method = RequestMethod.POST)
	public String addOrUpdate(@ModelAttribute(MODEL_ATTRIBUTE) Car c, Model model, 
			final RedirectAttributes redirectAtt) {
		try {
			if (c.getId() == null) {
				// new add it
				redirectAtt.addFlashAttribute("msg", "Save Successfully");
				logger.info("CarController (addOrUpdate): save new car record");
			} else {
				// existing , call update
				redirectAtt.addFlashAttribute("msg", "Update Successfully");
			}
//			this.carDao.save(c);
		} catch (Exception e) {
			logger.error("CarController (addOrUpdate): " + e.getMessage());
			logger.info("CarController (addOrUpdate): update car record" + c.getId());
		}
		
//		model.addAttribute("view", "ars/u/" + c.getId());
//		return "dashboard";
		return "redirect:/cars/u/" + c.getId();

	}

	@RequestMapping(value = "/cars/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Car c, Model model) {		
		model.addAttribute("view", VIEW_DETAIL);
		return "dashboard";
	}

	@RequestMapping(value = "/cars/u/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id, Model model) {
//		model.addAttribute(MODEL_ATTRIBUTE, carDao.findOne(id));
		model.addAttribute("view", VIEW_DETAIL);
		return "dashboard";
	}

	@RequestMapping(value = "/cars/remove", method = RequestMethod.POST)
	public String remove(Long id) {
//		carDao.delete(id);
		return "redirect:/cars";
	}
}
