/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.balutekbuilders;

import ch.opo.opoomcb.core.dao.builder.balutekbuilders.from.FromSegmentBuilder;
import ch.opo.opoomcb.core.dao.builder.model.*;
import org.apache.commons.lang.StringUtils;

/**
 * @author Paweł Łabuda
 */
public class Query
{
   private String SELECT_ITEM = "pk";

   private QueryModel queryModel;

   private Query(String param, String alias, boolean distinct)
   {
      if (StringUtils.isNotBlank(param))
      {
         SELECT_ITEM = param; //todo to chyba nie powinno tu pyc
      }

      queryModel = new QueryModel();

      Select select = new Select();
      select.setDistinct(distinct);
      select.addColumn(new Column(param, alias));
      queryModel.setSelect(select);
   }

   public static Query select()
   {
      return new Query(null, null, false);
   }

   public static Query select(String param)
   {
      return new Query(param, null, false);
   }

   public static Query select(String alias, String param)
   {
      return new Query(param, alias, true);
   }

   public static Query selectDistinct()
   {
      return new Query(null, null, true);
   }

   public static Query selectDistinct(String param)
   {
      return new Query(param, null, true);
   }

   public static Query selectDistinct(String alias, String param)
   {
      return new Query(param, alias, true);
   }

   public FromSegmentBuilder from(String from)
   {
      queryModel.getLastSelect().addFrom(new From(new Table(from, null)));
      return new FromSegmentBuilder(queryModel);
   }

   public FromSegmentBuilder from(String alias, String from)
   {
      queryModel.getLastSelect().addFrom(new From(new Table(from, alias)));
      return new FromSegmentBuilder(queryModel);
   }
}
