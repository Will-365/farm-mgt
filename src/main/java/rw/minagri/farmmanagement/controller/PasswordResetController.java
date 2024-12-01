package rw.minagri.farmmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rw.minagri.farmmanagement.dto.PasswordReset;
import rw.minagri.farmmanagement.model.User;
import rw.minagri.farmmanagement.service.UserService;

@RestController
public class PasswordResetController {

    @Autowired
    private UserService userService;

    // Forgot Password Form
//    @GetMapping("/forgot-password")
//    public String showForgotPasswordForm() {
//        return "forgot-password"; // Forgot password form page
//    }

    // Handle Forgot Password Request
    @PostMapping("/forgot-password")
    public String handleForgotPassword(@RequestBody User userObj) {
        // Check if the user exists
        if (!userService.doesEmailExist(userObj.getEmail())) {
            return "Email address not found."; // Redirect back to forgot password page
        }

        // Delete existing token if it exists
        userService.deleteExistingResetTokenByEmail(userObj.getEmail());

        // Generate password reset token and send email
        boolean emailSent = userService.sendPasswordResetEmail(userObj.getEmail());

        if (emailSent) {
            return  "A reset link has been sent to your email.";
        } else {
            return  "Failed to send email. Please try again.";
        }

    }

    // Password Reset Page
//    @GetMapping("/reset-password")
//    public String showResetPasswordForm(@RequestBody ResetToken tokenObj) {
//        boolean isValidToken = userService.validatePasswordResetToken(tokenObj.getToken());
//
//        if (!isValidToken) {
//            return "Invalid or expired password reset token.";
//        }
//
//
//        return tokenObj.getToken(); // Password reset form page
//    }

    @PostMapping("/reset-password")
    public String handlePasswordReset(@RequestBody PasswordReset tokens) {
        System.out.println("Received token for validation: " + tokens); // Log the token value
//return tokens.getToken();
        // Check if newPassword matches confirmNewPassword
        if (!tokens.getNewPassword().equals(tokens.getConfirmNewPassword())) {
            return "Passwords do not match. Please try again."; // Show reset password page again with error
        }

        boolean isResetSuccessful = userService.resetUserPassword(tokens.getToken(), tokens.getNewPassword());

        if (isResetSuccessful) {
            return "Your password has been successfully reset. You can now log in.";
        } else {
            return "Failed to reset password. Please try again.";

        }
    }


}