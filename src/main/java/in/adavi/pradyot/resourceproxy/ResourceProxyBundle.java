package in.adavi.pradyot.resourceproxy;

import com.google.inject.Guice;
import com.google.inject.Injector;
import in.adavi.pradyot.resourceproxy.core.ResourceProxyBundleConfiguration;
import in.adavi.pradyot.resourceproxy.core.ResourceProxyModule;
import in.adavi.pradyot.resourceproxy.core.ResourceProxyRegistration;
import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Pradyot H Adavi
 */
public abstract class ResourceProxyBundle<T extends Configuration> implements ConfiguredBundle<T> {
	
	public void run(final T configuration, Environment environment) throws Exception {
		
		ResourceProxyBundleConfiguration resourceProxyBundleConfiguration = getRequestProxyConfiguration(configuration);
		if(null != resourceProxyBundleConfiguration){
			
			Injector injector = Guice.createInjector(new ResourceProxyModule(resourceProxyBundleConfiguration));
			
			environment.jersey().register(injector.getInstance(ResourceProxyRegistration.class));
		}
	}
	
	public void initialize(Bootstrap<?> bootstrap) {
	
	}
	
	protected abstract ResourceProxyBundleConfiguration getRequestProxyConfiguration(T configuration);
}
