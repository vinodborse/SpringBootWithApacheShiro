package com.springbootshiro.vinu.topic.shiro.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vinod Borse
 * 19-Sep-2019
 */
@Configuration
public class ShiroConfig {


    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }
    	
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("SHA-256");
		hashedCredentialsMatcher.setHashIterations(512);
		return hashedCredentialsMatcher;
	}

    @Bean
    public Realm realm() {
    	AuthorizingRealmImpl authorizingRealmImpl = new AuthorizingRealmImpl();
    	authorizingRealmImpl.setCredentialsMatcher(hashedCredentialsMatcher());
    	return authorizingRealmImpl;        	
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

        chainDefinition.addPathDefinition("/login", "anon");
        chainDefinition.addPathDefinition("/registerUser", "anon");
        chainDefinition.addPathDefinition("/**", "authc");
        return chainDefinition;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm());
        defaultWebSecurityManager.setCacheManager(memoryConstrainedCacheManager());
        defaultWebSecurityManager.setSessionManager(sessionManager());
        return securityManager();
    }

    @Bean
    public MemoryConstrainedCacheManager memoryConstrainedCacheManager(){
    	MemoryConstrainedCacheManager memoryConstrainedCacheManager = new MemoryConstrainedCacheManager();
    	return memoryConstrainedCacheManager;
    }
    
    @Bean
    DefaultWebSessionManager sessionManager(){
    	DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
    	sessionManager.setDeleteInvalidSessions(true);
    	sessionManager.setGlobalSessionTimeout(1800000);
    	return sessionManager;
    }
}
