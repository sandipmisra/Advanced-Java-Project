package dev.controller;

import dev.domain.*;
import dev.service.*;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {


    private SellerService sellerService;

    private RentService rentService;

    private UserService userService;





    public UserController(UserService userService,SellerService sellerService,RentService rentService) {

        this.userService = userService;
        this.sellerService=sellerService;
        this.rentService=rentService;


    }

    @InitBinder
    public void intiBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/create")
    public String fourth(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping("/store")
    public String fifth(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            userService.create(user);
            return "confirm";
        }
    }


    // ... existing code ...

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(@ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpSession session) {
        System.out.println("Processing login request...");

        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());

            // Add validation errors to the model
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "login";
        }

        // Authenticate the user using the userService
        User authenticatedUser = userService.authenticate(user.getFullname(), user.getPassword());

        if (authenticatedUser != null) {
            // Set user information in the session or any other required actions
            // For example: session.setAttribute("authenticatedUser", authenticatedUser);
            session.setAttribute("authenticatedUser", authenticatedUser);

            return "redirect:/dashboard"; // Redirect to the dashboard page upon successful login
        } else {
            bindingResult.reject("login.error", "Invalid username or password");
            System.out.println("Authentication failed.");
            return "login";
        }
    }

    @RequestMapping("/dashboard")
    public String Dashboard(Model model,@ModelAttribute("user") User user, HttpSession session, BindingResult bindingResult) {
        // Check if the user is authenticated (assuming it is stored in the session during login)
        User authenticatedUser = (User) session.getAttribute("authenticatedUser");



        if (authenticatedUser != null) {
            // If authenticated, proceed to show the form
            session.setAttribute("authenticatedUser", authenticatedUser);
            model.addAttribute("Seller", new Seller());
            return "dashboard";
        } else {
            // If not authenticated, reject and redirect to login page
            bindingResult.reject("login.error", "Seller not authenticated");
            return "login"; // Redirect to login page if the seller is not authenticated
        }
    }



    // ... existing code ...


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Implement logout logic here
        // For simplicity, we'll invalidate the session and redirect to the home page

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    @GetMapping("/dashboard/edit")
    public String editUser(@Valid  Model model, HttpSession session, @ModelAttribute("user") User user, BindingResult bindingResult) {
        // Extract userId from the session (assuming it is stored in the session during login)
        User authenticatedUser = (User) session.getAttribute("authenticatedUser");

        if (authenticatedUser != null) {
            int userId = authenticatedUser.getId();
            User userFromDatabase = userService.getUserById(userId);
            model.addAttribute("user", userFromDatabase);
            return "editUser";
        } else {
            bindingResult.reject("login.error", "User not authenticated");
            return "login"; // Redirect to login page if the user is not authenticated
        }
    }


    @PostMapping("/updateUser/{userId}")
    public String updateUser(
            @PathVariable int userId,
            @Valid @ModelAttribute("user") User updatedUser,
            BindingResult bindingResult,

            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            return "redirect:/dashboard/edit";
        } else {
            // Set the value of quota based on the checkbox state


            updatedUser.setId(userId);
            userService.updateUser(updatedUser);

            // Add the message as a flash attribute
            redirectAttributes.addFlashAttribute("message", "Student INFO of ID " + userId + " has been updated.");

            return "editUser";
        }


    }

