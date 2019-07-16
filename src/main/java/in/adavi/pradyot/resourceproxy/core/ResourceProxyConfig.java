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
	
	private String host;
	
	private int port;
	
	private String path;
	
	private boolean proxyEnabled;
	
	@Builder.Default
	private int connectTimeout = 1000;

	@Builder.Default
	private int readTimeout = 1000;
}
