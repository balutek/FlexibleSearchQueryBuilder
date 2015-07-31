/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;
/**
 * @author Paweł Łabuda
 */
public class LeftJoin extends Join
{
   public LeftJoin(Table table)
   {
      super(table);
   }

   @Override
   public StringBuilder render(StringBuilder builder)
   {
      builder.append(LEFT);
      super.render(builder);
      return builder;
   }
}