//    @GetMapping("/showForm")
//    public String showForm(Model model) {
//        model.addAttribute("Seller", new Seller());
//        return "addseller";
//    }
    @GetMapping("/dashboard/showForm")
    public String showForm(Model model,@ModelAttribute("user") User user, HttpSession session, BindingResult bindingResult) {
    // Check if the user is authenticated (assuming it is stored in the session during login)
    User authenticatedUser = (User) session.getAttribute("authenticatedUser");



    if (authenticatedUser != null) {
        // If authenticated, proceed to show the form
        session.setAttribute("authenticatedUser", authenticatedUser);
        model.addAttribute("Seller", new Seller());
        return "addseller";
    } else {
        // If not authenticated, reject and redirect to login page
        bindingResult.reject("login.error", "Seller not authenticated");
        return "login"; // Redirect to login page if the seller is not authenticated
    }
    }


    @PostMapping("/storeSeller")
    public String storeSeller(@ModelAttribute("Seller") Seller seller,Model model,BindingResult bindingResult,@ModelAttribute("user") User user,HttpSession session) {
        // Your logic here
        User authenticatedUser = (User) session.getAttribute("authenticatedUser");
        if (authenticatedUser != null) {
            // If authenticated, proceed to show the form
            session.setAttribute("authenticatedUser", authenticatedUser);
            if (bindingResult.hasErrors()) {
                return "addseller";
            } else {
                sellerService.create(seller);
                return "addseller";
            }
        } else {
            // If not authenticated, reject and redirect to login page
            bindingResult.reject("login.error", "Seller not authenticated");
            return "login"; // Redirect to login page if the seller is not authenticated
        }




    }


    @GetMapping("/dashboard/showForm2")
    public String showForm2(Model model,@ModelAttribute("user") User user, HttpSession session, BindingResult bindingResult) {
        // Check if the user is authenticated (assuming it is stored in the session during login)
        User authenticatedUser = (User) session.getAttribute("authenticatedUser");



        if (authenticatedUser != null) {
            // If authenticated, proceed to show the form
            session.setAttribute("authenticatedUser", authenticatedUser);
            model.addAttribute("Rent", new Rent());
            return "addrent";
        } else {
            // If not authenticated, reject and redirect to login page
            bindingResult.reject("login.error", "Seller not authenticated");
            return "login"; // Redirect to login page if the seller is not authenticated
        }
    }


    @PostMapping("/storeRent")
    public String storeSeller2(@ModelAttribute("Rent") Rent rent,Model model,BindingResult bindingResult,@ModelAttribute("user") User user,HttpSession session) {
        // Your logic here
        User authenticatedUser = (User) session.getAttribute("authenticatedUser");
        if (authenticatedUser != null) {
            // If authenticated, proceed to show the form
            session.setAttribute("authenticatedUser", authenticatedUser);
            if (bindingResult.hasErrors()) {
                return "addrent";
            } else {
                rentService.create(rent);
                return "addrent";
            }
        } else {
            // If not authenticated, reject and redirect to login page
            bindingResult.reject("login.error", "Seller not authenticated");
            return "login"; // Redirect to login page if the seller is not authenticated
        }




    }

    @RequestMapping("/dashboard/seller")
    public String listSeller(Model model,@ModelAttribute("user") User user, HttpSession session, BindingResult bindingResult) {
        User authenticatedUser = (User) session.getAttribute("authenticatedUser");



        if (authenticatedUser != null) {
            // If authenticated, proceed to show the form
            session.setAttribute("authenticatedUser", authenticatedUser);
            List<Seller> sellerList = sellerService.getAllSeller();
            model.addAttribute("sellers", sellerList);

            System.out.println("Number of users: " + sellerList.size());
            System.out.println(sellerList);

            return "sellerlist";
        } else {
            // If not authenticated, reject and redirect to login page
            bindingResult.reject("login.error", "Seller not authenticated");
            return "login"; // Redirect to login page if the seller is not authenticated
        }
    }

    @RequestMapping("/dashboard/rent")
    public String listRent(Model model,@ModelAttribute("user") User user, HttpSession session, BindingResult bindingResult) {
        User authenticatedUser = (User) session.getAttribute("authenticatedUser");



        if (authenticatedUser != null) {
            // If authenticated, proceed to show the form
            session.setAttribute("authenticatedUser", authenticatedUser);
            List<Rent> rentList = rentService.getAllRent();
            model.addAttribute("rents", rentList);

            System.out.println("Number of users: " + rentList.size());
            System.out.println(rentList);

            return "rentList";
        } else {
            // If not authenticated, reject and redirect to login page
            bindingResult.reject("login.error", "Seller not authenticated");
            return "login"; // Redirect to login page if the seller is not authenticated
        }
    }



}
