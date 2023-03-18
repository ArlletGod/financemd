package md.finance.financemd.util;

import md.finance.financemd.model.User;
import md.finance.financemd.service.PersonDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final PersonDetailsService personDetailsService;

    public UserValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    User user = (User)target;
    try {
        personDetailsService.loadUserByUsername(user.getName());
    }catch(UsernameNotFoundException ignored){
        return;
    }
    errors.rejectValue("username","","User already is exist");
    }
}
