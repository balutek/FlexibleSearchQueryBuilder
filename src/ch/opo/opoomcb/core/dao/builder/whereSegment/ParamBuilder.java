/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.whereSegment;

import ch.opo.opoomcb.core.dao.builder.model.QueryModel;

/**
 * @author Paweł Łabuda
 */
public class ParamBuilder
{
   private WhereSegmentBuilder builder;

   public ParamBuilder(QueryModel queryModel)
   {
      builder = new WhereSegmentBuilder(queryModel, this);
   }

   public OperatorBuilder isNull(String param)
   {
      builder.insertRestrictionWithNull(param, "IS NULL");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder isNotNull(String param)
   {
      builder.insertRestrictionWithNull(param, "IS NOT NULL");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder lessThan(String param, Object value)
   {
      builder.insertRestrictionWithOperator(param, value, "<");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder lessOrEqualsThan(String param, Object value)
   {
      builder.insertRestrictionWithOperator(param, value, "<=");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder greaterThan(String param, Object value)
   {
      builder.insertRestrictionWithOperator(param, value, ">");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder greaterOrEqualsThan(String param, Object value)
   {
      builder.insertRestrictionWithOperator(param, value, ">=");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder startWith(String param, String value)
   {
      builder.insertRestrictionWithLike(param, value + "%");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder endWith(String param, String value)
   {
      builder.insertRestrictionWithLike(param, "%" + value);
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder contains(String param, String value)
   {
      builder.insertRestrictionWithLike(param, "%" + value + "%");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder like(String param, String value)
   {
      builder.insertRestrictionWithLike(param, value);
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder equals(String param, Object value)
   {
      builder.insertRestrictionWithOperator(param, value, "=");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder notEquals(String param, Object value)
   {
      builder.insertRestrictionWithOperator(param, value, "<>");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder isIn(String param, Object... values)
   {
      builder.insertRestrictionIn(param, values);
      return builder.getOperatorBuilder();
   }

   public ParamBuilder openBracket()
   {
      builder.openBracket();
      return builder.getParamBuilder();
   }

}
