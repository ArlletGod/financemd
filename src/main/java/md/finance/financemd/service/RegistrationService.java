package md.finance.financemd.service;

import md.finance.financemd.model.User;
import md.finance.financemd.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user){
        userRepository.save(user);
    }
}
