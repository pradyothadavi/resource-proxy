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
	 * A map of keys in the format ( http_method-resource_path )
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
