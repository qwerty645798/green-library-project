package com.library.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.dto.user.inquiry.UserBorrowDTO;
import com.library.dto.user.inquiry.UserCountDTO;
import com.library.dto.user.inquiry.UserInquiryDetailDTO;
import com.library.dto.user.inquiry.UserInterestDTO;
import com.library.dto.user.inquiry.UserRentHistoryDTO;
import com.library.dto.user.inquiry.UserReserveDTO;
import com.library.dto.user.profile.UserInfoDTO;
import com.library.dto.user.profile.UserInfoModificationDTO;
import com.library.service.user.InquiryService;
import com.library.service.user.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller("UserController")
@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	@Qualifier("UserService")
	private UserService userService;

	@Autowired
	@Qualifier("UserInquiryService")
	private InquiryService inquiryService;
	

	@GetMapping("/userInfo")
	public String userInfo(Model model, @RequestParam(name = "auth", defaultValue = "abc") String userId) {
		logger.info("Received auth: {}", userId);
		UserInfoDTO userDTO = userService.getUserInfo(userId);
		model.addAttribute("userInfo", userDTO);
		UserCountDTO userDTO2 = inquiryService.getUserCount(userId);
		model.addAttribute("count", userDTO2);
		return "user/userInfo";
	}
	
	@PostMapping("/userPassCheck")
	public String userPassCheckPerform(RedirectAttributes redirectAttributes, @RequestParam(name = "auth", defaultValue = "abc") String userId,
			@RequestParam(name = "user_pass", defaultValue = "error") String password, Model model) {
		if(password.equals("error")) 
			return "redirect:/user/userInfo";
		boolean check = userService.checkUserPass(userId, password);
		if(!check) {
			redirectAttributes.addFlashAttribute("message","비밀번호가 일치하지 않습니다.");
			return "redirect:/user/userInfo";
		}
			
		UserInfoDTO userDTO = userService.getUserInfo(userId);
		model.addAttribute("userInfo", userDTO);
		return "user/userInfoModification";
	}

	@PostMapping("/userInfoModification")
	public String userInfoModificationPerform(

			@ModelAttribute("userInfo") @Valid UserInfoModificationDTO userInfoModificationDTO, BindingResult result,
			@RequestParam(name = "auth", defaultValue = "abc") String userId, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("Validation error: {}", error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("message", "유효하지 않은 입력입니다.");
			return "redirect:/user/userInfo";
		}

		userService.update(userInfoModificationDTO, userId);
		return "redirect:/user/userInfo"; }
	 
	@PostMapping("/userDelete")
	public String userDelete(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam(name = "user_pass", defaultValue = "error") String password,
			RedirectAttributes redirectAttributes, HttpSession session) {
		if(password.equals("error")) 
			return "redirect:/user/userInfo";
		boolean check = userService.checkUserPass(userId, password);
		if(!check) {
			redirectAttributes.addFlashAttribute("message","비밀번호가 일치하지 않습니다.");
			return "redirect:/user/userInfo";
		}
		userService.deleteUser(userId);
		session.invalidate();
		redirectAttributes.addFlashAttribute("message", "userDelete");
		return "redirect:/";
	}

	@GetMapping("/userUseInformation")
	public String userUseInformation(@RequestParam(name = "auth", defaultValue = "abc") String userId, Model model) {
		UserCountDTO userDTO = inquiryService.getUserCount(userId);
		model.addAttribute("count", userDTO);
		return "user/userUseInformation";
	}

	@GetMapping("/useInformationBoard")
    public String useInformationBoard() {
        return "user/useInformation/board";
    }
	
	@GetMapping("/getUserData")
    @ResponseBody
    public Map<String, Object> getAllData(@RequestParam(name = "auth", defaultValue = "abc") String userId) {
        Map<String, Object> response = new HashMap<>();

        List<UserRentHistoryDTO> rentHistory = inquiryService.getUserRentHistory(userId);
        List<UserBorrowDTO> borrow = inquiryService.getUserBorrow(userId);
        List<UserReserveDTO> reserve = inquiryService.getUserReserve(userId);
		List<UserInterestDTO> interest = inquiryService.getUserInterest(userId);

        response.put("rentHistory", rentHistory);
        response.put("borrow", borrow);
        response.put("reserve", reserve);
		response.put("interest", interest);

        return response;
    }
	
	@PostMapping("/deleteRentHistory")
    @ResponseBody
    public Map<String, Object> deleteRentHistory(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam("id") String id) {

		inquiryService.deleteRentHistory(userId, id);

		
        List<UserRentHistoryDTO> updatedRentHistory = inquiryService.getUserRentHistory(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", updatedRentHistory);
        
        return response;
    }

    @PostMapping("/cancelReserve")
    @ResponseBody
    public Map<String, Object> cancelReserve(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam("id") String id) {
    	
    	inquiryService.cancelReserve(id);
    	
        List<UserReserveDTO> updatedReserve = inquiryService.getUserReserve(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", updatedReserve);
        
        return response;
    }
    
    @PostMapping("/insertInterest")
    public String insertInterest(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam("bookId") String bookId, RedirectAttributes redirectAttributes) {
    	
    	inquiryService.insertInterest(userId, bookId);
    	redirectAttributes.addFlashAttribute("message", "관심목록에 추가되었습니다.");
        return "redirect:/bookDetail?bookId=" + bookId;
    }
    
    @PostMapping("/deleteInterestEasy")
    public String deleteInterestEasy(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam("bookId") String bookId, RedirectAttributes redirectAttributes) {
    	
    	inquiryService.deleteInterest(userId, bookId);
    	redirectAttributes.addFlashAttribute("message", "관심목록에서 제거되었습니다.");
    	return "redirect:/bookDetail?bookId=" + bookId;
    }

    @PostMapping("/deleteInterest")
    @ResponseBody
    public Map<String, Object> deleteInterest(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam("id") String id) {
    	
    	inquiryService.deleteInterest(id);
    	
        List<UserInterestDTO> updatedInterest = inquiryService.getUserInterest(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", updatedInterest);
        
        return response;
    }
    
    @GetMapping("/userInquiryDetail")
	public String userInquiryDetail(@RequestParam(name = "auth", defaultValue = "abc") String userId, @RequestParam(name = "inquiryId", defaultValue = "error") String id, Model model) {
    	if(id.equals("error"))
    		return "redirect:/user/myWritten";
    	UserInquiryDetailDTO userDTO = inquiryService.getInquiryDetail(userId, id);
    	model.addAttribute("inquiryDetail", userDTO);
    	return "user/userInquiryDetail";
	}
}
