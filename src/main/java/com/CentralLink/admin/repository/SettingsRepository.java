package com.CentralLink.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CentralLink.admin.entity.Settings;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long> {
}
