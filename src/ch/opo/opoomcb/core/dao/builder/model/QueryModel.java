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
   private Select select;

   private Map<String, Object> queryParams;

   public QueryModel()
   {
      this.queryParams = new HashMap<String, Object>();
   }

   public Select getSelect()
   {
      return select;
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
}
