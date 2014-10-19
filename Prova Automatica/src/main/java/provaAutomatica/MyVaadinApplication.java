package provaAutomatica;

import java.util.Set;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import provaAutomatica.domain.Person;
import provaAutomatica.domain.Questao;
import provaAutomatica.ui.BasicCrudView;

import com.vaadin.Application;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application {

	public static final String PERSISTENCE_UNIT = "provaAutomatica";

	@Override
	public void init() {
		setMainWindow(new AutoCrudViews());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	class AutoCrudViews extends Window {
		
		public AutoCrudViews() {
			final HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
			Tree navTree = new Tree();
			navTree.addListener(new Property.ValueChangeListener() {
				@Override
				public void valueChange(ValueChangeEvent event) {
					BasicCrudView cv = (BasicCrudView) event.getProperty()
							.getValue();
					cv.refreshContainer();
					horizontalSplitPanel.setSecondComponent(cv);
				}
			});
			navTree.setSelectable(true);
			navTree.setNullSelectionAllowed(false);
			navTree.setImmediate(true);

			horizontalSplitPanel.setSplitPosition(200,
					HorizontalSplitPanel.UNITS_PIXELS);
			horizontalSplitPanel.addComponent(navTree);
			setContent(horizontalSplitPanel);

			// add a basic crud view for all entities known by the JPA
			// implementation, most often this is not desired and developers
			// should just list those entities they want to have editors for
			Metamodel metamodel = JPAContainerFactory
					.createEntityManagerForPersistenceUnit(PERSISTENCE_UNIT)
					.getEntityManagerFactory().getMetamodel();
			Set<EntityType<?>> entities = metamodel.getEntities();
			for (EntityType<?> entityType : entities) {
				Class<?> javaType = entityType.getJavaType();
				BasicCrudView view = new BasicCrudView(javaType,
						PERSISTENCE_UNIT);
				navTree.addItem(view);
				navTree.setItemCaption(view, view.getCaption());
				navTree.setChildrenAllowed(view, false);
				if(javaType == Person.class) {
					view.setVisibleTableProperties("firstName","lastName", "boss");
					view.setVisibleFormProperties("firstName","lastName", "phoneNumber", "street", "city", "zipCode", "boss");
				}
				
				if(javaType == Questao.class) {
					view.setVisibleTableProperties("questaoId","conteudo");
					view.setVisibleFormProperties("conteudo");
				}

			}

			// select first entity view
			navTree.setValue(navTree.getItemIds().iterator().next());
		}
	}
}
