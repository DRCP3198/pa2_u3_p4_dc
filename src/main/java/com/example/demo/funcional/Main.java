package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPersona per = new PersonaImpl();
		per.caminar();

		// 1.-SUPPLIER
		// 1.1.-CLASES
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase: " + supplier1.getId());

		// 1.2.-LAMBDAS:
		// Para impresion la buena practica es usar un LOGGER
		IPersonaSupplier<String> supplier2 = () -> "1751457167";
		LOG.info("Supplier lambda: " + supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "12121312";
			cedula = cedula + "ZZZZZ";
			return cedula;
		};
		LOG.info("Supplier lambda2: " + supplier3.getId());
		
		// 1.3.-Métodos referenciados
		
		MetodosReferenciados metodos = new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4 = metodos::getId;
		LOG.info("Supplier método referenciado: " + supplier4.getId());

		// 2.CONSUMER:
		// 2.1.-Clases
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer clase ");
		consumer1.accept("Dillan Coloma");

		// 2.2.-Lambdas
		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		LOG.info("Consumer Lambda ");
		consumer2.accept("Dillan Coloma2");
		
		// 2.3.-Método Referenciado
		IPersonaConsumer<String> consumer3= metodos::aceptar;
		LOG.info("Consumer metodos referenciado ");
		consumer3.accept("A");

		// 3.-PREDICATE
		// 3.1-Lambdas
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(4) == 0;
		LOG.info("Predicate lamda 1: " + predicate1.evaluar(12));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;
			} else {
				return false;
			}

		};
		LOG.info("Predicate lamda 2: " + predicate2.evaluar(95));

		// lambda de tipo predicate si mi nombre contiene un caracter;
		IPersonaPredicate<String> predicate3 = letra -> "Dillan".contains(letra);
		LOG.info("Predicate lambda 3: " + predicate3.evaluar("x"));

		IPersonaBiPredicate<String, String> bipredicate = (letra, cadena) -> cadena.contains(letra);
		LOG.info("BiPredicate lambda 4:" + bipredicate.evaluar("j", "Jose"));
	    
		// 3.2-Métodos Referenciados
		IPersonaPredicate<String> predicate4= metodos::evaluar;
		LOG.info("Predicate met referenciado: "+ predicate4.evaluar("m"));
		//4.-FUNCTION
		//4.1.-lambda:
		IPersonaFunction<String, Integer> function= numero->numero.toString();
		LOG.info("Function lambda 5: " + function.aplicar(8));
		
		IPersonaFunction<String, Integer> function1= numero->{
			String valorFinal= numero.toString().concat("valor");
			return valorFinal;
		
		};
		LOG.info("Function lambda 6: " + function1.aplicar(10));
		
		//4.2.-Métodos referenciados
		IPersonaFunction<String, Integer> function2= metodos::aplicar;
		LOG.info("Función metodos referenciados: "+ function2.aplicar(12));
		
		//5.-UNARYOPERATOR
		//5.1 Lambdas
		IPersonaUnaryOperator<Integer> unaryOperator= numero-> numero + (numero*2);
		LOG.info("UnaryOperator lambda 7: " + unaryOperator.aplicar(4));
	
		IPersonaUnaryOperatorFunction<Integer> unaryOperato2= numero-> numero + (numero*2);
		LOG.info("UnaryOperatorFunction lambda 8: " + unaryOperato2.aplicar(4));
	
		//5.2.-Métodos referenciados
		IPersonaUnaryOperator<Integer> unaryOperator3= metodos::aplicarUnary;
		LOG.info("UnaryOperator método referenciado: " +unaryOperator3.aplicar(99));
	}

}
