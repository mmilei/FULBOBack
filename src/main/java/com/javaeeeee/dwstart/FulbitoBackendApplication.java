package com.javaeeeee.dwstart;

import java.util.EnumSet;
import java.util.TimeZone;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;

import com.javaeeeee.dwstart.auth.OAuthAuthorizer;
import com.javaeeeee.dwstart.db.*;
import com.javaeeeee.dwstart.exception.NotFoundExceptionMapper;
import com.javaeeeee.dwstart.resources.*;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.DefaultUnauthorizedHandler;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;

import com.javaeeeee.dwstart.auth.OAuthAuthenticator;
import com.javaeeeee.dwstart.core.User;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FulbitoBackendApplication extends Application<FulbitoBackendConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FulbitoBackendApplication().run(args);
    }

    @Override
    public String getName() {
        return "SIGOWebBackend";
    }
    @Override
    public void initialize(final Bootstrap<FulbitoBackendConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final FulbitoBackendConfiguration configuration,
                    final Environment environment) {

    	// Register Datasource
    	DBIFactory factory = new DBIFactory();
    	DBI jdbi = null;
		try {
			jdbi = factory.build(environment, configuration.getDataSourceFactory(), "database");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// setting CORS
		Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

		// necesario para que no falle al correrse en docker
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));

		filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
		filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
		filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
		filter.setInitParameter(CrossOriginFilter.EXPOSED_HEADERS_PARAM, "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,Location,,Content-Disposition");
		filter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,Location");
		filter.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");
		
		ModuloDAO moduloDAO = jdbi.onDemand(ModuloDAO.class);
		IndicadorDAO indicadorDAO = jdbi.onDemand(IndicadorDAO.class);
        ProductoDAO productoDAO = jdbi.onDemand(ProductoDAO.class);
		ArchivoDAO archivoDAO = jdbi.onDemand(ArchivoDAO.class);
        UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        AccessTokenDAO accessTokenDAO = jdbi.onDemand(AccessTokenDAO.class);
		NotificacionDAO notificacionDAO = jdbi.onDemand(NotificacionDAO.class);
		ClienteDAO clienteDAO = jdbi.onDemand(ClienteDAO.class);
		CalificacionDAO calificacionDAO = jdbi.onDemand(CalificacionDAO.class);

		// genero TOKEN sin expiración para TESTING, BORRAR
		//TODO BORRAR
		//accessTokenDAO.initializeDefaultToken();
		////////////////////////////////////////////////////////////////////

		environment.jersey().register(new NotFoundExceptionMapper());
		
    	// Register Resources
		// auth
		final OAuthCredentialAuthFilter<User> authFilter =
				new OAuthCredentialAuthFilter.Builder<User>()
						.setAuthenticator(new OAuthAuthenticator())
						.setAuthorizer(new OAuthAuthorizer())
						.setPrefix("Bearer")
						.setUnauthorizedHandler(new DefaultUnauthorizedHandler())
						.buildAuthFilter();

		environment.jersey().register(RolesAllowedDynamicFeature.class);

        environment.jersey().register(new AuthDynamicFeature(authFilter));
		environment.jersey().register(new AuthValueFactoryProvider.Binder(User.class));

        environment.jersey().register(new ModuloResource(moduloDAO));
        environment.jersey().register(new IndicadorResource(indicadorDAO));
        environment.jersey().register(new ProductoResource(productoDAO,moduloDAO));
        environment.jersey().register(new OAuthResource(accessTokenDAO,userDAO));
		environment.jersey().register(new NotificacionResource(notificacionDAO));
		environment.jersey().register(new ClienteResource(clienteDAO));

		// servicio para upload de archivos
		environment.jersey().register(new ArchivoResource(archivoDAO));
    }

}
