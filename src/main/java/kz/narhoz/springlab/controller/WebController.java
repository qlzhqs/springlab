

package kz.narhoz.springlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebController {
@Autowired
Repository repository;
    @GetMapping("/")
    public String showUserList(@RequestParam(name="email", required=false, defaultValue="") String email,
                               @RequestParam(name="name", required=false, defaultValue="") String name,
                               @RequestParam(name="id", required=false, defaultValue="") Long id,
                               Model model) {
        List<User> users = repository.findAll();

        if(!email.isEmpty()){
        users = repository.findByEmailContainingOrderByNameDesc(email);
        }
        if(!name.isEmpty()){
            users = repository.findByNameStartsWith(name);
        }
        if(id != null){
            users = repository.findGreaterId(id);
        }
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/adduser")
    public String createUser(@ModelAttribute User user){
        addUser(user);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, User user) {
        updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = repository.getById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    private  void deleteById(long id) {
        repository.deleteById(id);

    }

    private void addUser(User newUser) {
      repository.save(newUser);
    }

    private  void updateUser(User updateUser) {

        User oldUser = repository.getById(updateUser.getId());


        oldUser.setName(updateUser.getName());
        oldUser.setSurname(updateUser.getSurname());

        repository.save(oldUser);
    }

}


