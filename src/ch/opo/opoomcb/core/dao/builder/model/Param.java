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
public class Param implements Renderable
{
   private String name;

   public Param(String name)
   {
      this.name = name;
   }

   public String getName()
   {
      return name;
   }

   @Override
   public void render(StringBuilder builder)
   {

   }
}
