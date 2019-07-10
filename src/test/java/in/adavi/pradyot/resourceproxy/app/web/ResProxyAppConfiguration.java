package in.adavi.pradyot.resourceproxy.app.web;

import in.adavi.pradyot.resourceproxy.core.ResourceProxyBundleConfiguration;
import io.dropwizard.Configuration;
import lombok.Data;

/**
 * @author Pradyot H Adavi
 */
@Data
public class ResProxyAppConfiguration extends Configuration {
	
	private ResourceProxyBundleConfiguration resourceProxyBundleConfiguration;
}
