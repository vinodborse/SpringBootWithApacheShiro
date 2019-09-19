package com.springbootshiro.vinu.topic.shiro.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.springbootshiro.vinu.topic.iservices.IUserService;
import com.springbootshiro.vinu.topic.models.UserAuthentication;

/**
 * The Shiro Realm which authenticates and authorizes users via the Datalayer
 * @version 1.0 Jun 10, 2016
 */
public class AuthorizingRealmImpl extends AuthorizingRealm {

  @Autowired
  private IUserService userAuthenticationService;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    return null;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    UsernamePasswordToken upat = (UsernamePasswordToken) token;
    UserAuthentication user = getUserAuthentication(upat.getUsername());
    if (null != user) {
      ByteSource salt = ByteSource.Util.bytes(user.getPasswordSalt());
      return new SimpleAuthenticationInfo(user, user.getPassword(), salt, getName());
    } else {
      //logger.info("Authentication for user {} failed.", upat.getUsername());
      throw new AuthenticationException("Invalid username/password combination!");
    }
  }

  private UserAuthentication getUserAuthentication(String username) {
	  UserAuthentication userAuthentication = userAuthenticationService.findByUsername(username);
	  return userAuthentication;
  }
}
