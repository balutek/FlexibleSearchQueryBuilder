/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.whereSegment;

/**
 * @author Paweł Łabuda
 */
public class ParamBuilder
{
   private WhereSegmentBuilder builder;

   public ParamBuilder(StringBuilder headerQuery)
   {
      builder = new WhereSegmentBuilder(headerQuery, this);
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

   public OperatorBuilder lesserThen(String param, Object value)
   {
      builder.insertRestrictionWithOperator(param, value, "<");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder lesserOrEqualsThen(String param, Object value)
   {
      builder.insertRestrictionWithOperator(param, value, "<=");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder greaterThen(String param, Object value)
   {
      builder.insertRestrictionWithOperator(param, value, ">");
      return builder.getOperatorBuilder();
   }

   public OperatorBuilder greaterOrEqualsThen(String param, Object value)
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
