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

public class Table implements Renderable
{
   private String name;

   private String alias;

   public Table(String name)
   {
      this.name = name;
   }
   public Table(String name, String alias)
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

   @Override
   public StringBuilder render(StringBuilder builder)
   {

      return builder;
   }
}
