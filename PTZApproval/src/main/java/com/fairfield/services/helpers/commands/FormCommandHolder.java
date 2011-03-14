package com.fairfield.services.helpers.commands;


public class FormCommandHolder {
	public static void execute(IFormCommand command){
		command.execute();
	}
}
