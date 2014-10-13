package br.ufrj.provaautomatica;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = ProvaAutomaticaUI.class)
public class Servlet extends VaadinServlet
{
	private static final long serialVersionUID = 6170204083431893599L;
}
