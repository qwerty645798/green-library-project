package com.library.service.admin;

import com.library.dto.admin._normal.AdminDTO;
import com.library.repository.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AdminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // 모든 관리자 목록 조회
    @Override
    public List<AdminDTO> allAdminManage() {
        return adminRepository.allAdminManage();
    }

    public AdminDTO findAdminById(String adminId) {
        return adminRepository.getMyInfo(adminId);
    }
}