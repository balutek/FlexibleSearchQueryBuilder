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
public class Join
{
   private Table table;

   protected On on;

   public Join(Table table)
   {
      this.table = table;
   }

   public Table getTable()
   {
      return table;
   }

   public void setOn(On on)
   {
      this.on = on;
   }

   public On getOn()
   {
      return on;
   }
}
