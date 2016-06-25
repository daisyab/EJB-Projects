/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ublab.timer;

import javax.ejb.Remote;

/**
 *
 * @author daisy
 */
@Remote
public interface TimerSessionBeanRemote {
  
    public void createTimer(long milliseconds);
    
}

