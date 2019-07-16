package in.adavi.pradyot.resourceproxy.hystrix;

import com.netflix.hystrix.HystrixCommandProperties;
import in.adavi.pradyot.resourceproxy.util.EnumHelper;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pradyot H Adavi
 */
public class ResProxyHystrixProperties {
	
	private static final String HYSTRIX_COMMAND = "hystrix.command.";
	private static final String HYSTRIX_THREADPOOL = "hystrix.threadpool.";
	
	private static final String EXECUTION_ISOLATION_STRATEGY = ".execution.isolation.strategy";
	private static final String EXECUTION_ISOLATION_THREAD_TIMEOUTINMILLISECONDS = ".execution.isolation.thread.timeoutInMilliseconds";
	private static final String EXECUTION_TIMEOUT_ENABLED = ".execution.timeout.enabled";
	private static final String EXECUTION_ISOLATION_SEMAPHORE_MAXCONCURRENTREQUESTS = ".execution.isolation.semaphore.maxConcurrentRequests";
	
	private static final String CIRCUITBREAKER_ENABLED = ".circuitBreaker.enabled";
	private static final String CIRCUITBREAKER_REQUEST_VOLUME_THRESHOLD = ".circuitBreaker.requestVolumeThreshold";
	private static final String CIRCUITBREAKER_SLEEP_WINDOW_INMILLISECONDS = ".circuitBreaker.sleepWindowInMilliseconds";
	private static final String CIRCUITBREAKER_ERROR_THRESHOLD_PERCENTAGE = ".circuitBreaker.errorThresholdPercentage";
	private static final String CIRCUITBREAKER_FORCEOPEN = ".circuitBreaker.forceOpen";
	private static final String CIRCUITBREAKER_FORCECLOSED = ".circuitBreaker.forceClosed";
	
	private static final String CORESIZE = ".coreSize";
	private static final String MAXIMUMSIZE = ".maximumSize";
	private static final String MAX_QUEUESIZE = ".maxQueueSize";
	private static final String QUEUE_SIZE_REJECTION_THRESHOLD = ".queueSizeRejectionThreshold";
	private static final String KEEP_ALIVE_TIMEMINUTES = ".keepAliveTimeMinutes";
	private static final String ALLOW_MAXIMUMSIZE_TO_DIVERGE_FROM_CORESIZE = ".allowMaximumSizeToDivergeFromCoreSize";
	
	private static final String HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_STRATEGY = "hystrix.command.default.execution.isolation.strategy";
	private static final String HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_THREAD_TIMEOUTINMILLISECONDS = "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds";
	private static final String HYSTRIX_COMMAND_DEFAULT_EXECUTION_TIMEOUT_ENABLED = "hystrix.command.default.execution.timeout.enabled";
	private static final String HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_SEMAPHORE_MAXCONCURRENTREQUESTS = "hystrix.command.default.execution.isolation.semaphore.maxConcurrentRequests";
	
	private static final String HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_ENABLED = "hystrix.command.default.circuitBreaker.enabled";
	private static final String HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_REQUESTVOLUMETHRESHOLD = "hystrix.command.default.circuitBreaker.requestVolumeThreshold";
	private static final String HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_SLEEPWINDOWINMILLISECONDS = "hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds";
	private static final String HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_ERRORTHRESHOLDPERCENTAGE = "hystrix.command.default.circuitBreaker.errorThresholdPercentage";
	private static final String HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_FORCEOPEN = "hystrix.command.default.circuitBreaker.forceOpen";
	private static final String HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_FORCECLOSED = "hystrix.command.default.circuitBreaker.forceClosed";
	
	private static final String HYSTRIX_THREADPOOL_DEFAULT_CORESIZE = "hystrix.threadpool.default.coreSize";
	private static final String HYSTRIX_THREADPOOL_DEFAULT_MAXIMUMSIZE = "hystrix.threadpool.default.maximumSize";
	private static final String HYSTRIX_THREADPOOL_DEFAULT_MAXQUEUESIZE = "hystrix.threadpool.default.maxQueueSize";
	private static final String HYSTRIX_THREADPOOL_DEFAULT_QUEUESIZEREJECTIONTHRESHOLD = "hystrix.threadpool.default.queueSizeRejectionThreshold";
	private static final String HYSTRIX_THREADPOOL_DEFAULT_KEEPALIVETIMEMINUTES = "hystrix.threadpool.default.keepAliveTimeMinutes";
	private static final String HYSTRIX_THREADPOOL_DEFAULT_ALLOW_MAXIMUMSIZE_TO_DIVERGE_FROM_CORESIZE = "hystrix.threadpool.default.allowMaximumSizeToDivergeFromCoreSize";
	
