/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.whereSegment;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
import ch.opo.opoomcb.core.dao.builder.orderBy.OrderBySegmentBuilder;

/**
 * @author Paweł Łabuda
 */
public class OperatorBuilder
{
   private WhereSegmentBuilder builder;

   public OperatorBuilder(WhereSegmentBuilder builder)
   {
      this.builder = builder;
   }

   public String build()
   {
      return builder.build();
   }

   public OrderBySegmentBuilder orderBy(String order)
   {
      return builder.getOrderByBuilder(order);
   }

   public ParamBuilder and()
   {
      builder.insertOperator(QueryElements.AND);
      return builder.getParamBuilder();
   }

   public ParamBuilder or()
   {
      builder.insertOperator(QueryElements.OR);
      return builder.getParamBuilder();
   }

   public OperatorBuilder closeBracket()
   {
      builder.closeBracket();
      return builder.getOperatorBuilder();
   }
}
