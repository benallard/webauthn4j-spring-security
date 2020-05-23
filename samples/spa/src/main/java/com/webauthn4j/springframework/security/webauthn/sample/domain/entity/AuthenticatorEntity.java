/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.springframework.security.webauthn.sample.domain.entity;

import com.webauthn4j.authenticator.Authenticator;
import com.webauthn4j.data.AuthenticatorTransport;
import com.webauthn4j.data.attestation.authenticator.AttestedCredentialData;
import com.webauthn4j.data.attestation.statement.AttestationStatement;
import com.webauthn4j.data.extension.authenticator.RegistrationExtensionAuthenticatorOutput;
import com.webauthn4j.data.extension.client.RegistrationExtensionClientOutput;
import com.webauthn4j.springframework.security.webauthn.sample.infrastructure.util.jpa.converter.AttestationStatementConverter;
import com.webauthn4j.springframework.security.webauthn.sample.infrastructure.util.jpa.converter.AuthenticatorExtensionsConverter;
import com.webauthn4j.springframework.security.webauthn.sample.infrastructure.util.jpa.converter.AuthenticatorTransportConverter;
import com.webauthn4j.springframework.security.webauthn.sample.infrastructure.util.jpa.converter.ClientExtensionsConverter;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

/**
 * Authenticator model
 */
@Entity
@Table(name = "m_authenticator")
public class AuthenticatorEntity implements Authenticator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    private UserEntity user;

    private long counter;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "m_transport", joinColumns = @JoinColumn(name = "authenticator_id"))
    @Column(name = "transport")
    @Convert(converter = AuthenticatorTransportConverter.class)
    private Set<AuthenticatorTransport> transports;

    @Embedded
    private AttestedCredentialData attestedCredentialData;

    @Lob
    @Convert(converter = AttestationStatementConverter.class)
    private AttestationStatement attestationStatement;

    @Lob
    @Convert(converter = ClientExtensionsConverter.class)
    private Map<String, RegistrationExtensionClientOutput<?>> clientExtensions;

    @Lob
    @Convert(converter = AuthenticatorExtensionsConverter.class)
    private Map<String, RegistrationExtensionAuthenticatorOutput<?>> authenticatorExtensions;

    public String getFormat() {
        return attestationStatement.getFormat();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    @Override
    public Set<AuthenticatorTransport> getTransports() {
        return transports;
    }

    public void setTransports(Set<AuthenticatorTransport> transports){
        this.transports = transports;
    }

    public AttestedCredentialData getAttestedCredentialData() {
        return attestedCredentialData;
    }

    public void setAttestedCredentialData(AttestedCredentialData attestedCredentialData) {
        this.attestedCredentialData = attestedCredentialData;
    }

    public AttestationStatement getAttestationStatement() {
        return attestationStatement;
    }

    public void setAttestationStatement(AttestationStatement attestationStatement) {
        this.attestationStatement = attestationStatement;
    }


    @Override
    public Map<String, RegistrationExtensionClientOutput<?>> getClientExtensions() {
        return clientExtensions;
    }

    public void setClientExtensions(Map<String, RegistrationExtensionClientOutput<?>> clientExtensions) {
        this.clientExtensions = clientExtensions;
    }

    @Override
    public Map<String, RegistrationExtensionAuthenticatorOutput<?>> getAuthenticatorExtensions() {
        return authenticatorExtensions;
    }

    public void setAuthenticatorExtensions(Map<String, RegistrationExtensionAuthenticatorOutput<?>> authenticatorExtensions) {
        this.authenticatorExtensions = authenticatorExtensions;
    }
}
