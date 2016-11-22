package edu.mum.ea.crs.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class CrudInterceptor {
	private static Logger logger = LogManager.getLogger(CrudInterceptor.class);

	@Around("execution(* edu.mum.ea.crs.service..*.*(..))")
	public Object logQueryTimes(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object retVal = pjp.proceed();
		stopWatch.stop();
		String str = pjp.getTarget().toString();
		logger.info(str.substring(str.lastIndexOf(".") + 1, str.lastIndexOf("@")) + " - " + pjp.getSignature().getName()
				+ ": " + stopWatch.getTotalTimeMillis() + "ms");		
		return retVal;
	}
	
}
