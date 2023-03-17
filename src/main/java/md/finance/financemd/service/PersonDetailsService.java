package md.finance.financemd.service;

import md.finance.financemd.model.Person;
import md.finance.financemd.repositories.PeopleRepository;
import md.finance.financemd.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByName(s);

if (!person.isPresent())
    throw new UsernameNotFoundException("User not found!");

    return new PersonDetails(person.get());
        }

}

