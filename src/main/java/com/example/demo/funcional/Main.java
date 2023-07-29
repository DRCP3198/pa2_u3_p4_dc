package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOG= LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         IPersona per = new PersonaImpl();
         per.caminar();
         
         //1.-SUPPLIER
         //1.1.-CLASES
         IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
         LOG.info("Supplier clase: "+supplier1.getId());
        
         //1.2.-LAMBDAS:
         //Para impresion la buena practica es usar un LOGGER
	     IPersonaSupplier<String> supplier2= ()-> "1751457167";
	     LOG.info("Supplier lambda: "+supplier2.getId());
	     
	     IPersonaSupplier<String> supplier3= ()-> {String cedula ="12121312";
			cedula=cedula+"ZZZZZ";
			return cedula;};
	     LOG.info("Supplier lambda2: "+supplier3.getId());
	}    

}
