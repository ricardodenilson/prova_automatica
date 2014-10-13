package br.ufrj.provaautomatica;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("provaautomatica")
public class ProvaAutomaticaUI extends UI
{
	private static final long serialVersionUID = 8550895598521747244L;

	@Override
	protected void init(VaadinRequest request)
	{
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Clique aqui!");
		button.addClickListener(new CustomClickListener(layout));
		
		String user = System.getProperty("user.name");
		Label label = new Label("Bem vindo ao Vaadin: " + user);
		
		layout.addComponent(button);
		layout.addComponent(label);
	}
}
