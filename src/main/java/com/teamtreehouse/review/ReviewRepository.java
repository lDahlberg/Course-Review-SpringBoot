package com.teamtreehouse.review;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by lDahlberg on 9/21/2016.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @reviewRepository.findOne(#id)?.reviewer?.username == authentication") //? makes methods behind it optional in case the return is null
    void delete(@Param("id")Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #review.reviewer?.username == authentication.name") //? makes methods behind it optional in case the return is null
    void delete(@Param("review") Review review);
}
