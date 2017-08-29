package api.controller.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

//    private final Map<String, List<String>> userDb = new HashMap<>();
//
//    public LoginController() {
//        userDb.put("tom", Arrays.asList("user"));
//        userDb.put("sally", Arrays.asList("user", "admin"));
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public LoginResponse login(@RequestBody final UserLogin login)
//        throws ServletException {
////        if (login.name == null || !userDb.containsKey(login.name)) {
////            throw new ServletException("Invalid login");
////        }
//        return new LoginResponse(Jwts.builder().setSubject(login.name)
//            .claim("roles", userDb.get(login.name)).setIssuedAt(new Date())
//            .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
//    }
//
//    @SuppressWarnings("unused")
//    private static class UserLogin {
//        public String name;
//        public String password;
//    }
//
//    @SuppressWarnings("unused")
//    private static class LoginResponse {
//        public String token;
//
//        public LoginResponse(final String token) {
//            this.token = token;
//        }
//    }
}
