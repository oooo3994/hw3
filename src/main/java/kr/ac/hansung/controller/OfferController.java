package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {
	
	@Autowired
	private OfferService offerService;
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping("/selectoffers/{year}/{semester}")
	public String showSelectOffers(@PathVariable String year,@PathVariable String semester,Model model) {
		
		List<Offer> offers = offerService.get(year,semester);
		model.addAttribute("selectoffers", offers);
		
		return "selectoffers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("--- Form data does not validated ---"); // 유효하지 않은 데이터
			
			List<ObjectError> errors = result.getAllErrors(); // 모든 에러를 가져오고
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage()); // 전부 출력
			}
			
			return  "createoffer"; // 다시 입력 받아라
		}
		offerService.insert(offer);

		return "offercreated";
	}
	

}
