package com.farheen.devicetask.repository;

import com.farheen.devicetask.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {
}
