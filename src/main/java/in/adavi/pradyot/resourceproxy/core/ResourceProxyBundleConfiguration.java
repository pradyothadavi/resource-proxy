package in.adavi.pradyot.resourceproxy.core;

import in.adavi.pradyot.resourceproxy.hystrix.ResProxyHystrixProperties;
import lombok.Data;

import java.util.Map;

/**
 * @author Pradyot H Adavi
 */
@Data
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
