/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Paweł Łabuda
 */
public class QueryModel
{
   private Select select; //should change to List, and add Logic Operation List

   private Map<String, Object> queryParams;

   public QueryModel()
   {
      this.queryParams = new HashMap<String, Object>();
   }

   public Select getLastSelect()
   {
      return select;
   }

   public From getLastFrom()
   {
      return getLastSelect().getLastFrom();
   }

   public Where getLastWhere()
   {
      return getLastSelect().getWhere();
   }

   public void setSelect(Select select)
   {
      this.select = select;
   }

   public Map<String, Object> getQueryParams()
   {
      return queryParams;
   }

   public void setQueryParams(Map<String, Object> queryParams)
   {
      this.queryParams = queryParams;
   }

   public void putQueryParam(String key, Object value)
   {
      queryParams.put(key, value);
   }

   public String createKey(String param)
   {
      int i = 0;
      while (queryParams.containsKey(param + i))
      {
         i++;
      }
      return param + i;
   }
}
