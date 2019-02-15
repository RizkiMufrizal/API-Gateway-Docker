package org.rizki.mufrizal.oauth2.server.repository;

import org.rizki.mufrizal.oauth2.server.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 15 February 2019
 * @Time 10:44
 * @Project OAuth2-Server
 * @Package org.rizki.mufrizal.oauth2.server.repository
 * @File UserRepository
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    @Query("select u from User u left join fetch u.userRoles pd where u.username = :username")
    User LoginUser(@Param("username") String username);

}
