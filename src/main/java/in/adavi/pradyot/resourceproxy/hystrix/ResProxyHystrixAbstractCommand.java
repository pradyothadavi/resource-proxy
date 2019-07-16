package in.adavi.pradyot.resourceproxy.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
 * @author Pradyot H Adavi
 */
public abstract class ResProxyHystrixAbstractCommand<T> extends HystrixCommand<T> {
	
	public ResProxyHystrixAbstractCommand(String commandGroupKeyName, String commandKeyName, String threadPoolKeyName,
	                                    ResProxyHystrixProperties resProxyHystrixProperties){
		
		super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(commandGroupKeyName))
				.andCommandKey(HystrixCommandKey.Factory.asKey(commandKeyName))
				.andCommandPropertiesDefaults(
						HystrixCommandProperties.Setter()
								.withExecutionIsolationStrategy(resProxyHystrixProperties.getExecutionIsolationStrategy(commandKeyName))
								.withExecutionTimeoutInMilliseconds(resProxyHystrixProperties.getExecutionTimeoutInMilliseconds(commandKeyName))
								.withExecutionTimeoutEnabled(resProxyHystrixProperties.isExecutionTimeoutEnabled(commandKeyName))
								.withExecutionIsolationSemaphoreMaxConcurrentRequests(resProxyHystrixProperties.getExecutionIsolationSemaphoreMaxConcurrentRequests(commandKeyName))
								.withCircuitBreakerEnabled(resProxyHystrixProperties.isCircuitBreakerEnabled(commandKeyName))
								.withCircuitBreakerRequestVolumeThreshold(resProxyHystrixProperties.getCircuitBreakerRequestVolumeThreshold(commandKeyName))
								.withCircuitBreakerSleepWindowInMilliseconds(resProxyHystrixProperties.getCircuitBreakerSleepWindowInMilliseconds(commandKeyName))
								.withCircuitBreakerErrorThresholdPercentage(resProxyHystrixProperties.getCircuitBreakerErrorThresholdPercentage(commandKeyName))
								.withCircuitBreakerForceOpen(resProxyHystrixProperties.isCircuitBreakerForceOpen(commandKeyName))
								.withCircuitBreakerForceClosed(resProxyHystrixProperties.isCircuitBreakerForceClosed(commandKeyName))
				)
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(threadPoolKeyName))
				.andThreadPoolPropertiesDefaults(
						HystrixThreadPoolProperties.Setter()
								.withCoreSize(resProxyHystrixProperties.getCoreSize(threadPoolKeyName))
								.withMaximumSize(resProxyHystrixProperties.getMaximumSize(threadPoolKeyName))
								.withMaxQueueSize(resProxyHystrixProperties.getMaxQueueSize(threadPoolKeyName))
								.withQueueSizeRejectionThreshold(resProxyHystrixProperties.getQueueSizeRejectionThreshold(threadPoolKeyName))
								.withKeepAliveTimeMinutes(resProxyHystrixProperties.getKeepAliveTimeMinutes(threadPoolKeyName))
								.withAllowMaximumSizeToDivergeFromCoreSize(resProxyHystrixProperties.isAllowMaximumSizeToDivergeFromCoreSize(threadPoolKeyName))
				)
		);
		
	}
}