	private Map<String,String> commandExecutionProperties;
	
	private Map<String,String> commandCircuitBreakerProperties;
	
	private Map<String,String> threadPoolProperties;
	
	public Map<String, String> getCommandExecutionProperties() {
		return commandExecutionProperties;
	}
	
	public void setCommandExecutionProperties(Map<String, String> commandExecutionProperties) {
		this.commandExecutionProperties = commandExecutionProperties;
		if(null == this.commandExecutionProperties) {
			this.commandExecutionProperties = new HashMap<>();
		}
		if(!this.commandExecutionProperties.containsKey(HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_STRATEGY))
			this.commandExecutionProperties.put(HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_STRATEGY,"THREAD");
		if(!this.commandExecutionProperties.containsKey(HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_THREAD_TIMEOUTINMILLISECONDS))
			this.commandExecutionProperties.put(HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_THREAD_TIMEOUTINMILLISECONDS, "1000");
		if(!this.commandExecutionProperties.containsKey(HYSTRIX_COMMAND_DEFAULT_EXECUTION_TIMEOUT_ENABLED))
			this.commandExecutionProperties.put(HYSTRIX_COMMAND_DEFAULT_EXECUTION_TIMEOUT_ENABLED,"true");
		if(!this.commandExecutionProperties.containsKey(HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_SEMAPHORE_MAXCONCURRENTREQUESTS))
			this.commandExecutionProperties.put(HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_SEMAPHORE_MAXCONCURRENTREQUESTS,"10");
	}
	
	public Map<String, String> getCommandCircuitBreakerProperties() {
		return commandCircuitBreakerProperties;
	}
	
