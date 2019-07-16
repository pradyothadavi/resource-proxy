package in.adavi.pradyot.resourceproxy.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pradyot H Adavi
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
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
