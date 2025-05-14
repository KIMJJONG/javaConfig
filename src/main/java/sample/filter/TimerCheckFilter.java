package sample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerCheckFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(TimerCheckFilter.class);
	
	public TimerCheckFilter() {
		logger.debug("TimerCheckFilter 실행");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		TimerChecker timer = new TimerChecker();
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestUri = httpRequest.getRequestURI();
		String referer = httpRequest.getHeader("REFERER");
		
		chain.doFilter(httpRequest, response);
		
		logger.debug("================================================");
		logger.debug("refererUrl: {}", referer);
		logger.debug("Request page: {}", requestUri);
		long endTime = timer.stop();
		logger.debug("endTime: {}", endTime);
		logger.debug("총 소요시간: {} 초", endTime/1000.0f);
		logger.debug("================================================");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
