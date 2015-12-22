package kr.re.etri.fncp.vapp.openflowswitch.em;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import kr.re.etri.fncp.vapp.openflowswitch.em.jersey.message.JettisonJsonArrayEntityProvider;
import kr.re.etri.fncp.vapp.openflowswitch.em.jersey.message.JettisonJsonEntityProvider;
import kr.re.etri.fncp.vapp.openflowswitch.em.jersey.message.OpenCommonJsonSimpleEntityProvider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Main class.
 *
 */
public class Main {

	public static final Log logger = LogFactory.getLog(Main.class);
	
	// Base URI the Grizzly HTTP server will listen on
	public static final URI baseUri = UriBuilder.fromUri("http://0.0.0.0").port(9797).build();

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
    	
    	if(logger.isInfoEnabled()){
    		logger.info("================== OpenFlow Switch EM, URI: "+baseUri.getHost());
    		logger.info("================== OpenFlow Switch EM, PORT: "+baseUri.getPort());
    	}
    	
        // create a resource config that scans for JAX-RS resources and providers
        // in kr.re.etri.fncp.vapp.openflowswitch.em package
    	ResourceConfig config = new ResourceConfig().setApplicationName("openflowswitch-em");
        config.register(JettisonJsonArrayEntityProvider.class);
        config.register(JettisonJsonEntityProvider.class);
        config.register(OpenCommonJsonSimpleEntityProvider.class);
        
        config.register(EMResource.class);
        
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
    	if(logger.isInfoEnabled()){
    		logger.info("================== OpenFlow Switch EM, RESTful Server Start ");
    	}
    	
    	final HttpServer server = startServer();
    	
    	if(logger.isInfoEnabled()){
    		logger.info("================== OpenFlow Switch EM, RESTful Server Started ");
    	}
        
        System.in.read();
        server.stop();
        
        if(logger.isInfoEnabled()){
        	logger.info("================== OpenFlow Switch EM, RESTful Server stop ");
        }
        
    }
}

