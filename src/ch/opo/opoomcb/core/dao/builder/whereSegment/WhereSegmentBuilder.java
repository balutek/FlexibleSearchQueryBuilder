/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.whereSegment;

import ch.opo.opoomcb.core.dao.builder.model.OrderBy;
import ch.opo.opoomcb.core.dao.builder.model.QueryModel;
import ch.opo.opoomcb.core.dao.builder.model.Where;
import ch.opo.opoomcb.core.dao.builder.model.operation.Bracket;
import ch.opo.opoomcb.core.dao.builder.model.operation.Operation;
import ch.opo.opoomcb.core.dao.builder.orderBy.OrderBySegmentBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class WhereSegmentBuilder
{
   private ParamBuilder paramBuilder;

   private OperatorBuilder operatorBuilder;

   private OrderBySegmentBuilder orderByBuilder;

   private QueryModel queryModel;

//   private StringBuilder query;
//
//   private Map<String, Object> paramMap;

   private List<Operation> operationList;

   private List<Bracket> bracketList;

   public WhereSegmentBuilder(QueryModel queryModel, ParamBuilder paramBuilder)
   {
      this.queryModel = queryModel;
//         .append(QueryElements.WHERE);
      this.paramBuilder = paramBuilder;
      this.operatorBuilder = new OperatorBuilder(this);
//      paramMap = new HashMap<String, Object>();
      operationList = new ArrayList<Operation>();
      bracketList = new ArrayList<Bracket>();

      this.queryModel.getLastSelect().setWhere(new Where());
   }

   public void insertOperationWithParam(Operation operation, String key, Object param)
   {
      queryModel.putQueryParam(key, param);
      insertOperation(operation);
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
      return queryModel;
   }

   public String createKey(String name)
   {
      return queryModel.createKey(name);
   }

   public ParamBuilder getParamBuilder()
   {
      return paramBuilder;
   }

   public OperatorBuilder getOperatorBuilder()
   {
      return operatorBuilder;
   }

   public OrderBySegmentBuilder getOrderByBuilder(String alias, String column)
   {
      queryModel.getLastWhere().setOperationList(operationList);
      queryModel.getLastSelect().setOrderBy(new OrderBy(column, alias));
      if (orderByBuilder == null)
      {
         orderByBuilder = new OrderBySegmentBuilder(queryModel);
      }

      return orderByBuilder;
   }
}
