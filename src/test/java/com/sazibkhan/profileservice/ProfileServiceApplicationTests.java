package com.sazibkhan.profileservice;

import com.sazibkhan.profileservice.dto.request.ProfileDTO;
import com.sazibkhan.profileservice.dto.response.ProfileRest;
import com.sazibkhan.profileservice.entity.ProfileEntity;
import com.sazibkhan.profileservice.repository.ProfileRepository;
import com.sazibkhan.profileservice.service.EntityValidationService;
import com.sazibkhan.profileservice.service.ProfileService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProfileServiceApplicationTests {
	@Mock
	private ProfileRepository repo;
	@Mock
	private EntityValidationService validationService;
	@InjectMocks
	private ProfileService service;

	@Test
	void contextLoads() {
	}

	@Test
	void testSaveProfile() {
		ProfileDTO dto = new ProfileDTO();
		dto.setName("Sazib");
		ProfileEntity entity = new ProfileEntity();
		Mockito.when(repo.saveAndFlush(Mockito.any())).thenReturn(entity);
		service.saveProfile(dto);
		Mockito.verify(repo).saveAndFlush(Mockito.any());
	}

	@Test
	void testGetProfileList() {
		ProfileEntity entity = new ProfileEntity();
		entity.setId(1L);
		entity.setName("Sazib");
		Mockito.when(repo.findAll()).thenReturn(List.of(entity));
		List<ProfileRest> list = service.getProfileList();
		assertEquals(1, list.size());
		assertEquals("Sazib", list.get(0).getName());
	}

	@Test
	void testGetProfileById() {
		ProfileEntity entity = new ProfileEntity();
		entity.setId(1L);
		entity.setName("Sazib");
		Mockito.when(validationService.validateProfile(1L)).thenReturn(entity);
		ProfileRest rest = service.getProfileById(1L);
		assertEquals("Sazib", rest.getName());
	}

	@Test
	void testUpdateProfile() {
		ProfileEntity entity = new ProfileEntity();
		entity.setId(1L);
		Mockito.when(validationService.validateProfile(1L)).thenReturn(entity);
		ProfileDTO dto = new ProfileDTO();
		dto.setName("Updated");
		service.updateProfile(1L, dto);
		assertEquals("Updated", entity.getName());
	}

	@Test
	void testDeleteProfile() {
		ProfileEntity entity = new ProfileEntity();
		entity.setId(1L);
		Mockito.when(validationService.validateProfile(1L)).thenReturn(entity);
		service.deleteProfile(1L);
		Mockito.verify(repo).deleteById(1L);
	}

}
