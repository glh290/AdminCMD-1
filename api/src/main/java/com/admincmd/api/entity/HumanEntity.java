package com.admincmd.api.entity;

public interface HumanEntity extends LivingEntity {
    
    public int getHunger();
    
    public void setHunger(int hunger);
    
    public float getSaturation();
    
    public void setSaturation(float saturation);

}
