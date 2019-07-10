package in.adavi.pradyot.resourceproxy.core;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.Data;

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
}
