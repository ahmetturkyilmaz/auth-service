package com.fitness.authservice.util;

import com.fitness.authservice.exception.ExceptionMessages;
import com.fitness.authservice.exception.RequestValidationException;
import com.fitness.authservice.model.User;
import com.fitness.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.Optional;

@Component
public class UserValidator {

    @Autowired
    UserRepository userRepository;

    public void validateUser(User user) throws RequestValidationException {
        InternetAddress emailAddr = null;

        checkIfPasswordProper(user.getPassword());
        user.setPassword(StringUtils.trimAllWhitespace(user.getPassword()));
        user.setEmail(StringUtils.trimAllWhitespace(user.getEmail()));
        checkIfEmailExist(user.getEmail());
        try {
            emailAddr = new InternetAddress(user.getEmail());
            emailAddr.validate();
        } catch (AddressException e) {
            throw new RequestValidationException(ExceptionMessages.EMAIL_ADDRESS_NOT_VALID, ExceptionMessages.EMAIL_ADDRESS_NOT_VALID_CODE);
        }

    }

    private void checkIfEmailExist(String email) throws RequestValidationException {
        if (StringUtils.isEmpty(email)) {
            throw new RequestValidationException(ExceptionMessages.EMAIL_ADDRESS_MANDATORY, ExceptionMessages.EMAIL_ADDRESS_NOT_VALID_CODE);
        }

        if (!StringUtils.isEmpty(email)) {
            Optional<User> user = userRepository.findByEmail(email);
            if (user.isPresent()) {
                throw new RequestValidationException(ExceptionMessages.EMAIL_ALREADY_EXIST, ExceptionMessages.EMAIL_ALREADY_EXIST_CODE);
            }
        }
    }

    private void checkIfPasswordProper(String password) throws RequestValidationException {
        if (StringUtils.isEmpty(password)) {
            throw new RequestValidationException(ExceptionMessages.PASSWORD_IS_MANDATORY, ExceptionMessages.PASSWORD_IS_MANDATORY_CODE);
        }
        String regex = "(?=.*[0-9]{2})(?=.*[a-z]).{8,32}";
        if (!password.matches(regex)) {
            throw new RequestValidationException(ExceptionMessages.PASSWORD_IS_NOT_MATCHED, ExceptionMessages.PASSWORD_IS_NOT_MATCHED_CODE);
        }

    }
}
