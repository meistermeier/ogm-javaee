package org.neo4j.ogm.env;

import javax.enterprise.context.ApplicationScoped;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;

@ApplicationScoped
public class OgmSessionBean {

	private final SessionFactory sessionFactory;

	public OgmSessionBean() {
		Configuration configuration = new Configuration.Builder()
				.credentials("neo4j", "secret")
				.uri("bolt://localhost:7687")
				.build();

		sessionFactory = new SessionFactory(configuration, "org.neo4j.ogm.env.domain");
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
