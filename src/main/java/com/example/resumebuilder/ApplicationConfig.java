package com.example.resumebuilder;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/resumebuilder",
        callerQuery = "SELECT USER_PASSWORD FROM USERS WHERE USER_USERNAME = ?",
        groupsQuery = "SELECT USER_GROUP FROM USERS WHERE USER_USERNAME = ?"
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                errorPage = "",
                useForwardToLogin = false
        )
)
@FacesConfig
@ApplicationScoped
public class ApplicationConfig {
}
