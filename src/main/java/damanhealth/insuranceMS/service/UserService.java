package damanhealth.insuranceMS.service;

import damanhealth.insuranceMS.entity.Plan;
import damanhealth.insuranceMS.entity.User;
import damanhealth.insuranceMS.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);

}
