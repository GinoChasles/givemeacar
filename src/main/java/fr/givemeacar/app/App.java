package fr.givemeacar.app;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

import javax.persistence.metamodel.EntityType;
@SpringBootApplication
public class App {
	private static final SessionFactory ourSessionFactory;

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> sessionManagerCustomizer() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		return server -> server.addContextCustomizers(context -> {
			context.setSessionTimeout(24 * 60);
			context.setUseHttpOnly(false);
		});
	}

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();

			ourSessionFactory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		return ourSessionFactory.openSession();
	}

	public static void main(final String[] args) throws Exception {
		final Session session = getSession();
		SpringApplication.run(App.class, args);

		try {
			final Metamodel metamodel = session.getSessionFactory().getMetamodel();
		} finally {
			session.close();
		}
	}
}
