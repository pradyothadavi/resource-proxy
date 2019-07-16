package in.adavi.pradyot.resourceproxy.core;

import com.codahale.metrics.MetricRegistry;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import in.adavi.pradyot.resourceproxy.hystrix.ResProxyHystrixProperties;
import io.dropwizard.setup.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.glassfish.jersey.client.ClientProperties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Map;

/**
 * @author Pradyot H Adavi
 */
@Data
@AllArgsConstructor
public class ResourceProxyModule extends AbstractModule {
	
	private ResourceProxyBundleConfiguration resourceProxyBundleConfiguration;
	private Environment environment;
	
	@Override
	protected void configure() {
		bind(ResourceProxyService.class).to(ResourceProxyMgr.class);
	}
	
	@Provides
	@Singleton
	public Map<String,ResourceProxyConfig> providesMapResourceProxyConfigMap(){
		return resourceProxyBundleConfiguration.getResourceProxyConfigMap();
	}
	
	@Provides
	@Singleton
	public Client providesClient(){
		Client client = ClientBuilder.newClient();
		return client;
	}
	
	@Provides
	@Singleton
	public MetricRegistry providesMetricRegistry(){
		return environment.metrics();
	}
	
	@Provides
	@Singleton
	public ResProxyHystrixProperties providesResProxyHystrixProperties(){
		return resourceProxyBundleConfiguration.getResProxyHystrixProperties();
	}
	
	@Provides
	@Singleton
	public ResourceProxyBundleConfiguration providesResourceProxyBundleConfiguration(){
		return resourceProxyBundleConfiguration;
	}
}
