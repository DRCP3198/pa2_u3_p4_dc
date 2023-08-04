package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaPredicateImpl implements IPersonaPredicate<Integer>{
	private static final Logger LOG= LoggerFactory.getLogger(PersonaPredicateImpl.class);
	@Override
	public boolean evaluar(Integer arg) {
		// TODO Auto-generated method stub
		if(arg>20) {
			arg=arg+200;
			return true;
		}else {
			arg=arg*5;
			return false;
		}
		
	}

}
