package org.prem.rest.resttest.service;

import java.util.ArrayList;
import java.util.List;

import org.prem.rest.resttest.Model.*;
public class Messageservice {
	
	public List<Message> getAllMessages()
	{
		Message m1=new Message(1,"Hello", "prem");
		Message m2=new Message(1,"Hello jack", "Ashu");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
		
	}

}
