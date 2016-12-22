//package com.edexsoft.postroad.portal.spring;
//
//import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
//
//@EnableGlobalMethodSecurity(securedEnabled = true)
////@EnableGlobalMethodSecurity(jsr250Enabled = true)
//public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration{
//
//	@Override
//    protected MethodSecurityExpressionHandler createExpressionHandler() {
//        // ... create and return custom MethodSecurityExpressionHandler ...
//        return expressionHander;
//    }
//	
//}


////public interface BankService {
////
////	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
////	public Account readAccount(Long id);
////
////	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
////	public Account[] findAccounts();
////
////	@Secured("ROLE_TELLER")
////	public Account post(Account account, double amount);
////}
////
////public interface BankService {
////
////	@PreAuthorize("isAnonymous()")
////	public Account readAccount(Long id);
////
////	@PreAuthorize("isAnonymous()")
////	public Account[] findAccounts();
////
////	@PreAuthorize("hasAuthority('ROLE_TELLER')")
////	public Account post(Account account, double amount);
////}


