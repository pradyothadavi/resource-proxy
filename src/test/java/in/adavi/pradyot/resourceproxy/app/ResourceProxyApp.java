package in.adavi.pradyot.resourceproxy.app;

import in.adavi.pradyot.resourceproxy.ResourceProxyBundle;
import in.adavi.pradyot.resourceproxy.app.web.ResProxyAppConfiguration;
import in.adavi.pradyot.resourceproxy.app.web.ResProxySimpleDemoResource;
import in.adavi.pradyot.resourceproxy.core.ResourceProxyBundleConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Pradyot H Adavi
 */
public class ResourceProxyApp extends Application<ResProxyAppConfiguration> {
	
	@Override
	public void initialize(Bootstrap<ResProxyAppConfiguration> bootstrap) {
		super.initialize(bootstrap);
		
		bootstrap.addBundle(new ResourceProxyBundle<ResProxyAppConfiguration>() {
			protected ResourceProxyBundleConfiguration getRequestProxyConfiguration(ResProxyAppConfiguration configuration) {
				return configuration.getResourceProxyBundleConfiguration();
			}
		});
	}
	
	@Override
	public void run(ResProxyAppConfiguration resProxyAppConfiguration, Environment environment) throws Exception {
		environment.jersey().register(new ResProxySimpleDemoResource());
	}
}
