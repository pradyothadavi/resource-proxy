package in.adavi.pradyot.resourceproxy.core;

import lombok.Data;

/**
 * @author Pradyot H Adavi
 */
@Data
public class ResourceProxyConfig {
	
	private String host;
	
	private int port;
	
	private String path;
	
	private boolean proxyEnabled;
}
