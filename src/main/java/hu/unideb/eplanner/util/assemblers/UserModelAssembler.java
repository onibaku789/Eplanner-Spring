package hu.unideb.eplanner.util.assemblers;

import hu.unideb.eplanner.controller.UserController;
import hu.unideb.eplanner.model.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserModelAssembler extends SimpleIdentifiableRepresentationModelAssembler<User> {

    public UserModelAssembler() {
        super(UserController.class);
    }
}


