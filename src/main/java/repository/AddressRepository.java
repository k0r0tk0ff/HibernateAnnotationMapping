package repository;

import entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by k0r0tk0ff on 4/15/2017.
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
