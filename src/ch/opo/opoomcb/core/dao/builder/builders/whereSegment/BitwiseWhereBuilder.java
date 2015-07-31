/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.builders.whereSegment;

import ch.opo.opoomcb.core.dao.builder.model.QueryModel;
import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.And;
import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.Or;
import ch.opo.opoomcb.core.dao.builder.builders.orderBy.OrderBySegmentBuilder;

/**
 * @author Paweł Łabuda
 */
public class BitwiseWhereBuilder
{
   private WhereSegmentBuilder builder;

   public BitwiseWhereBuilder(WhereSegmentBuilder builder)
   {
      this.builder = builder;
   }

   public QueryModel getQuery()
   {
      return builder.getQuery();
   }

   public OrderBySegmentBuilder orderBy(String alias, String column)
   {
      return builder.getOrderByBuilder(alias, column);
   }

   public CompareWhereBuilder and()
   {
      builder.insertOperation(new And());
      return builder.getCompareWhereBuilder();
   }

   public CompareWhereBuilder or()
   {
      builder.insertOperation(new Or());
      return builder.getCompareWhereBuilder();
   }

   public BitwiseWhereBuilder closeBracket()
   {
      builder.closeBracket();
      return builder.getBitwiseWhereBuilder();
   }
}
