package com.CentralLink.admin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CentralLink.admin.entity.Settings;
import com.CentralLink.admin.repository.SettingsRepository;

@Service
public class SettingsService {

	@Autowired
	private SettingsRepository settingsRepository;

	// Get Settings by ID
	public Optional<Settings> getSettings(Long id) {
		return settingsRepository.findById(id);
	}

	// Create new Settings (if not exists)
	public Settings createSettings(Settings settings) {
		// In case you have only one record, you could either return the same record if
		// it exists, or create a new one
		return settingsRepository.save(settings);
	}

	// Update Settings
	public Settings updateSettings(Long id, Settings settings) {
		if (!settingsRepository.existsById(id)) {
			throw new RuntimeException("Settings not found with ID: " + id);
		}
		settings.setId(id);
		return settingsRepository.save(settings);
	}

	// Delete Settings
	public void deleteSettings(Long id) {
		if (!settingsRepository.existsById(id)) {
			throw new RuntimeException("Settings not found with ID: " + id);
		}
		settingsRepository.deleteById(id);
	}
}
