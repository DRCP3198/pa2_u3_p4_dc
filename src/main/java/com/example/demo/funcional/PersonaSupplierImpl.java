package com.example.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula ="12121312";
		cedula=cedula+"ZZZZZ";
		return cedula;
	}

}
