package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);
	
	public Integer getId() {
		return 8;
	}
	
	 public void aceptar(String arg) {
		 String cadena = "Dillan";
		 LOG.info(cadena + " "+ arg);
	 }
		public boolean evaluar(String arg) {
			String nombre= "Renato";
			nombre.contains("a");
			return true;
		}

		public String aplicar(Integer arg) {
			
			Integer numero=10;
			String valorFinal= numero.toString().concat("Mi mama me mima");
			
			return  valorFinal;
		}
		
		public Integer aplicarUnary(Integer arg) {
			 
			if(arg.compareTo(100)>0) {
				arg=arg*100;
			}else {
				arg=arg+200;
			}
			
			return arg;
		}
}
