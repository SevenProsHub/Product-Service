package com.example.productservice.configs;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//		if (authentication == null || !authentication.isAuthenticated()) {
//			return null;
//		}
//
//		return Optional.of(getToken().getEmail());

		return Optional.of("Temp User");
	}

//	public Principal getPrincipal() {
//		return (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//	}
//
//	public AccessToken getToken() {
//		KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) getPrincipal();
//		return principal.getKeycloakSecurityContext().getToken();
//	}

}
