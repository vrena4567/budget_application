package hu.progmatic.budget_application.controller;

import hu.progmatic.budget_application.model.Expense;
import hu.progmatic.budget_application.model.User;
import hu.progmatic.budget_application.service.BudgetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BudgetController {
    private BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/registration")
    public String getRegPage() {
        return "reg";
    }
    @GetMapping("users")
    public String getAllUser(Model model){
        model.addAttribute("users", budgetService.getAllUser());
        model.addAttribute("expenses", budgetService.getAllExpenses());
        return "users";
    }
    @PostMapping("/regist")
    public String register(User user, Expense expense) {
        budgetService.addUser(user);
        user.addExpense(expense);
        return "redirect:/home";
    }

}
