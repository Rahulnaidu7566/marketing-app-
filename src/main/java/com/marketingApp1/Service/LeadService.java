package com.marketingApp1.Service;

import java.util.List;

import com.marketingApp1.entity.Lead;

public interface LeadService {
	public void saveLead(Lead lead);
	public List<Lead> getAllLeads();
	public void deleteLeadbyId(long id);
	public Lead findLeadById(long id);
	
  } 

