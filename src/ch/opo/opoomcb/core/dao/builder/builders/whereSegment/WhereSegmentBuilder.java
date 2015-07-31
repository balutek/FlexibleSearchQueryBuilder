/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.builders.whereSegment;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.OrderBy;
import ch.opo.opoomcb.core.dao.builder.model.QueryModel;
import ch.opo.opoomcb.core.dao.builder.model.Where;
import ch.opo.opoomcb.core.dao.builder.model.operation.Bracket;
import ch.opo.opoomcb.core.dao.builder.model.operation.Operation;
import ch.opo.opoomcb.core.dao.builder.builders.orderBy.OrderBySegmentBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class WhereSegmentBuilder
{
   private CompareWhereBuilder compareWhereBuilder;

   private BitwiseWhereBuilder bitwiseWhereBuilder;

   private OrderBySegmentBuilder orderByBuilder;

   private QueryModel queryModel;

   private List<Operation> operationList;

   private List<Bracket> bracketList;

   public WhereSegmentBuilder(QueryModel queryModel, CompareWhereBuilder compareWhereBuilder)
   {
      this.queryModel = queryModel;
      this.compareWhereBuilder = compareWhereBuilder;
      this.bitwiseWhereBuilder = new BitwiseWhereBuilder(this);
      operationList = new ArrayList<Operation>();
      bracketList = new ArrayList<Bracket>();

      this.queryModel.getLastSelect().setWhere(new Where());
   }

   public void insertOperation(Operation operation)
   {
      if (bracketList.size() > 0)
      {
         bracketList.get(bracketList.size() - 1).addOperation(operation);
      }
      else
      {
         operationList.add(operation);
      }
   }

   public void openBracket()
   {
      bracketList.add(new Bracket());
   }

   public void closeBracket()
   {
      if (bracketList.size() > 0)
      {
         Bracket bracket = bracketList.remove(bracketList.size() - 1);

         insertOperation(bracket);
      }
   }

   public QueryModel getQuery()
   {
      queryModel.getLastWhere().setOperationList(operationList);
      return queryModel;
   }

   public CompareWhereBuilder getCompareWhereBuilder()
   {
      return compareWhereBuilder;
   }

   public BitwiseWhereBuilder getBitwiseWhereBuilder()
   {
      return bitwiseWhereBuilder;
   }

   public OrderBySegmentBuilder getOrderByBuilder(String alias, String column)
   {
      queryModel.getLastWhere().setOperationList(operationList);
      queryModel.getLastSelect().setOrderBy(new OrderBy(new Column(column, alias)));
      if (orderByBuilder == null)
      {
         orderByBuilder = new OrderBySegmentBuilder(queryModel);
      }

      return orderByBuilder;
   }
}
