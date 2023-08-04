package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);
	
	public static Integer getId() {
		return 8;
	}
	public static String getIdHO() {
		LOG.info("Métodos referenciado y HO");
		return "Renato Pozo";
	}
	
	
	 public static void aceptar(String arg) {
		 String cadena = "Dillan";
		 LOG.info(cadena + " "+ arg);
	 }
		public boolean evaluar(String arg) {
			String nombre= "Renato";
			nombre.contains("a");
			return true;
		}
		public boolean evaluarPredicate(String arg) {
			String nombre= "Renato";
			nombre.contains("a");
			return true;
		}
		public static boolean predicateHo (Integer num) {
			return num+1>30;
		}
		public static String functionReferenciado(Integer num) {
          

			return "Sueldo de Dillan "+ num.toString();
		}
		public static Integer aplicarUnary(Integer arg) {
			 
			if(arg.compareTo(100)>0) {
				arg=arg*100;
			}else {
				arg=arg+200;
			}
			
			return arg;
		}
		
}
