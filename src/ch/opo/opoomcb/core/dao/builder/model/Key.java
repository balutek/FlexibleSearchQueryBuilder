/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model;

/**
 * @author Paweł Łabuda
 */
public class Key implements Renderable
{
   private String key;

   public Key(String key)
   {
      this.key = key;
   }

   @Override
   public void render(StringBuilder builder)
   {
      builder.append(key);
   }
}
