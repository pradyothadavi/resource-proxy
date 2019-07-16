package in.adavi.pradyot.resourceproxy.hystrix;

import in.adavi.pradyot.resourceproxy.core.ResourceProxyConfig;
import in.adavi.pradyot.resourceproxy.core.ResourceProxyService;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Response;

/**
 * @author Pradyot H Adavi
 */
public class ResourceProxyRequestCommand extends ResProxyHystrixAbstractCommand<Response> {
	
	private final ResourceProxyService resourceProxyService;
	private final ResourceProxyConfig resourceProxyConfig;
	private final ContainerRequestContext containerRequestContext;
	private final ResourceInfo resourceInfo;
	
	public ResourceProxyRequestCommand(String commandGroupKeyName, String commandKeyName, String threadPoolKeyName, ResProxyHystrixProperties resProxyHystrixProperties, ResourceProxyService resourceProxyService, ResourceProxyConfig resourceProxyConfig, ContainerRequestContext containerRequestContext, ResourceInfo resourceInfo) {
		super(commandGroupKeyName, commandKeyName, threadPoolKeyName, resProxyHystrixProperties);
		this.resourceProxyService = resourceProxyService;
		this.resourceProxyConfig = resourceProxyConfig;
		this.containerRequestContext = containerRequestContext;
		this.resourceInfo = resourceInfo;
	}
	
	/**
	 * Implement this method with code to be executed when {@link #execute()} or {@link #queue()} are invoked.
	 *
	 * @return R response type
	 * @throws Exception if command execution fails
	 */
	@Override
	protected Response run() throws Exception {
		return resourceProxyService.proxyResource(resourceProxyConfig,containerRequestContext,resourceInfo);
	}
}