	public void setCommandCircuitBreakerProperties(Map<String, String> commandCircuitBreakerProperties) {
		this.commandCircuitBreakerProperties = commandCircuitBreakerProperties;
		if(null == this.commandCircuitBreakerProperties) {
			this.commandCircuitBreakerProperties = new HashMap<>();
		}
		if(!this.commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_ENABLED))
			this.commandCircuitBreakerProperties.put(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_ENABLED,"true");
		if(!this.commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_REQUESTVOLUMETHRESHOLD))
			this.commandCircuitBreakerProperties.put(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_REQUESTVOLUMETHRESHOLD,"20");
		if(!this.commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_SLEEPWINDOWINMILLISECONDS))
			this.commandCircuitBreakerProperties.put(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_SLEEPWINDOWINMILLISECONDS, "5000");
		if(!this.commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_ERRORTHRESHOLDPERCENTAGE))
			this.commandCircuitBreakerProperties.put(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_ERRORTHRESHOLDPERCENTAGE,"50");
		if(!this.commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_FORCEOPEN))
			this.commandCircuitBreakerProperties.put(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_FORCEOPEN,"false");
		if(!this.commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_FORCECLOSED))
			this.commandCircuitBreakerProperties.put(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_FORCECLOSED,"false");
	}
	
	public Map<String, String> getThreadPoolProperties() {
		return threadPoolProperties;
	}
	
	public void setThreadPoolProperties(Map<String, String> threadPoolProperties) {
		this.threadPoolProperties = threadPoolProperties;
		if(null == this.threadPoolProperties) {
			this.threadPoolProperties = new HashMap<>();
		}
		if(!this.threadPoolProperties.containsKey(HYSTRIX_THREADPOOL_DEFAULT_CORESIZE))
			this.threadPoolProperties.put(HYSTRIX_THREADPOOL_DEFAULT_CORESIZE,"10");
		if(!this.threadPoolProperties.containsKey(HYSTRIX_THREADPOOL_DEFAULT_MAXIMUMSIZE))
			this.threadPoolProperties.put(HYSTRIX_THREADPOOL_DEFAULT_MAXIMUMSIZE,"10");
		if(!this.threadPoolProperties.containsKey(HYSTRIX_THREADPOOL_DEFAULT_MAXQUEUESIZE))
			this.threadPoolProperties.put(HYSTRIX_THREADPOOL_DEFAULT_MAXQUEUESIZE,"-1");
		if(!this.threadPoolProperties.containsKey(HYSTRIX_THREADPOOL_DEFAULT_QUEUESIZEREJECTIONTHRESHOLD))
			this.threadPoolProperties.put(HYSTRIX_THREADPOOL_DEFAULT_QUEUESIZEREJECTIONTHRESHOLD,"5");
		if(!this.threadPoolProperties.containsKey(HYSTRIX_THREADPOOL_DEFAULT_KEEPALIVETIMEMINUTES))
			this.threadPoolProperties.put(HYSTRIX_THREADPOOL_DEFAULT_KEEPALIVETIMEMINUTES,"1");
		if(!this.threadPoolProperties.containsKey(HYSTRIX_THREADPOOL_DEFAULT_ALLOW_MAXIMUMSIZE_TO_DIVERGE_FROM_CORESIZE))
			this.threadPoolProperties.put(HYSTRIX_THREADPOOL_DEFAULT_ALLOW_MAXIMUMSIZE_TO_DIVERGE_FROM_CORESIZE,"false");
	}
	
	public HystrixCommandProperties.ExecutionIsolationStrategy getExecutionIsolationStrategy(String hystrixCommandKey){
		
		if(commandExecutionProperties.containsKey(HYSTRIX_COMMAND+hystrixCommandKey+EXECUTION_ISOLATION_STRATEGY)){
			String isolationStrategyValue =  commandExecutionProperties.get(HYSTRIX_COMMAND+hystrixCommandKey+EXECUTION_ISOLATION_STRATEGY);
			return EnumHelper.safeValueOf(HystrixCommandProperties.ExecutionIsolationStrategy.class, isolationStrategyValue,
					HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);
		}
		String isolationStrategyValue =  commandExecutionProperties.get(HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_STRATEGY);
		return EnumHelper.safeValueOf(HystrixCommandProperties.ExecutionIsolationStrategy.class, isolationStrategyValue,
				HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);
	}
	
	public int getExecutionTimeoutInMilliseconds(String hystrixCommandKey){
		
		if(commandExecutionProperties.containsKey(HYSTRIX_COMMAND+hystrixCommandKey+EXECUTION_ISOLATION_THREAD_TIMEOUTINMILLISECONDS)){
			return Integer.valueOf(commandExecutionProperties.get(HYSTRIX_COMMAND+hystrixCommandKey+EXECUTION_ISOLATION_THREAD_TIMEOUTINMILLISECONDS));
		}
		return Integer.valueOf(commandExecutionProperties.get
				(HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_THREAD_TIMEOUTINMILLISECONDS));
	}
	
	public boolean isExecutionTimeoutEnabled(String hystrixCommandKey) {
		if(commandExecutionProperties.containsKey(HYSTRIX_COMMAND+hystrixCommandKey+EXECUTION_TIMEOUT_ENABLED)){
			return Boolean.valueOf(commandExecutionProperties.get(HYSTRIX_COMMAND+hystrixCommandKey+EXECUTION_TIMEOUT_ENABLED));
		}
		return Boolean.valueOf(commandExecutionProperties.get(HYSTRIX_COMMAND_DEFAULT_EXECUTION_TIMEOUT_ENABLED));
	}
	
	public int getExecutionIsolationSemaphoreMaxConcurrentRequests(String hystrixCommandKey) {
		if(commandExecutionProperties.containsKey(HYSTRIX_COMMAND+hystrixCommandKey+EXECUTION_ISOLATION_SEMAPHORE_MAXCONCURRENTREQUESTS)){
			return Integer.valueOf(commandExecutionProperties.get(HYSTRIX_COMMAND+hystrixCommandKey+EXECUTION_ISOLATION_SEMAPHORE_MAXCONCURRENTREQUESTS));
		}
		return Integer.valueOf(commandExecutionProperties.get(HYSTRIX_COMMAND_DEFAULT_EXECUTION_ISOLATION_SEMAPHORE_MAXCONCURRENTREQUESTS));
	}
	
	
	public boolean isCircuitBreakerEnabled(String hystrixCommandKey) {
		if(commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_ENABLED)){
			return Boolean.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_ENABLED));
		}
		return Boolean.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_ENABLED));
	}
	
	public int getCircuitBreakerRequestVolumeThreshold(String hystrixCommandKey) {
		if(commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_REQUEST_VOLUME_THRESHOLD)){
			return Integer.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_REQUEST_VOLUME_THRESHOLD));
		}
		return Integer.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_REQUESTVOLUMETHRESHOLD));
	}
	
	public int getCircuitBreakerSleepWindowInMilliseconds(String hystrixCommandKey) {
		if(commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_SLEEP_WINDOW_INMILLISECONDS)){
			return Integer.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_SLEEP_WINDOW_INMILLISECONDS));
		}
		return Integer.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_SLEEPWINDOWINMILLISECONDS));
	}
	
	public int getCircuitBreakerErrorThresholdPercentage(String hystrixCommandKey) {
		if(commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_ERROR_THRESHOLD_PERCENTAGE)){
			return Integer.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_ERROR_THRESHOLD_PERCENTAGE));
		}
		return Integer.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_ERRORTHRESHOLDPERCENTAGE));
	}
	
	public boolean isCircuitBreakerForceOpen(String hystrixCommandKey) {
		if(commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_FORCEOPEN)){
			return Boolean.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_FORCEOPEN));
		}
		return Boolean.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_FORCEOPEN));
	}
	
	public boolean isCircuitBreakerForceClosed(String hystrixCommandKey) {
		if(commandCircuitBreakerProperties.containsKey(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_FORCECLOSED)){
			return Boolean.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND+hystrixCommandKey+CIRCUITBREAKER_FORCECLOSED));
		}
		return Boolean.valueOf(commandCircuitBreakerProperties.get(HYSTRIX_COMMAND_DEFAULT_CIRCUITBREAKER_FORCECLOSED));
	}
	
	public int getCoreSize(String threadPoolKey) {
		if(threadPoolProperties.containsKey(HYSTRIX_THREADPOOL+threadPoolKey+CORESIZE)){
			return Integer.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL+threadPoolKey+CORESIZE));
		}
		return Integer.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL_DEFAULT_CORESIZE));
	}
	
	public int getMaximumSize(String threadPoolKey) {
		if(threadPoolProperties.containsKey(HYSTRIX_THREADPOOL+threadPoolKey+MAXIMUMSIZE)){
			return Integer.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL+threadPoolKey+MAXIMUMSIZE));
		}
		return Integer.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL_DEFAULT_MAXIMUMSIZE));
	}
	
	public int getMaxQueueSize(String threadPoolKey) {
		if(threadPoolProperties.containsKey(HYSTRIX_THREADPOOL+threadPoolKey+MAX_QUEUESIZE)){
			return Integer.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL+threadPoolKey+MAX_QUEUESIZE));
		}
		return Integer.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL_DEFAULT_MAXQUEUESIZE));
	}
	
	public int getQueueSizeRejectionThreshold(String threadPoolKey) {
		if(threadPoolProperties.containsKey(HYSTRIX_THREADPOOL+threadPoolKey+QUEUE_SIZE_REJECTION_THRESHOLD)){
			return Integer.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL+threadPoolKey+QUEUE_SIZE_REJECTION_THRESHOLD));
		}
		return Integer.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL_DEFAULT_QUEUESIZEREJECTIONTHRESHOLD));
	}
	
	public int getKeepAliveTimeMinutes(String threadPoolKey) {
		if(threadPoolProperties.containsKey(HYSTRIX_THREADPOOL+threadPoolKey+KEEP_ALIVE_TIMEMINUTES)){
			return Integer.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL+threadPoolKey+KEEP_ALIVE_TIMEMINUTES));
		}
		return Integer.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL_DEFAULT_KEEPALIVETIMEMINUTES));
	}
	
	public boolean isAllowMaximumSizeToDivergeFromCoreSize(String threadPoolKey) {
		if(threadPoolProperties.containsKey(HYSTRIX_THREADPOOL+threadPoolKey+ALLOW_MAXIMUMSIZE_TO_DIVERGE_FROM_CORESIZE)){
			return Boolean.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL+threadPoolKey+ALLOW_MAXIMUMSIZE_TO_DIVERGE_FROM_CORESIZE));
		}
		return Boolean.valueOf(threadPoolProperties.get(HYSTRIX_THREADPOOL_DEFAULT_ALLOW_MAXIMUMSIZE_TO_DIVERGE_FROM_CORESIZE));
	}
	
	@Override
	public String toString() {
		return "ResProxyHystrixProperties{" +
				"commandExecutionProperties=" + commandExecutionProperties +
				", commandCircuitBreakerProperties=" + commandCircuitBreakerProperties +
				", threadPoolProperties=" + threadPoolProperties +
				'}';
	}
}
