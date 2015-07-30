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
public class Column
{
   private String name;

   private String alias;

   public Column(String name, String alias)
   {
      this.name = name;
      this.alias = alias;
   }

   public String getName()
   {
      return name;
   }

   public String getAlias()
   {
      return alias;
   }
}
