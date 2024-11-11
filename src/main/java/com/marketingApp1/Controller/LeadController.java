package com.marketingApp1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingApp1.Dto.LeadDto;
import com.marketingApp1.Service.LeadService;
import com.marketingApp1.entity.Lead;
import com.marketingApp1.utility.EmailService;

@Controller  //it interact with view and with backEnd business logic
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/create") //it acts as the web servlet annotation
	public String viewCreateLead() {
		return "create_lead"; //it is used to load the page in browser
		
	}
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute Lead lead, ModelMap model) {//(it copy data form to entity object)
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(), "Test", "Welcome");
		model.addAttribute("msg","Record is saved");
		return "create_lead";
		
	}
	
//	@RequestMapping("/saveLead")
//	public String saveLead(LeadDto leadDto) {
//		Lead lead = new Lead();
//		lead.setFirstName(leadDto.getFirstName());
//		lead.setLastName(leadDto.getLastName());
//		lead.setEmail(leadDto.getEmail());
//		lead.setMobile(leadDto.getMobile());
//		leadService.saveLead(lead);
//		return "create_lead";
//		
//	}
	
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads",leads);
		return "search_result";
	}
	
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id") long id, Model model) {
		leadService.deleteLeadbyId(id);
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads",leads);
		return "search_result";
		
	}
	@RequestMapping("/update")
	public String getLeadById(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead",lead);
			return "update_lead";
	}
	@RequestMapping("/updateLead")
	public String updateLead(LeadDto dto, Model model) {
		Lead l = new Lead();
		l.setId(dto.getId());
		l.setFirstName(dto.getFirstName());
		l.setEmail(dto.getEmail());
		l.setLastName(dto.getLastName());
		l.setMobile(dto.getMobile());
		
		leadService.saveLead(l);
		
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads",leads);
		return "search_result";
		
	}
	
}