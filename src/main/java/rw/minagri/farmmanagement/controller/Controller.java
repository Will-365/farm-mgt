//package rw.minagri.farmmanagement.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import rw.minagri.farmmanagement.model.User;
//import rw.minagri.farmmanagement.service.UserService;
//
//@org.springframework.stereotype.Controller
//public class Controller {
//    @Autowired
//    private UserService userService;
//    @GetMapping("/register")
//    public String showRegForm(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//
//    }
//    @PostMapping("/register") // Handle POST requests for /register
//    public String registerUser(@ModelAttribute("user") User user, Model model) {
//        // Check if the username already exists
//        if (userService.findByUsername(user.getUsername()) == null) {
//            userService.save(user); // Save the new user to the database
//            model.addAttribute("message", "Registration Successful"); // Add a success message to the model
//            return "redirect:/login"; // Redirect to the login page
//        } else {
//            model.addAttribute("error", "Username Already exists"); // Add an error message to the model
//            return "register"; // Return to the registration form if username exists
//        }
//    }
//    @GetMapping("/login")
//    public String showLoginForm(Model model) {
//        model.addAttribute("user", new User());
//        return "login"; // Display the login form
//    }
//
//    @PostMapping("/login")
//    public String loginUser(@ModelAttribute("user") User user, Model model) {
//        if (userService.isValidUser(user.getUsername(), user.getPassword())) {
//            return "redirect:/home"; // Redirect to the home page after successful login
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login"; // Return to login page on failure
//        }
//    }
//
//    @GetMapping("/home")
//    public String showHomePage(Model model) {
//        model.addAttribute("message", "Welcome to the Homepage!");
//        return "home"; // This will map to home.html
//    }
//}
