package com.farheen.devicetask.controller;

import com.farheen.devicetask.entity.Device;
import com.farheen.devicetask.exception.ResourceNotFoundException;
import com.farheen.devicetask.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    //get all devices
    @GetMapping
    public List<Device> getAllDevices(){
        return this.deviceRepository.findAll();
    }

    //get device by id
    @GetMapping("/{id}")
    public Device getDeviceById(@PathVariable(value = "id") String deviceId){
        return this.deviceRepository.findById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Device Not found with id " + deviceId));
    }

    // save/create device
    @PostMapping
    public Device createDevice(@RequestBody Device device)
    {
        return deviceRepository.save(device);
    }

    // update device
    @PutMapping("/{id}")
    public Device updateDevice(@RequestBody Device device, @PathVariable("id") String deviceId){
        Device existingDevice =  this.deviceRepository.findById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Device Not found with id " + deviceId));
        existingDevice.setDeviceId(deviceId);
        existingDevice.setDeviceName(device.getDeviceName());
        existingDevice.setDeviceModel(device.getDeviceModel());
        existingDevice.setDeviceStatus(device.getDeviceStatus());
        existingDevice.setEnrolledTime(device.getEnrolledTime());
        return this.deviceRepository.save(existingDevice);

    }

    // delete device by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Device> deleteDevice(@PathVariable("id") String deviceId){
        Device existingDevice =  this.deviceRepository.findById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Device Not found with id " + deviceId));
        this.deviceRepository.delete(existingDevice);
        return ResponseEntity.ok().build();
    }

    // delete all the devices in the database
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Device> deleteAllDevice(){
        this.deviceRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
