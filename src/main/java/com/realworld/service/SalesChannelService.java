package com.realworld.service;

import com.realworld.DTO.SalesChannelDTO;
import com.realworld.entity.SalesChannel;
import com.realworld.exception.EntityNotFoundException;
import com.realworld.repository.SalesChannelRepository;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class SalesChannelService {
  private final SalesChannelRepository repository;

  @Autowired
  public SalesChannelService(SalesChannelRepository repository) {
    this.repository = repository;
  }

  public List<SalesChannel> getSalesChannelList() {
    return repository.findAll();
  }

  public SalesChannel getSalesChannel(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Sales Channel ", id));
  }

  public SalesChannel createSalesChannel(SalesChannelDTO salesChannelDTO) {
    var salesChannel =
        SalesChannel.builder()
            .name(salesChannelDTO.getName())
            .isDisabled(salesChannelDTO.isDisabled())
            .description(salesChannelDTO.getDescription())
            .build();
    return repository.save(salesChannel);
  }

  public boolean ifExists(Long id) {
    return repository.existsById(id);
  }

  public boolean ifExistsByName(String value) {
    return repository.existsSalesChannelByName(value);
  }

  public boolean ifExistsOrError(Long id) {
    if (repository.existsById(id)) {
      return true;
    }

    throw new EntityNotFoundException("Sales Channel", id);
  }

  public boolean deleteSalesChannel(Long id) {
    repository.deleteById(id);
    return !repository.existsById(id);
  }

  public SalesChannel updateSalesChannel(Long id, Map<String, Object> updates) {

    SalesChannel salesChannel =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Sales Channel not found", id));

    System.out.println(salesChannel);
    //noinspection DuplicatedCode
    updates.forEach(
        (key, value) -> {
          Field field = ReflectionUtils.findField(SalesChannel.class, key);
          if (field != null) {
            field.setAccessible(true);
            ReflectionUtils.setField(field, salesChannel, value);
          }
        });

    System.out.println(salesChannel.getName());

    return repository.save(salesChannel);
  }
}
