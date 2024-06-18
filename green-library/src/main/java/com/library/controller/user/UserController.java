package com.library.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.dto.user.UserDto;
import com.library.dto.user.UserInfoModificationDto;
import com.library.exception.DatabaseException;
import com.library.exception.SessionNotFoundException;
import com.library.service.user.UserService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/userFinding")
	public String userFinding() {
		return "user/userFinding";
	}

	@GetMapping("/userUseInformation")
	public String userUseInformation() {
		return "user/userUseInformation";
	}

	@GetMapping("/useInformationBoard")
	public String useInformationBoard() {
		return "user/useInformation/board";
	}

	@GetMapping("/userInquiryDetail")
	public String userInquiryDetail() {
		return "user/userInquiryDetail";
	}

	@GetMapping("/userInquiryCreate")
	public String userInquiryCreate() {
		return "user/userInquiryCreate";
	}

	@GetMapping("/userInfo")
	public String userInfo(Model model) {
		
		UserDto userDto = userService.getUserDetails();
		model.addAttribute("user", userDto);
		return "user/userInfo";
	}

	@GetMapping("/userInfoModification")
	public String userInfoModification(Model model) {
		UserDto userDto = userService.getUserDetails();
		model.addAttribute("user", userDto);
		return "user/userInfoModification";
	}

	@PostMapping("/userInfoModification")
	public String userInfoModificationPerform(

			@ModelAttribute("user") @Valid UserInfoModificationDto userInfoModificationDto,

			BindingResult result) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
	            System.out.println(error.getDefaultMessage());
	        }
			return "redirect:/userInfoModification?error=true";
		}

		boolean success = userService.update(userInfoModificationDto);

		if (success)
			return "redirect:/userInfo?success=true";
		else
			return "redirect:/userInfoModification?error=true";

	}
	

	@ExceptionHandler(SessionNotFoundException.class)
    public String handleSessionNotFound(SessionNotFoundException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:/userLogin?error=true";
    }
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", ex.getParameterName() + " parameter is missing");
        return "redirect:/missingServletRequestParam";
    }
	
	@GetMapping("/missingServletRequestParam")
	public String missingServletRequestParam() {
		return "user/missingServletRequestParam";
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
    public String EmptyResultDataAccess(EmptyResultDataAccessException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:/userLogin?error=true";
    }
	
	@ExceptionHandler(DatabaseException.class)
    public String DatabaseException(DatabaseException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:/userLogin?error=true";
    }
	
	

}
