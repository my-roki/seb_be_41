package com.codestates.backup.service;

import com.codestates.backup.entity.BackupMember;
import com.codestates.backup.repository.BackupMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BackupMemberService {
    private final BackupMemberRepository backupMemberRepository;

    public BackupMemberService(BackupMemberRepository backupMemberRepository) {
        this.backupMemberRepository = backupMemberRepository;
    }

    public void createBackupMember(BackupMember backupMember) {
        backupMemberRepository.save(backupMember);

        // 회원 정보 저장중 예외 발생
        // (조건문 안에 true, false 로 각각 설정했을 때 db에 저장되는 결과가 어떻게 되는지 확인해보자)
        if (true) throw new RuntimeException("multi datasource rollback test");
    }
}