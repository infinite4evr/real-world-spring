package com.realworld.controller;

import com.realworld.DTO.SalesChannelDTO;
import com.realworld.annotations.HandleInvalidBody.HandleInvalidBody;
import com.realworld.entity.SalesChannel;
import com.realworld.exception.GeneralException;
import com.realworld.service.SalesChannelService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/sales-channels")
public class SalesChannelController {

  private final SalesChannelService service;

  @Autowired
  public SalesChannelController(SalesChannelService service) {
    this.service = service;
  }

  @GetMapping("")
  public List<SalesChannel> listSalesChannel() {
    return service.getSalesChannelList();
  }

  @GetMapping("/{salesChannelId}")
  public ResponseEntity<Object> getSalesChannel(@PathVariable @Positive Long channelId) {
    return ResponseEntity.ok().body(service.getSalesChannel(channelId));
  }

  @PostMapping("")
  @HandleInvalidBody
  public ResponseEntity<Object> createSalesChannel(
      @Valid @RequestBody SalesChannelDTO salesChannelDTO) throws Exception {
    if (service.ifExistsByName(salesChannelDTO.getName())) {
      throw new GeneralException("Entity already exist", "The name already exist");
    }

    return ResponseEntity.ok(service.createSalesChannel(salesChannelDTO));
  }

  @PatchMapping("/{salesChannelId}")
  @HandleInvalidBody
  public ResponseEntity<Object> updateSalesChannel(
      @PathVariable @Positive Long salesChannelId, @RequestBody Map<String, Object> updates) {
    System.out.println(updates);
    return ResponseEntity.ok().body(service.updateSalesChannel(salesChannelId, updates));
  }

  @DeleteMapping("/{salesChannelId}")
  public ResponseEntity<Object> deleteProductTag(@PathVariable @Positive Long salesChannelId) {
    if (service.ifExistsOrError(salesChannelId)) {
      if (service.deleteSalesChannel(salesChannelId)) {
        return ResponseEntity.ok().body(null);
      }
    }

    throw new GeneralException();
  }
}
