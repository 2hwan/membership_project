package kt.com.membership.repository;

import kt.com.membership.domain.Membership;
import kt.com.membership.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {
    Optional<Membership> findByUser(User user);
}
