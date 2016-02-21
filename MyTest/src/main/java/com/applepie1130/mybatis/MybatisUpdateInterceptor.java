package com.applepie1130.mybatis;

import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({ @Signature(type = StatementHandler.class, method = "update", args = { Statement.class }) })
public class MybatisUpdateInterceptor implements Interceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler handler = (StatementHandler)invocation.getTarget();

		// 쿼리
		String sql = handler.getBoundSql().getSql();

		// 쿼리실행시 맵핑되는 파라메터들
		String param = (handler.getParameterHandler().getParameterObject() != null ) ? handler.getParameterHandler().getParameterObject().toString() : "";

		logger.info("==============================");
		logger.info("Query : {}", sql);
		logger.info("Params : {}", param);
		logger.info("==============================");

		// DB에다 로그 insert
		// TODO ..

		return invocation.proceed();	// 쿼리 실행
	}


	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}
}