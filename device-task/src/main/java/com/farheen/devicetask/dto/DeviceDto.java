package com.farheen.devicetask.dto;

import java.util.Date;

public class DeviceDto {

        private String deviceId;

        private String deviceName;

        private String deviceStatus;

        private String deviceModel;

        private Date enrolledTime;

    public DeviceDto(String deviceId, String deviceName, String deviceStatus, String deviceModel, Date enrolledTime)
    {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceStatus = deviceStatus;
        this.deviceModel = deviceModel;
        this.enrolledTime = enrolledTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Date getEnrolledTime() {
        return enrolledTime;
    }

    public void setEnrolledTime(Date enrolledTime) {
        this.enrolledTime = enrolledTime;
    }
}
