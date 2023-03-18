package md.finance.financemd.service;

import md.finance.financemd.model.User;
import md.finance.financemd.repositories.UserRepository;
import md.finance.financemd.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public PersonDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> person = userRepository.findByName(s);

if (!person.isPresent())
    throw new UsernameNotFoundException("User not found!");

    return new PersonDetails(person.get());
        }

}

