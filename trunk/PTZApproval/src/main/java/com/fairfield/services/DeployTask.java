package com.fairfield.services;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;

public class DeployTask{
	private static JbpmConfiguration conf = null;
	private static void createSchema(){
		try{
		JbpmConfiguration conf = JbpmConfiguration.parseResource("jbpm.cfg.xml");
		if(conf==null){
			System.out.println("Configuration is null");
		}
		conf.createSchema();
        JbpmContext context = conf.createJbpmContext();
        ProcessDefinition processDefinition = ProcessDefinition.parseXmlResource("simple/processdefinition.xml");
        processDefinition.setName("requestFacilityDefinition");
        context.deployProcessDefinition(processDefinition);
        context.close();
        }catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	private static void deployProcess(){

	}
	public static void run(){
		if(conf==null){
			createSchema();
			deployProcess();
		}
	}
}
