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

import java.util.LinkedList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class Query extends AbstractBuilder<QueryModel>
{
   private SelectBuilder selectBuilder;

   private Query()
   {
      super(new LinkedList<AbstractBuilder>());

      selectBuilder = new SelectBuilder(previousBuilders);
   }

   public static SelectBuilder select()
   {
      QueryModel queryModel = new QueryModel();
      Select select = new Select();
      queryModel.setSelect(select);

      Query query = new Query();
      query.setConstructedObject(queryModel);
      query.getSelectBuilder().setConstructedObject(select);
      return query.getSelectBuilder();
   }

   public SelectBuilder getSelectBuilder()
   {
      return selectBuilder;
   }

   public String build()
   {
      StringBuilder builder = new StringBuilder();
      constructedObject.render(new StringBuilder());
      return builder.toString();
   }

}
