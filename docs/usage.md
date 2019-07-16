# Usage

## Integrate with dropwizard application

* The configuration class of the application has
ResourceProxyBundleConfiguration.

``` java 
public class ResProxyAppConfiguration extends Configuration {
	
	private ResourceProxyBundleConfiguration resourceProxyBundleConfiguration;
}
```

* Add the bundle in the initialize method of the dropwizard application
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

* Resource Proxy Configurations 
``` yaml
server:
  type: default
  applicationContextPath: /resource-proxy
  adminContextPath: /admin
  applicationConnectors:
    - type: http
      port: 19090
  adminConnectors:
    - type: http
      port: 19091

logging:
  level: INFO
  appenders:
    - type: console

resourceProxyBundleConfiguration:
  resourceProxyConfigMap:
    GET-demo/0: {"host":"http://localhost:", "port": 19090,"path": "resource-proxy/demo/1","proxyEnabled": true}
    POST-demo/3: {"host":"http://localhost:", "port": 19090,"path": "resource-proxy/demo/4","proxyEnabled": true,
                  "connectTimeout": 2000}
    GET-demo/5: {"host":"http://localhost:", "port": 19090,"path": "resource-proxy/demo/6","proxyEnabled": true,
                 "readTimeout": 2000}
    PUT-demo/7: {"host":"http://localhost:", "port": 19090,"path": "resource-proxy/demo/8","proxyEnabled": true}

  resProxyHystrixProperties:
    commandExecutionProperties:
      hystrix.command.POST-demo/3.execution.isolation.thread.timeoutInMilliseconds: 3000
      hystrix.command.GET-demo/5.execution.isolation.thread.timeoutInMilliseconds: 3000
      hystrix.command.PUT-demo/7.execution.isolation.thread.timeoutInMilliseconds: 3000
    commandCircuitBreakerProperties:
      hystrix.command.POST-demo/3.circuitBreaker.forceClosed: false
      hystrix.command.GET-demo/5.circuitBreaker.forceClosed: false
      hystrix.command.PUT-demo/7.circuitBreaker.forceClosed: false
    threadPoolProperties:
      hystrix.threadpool.POST-demo/3.coreSize: 10
      hystrix.threadpool.POST-demo/3.maximumSize: 10
      hystrix.threadpool.POST-demo/3.allowMaximumSizeToDivergeFromCoreSize: false
      hystrix.threadpool.GET-demo/5.coreSize: 10
      hystrix.threadpool.GET-demo/5.maximumSize: 10
      hystrix.threadpool.GET-demo/5.allowMaximumSizeToDivergeFromCoreSize: false
      hystrix.threadpool.PUT-demo/7.coreSize: 10
      hystrix.threadpool.PUT-demo/7.maximumSize: 10
      hystrix.threadpool.PUT-demo/7.allowMaximumSizeToDivergeFromCoreSize: false

```

## Configurations
* Resource Proxy Bundle 
```java
public class ResourceProxyBundleConfiguration {
	
	/**
	 * Format of the key ( http_method-resource_path )
	 * A map of keys to {@link in.adavi.pradyot.resourceproxy.core.ResourceProxyConfig}
	 */
	private Map<String,ResourceProxyConfig> resourceProxyConfigMap;
	
	/**
	 * Control flag to dis/enable Hystrix Circuit Breaker
	 */
	private boolean hystrixEnabled;
	
	/**
	 * Hystrix Circuit Breaker properties for the resources being proxied.
	 */
	private ResProxyHystrixProperties resProxyHystrixProperties;
}
```

* ResourceProxyConfig 
```java
public class ResourceProxyConfig {
	
	/**
	 * Host of the proxy
	 */
	private String host;
	
	/**
	 * Port of the proxy
	 */
	private int port;
	
	/**
	 * Path of the proxy resource
	 */
	private String path;
	
	/**
	 * Control to dis/enable the proxy
	 */
	private boolean proxyEnabled;
	
	/**
	 * Connection timeout
	 */
	@Builder.Default
	private int connectTimeout = 1000;
	
	/**
	 * Read timeout
	 */
	@Builder.Default
	private int readTimeout = 1000;
}
```