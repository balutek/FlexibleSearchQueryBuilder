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
public class RightJoin extends Join
{
   public RightJoin(Table table)
   {
      super(table);
   }

   @Override
   public StringBuilder render(StringBuilder builder)
   {
      super.render(builder);
      return builder;
   }
}
