package cinema.controller;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectController {
    private final UserService userService;
    private final RoleService roleService;

    public InjectController(UserService userService,
                            RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/inject")
    public String injectData() {
        Role adminRole = new Role();
        adminRole.setRoleType(Role.RoleType.ADMIN);
        roleService.add(adminRole);

        Role userRole = new Role();
        userRole.setRoleType(Role.RoleType.USER);
        roleService.add(userRole);

        User adminUser = new User();
        adminUser.setEmail("bob@gmail.com");
        adminUser.setPassword("1234");
        adminUser.setRoles(Set.of(roleService.getRoleByName(String.valueOf(Role.RoleType.ADMIN))));
        userService.add(adminUser);

        User user = new User();
        user.setEmail("alice@gmail.com");
        user.setPassword("1234");
        user.setRoles(Set.of(roleService.getRoleByName(String.valueOf(Role.RoleType.USER))));
        userService.add(user);

        return "Injecting done.";
    }
}
