package hu.progmatic.budget_application.service;

import hu.progmatic.budget_application.model.Expense;
import hu.progmatic.budget_application.model.User;
import hu.progmatic.budget_application.repository.ExpenseRepo;
import hu.progmatic.budget_application.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    private UserRepo userRepo;
    private ExpenseRepo expenseRepo;

    public BudgetService(UserRepo userRepo, ExpenseRepo expenseRepo) {
        this.userRepo = userRepo;
        this.expenseRepo = expenseRepo;
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }
    public List<Expense> getAllExpenses(){
        return expenseRepo.findAll();
    }

    public User addUser(User user){
        return userRepo.save(user);
    }
}
