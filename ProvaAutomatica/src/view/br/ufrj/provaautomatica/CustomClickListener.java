package br.ufrj.provaautomatica;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;

public class CustomClickListener implements ClickListener
{
	private static final long serialVersionUID = 1681648669598756777L;

	Layout layout;
	
	public CustomClickListener(Layout layout)
	{
		this.layout = layout;
	}
	
	@Override
	public void buttonClick(ClickEvent event)
	{
		layout.addComponent(new Label("Olá mundo!"));
	}
}
