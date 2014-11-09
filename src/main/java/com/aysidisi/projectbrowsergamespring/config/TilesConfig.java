
package com.aysidisi.projectbrowsergamespring.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.UnresolvingLocaleDefinitionsFactory;
import org.apache.tiles.request.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
public class TilesConfig extends TilesConfigurer
{
	public static class JavaDefinitionsFactory extends
	UnresolvingLocaleDefinitionsFactory
	{
		
		public JavaDefinitionsFactory()
		{
		}

		@Override
		public Definition getDefinition(final String name,
				final Request tilesContext)
		{
			String[] splittedName = name.split("\\|", 2);
			String viewName = "";
			String template = "";
			if (splittedName.length > 1)
			{
				template = splittedName[0];
				viewName = splittedName[1];
			}
			Map<String, Attribute> bodyAttribute = new HashMap<String, Attribute>();
			bodyAttribute.put("body", new Attribute("/WEB-INF/views/"
					+ viewName + ".jsp"));
			Definition definition = tiles.get(template);
			if (definition != null)
			{
				definition.addMissing(bodyAttribute);
			}
			return definition;
		}
	}

	private static final Map<String, Definition> tiles = new HashMap<String, Definition>();
	
	@Bean
	public TilesConfigurer tilesConfigurer()
	{
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer
		.setDefinitionsFactoryClass(JavaDefinitionsFactory.class);
		tilesConfigurer.setDefinitions(new String[] {});
		this.addDefinition("bodyOnly", new Attribute(
				"/WEB-INF/tiles/bodyOnly/bodyOnly.jsp"), this
				.getBodyOnlyAttributes());
		this.addDefinition("mainTemplate", new Attribute(
				"/WEB-INF/tiles/mainTemplate/mainTemplate.jsp"), this
				.getMainTemplateAttributes());
		return tilesConfigurer;
	}
	
	private void addDefinition(final String name, final Attribute template,
			final Map<String, Attribute> attributes)
	{
		tiles.put(name, new Definition(name, template, attributes));
	}
	
	private Map<String, Attribute> getBodyOnlyAttributes()
	{
		Map<String, Attribute> attributes = new HashMap<String, Attribute>();
		return attributes;
	}
	
	private Map<String, Attribute> getMainTemplateAttributes()
	{
		Map<String, Attribute> attributes = new HashMap<String, Attribute>();
		attributes.put("header", new Attribute(
				"/WEB-INF/views/mainTemplate/header.jsp"));
		attributes.put("navigation", new Attribute(
				"/WEB-INF/views/mainTemplate/navigation.jsp"));
		attributes.put("footer", new Attribute(
				"/WEB-INF/views/mainTemplate/footer.jsp"));
		return attributes;
	}

}
