package in.adavi.pradyot.resourceproxy.core;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Response;

/**
 * @author Pradyot H Adavi
 */
public interface ResourceProxyService {
	
	Response proxyResource(ResourceProxyConfig resourceProxyConfig, ContainerRequestContext containerRequestContext,
	                       ResourceInfo resourceInfo);
}
