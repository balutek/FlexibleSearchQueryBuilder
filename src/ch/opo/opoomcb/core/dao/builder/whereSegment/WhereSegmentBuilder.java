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

import java.util.HashMap;
import java.util.Map;

/**
 * @author Paweł Łabuda
 */
public class WhereSegmentBuilder
{
   private ParamBuilder paramBuilder;

   private OperatorBuilder operatorBuilder;

   private OrderBySegmentBuilder orderByBuilder;

   private StringBuilder query;

   private Map<String, Object> paramMap;

   private int bracketCount = 0;

   public WhereSegmentBuilder(StringBuilder headerQuery, ParamBuilder paramBuilder)
   {
      query = headerQuery
         .append(QueryElements.WHERE);
      this.paramBuilder = paramBuilder;
      this.operatorBuilder = new OperatorBuilder(this);
      paramMap = new HashMap<String, Object>();
   }

   public void insertRestrictionWithOperator(String param, Object value, String operator)
   {
      String key = createKey(param);
      query.append(QueryElements.KEY_PARAM_PREFIX)
         .append(param)
         .append(QueryElements.KEY_PARAM_SUFIX)
         .append(" ")
         .append(operator)
         .append(" ")
         .append(QueryElements.VALUE_PARAM_PREFIX)
         .append(key);
      paramMap.put(key, value);
   }

   public void insertRestrictionWithNull(String param, String nullQuery)
   {
      query.append(QueryElements.KEY_PARAM_PREFIX)
         .append(param)
         .append(QueryElements.KEY_PARAM_SUFIX)
         .append(" ")
         .append(nullQuery);
   }

   public void insertRestrictionWithLike(String param, String value)
   {
      query.append(QueryElements.KEY_PARAM_PREFIX)
         .append(param)
         .append(QueryElements.KEY_PARAM_SUFIX)
         .append(QueryElements.LIKE)
         .append("'")
         .append(value)
         .append("'");

   }

   public void insertRestrictionIn(String param, Object[] values) //todo aga - powinno być dodanie do mapy parametrów
   {
      query.append(QueryElements.KEY_PARAM_PREFIX)
         .append(param)
         .append(QueryElements.KEY_PARAM_SUFIX)
         .append(QueryElements.IN)
         .append(QueryElements.OPEN_BRACKET);
      for (int i = 0; i < values.length; ++i)
      {
         query.append(values[i]);
         if (i < values.length - 1)
         {
            query.append(", ");
         }
      }
      query.append(QueryElements.CLOSE_BRACKET);
   }

   public void insertOperator(QueryElements element)
   {
      query.append(element);
   }

   public void openBracket()
   {
      bracketCount++;
      query.append(QueryElements.OPEN_BRACKET);
   }

   public void closeBracket()
   {
      bracketCount--;
      if (bracketCount < 0)
      {
         bracketCount = 0;
      }
      else
      {
         query.append(QueryElements.CLOSE_BRACKET);
      }
   }

   public String build()
   {
      closeAllBrackets();
      return query.toString();
   }

   private void closeAllBrackets() // it shouldn't exist, it should be exception!
   {
      while (bracketCount > 0)
      {
         closeBracket();
      }
   }

   private String createKey(String param)
   {
      int i = 0;
      while (paramMap.containsKey(param + i))
      {
         i++;
      }
      return param + i;
   }

   public ParamBuilder getParamBuilder()
   {
      return paramBuilder;
   }

   public OperatorBuilder getOperatorBuilder()
   {
      return operatorBuilder;
   }

   public OrderBySegmentBuilder getOrderByBuilder(String order)
   {
      closeAllBrackets();

      if (orderByBuilder == null)
      {
         orderByBuilder = new OrderBySegmentBuilder(query, order);
      }

      return orderByBuilder;
   }
}
