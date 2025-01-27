package com.CentralLink.admin.controller.master;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CentralLink.admin.entity.Settings;
import com.CentralLink.admin.service.SettingsService;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

	@Autowired
	private SettingsService settingsService;

	// Get the current Settings by ID
	@GetMapping("/{id}")
	public ResponseEntity<Settings> getSettingsById(@PathVariable Long id) {
		Optional<Settings> settings = settingsService.getSettings(id);
		return settings.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Create new Settings (or update if already exists)
	@PostMapping
	public ResponseEntity<Settings> createSettings(@RequestBody @Valid Settings settings) {
		// Check if a settings record already exists
		Optional<Settings> existingSettings = settingsService.getSettings(1L); // assuming we only have one settings
																				// entry

		if (existingSettings.isPresent()) {
			return ResponseEntity.badRequest().body(null); // or you can update the existing settings record
		}

		Settings createdSettings = settingsService.createSettings(settings);
		return ResponseEntity.ok(createdSettings);
	}

	// Update Settings
	@PutMapping("/{id}")
	public ResponseEntity<Settings> updateSettings(@PathVariable Long id, @RequestBody @Valid Settings settings) {
		Settings updatedSettings = settingsService.updateSettings(id, settings);
		return ResponseEntity.ok(updatedSettings);
	}

	// Delete Settings
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSettings(@PathVariable Long id) {
		settingsService.deleteSettings(id);
		return ResponseEntity.noContent().build();
	}
}
