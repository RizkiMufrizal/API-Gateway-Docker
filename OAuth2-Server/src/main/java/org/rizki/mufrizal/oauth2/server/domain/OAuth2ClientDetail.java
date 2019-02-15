package org.rizki.mufrizal.oauth2.server.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 15 February 2019
 * @Time 10:36
 * @Project OAuth2-Server
 * @Package org.rizki.mufrizal.oauth2.server.domain
 * @File OAuth2ClientDetail
 */
@Entity
@Table(name = "oauth_client_details")
public class OAuth2ClientDetail implements Serializable {

    @Id
    @Getter
    @Setter
    @Column(name = "client_id", nullable = false)
    private String clientId;

    @Getter
    @Setter
    @Column(name = "resource_ids", nullable = false)
    private String resourceIds;

    @Getter
    @Setter
    @Column(name = "client_secret", nullable = false)
    private String clientSecret;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "scope", nullable = false)
    private Scope scope;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "authorized_grant_types", nullable = false)
    private AuthorizedGrantTypes authorizedGrantTypes;

    @Getter
    @Setter
    @Column(name = "web_server_redirect_uri", nullable = false)
    private String webServerRedirectUri;

    @Getter
    @Setter
    @Column(name = "authorities", nullable = false)
    private String Authorities;

    @Getter
    @Setter
    @Column(name = "access_token_validity", nullable = false)
    private Integer accessTokenValidity;

    @Getter
    @Setter
    @Column(name = "refresh_token_validity", nullable = false)
    private Integer refreshTokenValidity;

    @Getter
    @Setter
    @Lob
    @Column(name = "additional_information", nullable = false)
    private String additionalInformation;

    @Getter
    @Setter
    @Column(name = "autoapprove", nullable = false)
    private Boolean autoApprove;
}