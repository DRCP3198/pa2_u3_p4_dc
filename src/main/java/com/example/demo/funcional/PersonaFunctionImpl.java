package com.example.demo.funcional;

public class PersonaFunctionImpl implements IPersonaFunction<String, Integer>{

	@Override
	public String aplicar(Integer arg) {
		// TODO Auto-generated method stub
		Integer numero=20;
		
		String fin= "Dillan edad".concat(numero.toString());
		return fin;
	}

}
