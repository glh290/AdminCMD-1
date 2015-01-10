package com.admincmd.world;

public class Location {
    
    private double x;
    private double y;
    private double z;
    private double yaw;
    private double pitch;
    
    public Location(double x, double y, double z) {
        this(x, y, z, 0, 0);
    }

    public Location(double x, double y, double z, double yaw, double pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

}
