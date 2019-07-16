# Integrate with dropwizard application

1. The configuration class of the application has
   ResourceProxyBundleConfiguration.

``` java 
public class ResProxyAppConfiguration extends Configuration {
	
	private ResourceProxyBundleConfiguration resourceProxyBundleConfiguration;
}
```

2. Add the bundle in the initialize method of the dropwizard application 
   class.
   
``` java
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
	
	
}
```